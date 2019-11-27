/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordanalyst;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author s4nk4
 */
public class WordAnalyst {

    // future stuff: 
    // re-organizing the list
    // tabs between words, N's and %'s
    // number of tokens and words
    // coping with just one list? --> use the methods of Word?
    // better to do with HashMap?
    // function for identifying inflected forms of same word
    // ---- if nnn contains n --> "are these different forms of a same word?"
    // ---- save different forms to same Word
    // - graphic interface: opening a file and some following functionalities:
    // - make a function for listing words that are in 
    // A) same paragraph and 
    // B) same sentence
    // ---- maybe by creating a temporary Objects Sentence and Paragraph that return the other words to a word 
    // ---- maybe as a continuous +++string?
    // ---- or maybe just a function to read the words in sent.'s and paragr.'s including a _selected word!_
    // - some kind of functionality to save the CAPITAL Letter tokens of a word
    // - comparison with word lists?
    // - downloading data from web resource?
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        

        // ohjelmassa:
        ArrayList<Word> words = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        // instead of playing with two lists, consider creating a
        // .equals -method for Word that compares Strings if the 
        // Objects are of same type
        try (Scanner fileReader = new Scanner(new File("sampletext.txt"))) {

            fileReader.useDelimiter("\\s"); 
  
            while (fileReader.hasNext()) {
                String readWrd = fileReader.next();
                readWrd = readWrd.toLowerCase();
                
                //turha? readWrd = readWrd.trim();
                if (readWrd.isEmpty()) {
                    continue;
                }
                if (readWrd.endsWith(".") || readWrd.endsWith(",")) {
                    readWrd = readWrd.substring(0, readWrd.length()-1);
                }
                
            
                Word word = new Word(readWrd, 1);
                if (strings.isEmpty()) {
                        strings.add(readWrd);
                        words.add(word);
                } else if (strings.contains(readWrd)) {
                    words.get(strings.indexOf(readWrd)).addN();
                } else {
                    strings.add(readWrd);
                    words.add(word);
                }
            }
            
        
                
//(fileReader.next());
                
            } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        int ncounter = 0;
        for (Word word: words) {
            ncounter = ncounter + word.getN();
            if (word.getTxt().isEmpty()) {
                words.remove(word);
            }
        }
        // int maxN = 0;
        //for (Word word: words) {
        //    if (word.getN() > maxN) {
        //        maxN = word.getN();
        //        Word item = new Word(word.getTxt(), word.getN());
        //        int itemPos = words.indexOf(item);
        //        words.remove(itemPos);
        //        words.add(0, item );
        //    }
        //}

        for (Word word: words) {
            word.setPerc( (double) word.getN() / (double) ncounter );
        }
        

        
        for (Word word: words) {
               System.out.println(word);
            }
        System.out.println("");
        System.out.println("Total numer of words: "+ncounter);


        
    }

    // integroi tämä!
    public boolean saveWordList(ArrayList<Word> words, File tiednimi) {
        boolean pal = true;
        try (PrintWriter kirjoittaja = new PrintWriter(tiednimi)) {
                for (Word s : words) {
                    String rivi = s.toString();
                    kirjoittaja.println(rivi);
                }
                kirjoittaja.close();
        } catch (Exception e) {
            System.out.println(e);
            pal = false;
        }
        return pal;
    }

}
