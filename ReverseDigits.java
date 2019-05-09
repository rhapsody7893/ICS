import java.io.*;

/**
 * This program will reverse the digits of an integer using recursion
 * Krasetva
 * @version 1.0 April 12, 2019
 * @author Michael Zhou 
 */ 
public class ReverseDigits {
  
  /** 
   * This method will reverse the order of the digits of the passed integer
   * @return integer with digits reversed
   * @param input the number that will have its digits reversed
   */ 
  public int revDigits(int input) {
    if (input < 10)
      return input;
    return input % 10 * (int) Math.pow (10, (int) Math.log10 (input)) + revDigits(input/10); 
  }
  
  /** 
   * Takes the input and converts it into an integer
   * @return the input as an integer
   */ 
  public int getInput() {
    String line = "";   
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));      
      line = reader.readLine ();
    }
    catch (IOException e) {
    }
    return Integer.parseInt (line);
  }
  
  /** 
   * Entry to the program
   *
   * @param args the arguments passed from the command line
   */ 
  public static void main (String [] args) {
    ReverseDigits reverseDigits = new ReverseDigits();
    System.out.println (reverseDigits.revDigits (reverseDigits.getInput ()));
    
  }
}