import java.io.*;
import java.util.*;

/** This class demonstrates a simple bucket sort with postitive integers
  * @author Michael Zhou, Feng Xiong
  * @version 1.0
  */ 
public class BucketSort{
  int [] allNumbers; //original array of elements 
  
  public BucketSort(){
    String[] allStringNumbers = null;
    //Gets input for cards
    try{
      BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
      allStringNumbers = br.readLine().split(" ");    
    }catch(IOException e){
      
    }
    //convert input into an integer array
    allNumbers = new int [allStringNumbers.length];
    for (int i = 0; i < allStringNumbers.length; i++)
    {
      allNumbers[i] = Integer.parseInt(allStringNumbers[i]);
    }
    
  }
  
  public ArrayList<Integer> sort(){//This is the sorting algorithm
    //find the max and min values in order to calculate the range and the number of buckets
    int min = allNumbers[0];
    int max = allNumbers[0];
    for (int i = 0; i < allNumbers.length; i ++)
    {
      if (allNumbers [i] < min)
        min = allNumbers [i];
      if (allNumbers [i] > max)
        max = allNumbers [i];
    }
    
    //Inititialize the ArrayList
    ArrayList<Integer>[] buckets = new ArrayList [(max - min)/10 + 1];//Creates buckets, each hold a range of 10 values
    for (int i = 0; i < buckets.length; i ++) //each bucket
    {
      buckets [i] = new ArrayList <Integer> ();
    }
    //put the elements into buckets
    for(int i = 0; i < allNumbers.length; i++)//For each Bucket
    {
      buckets[allNumbers[i]/10].add (allNumbers[i]); //add the element to the correct bucket
    }
    
    //Print the unsorted buckets for visualization
    System.out.println ("Unsorted buckets: ");
    for (int i = 0; i < buckets.length; i ++) //each bucket
    {
      System.out.println (buckets[i]);
    }
    
    //Sort each bucket
    System.out.println ("Sorted buckets: ");
    buckets[0] = insertionSort(buckets[0]);//Sort the first bucket
    for(int i = 1; i < buckets.length; i++){//For each bucket
      buckets[i] = insertionSort(buckets[i]);//Sort the bucket
      buckets[0].addAll(buckets[i]);//Add the bucket to the first bucket
    }
    return buckets[0];//Return the first bucket
  }
  
  public ArrayList<Integer> insertionSort(ArrayList<Integer> input){//The insertion sort to sort individual buckets
    for(int i = 1; i < input.size(); i++){//for the size of the bucket
      int temp = input.remove(i);//Remove the Integer at the current index
      int j = 0;
      for(j = 0; j < i; j++)//Starting from 0, loop to right before the removed index.
        if(temp < input.get(j))//if the current integer is bigger
        break;//Leave the for loop
      input.add(j, temp);//At the place where the loop was exited, add the new piece
    }
    System.out.println (input);
    return input;//Return the sorted ArrayList
  }
  
  public static void main(String[] args) {
    System.out.println("Final sorted elements: " + (new BucketSort()).sort()); //print the array
  }
  
  //Test case: 46 49 17 7 92 83 57 31 2 19 58 59 26 36 12 92 95 21 55 78 35 64 37 43 16 25 48 87 45 90 75 62 9 96 27 49 95 72 71 17 31 51 33 49 88 63 15 4 63 87 53 96 81 7 41 62 22 56 48 98 52 32 76 98 2 62 56 55 57 25 32 85 4 29 65 42 87 48 53 28 75 0 85 83 1 18 27 50 57 92 36 42 6 0 2 43 2 16 48 36
}