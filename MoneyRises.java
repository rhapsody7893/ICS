import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class
/*
*Name: Michael Zhou
*Program Name: Money Rises - Monopoly
*Teacher: Ms. Krasteva
*Date: Dec 17, 2018
*Description: The purpose of this class is to animate random amounts of money rising from the bottom of the screen

Variable dictionary:
Name:                   Type:               Purpose:
c                       Console             This variable is used to display and get input on the console.
*/

public class MoneyRises implements Runnable //my one class that implements Runnable
{
    private Console c;

    /*
    The purpose of this method is to animate money rising from the bottom screen
    The first for loop is used to draw the colums of money
    The second loop is used to draw a random height for each pile of money
    The try catch is used to catch expections for the thread.sleep
    Variable dictionary:
    Name:               Type:               Purpose:
    black               Color               Stores a black color
    green               Color               Stores a green color
    white               Color               Stores a white color
    */
    public void moneyRises ()
    {
	//local colors
	Color black = new Color (0, 0, 0);
	Color green = new Color (20, 168, 37);
	Color white = new Color (255, 255, 255);
	for (int x = 0 ; x <= 900 ; x += 100)
	{
	    for (int y = 0 ; y <= 151 * Math.random () ; y += 50)
	    {
		c.setColor (green);
		c.fillRect (x + 1, 650 - y, 100, 50); //money stack
		c.setColor (black);
		//edges of the bills
		c.drawLine (x, 660 - y, x + 99, 660 - y);
		c.drawLine (x, 670 - y, x + 99, 670 - y);
		c.drawLine (x, 680 - y, x + 99, 680 - y);
		c.drawLine (x, 690 - y, x + 99, 690 - y);
		c.drawLine (x, 700 - y, x + 99, 700 - y);
		c.setColor (white);
		//binding strand
		c.fillRect (x + 30, 650 - y, 40, 50);
		c.setColor (black);
		c.drawLine (x + 100, 700 - y, x + 100, 650 - y);
		c.setFont (new Font ("Arial", 1, 39));
		c.drawString ("$", x + 40, 690 - y);
		try
		{
		    Thread.sleep (200); //delay
		}
		catch (Exception e)
		{
		}
	    }
	}
    }


    /*
    The purpose of this method (constructor) is to create a new object of console and assign it the reference variable c.
    Variable dictionary:
    Name:               Type:               Purpose:
    con                 Console             reference variable to my main console
    */
    public MoneyRises (Console con)  //constructor
    {
	c = con;
    }


    //This method will be called when the thread starts
    public void run ()
    {
	moneyRises ();
    }
}

