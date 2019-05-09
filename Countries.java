import java.io.*;
import java.text.NumberFormat;

/** This class provides methods that allow the user to read Country data from Countries-Population.txt.
  * The name, capital, area and population of each country in the file is read and each stored in their corresponding
  * array. The countries are sorted based on alphabetical name and stored in order in a file called sortedByCountry.txt.
  * The countries are also sorted by population (high to low) and stored in a file called sortedByPopulation.txt.
  * 
  * ICS4U0 with Krasteva, V. 
  * @version 1 April 1, 2019 
  * @author Michael Z, Feng X
  */ 
public class Countries {
  
  private String[] countryNames;
  private String[] countryCapital;
  private String[] countryArea;
  private String[] countryPopulation;
  private String[] badCountries = {"Antigua and Barbuda", "Bosnia and Herzegovina", "Brunei Darussalam", "Burkina Faso", "Cabo Verde", "Cape Verde", "Central African Republic", "Congo, Democratic Republic of the", "Congo, Republic of", "Costa Rica", "Czech Republic", "Côte D'Ivoire", "Côte d'Ivoire", "Dominican Republic", "East Timor", "El Salvador", "Equatorial Guinea", "Guinea Bissau", "Korea, North", "Korea, South", "Marshall Islands", "Myanmar (Burma)", "New Zealand", "Papua New Guinea", "Saint Lucia", "San Marino", "Saudi Arabia", "Sierra Leone", "Solomon Islands", "South Africa", "South Sudan", "Sri Lanka", "St. Kitts and Nevis", "St. Lucia", "St. Vincent and the Grenadines", "São Tomé and Príncipe", "Trinidad and Tobago", "United Arab Emirates", "United Kingdom", "United States", "Vatican City", "Western Sahara"};
  
  private int lineCount;
  
  private String[] sortedCountriesArray;
  private String[] tempCountriesArray;
  private String[] sortedPopulationArray;
  private String[] tempPopulationArray;
  private NumberFormat numberFormat = NumberFormat.getNumberInstance(java.util.Locale.US); //https://docs.oracle.com/javase/7/docs/api/java/text/NumberFormat.html
  
  /** 
   * This method reads the country infomation from the file and stores each piece of infomation in its corresponding array.
   */
  public void getCountryInfo ()
  {
    lineCount = 0;
    try
    {
      BufferedReader br = new BufferedReader(new FileReader("Countries-Population.txt"));
      while (br.readLine() != null)
      {
        lineCount++; //count lines
      }
      br.close ();
      
      //now that I know the number of elements I create the arrays
      countryNames = new String [lineCount];
      countryCapital = new String [lineCount];
      countryArea = new String [lineCount];
      countryPopulation = new String [lineCount];
      
      lineCount = 0;      
      BufferedReader br2 = new BufferedReader(new FileReader("Countries-Population.txt"));
      String line;
      while ((line = br2.readLine()) != null)
      {
        String[] data = line.split(" "); //split by spaces
        countryPopulation[lineCount] = data[data.length-1]; //last element is the population
        countryArea[lineCount] = data[data.length-2]; //second last element is the area
        boolean isBadCountry = false;
        for (String s : badCountries)
        {
          if (line.indexOf(s) != -1) //check for countries with multiple words for name
          {
            countryNames[lineCount] = s;            
            isBadCountry = true;
            break;             
          }
        }
        if (!isBadCountry) //if the country has 1 word for its name
        {
          countryNames[lineCount] = data[0]; //the first element is the name of the country
        }
        countryCapital[lineCount] = line.substring (countryNames[lineCount].length() + 1, line.indexOf(countryArea[lineCount]) - 1); //the capital is in between the country name and area 
        lineCount++; //next index/line
      }
      br2.close ();
    }
    catch (IOException e)
    {
      System.out.println("Something went wrong when reading the file!" + e);
    }
  } 
  
  /** 
   * This method starts the process of the merge sort.
   * @param sortType the sort typr of country or population 
   */ 
  private void sort(String sortType) {
    doMerge(0, lineCount - 1, sortType); 
  }
  
  /** 
   * This method is called recursively to divide the array into each of the groups to be sorted.
   * @param lowerIndex  the lower index of the subgroup
   * @param higherIndex  the higher index of the subgroup
   * @param sortType the sort typr of country or population 
   */
  private void doMerge(int lowerIndex, int higherIndex, String sortType) {    
    if (lowerIndex < higherIndex) {
      int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
      //make 2 half branches
      doMerge(lowerIndex, middle, sortType);
      doMerge(middle + 1, higherIndex, sortType);
      //when the sorts get here, merge them
      merge(lowerIndex, middle, higherIndex, sortType);
    }
  }
  
  /** 
   * This method merges the elements in two subgroups
   * ([start, middle] and [middle+1, end]) in ascending order for country names
   * ([start, middle] and [middle+1, end]) in decending order for population
   * @param lowerIndex  the index of the lower element
   * @param middle  the index of the middle element
   * @param higherIndex  the index of the higher element
   * @param sortType the sort typr of country or population 
   */
  private void merge(int lowerIndex, int middle, int higherIndex, String sortType) {    
    sortedCountriesArray = countryNames;    
    sortedPopulationArray = countryPopulation;
    tempCountriesArray = new String[lineCount];
    tempPopulationArray = new String [lineCount];
    
    for (int i = lowerIndex; i <= higherIndex; i++) {
      tempCountriesArray[i] = sortedCountriesArray[i];
      tempPopulationArray[i] = sortedPopulationArray[i];
    }
    int i = lowerIndex;
    int j = middle + 1;
    int k = lowerIndex;
    while (i <= middle && j <= higherIndex) {
      if ("country".equals(sortType)) {
        if (tempCountriesArray[i].compareTo (tempCountriesArray[j]) <= 0) {
          sortedCountriesArray[k] = tempCountriesArray[i];
          sortedPopulationArray[k] = tempPopulationArray[i];
          i++;
        } else {
          sortedCountriesArray[k] = tempCountriesArray[j];
          sortedPopulationArray[k] = tempPopulationArray[j];
          j++;
        }
      } else {
        try {
          if (numberFormat.parse(sortedPopulationArray[i]).intValue() >= numberFormat.parse(tempPopulationArray[j]).intValue()) { //https://docs.oracle.com/javase/7/docs/api/java/text/NumberFormat.html
            sortedCountriesArray[k] = tempCountriesArray[i];
            sortedPopulationArray[k] = tempPopulationArray[i];
            i++;
          } else {
            sortedCountriesArray[k] = tempCountriesArray[j];
            sortedPopulationArray[k] = tempPopulationArray[j];
            j++;
          }
        }
        catch (java.text.ParseException e)
        {
        }
      }
      k++;
    }
    while (i <= middle) {
      sortedCountriesArray[k] = tempCountriesArray[i];
      sortedPopulationArray[k] = tempPopulationArray[i];
      k++;
      i++;
    }    
  }
  
  /** 
   * This method takes the countries sorted by their name and writes it to another file.
   */
  public void writeCountry ()
  {
    sort("country");
    try  {
      FileWriter fw = new FileWriter (new File ("sortedByCountry.txt"));
      for (int x = 0; x < sortedCountriesArray.length; x++)
        fw.write (sortedCountriesArray[x] + "                                                             ".substring (sortedCountriesArray[x].length() + sortedPopulationArray[x].length()) + sortedPopulationArray[x] + System.getProperty("line.separator")); //write a line to the file, move to next line
      fw.close ();
    }
    catch (IOException e)
    {
    }
  }
  
  /** 
   * This method takes the countries sorted by their population (high to low) and writes it to another file.
   */
  private  void writePopulation ()
  {
    sort("population");
    try  {
      FileWriter fw = new FileWriter (new File ("sortedByPopulation.txt"));
      for (int x = 0; x < sortedPopulationArray.length; x++)
        fw.write (sortedCountriesArray[x] + "                                                             ".substring (sortedCountriesArray[x].length() + sortedPopulationArray[x].length()) + sortedPopulationArray[x] + System.getProperty("line.separator")); //write a line to the file, move to next line
      fw.close ();
    }
    catch (IOException e)
    {
    }
  }
  
  /**
   * The entry point to the program. 
   * 
   * @param args The arguments passed from the command line. 
   */ 
  public static void main (String args [])
  {
    Countries c = new Countries ();
    c.getCountryInfo ();
    c.writeCountry ();
    c.writePopulation ();
  }
}