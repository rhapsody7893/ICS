import java.io.*;

/**
 * This program will take inputed words and print them out in reverse order using recursion
 * Krasetva
 * @version 1.0 April 12, 2019
 * @author Michael Zhou 
 */ 
public class WordReverse {
  
  /** 
   * Reverses the order of each word in the string
   * @return the string with reversed order of each word
   * @param the string with words
   */ 
  public String reverseWords (String words) {
    if (words.indexOf ("\n") != -1) 
      return words.substring (words.lastIndexOf ("\n"), words.length()) + reverseWords (words.substring (0, words.lastIndexOf ("\n")));
    return "\n" + words;
  }
  
  /** 
   * Takes the user input
   * @return the input as a string
   */ 
  public String getInput() {
    String input = "";
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String line = "";
      while (!line.equals (".")) {      
        line = reader.readLine ();
        input = input + (line + "\n");    
      }
    }
    catch (IOException e) {
    }
    return input;
  }
  
  /** Entry to the program
    * 
    * @param args the arguments passed from the command line
    */
  public static void main (String [] args) {
    WordReverse wordReverse = new WordReverse();
    System.out.println (wordReverse.reverseWords(wordReverse.getInput()));
  }
}