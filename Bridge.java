import java.io.*;
import java.util.*; 

/** This class provides methods that allow the user to read and sort card data from cards.txt.
  * The hand of each set (of 4) in the file is read and each stored into a matrix.
  * Each hand is sorted into suits, converted to integer values and sorted by value before being converted back into card values.
  * Each sorted hand is printed in order of suits and value.
  * 
  * ICS4U0 with Krasteva, V. 
  * @version 1 April 1, 2019 
  * @author Michael Z, Feng X
  */ 
public class Bridge
{
  private String[] [] setsOfHands;
  private ArrayList <Integer> spades;
  private ArrayList <Integer> hearts;
  private ArrayList <Integer> diamonds;
  private ArrayList <Integer> clubs;
  
  /** This method reads the data inside of the file and stores it into a matrix (set) (hands)
    * 
    * @return If the data was accessed and stored sucessfully
    */ 
  public boolean getHands ()
  {
    int lineCount = 0;
    try
    {
      BufferedReader br = new BufferedReader (new FileReader ("cards.txt"));
      while (br.readLine () != null)
      {
        lineCount++; //count the number of lines in the file
      }
      br.close ();
      if (lineCount % 4 != 0) //check if there are sets of 4 hands
        return false;
      setsOfHands = new String [lineCount / 4] [4]; //create the array after counting the number of hands
      BufferedReader br2 = new BufferedReader (new FileReader ("cards.txt"));
      String line;
      int x = 0; //sets
      int y = 0; //hands
      while ((line = br2.readLine ()) != null)
      {
        setsOfHands [x] [y] = line; //store each line into array
        y++;
        if (y > 3)
        {
          y = 0;
          x++;
        }
      }
      br2.close ();
    }
    catch (IOException e)
    {
      return false;
    }
    return true;
  }
  
  /** This method returns the setsOfHands
    * 
    * @return The sets and the hands in each set
    */ 
  public String[][] getSetsOfHands () {
    return setsOfHands;
  }
  /** This method sorts a hand in a certain set into array lists that represent each suit, the values in each suit is then sorted
    * 
    * @param set The set number
    * @param handNumber The hand in the set
    */ 
  public void suitSort (int set, int handNumber)
  {
    spades = new ArrayList <Integer> ();
    hearts = new ArrayList <Integer> ();
    diamonds = new ArrayList <Integer> ();
    clubs = new ArrayList <Integer> ();
    
    for (int a = 1 ; a <= setsOfHands [set] [handNumber].length () ; a += 2) //loop through every second character
    {
      if (setsOfHands [set] [handNumber].charAt (a) == 'S') //is it S for spades
        spades.add (convertToValue (setsOfHands [set] [handNumber].charAt (a - 1))); //add the card value before it
      if (setsOfHands [set] [handNumber].charAt (a) == 'H') //is it H for hearts
        hearts.add (convertToValue (setsOfHands [set] [handNumber].charAt (a - 1))); //add the card value before it
      if (setsOfHands [set] [handNumber].charAt (a) == 'D') //is it D for diamondss
        diamonds.add (convertToValue (setsOfHands [set] [handNumber].charAt (a - 1))); //add the card value before it
      if (setsOfHands [set] [handNumber].charAt (a) == 'C') //is it C for clubs
        clubs.add (convertToValue (setsOfHands [set] [handNumber].charAt (a - 1))); //add the card value before it
    }
    //sort each arraylist
    selectionSort (spades);
    selectionSort (hearts);
    selectionSort (diamonds);
    selectionSort (clubs);
  }
  
  /** This method converts a character (card value) into an integer value
    * 
    * @param card The character that represents a card value
    * @return The int value of the card
    */ 
  private int convertToValue (char card) {
    if (card == 'A')
      return 14;
    else if (card == 'K')
      return 13;
    else if (card == 'Q')
      return 12;
    else if (card == 'J')
      return 11;
    else if (card == 'T')
      return 10;
    else
      return Character.getNumericValue(card);
  }
  
  /** This method converts a integer value int a character (card value)
    * 
    * @param value The integer value of a card
    * @return The character that represents a card value
    */ 
  private String convertToCard (int value) {
    if (value == 14)
      return "Ace";
    else if (value == 13)
      return "King";
    else if (value == 12)
      return "Queen";
    else if (value == 11)
      return "Jack";
    else if (value == 10)
      return "10";
    else
      return String.valueOf (value);
  }
  
  /** This method sorts an array list into descending order
    * 
    * @param arr The array list to be sorted
    */
  private void selectionSort (ArrayList <Integer> arr) { 
    int max_idx; 
    int length  = arr.size ();
    
    for (int i = 0; i < length-1; i++) 
    { 
      max_idx = i; 
      for (int j = i+1; j < length; j++) 
        if (arr.get(j) > arr.get(max_idx)) //get the max in the selected elements
        max_idx = j; 
      
      //swap
      int temp = arr.get (max_idx); 
      arr.set (max_idx, arr.get (i));
      arr.set (i, temp);
    } 
    
  }
  
  /** This method calculates the score of a hand
    * 
    * @return The score of the hand
    */
  private int calculateScore () {
    int score = 0;
    //Ace, King, Queen, or Jack
    for (Integer i : spades) {
      if (i - 10 > 0)
        score += (i - 10);
    }
    for (Integer i : hearts){
      if (i - 10 > 0)
        score += (i - 10);
    }
    for (Integer i : diamonds) {
      if (i - 10 > 0)
        score += (i - 10);
    }
    for (Integer i : clubs){
      if (i - 10 > 0)
        score += (i - 10);
    }
    //void
    if (spades.size() == 0)
      score += 3;
    if (hearts.size() == 0)
      score += 3;
    if (diamonds.size() == 0)
      score += 3;
    if (clubs.size() == 0)
      score += 3;
    //singletones
    if (spades.size() == 1)
      score += 2;
    if (hearts.size() == 1)
      score += 2;
    if (diamonds.size() == 1)
      score += 2;
    if (clubs.size() == 1)
      score += 2;
    //doubletons
    if (spades.size() == 2)
      score += 1;
    if (hearts.size() == 2)
      score += 1;
    if (diamonds.size() == 2)
      score += 1;
    if (clubs.size() == 2)
      score += 1;
    return score;
  }
  
  /** This method prints the sorted hand in order of suits and values
    *
    * @param hand The hand to be printed
    */ 
  public void displayHand (int hand) {
    System.out.println ("Hand: " + (hand + 1) + ", Score: " + calculateScore ());
    System.out.print ("Spades: ");
    for (Integer i : spades)
      System.out.print (convertToCard (i) + " "); //convert the integer value to a card value and print it
    System.out.println ();
    System.out.print ("Hearts: ");
    for (Integer i : hearts)
      System.out.print (convertToCard (i) + " "); //convert the integer value to a card value and print it
    System.out.println ();
    System.out.print ("Diamonds: ");
    for (Integer i : diamonds)
      System.out.print (convertToCard (i) + " "); //convert the integer value to a card value and print it
    System.out.println ();
    System.out.print ("Clubs: ");
    for (Integer i : clubs)
      System.out.print (convertToCard (i) + " "); //convert the integer value to a card value and print it
    System.out.println ();
    System.out.println ();
  }
  /**
   * This method evaluates a set to see
   * 
   * @param setNumber The set to be evaluated
   * @return If the set is correct
   */ 
  public boolean evaluateSet (int setNumber) {
    for (int handNumber = 0; handNumber < setsOfHands[setNumber].length; handNumber++)
    {
      if (setsOfHands[setNumber][handNumber].length () != 26) //check if each hand has 26 characters
        return false;
      else
      {
        for (int i = 0; i < 26; i += 2) //check that the card values are correct
        {
          if (setsOfHands[setNumber][handNumber].charAt (i) != 'A' && setsOfHands[setNumber][handNumber].charAt (i) != 'K' && setsOfHands[setNumber][handNumber].charAt (i) != 'Q' && setsOfHands[setNumber][handNumber].charAt (i) != 'J' &&
              setsOfHands[setNumber][handNumber].charAt (i) != 'T' && (int)setsOfHands[setNumber][handNumber].charAt (i) > 57 && (int)setsOfHands[setNumber][handNumber].charAt (i) < 50)
            return false;
        }
        for (int i = 1; i < 26; i += 2) //check that the suits are correct
        {
          if (setsOfHands[setNumber][handNumber].charAt (i) != 'S' && setsOfHands[setNumber][handNumber].charAt (i) != 'C' && setsOfHands[setNumber][handNumber].charAt (i) != 'D' && setsOfHands[setNumber][handNumber].charAt (i) != 'H')
            return false;
        }
      }
    }
    return true;
  }
  
  /**
   * The entry point to the program. 
   * 
   * @param args The arguments passed from the command line. 
   */ 
  public static void main (String[] args)
  {
    Bridge b = new Bridge ();
    if (b.getHands ())
    {
      String [] [] bridgeSets =  b.getSetsOfHands ();
      for (int setN = 0; setN < bridgeSets.length; setN++) //for ever set
      {
        if (b.evaluateSet (setN))
        {
          for (int handN = 0; handN < bridgeSets [setN].length; handN++) //for every hand in the st
          {       
            b.suitSort (setN, handN);
            b.displayHand (handN);
          }
        }
        else
          System.out.println ("Error: Bad infomation in set " + (setN + 1));
      }
    }
    else
      System.out.println ("Error: File infomation is not properly arranged");
  }
}
