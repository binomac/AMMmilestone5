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
public class Errore {
    private String header = "Errore!";
    private String errorType ;
    private int errorCode ;
    private String description ;
    
    public Errore(String tipo,int codice, String descrizione){
        this.errorType= tipo ;
        this.errorCode= codice ;
        this.description= descrizione;
    }
    public Errore(String titolo,String tipo,int codice){
        this.header = titolo ;
        this.errorType= tipo ;
        this.errorCode= codice ;
    }

    /**
     * @return the header
     */
    public String getHeader() {
        return header;
    }

    /**
     * @return the errorType
     */
    public String getErrorType() {
        return errorType;
    }

    /**
     * @return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * @param errorType the errorType to set
     */
    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
