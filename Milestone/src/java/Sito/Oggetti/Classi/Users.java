/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sito.Oggetti.Classi;

/**
 *
 * @author luca
 */
public abstract class Users {
    private int id;
    protected String nome;
    protected String cognome;
    
    protected String username;
    protected String password;
    

    /* Costruttore */
    public Users(){
        
        nome = "user?";
        cognome = "";
        username="";
        password="";
        
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

   
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean areTheSame( int id){
        if(this.getId()==id) return true ;
        else return false;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}