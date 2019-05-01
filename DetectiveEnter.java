import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class
/*
*Name: Michael Zhou
*Teacher: Ms. Krasteva
*Date: Oct 13, 2018
*Description: This class animates a detective entering from the left side of the console.
*/

public class DetectiveEnter implements Runnable //my one class that implements Runnable
{
    private Console c;
    //global color
    Color lightBrown = new Color (102, 51, 0);

    public void detectiveEnter ()
    {
	//local colors
	Color peach = new Color (255, 229, 204);
	Color olive = new Color (204, 204, 0);
	Color darkBrown = new Color (51, 25, 0);
	Color darkOlive = new Color (150, 150, 0);
	Color black = new Color (0, 0, 0);
	Color white = new Color (255, 255, 255);
	for (int x = 0 ; x <= 178 ; x++)
	{
	    c.setColor (lightBrown);
	    c.fillRect (-101 + x, 300, 81, 160); //erase
	    c.setColor (peach);
	    c.fillArc (-80 + x, 300, 40, 40, 180, 180); //head (bottom half)
	    c.setColor (olive);
	    c.fillArc (-80 + x, 300, 40, 40, 0, 180); //hat
	    c.fillArc (-80 + x, 340, 40, 40, 0, 180); //top part of body
	    c.fillRect (-80 + x, 360, 40, 60); //body
	    c.drawLine (-100 + x, 320, -20 + x, 320); //rim of hat
	    c.setColor (darkOlive);
	    c.fillRect (-80 + x, 420, 40, 40); //legs
	    c.fillArc (-68 + x, 350, 15, 15, 0, 180); //shoulder
	    c.fillRect (-68 + x, 357, 15, 40); //arm
	    c.setColor (olive);
	    c.drawLine (-60 + x, 459, -60 + x, 420); //legs separator
	    c.setColor (black);
	    c.fillRect (-60 + x, 397, 30, 10); //flashlight handle
	    c.fillOval (-33 + x, 395, 13, 13); //flashlight fornt part
	    c.drawLine (-55 + x, 332, -35 + x, 332); //bubble blower
	    c.fillArc (-35 + x, 327, 10, 10, 180, 180); //bubble blower
	    c.setColor (peach);
	    c.fillOval (-68 + x, 397, 15, 15); //hand

	    try
	    {
		Thread.sleep (15); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void detectiveSpeak ()
    {
	//local color
	Color white = new Color (255, 255, 255);
	c.setColor (white);
	c.setFont (new Font ("Sans Serif", 1, 12));
	c.drawString ("Anyone home?", 180, 330); //detective talks

	try
	{
	    Thread.sleep (2000); //pause
	}
	catch (InterruptedException e)
	{
	}

	for (int x = 0 ; x <= 84 ; x++)
	{
	    c.setColor (lightBrown);
	    c.drawLine (179 + x, 320, 179 + x, 333); //erase
	}
    }


    public DetectiveEnter (Console con)  //constructor
    {
	c = con;
    }


    public void run ()
    {
	detectiveEnter ();
	detectiveSpeak ();
    }
}

