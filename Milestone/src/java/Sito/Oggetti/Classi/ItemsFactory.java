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
public class ItemsFactory {

    private static ItemsFactory singleton;
    private static String connectionString ;
             
    public void setConnectionString(String s){
	this.connectionString = s;
}
    
    public String getConnectionString(){
	return this.connectionString;
} 

    
    
    private ItemsFactory(){
        
    }
    
    public static ItemsFactory GetIstance(){
         if (singleton == null) {
            singleton = new ItemsFactory();
        }
        return singleton;
    }
    
    public ArrayList<ItemsVendita> getLista(String cat){
        try {
            Connection conn = DriverManager.getConnection(connectionString,"root","root");
            String query = "select * from inserzioni where categoria = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, cat);
            ResultSet set = stmt.executeQuery();
            ArrayList<ItemsVendita> listaCategoria =new ArrayList<ItemsVendita>() ;
            while(set.next()){
                ItemsVendita inserzione = new ItemsVendita();
                inserzione.setId(set.getInt("id"));
                inserzione.setNome(set.getString("titolo"));
                inserzione.setDescrizione(set.getString("descrizione"));
                inserzione.setPrezzo(set.getDouble("prezzo"));
                inserzione.setQuantita(set.getInt("quantita"));
                inserzione.setCategoria(set.getString("categoria"));
                listaCategoria.add(inserzione);
            }
            stmt.close();
            conn.close();
            return listaCategoria ;
        }
        catch (SQLException ex) {
             Logger.getLogger(UsersFactory.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
    }
    
    public ItemsVendita getInserzione(int id){
        try {
            Connection conn = DriverManager.getConnection(connectionString,"root","root");
            String query = "select * from inserzioni where id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery();
            if(set.next()){
                ItemsVendita inserzione = new ItemsVendita();
                inserzione.setId(set.getInt("id"));
                inserzione.setNome(set.getString("titolo"));
                inserzione.setDescrizione(set.getString("descrizione"));
                inserzione.setPrezzo(set.getDouble("prezzo"));
                inserzione.setQuantita(set.getInt("quantita"));
                inserzione.setCategoria(set.getString("categoria"));
                inserzione.setVenditore_id(set.getInt("venditore_id"));
                stmt.close();
                conn.close();
                return inserzione;
            }else{
                //errortype
            }
            
        } catch (SQLException ex) {
             Logger.getLogger(UsersFactory.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }  
        return null;
    }
    
    public int putInserzione (ItemsVendita inserzione,int user_id){
        try {
            Connection conn = DriverManager.getConnection(connectionString,"root","root");
            
            String query="INSERT INTO INSERZIONI (ID,TITOLO,DESCRIZIONE,PREZZO,QUANTITA,CATEGORIA,VENDITORE_ID)"
                + "VALUES(DEFAULT,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, inserzione.getNome());
            stmt.setString(2,inserzione.getDescrizione() );
            stmt.setDouble(3, inserzione.getPrezzo());
            stmt.setInt(4, inserzione.getQuantita());
            stmt.setString(5, inserzione.getCategoria());
            stmt.setInt(6, user_id );
            
            
            
            return stmt.executeUpdate();
            
        }catch (SQLException ex) {
             Logger.getLogger(UsersFactory.class.getName()).log(Level.SEVERE, null, ex);
             
            
        }
        return 0 ;
    }
    public int modInserzione (ItemsVendita inserzione , Connection conn){
        try {
            if(conn == null) conn = DriverManager.getConnection(connectionString,"root","root");
            String query = "UPDATE inserzioni SET "
                    + "TITOLO = ?,DESCRIZIONE = ?,PREZZO = ?,QUANTITA = ?"
                    + "WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, inserzione.getNome());
            stmt.setString(2,inserzione.getDescrizione() );
            stmt.setDouble(3, inserzione.getPrezzo());
            stmt.setInt(4, inserzione.getQuantita());
            stmt.setInt(5, inserzione.getId());
            
            return stmt.executeUpdate();
        } catch (SQLException ex) {
             Logger.getLogger(UsersFactory.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
             return 0;
         }  
    }
    
    public int deleteInserzione(int inserzione_id){
        try {
            Connection conn = DriverManager.getConnection(connectionString,"root","root");
            String query = "DELETE FROM inserzioni "
                    + "WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setInt(1, inserzione_id);
            return stmt.executeUpdate();
        } catch (SQLException ex) {
             Logger.getLogger(UsersFactory.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
             return 0;
         }  
    }
        
    public ArrayList<ItemsVendita> getListaFiltred(String cat,String text){
        try {
            Connection conn = DriverManager.getConnection(connectionString,"root","root");
            String query = "select * from inserzioni where categoria = ? "
                    + "AND (inserzioni.titolo LIKE ? OR inserzioni.descrizione LIKE ? )" ;
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            text = "%"+text+"%";
            stmt.setString(1, cat);
            stmt.setString(2, text);
            stmt.setString(3, text);
            ResultSet set = stmt.executeQuery();
            ArrayList<ItemsVendita> listaCategoria =new ArrayList<ItemsVendita>() ;
            while(set.next()){
                ItemsVendita inserzione = new ItemsVendita();
                inserzione.setId(set.getInt("id"));
                inserzione.setNome(set.getString("titolo"));
                inserzione.setDescrizione(set.getString("descrizione"));
                inserzione.setPrezzo(set.getDouble("prezzo"));
                inserzione.setQuantita(set.getInt("quantita"));
                inserzione.setCategoria(set.getString("categoria"));
                listaCategoria.add(inserzione);
            }
            stmt.close();
            conn.close();
            return listaCategoria ;
        }
        catch (SQLException ex) {
             Logger.getLogger(UsersFactory.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
    }
        
    }
    

