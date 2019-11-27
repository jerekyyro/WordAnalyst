package wordanalyst;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Jerezzz
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
  
    @Override
    public String toString() {
        
        return this.wordTxt+", N="+this.WordN+", "+this.getNeatPerc()+".";
    }
    
}
