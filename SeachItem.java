import java.util.*;

/**
 * This program will check if an item exists in an array using recursion
 * Krasetva
 * @version 1.0 April 12, 2019
 * @author Michael Zhou 
 */ 

public class SeachItem {
  
  /**
   * @return if the item was found
   * @param arr the array to be searched
   * @param compare the item to be found
   */ 
  public boolean search (Comparable[] arr, Comparable compare) {
    if (arr.length == 0)
      return false;
    else if (arr[0].compareTo(compare) == 0)
      return true;
    return search (Arrays.copyOfRange (arr, 1, arr.length) ,compare); 
  }
  
  /** 
   * Entry to the program
   * 
   * @param args the arguments passed from the command line
   */
  public static void main (String [] args) {
    Comparable[] arr = {1, 2, 7, 2 ,4 ,1 ,23 ,4};
    SeachItem seachItem = new SeachItem();
    System.out.println (seachItem.search (arr, 7));
  }
}