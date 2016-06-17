/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sito.Oggetti;

import Sito.Oggetti.Classi.Errore;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ErrorManager", urlPatterns = {"/ErrMan.json"})
public class ErrorManager extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        ArrayList<Errore> listaErrori = new ArrayList<Errore>();
        
     
        if("check".equals(request.getParameter("cmd"))){
            if("link".equals(request.getParameter("cat"))){
                if(session.getAttribute("loggedIn")!= null && session.getAttribute("loggedIn").equals(true)){
                }
                else{
                     listaErrori.add(new Errore("href parsing",0,request.getParameter("link")));
                    if("Cliente".equals(request.getParameter("link"))&&"Venditore".equals(request.getParameter("link"))){
                        listaErrori.add(new Errore("Not Logged",0,"Devi prima accedere alla tua area riservata per visitare questa pagina"));
                        //request.setAttribute("errore", new Errore("Not Logged",0));
                    }
                }
                request.setAttribute("ListaErrori",listaErrori);
                request.getRequestDispatcher("struttura/errMan.jsp").forward(request, response);  
            }           
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
