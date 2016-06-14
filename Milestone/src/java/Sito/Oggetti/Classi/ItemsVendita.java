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
public class ItemsVendita {
    private static int counter=0;
    private int id;
    private String categoria;
    private String nome;
    private String URL;
    private String descrizione;
    private double prezzo;
    private int quantita;
    private int venditore_id ;
    
    public ItemsVendita(){
        id=counter;
        nome="";
        URL="";
        descrizione="";
        prezzo=0.0;
        quantita=0;
        categoria="none";
        counter++;
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
     * @return the URL
     */
    public String getURL() {
        return URL;
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @return the prezzo
     */
    public double getPrezzo() {
        return prezzo;
    }

    /**
     * @return the quantita
     */
    public int getQuantita() {
        return quantita;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param URL the URL to set
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * @param prezzo the prezzo to set
     */
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * @param quantita the quantita to set
     */
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean areTheSame(int id){
        if(this.getId()==id) return true ;
        else return false;
    }

    /**
     * @return the venditore_id
     */
    public int getVenditore_id() {
        return venditore_id;
    }

    /**
     * @param venditore_id the venditore_id to set
     */
    public void setVenditore_id(int venditore_id) {
        this.venditore_id = venditore_id;
    }


   
}
