/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sito.Oggetti;

import Sito.Oggetti.Classi.ItemsFactory;
import Sito.Oggetti.Classi.ItemsVendita;
import Sito.Oggetti.Classi.Users;
import Sito.Oggetti.Classi.UsersVenditori;
import Sito.Oggetti.Classi.UsersClienti;
import Sito.Oggetti.Classi.UsersFactory;
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
@WebServlet(name = "Venditore", urlPatterns = {"/Venditore"})
public class Venditore extends HttpServlet {

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
            if(session.getAttribute("UserVenditore")!= null){
                 if(request.getParameter("cmd")!= null) { 
                     if(request.getParameter("cmd").equals("view")){
                        ItemsVendita corrente = ItemsFactory.GetIstance().getInserzione(Integer.parseInt(request.getParameter("id")));
                        if(corrente!=null){
                             
                         request.setAttribute("inserzione", corrente);
                         
                         request.getRequestDispatcher("struttura/inserzione.jsp").forward(request, response);
                        }
                     }
                     else {
              if(request.getParameter("cmd").equals("modifica")){
                             if(request.getParameter("submit") != null){
                                 ItemsVendita modificato = new ItemsVendita();
                                 int flag = 0;
                     
                        
                     if(modificato==null){
                         request.setAttribute("errorType", "inserimentoInserzione");
                         request.setAttribute("errorCode", 0);
                         flag++;
                     }else{
                         modificato.setNome(request.getParameter("nome"));
                         if(modificato.getNome()==null || "".equals(modificato.getNome())){
                             request.setAttribute("errorType", "inserimentoInserzione");
                             request.setAttribute("errorCode", 1);
                             flag++;
                         }else{
                             modificato.setQuantita(Integer.parseInt(request.getParameter("quantita")));
                             if(modificato.getQuantita() <=0){
                                 request.setAttribute("errorType", "inserimentoInserzione");
                                 request.setAttribute("errorCode", 2);
                                 flag++;
                             }else{
                                 String numero= request.getParameter("prezzo");
                                 numero = numero.replace(",",".");
                                  modificato.setPrezzo(Double.parseDouble(numero));
                                  if(modificato.getPrezzo()<=0.0){
                                      request.setAttribute("errorType", "inserimentoInserzione");
                                      request.setAttribute("errorCode", 3);
                                      flag++;
                                  }
                                      else {
                                          modificato.setDescrizione(request.getParameter("descrizione"));
                                          modificato.setId(Integer.parseInt(request.getParameter("id")));
                                          
                                          
                                      }
                                  
                             }
                         }
                     }
                     if(flag>0) request.getRequestDispatcher("venditore/venditore.jsp").forward(request, response);
                     else{
                         int flagModifica = ItemsFactory.GetIstance().modInserzione(modificato,null);
                         if(flagModifica == 1){
                             UsersVenditori refresh = (UsersVenditori)session.getAttribute("UserVenditore");
                             session.setAttribute("UserVenditore", UsersFactory.getInstance().getUser(refresh.getId()));
                            request.setAttribute("modificato", true);
                            request.getRequestDispatcher("Login").forward(request, response);
                        }
                        else{
                            request.setAttribute("modificato", false);
                            request.getRequestDispatcher("venditore/venditore.jsp").forward(request, response);
                        }
                         
                         
                         
                        }
                    }
                             else{
                        request.setAttribute("action", "mod");//attiva l'hidden input per il cmd modifica
                        ItemsVendita corrente = ItemsFactory.GetIstance().getInserzione(Integer.parseInt(request.getParameter("id")));
                        if(corrente!=null){
                             
                         request.setAttribute("inserzione", corrente);
                        request.getRequestDispatcher("venditore/venditore.jsp").forward(request, response);
                             }
                             
                             
                         }
                         }
                         if(request.getParameter("cmd").equals("cancella")){
                             int flagCancellazione = ItemsFactory.GetIstance().deleteInserzione(Integer.parseInt(request.getParameter("id")));
                              UsersVenditori user = (UsersVenditori)session.getAttribute("UserVenditore");
                             if(flagCancellazione == 1){
                            request.setAttribute("creato", true);
                             session.setAttribute("UserVenditore", UsersFactory.getInstance().getUser(user.getId()));
                            request.getRequestDispatcher("Login").forward(request, response);
                        }
                        else{
                            request.setAttribute("creato", false);
                            request.getRequestDispatcher("venditore/venditore.jsp").forward(request, response);
                        }
                         }
                         if(request.getParameter("cmd").equals("inserimento")){
                       int flag = 0;
                     
                        ItemsVendita inserito = new ItemsVendita();
                     if(inserito==null){
                         request.setAttribute("errorType", "inserimentoInserzione");
                         request.setAttribute("errorCode", 0);
                         flag++;
                     }else{
                         inserito.setNome(request.getParameter("nome"));
                         if(inserito.getNome()==null || "".equals(inserito.getNome())){
                             request.setAttribute("errorType", "inserimentoInserzione");
                             request.setAttribute("errorCode", 1);
                             flag++;
                         }else{
                             inserito.setQuantita(Integer.parseInt(request.getParameter("quantita")));
                             if(inserito.getQuantita() <=0){
                                 request.setAttribute("errorType", "inserimentoInserzione");
                                 request.setAttribute("errorCode", 2);
                                 flag++;
                             }else{
                                 String numero= request.getParameter("prezzo");
                                 numero = numero.replace(",",".");
                                  inserito.setPrezzo(Double.parseDouble(numero));
                                  if(inserito.getPrezzo()<=0.0){
                                      request.setAttribute("errorType", "inserimentoInserzione");
                                      request.setAttribute("errorCode", 3);
                                      flag++;
                                  }else{
                                      inserito.setURL(request.getParameter("foto"));
                                      if(inserito.getURL()==null || "".equals(inserito.getURL())){
                                          request.setAttribute("errorType", "inserimentoInserzione");
                                          request.setAttribute("errorCode", 4);
                                          flag++;
                                      }
                                      else {
                                          inserito.setDescrizione(request.getParameter("descrizione"));
                                          inserito.setCategoria(request.getParameter("categoria"));
                                      }
                                  }
                             }
                         }
                     }
                     if(flag>0) request.getRequestDispatcher("venditore/venditore.jsp").forward(request, response);
                     else{
                         UsersVenditori user = (UsersVenditori)session.getAttribute("UserVenditore");
                     
                        int flagInserimento = ItemsFactory.GetIstance().putInserzione(inserito, user.getId());
                        if(flagInserimento == 1){
                            request.setAttribute("creato", true);
                             session.setAttribute("UserVenditore", UsersFactory.getInstance().getUser(user.getId()));
                            request.getRequestDispatcher("Login").forward(request, response);
                        }
                        else{
                            request.setAttribute("creato", false);
                            request.getRequestDispatcher("venditore/venditore.jsp").forward(request, response);
                        }
                        
                     }
                     
                 
                 }
                     }   
                         
                 }
            
            else{
                     request.setAttribute("action", "new");//attiva l'hidden input type il cmd inserimento
                    request.getRequestDispatcher("venditore/venditore.jsp").forward(request, response);
                 }
           
        }
             else{
                request.setAttribute("errorType", "wrongUser");
                request.setAttribute("errorCode", "2");
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
