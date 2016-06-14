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
public class Saldo {
    private double conto;
    
    public Saldo(double val){
        this.conto=val;
    }

    /**
     * @return the conto
     */
    public double getConto() {
        return conto;
    }

    /**
     * @param conto the conto to set
     */
    public void setConto(double conto) {
        this.conto = conto;
    }
    
}
