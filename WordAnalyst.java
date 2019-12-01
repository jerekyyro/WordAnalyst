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
 * @author Jerezzz
 */

public class WordAnalyst {
    
    public static void main(String[] args) {
        
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
                
                //useless? readWrd = readWrd.trim();
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

    // integrate this!
    public boolean saveWordList(ArrayList<Word> words, File tiednimi) {
        boolean result = true;
        try (PrintWriter writer = new PrintWriter(tiednimi)) {
                for (Word s : words) {
                    String rivi = s.toString();
                    writer.println(rivi);
                }
                writer.close();
        } catch (Exception e) {
            System.out.println(e);
            result = false;
        }
        return result;
    }

}
