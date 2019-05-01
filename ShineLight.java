//imports
import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class
/*
*Name: Michael Zhou
*Teacher: Ms. Krasteva
*Date: Oct 13, 2018
*Description: This class animates the flashlight shooting a beam of light while the detective talks.
*/
public class ShineLight extends Thread
{
    private Console c;
    //global color
    Color lightBrown = new Color (102, 51, 0);

    public void detectiveSpeak ()
    {
	Color white = new Color (255, 255, 255);
	c.setColor (white);
	c.setFont (new Font ("Sans Serif", 1, 12));
	c.drawString ("Flashlight attack!", 260, 270); //detective speaks

	try
	{
	    Thread.sleep (2000); //delay
	}
	catch (InterruptedException e)
	{
	}
	for (int x = 0 ; x <= 95 ; x++)
	{
	    c.setColor (lightBrown);
	    c.drawLine (259 + x, 260, 259 + x, 271); //erase
	}
    }


    public void shineLight ()
    {
	Color yellow = new Color (255, 255, 0);
	for (int x = 0 ; x <= 77 ; x++)
	{
	    c.setColor (yellow);
	    c.drawLine (260 + x, 400 - x / 2, 260 + x, 400 + x / 2); //beam
	    try
	    {
		sleep (25); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }




    public void lightFades ()
    {
	for (int x = 0 ; x <= 77 ; x++)
	{
	    c.setColor (lightBrown);
	    c.drawLine (260 + x, 400 - x / 2, 260 + x, 400 + x / 2); //erase for beam
	    try
	    {
		sleep (25); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public ShineLight (Console con)  //constructor
    {
	c = con;
    }


    public void run ()
    {
	detectiveSpeak ();
	shineLight ();
	lightFades ();
    }
}
