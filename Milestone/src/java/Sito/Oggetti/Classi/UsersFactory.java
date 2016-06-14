/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sito.Oggetti.Classi;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luca
 */
public class UsersFactory {
     private static UsersFactory singleton;
     private static String connectionString ;
             
    public void setConnectionString(String s){
	this.connectionString = s;
}
    
    public String getConnectionString(){
	return this.connectionString;
} 

    
    /* Costruttore */
    private UsersFactory() {
         
        
    }
    /*Metodi*/
    public static UsersFactory getInstance() {
        if (singleton == null) {
            singleton = new UsersFactory();
        }
        return singleton;
    }
    public Users getUser(int id){
        try {
            Connection conn = DriverManager.getConnection(connectionString,"root","root");
             // sql command
            String query = "select * from utente where "
                    + "id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setInt(1, id);
             ResultSet set = stmt.executeQuery();
            
            if(set.next()){
                String user= set.getString("username");
                String psw= set.getString("password");
                stmt.close();
                conn.close();
                return getUser(user,psw);
            }
        }catch(SQLException ex){
             Logger.getLogger(UsersFactory.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }  
         return null;
    }
    public  Users getUser(String username, String password) {
         try {
             Connection conn = DriverManager.getConnection(connectionString,"root","root");
             // sql command
            String query = "select * from utente where "
                    + "password = ? and username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            //
            ResultSet set = stmt.executeQuery();
            
            if(set.next())
            {
                if(set.getInt("tipo")==1){
                    UsersVenditori utente = new UsersVenditori();
                    utente.setId(set.getInt("id"));
                    utente.setNome(set.getString("nome"));
                    utente.setCognome(set.getString("cognome"));
                    utente.setUsername(set.getString("username"));
                    utente.setPassword(set.getString("password"));
                    
                    query = "select * from saldo where utente_id = " + set.getInt("id");
                    Statement st = conn.createStatement();
                    ResultSet set2 = st.executeQuery(query);
                    if(set2.next()){
                        utente.setCredito(new Saldo(set2.getDouble("conto")));
                    }else {}//da finire: codice errore e reindirizzamento
                    st.close();
                    
                    query = "select * from inserzioni where venditore_id = " + set.getInt("id");
                    
                    st = conn.createStatement();
                    set2 = st.executeQuery(query);
                    while(set2.next()){
                        ItemsVendita inserzione = new ItemsVendita();
                        inserzione.setId(set2.getInt("id"));
                        inserzione.setNome(set2.getString("titolo"));
                        inserzione.setDescrizione(set2.getString("descrizione"));
                        inserzione.setPrezzo(set2.getDouble("prezzo"));
                        inserzione.setQuantita(set2.getInt("quantita"));
                        inserzione.setCategoria(set2.getString("categoria"));
                        utente.addInserzione(inserzione);
                    }
                    
                    st.close();
                    stmt.close();
                    conn.close();
                    return utente;
                    
                }else if(set.getInt("tipo")==2){
                    UsersClienti utente = new UsersClienti();
                    utente.setId(set.getInt("id"));
                    utente.setNome(set.getString("nome"));
                    utente.setCognome(set.getString("cognome"));
                    utente.setUsername(set.getString("username"));
                    utente.setPassword(set.getString("password"));
                    
                    query = "select * from saldo where utente_id =" + set.getInt("id");
                    Statement st = conn.createStatement();
                    ResultSet set2 = st.executeQuery(query);
                    if(set2.next()){
                        utente.setCredito(new Saldo(set2.getDouble("conto")));
                    }else {}//da finire: codice errore e reindirizzamento
                    st.close();
                    stmt.close();
                    conn.close();
                    return utente;
                }
                
            }
         } catch (SQLException ex) {
             Logger.getLogger(UsersFactory.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }  
         return null;
    }
    
    public int processTransation(int cliente_id,int inserzione_id) throws SQLException{
        ItemsVendita inserzione = ItemsFactory.GetIstance().getInserzione(inserzione_id);
        UsersVenditori venditore =(UsersVenditori) UsersFactory.getInstance().getUser(inserzione.getVenditore_id());
        UsersClienti cliente =(UsersClienti) UsersFactory.getInstance().getUser(cliente_id);
        if(cliente.getCredito().getConto() >= inserzione.getPrezzo()){
            Connection conn = DriverManager.getConnection(connectionString,"root","root");
         try {
             
            conn.setAutoCommit(false);
             
            
            String query = "UPDATE saldo SET "
                    + "CONTO = ?"
                    + "WHERE UTENTE_ID = ?";
             PreparedStatement stmt = conn.prepareStatement(query);
             stmt.setDouble(1,(cliente.getCredito().getConto() - inserzione.getPrezzo()));
             stmt.setInt(2,cliente.getId());
             int flagVenditore = 0;
            int flagCliente = stmt.executeUpdate();
            stmt.close();
            if(flagCliente == 1){
                
                query = "UPDATE saldo SET "
                    + "CONTO = ?"
                    + "WHERE UTENTE_ID = ?";
             stmt = conn.prepareStatement(query);
             stmt.setDouble(1,(venditore.getCredito().getConto() + inserzione.getPrezzo()));
             stmt.setInt(2,venditore.getId());
             flagVenditore = stmt.executeUpdate();
             if(flagVenditore == 1){
                 inserzione.setQuantita(inserzione.getQuantita()-1);
                 ItemsFactory.GetIstance().modInserzione(inserzione,conn);
                 
             }
            }
            if(flagVenditore != 1 || flagCliente != 1){
                conn.rollback();
                return 0 ;
            }
            else {conn.commit() ; return 1 ;}
         
         }catch (SQLException ex) {
             conn.rollback();
             Logger.getLogger(UsersFactory.class.getName()).log(Level.SEVERE, null, ex);
             return 0 ;
         }finally{
             conn.setAutoCommit(true);
            conn.close();
         }
        }
        else return -1;
    }
            
    
    
    /**
   * Print the stack trace for a SQLException to STDERR.
   *
   * @param e SQLException to print stack trace of
   */
  public static void printStackTrace(SQLException e) {
      printStackTrace(e, new PrintWriter(System.err));
  }
  /**
   * Print the stack trace for a SQLException to a 
   * specified PrintWriter. 
   *
   * @param e SQLException to print stack trace of
   * @param pw PrintWriter to print to
   */
  public static void printStackTrace(SQLException e, PrintWriter pw) {

      SQLException next = e;
      while (next != null) {
          next.printStackTrace(pw);
          next = next.getNextException();
          if (next != null) {
              pw.println("Next SQLException:");
          }
      }
  }
}
