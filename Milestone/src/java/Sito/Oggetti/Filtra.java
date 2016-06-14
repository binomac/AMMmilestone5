/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sito.Oggetti;

import Sito.Oggetti.Classi.ItemsFactory;
import Sito.Oggetti.Classi.ItemsVendita;
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
@WebServlet(name = "Filter", urlPatterns = {"/filter.json"})
public class Filtra extends HttpServlet {

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
     
        
        if(session.getAttribute("loggedIn")!= null && session.getAttribute("loggedIn").equals(true)){
            if(request.getParameter("cmd") != null){
                if( request.getParameter("cmd").equals("search")){
                    String categoria= request.getParameter("cat");
                    ArrayList<ItemsVendita> listaFiltrata ;
                    response.setContentType("application/json");
                    response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
                    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
                    switch(categoria){
                        case "Auto"     : listaFiltrata = ItemsFactory.GetIstance().getListaFiltred("Auto", request.getParameter("text"));  break;
                        case "Moto"     : listaFiltrata = ItemsFactory.GetIstance().getListaFiltred("Moto", request.getParameter("text"));  break;                      
                        case "Yatch"    : listaFiltrata = ItemsFactory.GetIstance().getListaFiltred("Yatch", request.getParameter("text")); break;                       
                        case "Barche"   : listaFiltrata = ItemsFactory.GetIstance().getListaFiltred("Barche", request.getParameter("text"));break;
                        default : listaFiltrata = null ;
                    }
                    request.setAttribute("listaFiltrata", listaFiltrata);
                    request.getRequestDispatcher("struttura/lista_inserzioniJson.jsp").forward(request, response);
                }
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
