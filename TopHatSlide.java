//imports
import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class
/*
*Name: Michael Zhou
*Program Name: Top Hat Slide - Monopoly
*Teacher: Ms. Krasteva
*Date: Dec 17, 2018
*Description: The purpose of this class is to animate a top hat sliding in from the left side of the screen

Variable dictionary:
Name:                   Type:               Purpose:
c                       Console             This variable is used to display and get input on the console.
*/

public class TopHatSlide extends Thread
{
    private Console c;

    /*
    The purpose of this method is to animate a top hat sliding in from the left side of the screen
    The for loop is used to move the top hat from the left side of the screen
     The try catch is used to catch expections for the thread.sleep 
    Variable dictionary:
    Name:               Type:               Purpose:
    black               Color               Stores a black color
    lightBlue           Color               Stores a lightBlueColor color
    white               Color               Stores a white color
    */
    public void topHatSlide ()
    {
	Color lightBlue = new Color (204, 255, 255);
	Color black = new Color (0, 0, 0);
	Color white = new Color (255, 255, 255);
	for (int x = 0 ; x <= 550 ; x++)
	{
	    c.setColor (lightBlue);
	    c.fillRect (-251 + x, 200, 200, 300);//erase
	    c.setColor (black);
	    //top hat
	    c.fillRect (-200 + x, 200, 200, 250);
	    c.fillRect (-250 + x, 450, 300, 50);
	    c.setColor (white);
	    //white stripe?
	    c.fillRect (-200 + x, 400, 200, 50);
	    try
	    {
		Thread.sleep (20); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    /*
    The purpose of this method (constructor) is to create a new object of console and assign it the reference variable c.
    Variable dictionary:
    Name:               Type:               Purpose:
    con                 Console             reference variable to my main console
    */
    public TopHatSlide (Console con)
    {
	c = con;
    }


    //This method will be called when the thread starts
    public void run ()
    {
	topHatSlide ();
    }
}

