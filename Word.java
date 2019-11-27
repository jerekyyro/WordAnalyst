/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordanalyst;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author s4nk4
 */
class Word {
    private String wordTxt;
    private int WordN;
    private double WordPerc;
    private String neatPerc;
    
    public Word(String text) {
        this(text, 0, 0.0);
    }
    
    public Word(String text, int N) {
        this(text, N, 0.0);
    }
    
    public Word(String text, int N, double perc) {
        
        this.wordTxt = text;
        this.WordN = N;
        this.WordPerc = perc;
    }
    
    public void addN() {
        this.WordN ++;
    }
    
    public String getTxt() {
        return this.wordTxt;
    }
    
    public int getN() {
        return this.WordN;
    }
    
    public void setPerc(double set) {
        this.WordPerc = 100 * set;
    }
    
    public String getNeatPerc() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(this.WordPerc)+"%"; 
    }
    
    //public boolean equals(Object verrattava) {
        // jos muuttujat sijaitsevat samassa paikassa, ovat ne samat
    //    if (this == verrattava) {
    //        return true;
    //    }

        // jos verrattava olio ei ole Paivays-tyyppinen, oliot eivät ole samat
    //    if (!(verrattava instanceof Paivays)) {
    //        return false;
    //    }

        // muunnetaan Object-tyyppinen verrattava-olio
        // Paivays-tyyppiseksi verrattavaPaivays-olioksi
    //    Paivays verrattavaPaivays = (Paivays) verrattava;

        // jos olioiden oliomuuttujien arvot ovat samat, ovat oliot samat
    //    if (this.paiva == verrattavaPaivays.paiva &&
    //        this.kuukausi == verrattavaPaivays.kuukausi &&
    //        this.vuosi == verrattavaPaivays.vuosi) {
    //        return true;
       // }

        // muulloin oliot eivät ole samat
     //   return false;
    //}
    
    @Override
    public String toString() {
        
        return this.wordTxt+", N="+this.WordN+", "+this.getNeatPerc()+".";
    }
    
}
