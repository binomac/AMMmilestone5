    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sito.Oggetti;

import Sito.Oggetti.Classi.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luca
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"}, loadOnStartup = 0)
public class Login extends HttpServlet {

    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    @Override 
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsersFactory.getInstance().setConnectionString(dbConnection);
        ItemsFactory.GetIstance().setConnectionString(dbConnection);
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        
         if(session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)){
                if(session.getAttribute("UserVenditore")!= null) request.getRequestDispatcher("login/Logged_seller.jsp").forward(request, response);
                else request.getRequestDispatcher("login/Logged_buyer.jsp").forward(request, response);
            }
        else{
            if(request.getParameter("Submit") != null)
            {
            
            // Preleva i dati inviati
            String username = request.getParameter("Username");
            String password = request.getParameter("Password");
            Users u = UsersFactory.getInstance().getUser(username, password);
            if(u != null){
                session.setAttribute("loggedIn", true);
                session.setAttribute("id", u.getId());
                if(u instanceof UsersVenditori){
                    session.setAttribute("UserVenditore", u);
                    request.getRequestDispatcher("login/Logged_seller.jsp").forward(request, response);
                }
                else{
                    session.setAttribute("UserCliente", u);
                    request.getRequestDispatcher("login/Logged_buyer.jsp").forward(request, response);  
                }                    
            }
            else {
                request.setAttribute("errorType", "autenticazione");
                response.sendRedirect("Login");
            }
        }
            else request.getRequestDispatcher("login/Form_Login.jsp").forward(request, response);  
    }
}
        
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

