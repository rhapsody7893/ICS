//imports
import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class
/*
*Name: Michael Zhou
*Teacher: Ms. Krasteva
*Date: Oct 13, 2018
*Description: This class animates the eyes of the portraits moving to the right.
*/
public class EyesFollow extends Thread
{
    private Console c;

    public void eyesFollow ()
    {
	//local colors
	Color black = new Color (0, 0, 0);
	Color white = new Color (255, 255, 255);
	for (int x = 0 ; x <= 10 ; x++)
	{
	    c.setColor (white);
	    //first portrait eyes
	    c.fillOval (120 + x, 180, 10, 11);
	    c.fillOval (150 + x, 180, 10, 11);
	    //second portrait eyes
	    c.fillOval (340 + x, 180, 10, 11);
	    c.fillOval (370 + x, 180, 10, 11);
	    //third portrait eyes
	    c.fillOval (560 + x, 180, 10, 11);
	    c.fillOval (590 + x, 180, 10, 11);
	    c.setColor (black);
	    //first portrait pupils
	    c.fillOval (121 + x, 181, 9, 9);
	    c.fillOval (151 + x, 181, 9, 9);
	    //second portrait pupils
	    c.fillOval (341 + x, 181, 9, 9);
	    c.fillOval (371 + x, 181, 9, 9);
	    //third portrait pupils
	    c.fillOval (561 + x, 181, 9, 9);
	    c.fillOval (591 + x, 181, 9, 9);
	    try
	    {
		sleep (300); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public EyesFollow (Console con) //constructor
    {
	c = con;
    }


    public void run ()
    {
	eyesFollow ();

    }
}
