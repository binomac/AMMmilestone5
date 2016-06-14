/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sito.Oggetti;

import Sito.Oggetti.Classi.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "Cliente", urlPatterns = {"/Cliente"})
public class Cliente extends HttpServlet {

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
        HttpSession session = request.getSession(false);
               
        if(session.getAttribute("loggedIn")!= null && session.getAttribute("loggedIn").equals(true)){
            if(session.getAttribute("UserCliente")!= null){
                
                if(request.getParameter("cmd") != null){
                    if( request.getParameter("cmd").equals("buy")){
                    ItemsVendita corrente = ItemsFactory.GetIstance().getInserzione(Integer.parseInt(request.getParameter("id")));
                    
                    
                    if(corrente != null){
                        // TRANSAZIONE
                        UsersClienti utente = (UsersClienti)session.getAttribute("UserCliente");
                        
                        if(utente.getCredito().getConto() >= corrente.getPrezzo()){
                            try{
                            UsersFactory.getInstance().processTransation(utente.getId(),corrente.getId());
                            session.setAttribute(("UserCliente"), UsersFactory.getInstance().getUser(utente.getId()));
                            }catch(SQLException erroreConnessione){
                                Logger.getLogger(UsersFactory.class.getName()).log(Level.SEVERE, null, erroreConnessione);
                            }
                            request.getRequestDispatcher("Login").forward(request, response);
                        }
                        else{
                            request.setAttribute("errorType", "transazione");
                            request.setAttribute("errorCode", "1");
                            request.getRequestDispatcher("Cliente?cmd=view&id=" + corrente.getId()).forward(request, response);
                            
                        }
                        
                    }
                    else{
                        request.setAttribute("errorType", "transazione");
                        request.setAttribute("errorCode", "1");
                        request.getRequestDispatcher("Login").forward(request, response);
                    }
                    }
                    if(request.getParameter("cmd").equals("view")){
                        ItemsVendita corrente = ItemsFactory.GetIstance().getInserzione(Integer.parseInt(request.getParameter("id")));
                        if(corrente!=null){
                            request.setAttribute("inserzione", corrente);
                            request.getRequestDispatcher("struttura/inserzione.jsp").forward(request, response);
                        }
                        else {
                            request.setAttribute("errorType", "transazione");
                            request.setAttribute("errorCode", "2");
                            request.getRequestDispatcher("Login").forward(request, response);
                        }
                    }
                }
                else{
                    request.setAttribute("listaAuto", ItemsFactory.GetIstance().getLista("Auto"));
                    request.setAttribute("listaMoto", ItemsFactory.GetIstance().getLista("Moto"));
                    request.setAttribute("listaYatch", ItemsFactory.GetIstance().getLista("Yatch"));
                    request.setAttribute("listaBarche", ItemsFactory.GetIstance().getLista("Barche"));
                    request.getRequestDispatcher("cliente/cliente.jsp").forward(request, response);
                }
            }
            else{
                request.setAttribute("errorType", "wrongUser");
                request.setAttribute("errorCode", "1");
                request.getRequestDispatcher("Login").forward(request, response);
            }
        
        }
        else {
            request.setAttribute("errorType", "notLogged");
            request.getRequestDispatcher("Login").forward(request, response);
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
