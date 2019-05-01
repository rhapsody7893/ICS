//imports
import java.awt.*;
import hsa.Console;

/*
*Name: Michael Zhou
*Teacher: Ms. Krasteva
*Date: Oct 13, 2018
*Description: This class displays an intro screen that includes a title and my name.
*/

public class Intro
{
    private Console c;

    public void intro ()
    {
	//local colors
	Color orange = new Color (255, 128, 0);
	Color aqua = new Color (102, 205, 170);
	for (int x = 0 ; x <= 640 ; x++)
	{
	    c.setColor (orange);
	    c.drawLine (0 + x, 0, 0 + x, 500); //background
	}
	c.setColor (aqua);
	c.setFont (new Font ("Algerian", 1, 50));
	c.drawString ("Haunted House", 80, 100); //title
	c.drawString ("Mystery", 80, 180); //title
	c.setFont (new Font ("Algerian", 1, 20));
	c.drawString ("By: Michael Zhou", 80, 380); //name
	try
	{
	    Thread.sleep (3000); //pause
	}
	catch (InterruptedException e)
	{
	}

    }


    public Intro (Console con)  //constructor
    {
	c = con;
	intro ();
    }
}
