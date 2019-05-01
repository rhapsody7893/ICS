//import
import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class
/*
*Name: Michael Zhou
*Teacher: Ms. Krasteva
*Date: Oct 13, 2018
*Description: This class animates a ghost passing from the left screen to the right.
*/

public class GhostFollows extends Thread
{
    private Console c;

    public void ghostFollows ()
    {
	//local colors
	Color grey = new Color (200, 200, 200);
	Color black = new Color (0, 0, 0);
	Color white = new Color (255, 255, 255);
	Color lightBrown = new Color (102, 51, 0);
	for (int x = 0 ; x <= 740 ; x++)
	{
	    c.setColor (lightBrown);
	    c.fillRect (-101 + x, 300, 100, 150); //erase
	    c.setColor (white);
	    c.fillArc (-100 + x, 300, 100, 80, 0, 180); //top of ghost
	    c.fillRect (-100 + x, 340, 100, 100); //body of ghost
	    c.fillArc (-100 + x, 430, 20, 20, 180, 180); //bottom of the ghost
	    c.fillArc (-60 + x, 430, 20, 20, 180, 180); //bottom of the ghost
	    c.fillArc (-20 + x, 430, 20, 20, 180, 180); //bottom of the ghost
	    c.setColor (lightBrown);
	    c.fillArc (-80 + x, 430, 20, 20, 0, 180); //bottom of the ghost
	    c.fillArc (-40 + x, 430, 20, 20, 0, 180); //bottom of the ghost
	    c.setColor (grey);
	    c.fillOval (-70 + x, 310, 20, 20); //left eye
	    c.fillOval (-50 + x, 310, 20, 20); //right eye
	    c.setColor (black);
	    c.fillOval (-65 + x, 315, 10, 10); //left pupil
	    c.fillOval (-45 + x, 315, 10, 10); //right pupil
	    c.drawLine (-80 + x, 340, -60 + x, 360); //left part of smile
	    c.drawLine (-60 + x, 360, -40 + x, 360); //middle part of smile
	    c.drawLine (-40 + x, 360, -20 + x, 340); //right part of smile
	    try
	    {
		sleep (15); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public GhostFollows (Console con)  //constructor
    {
	c = con;
    }


    public void run ()
    {
	ghostFollows ();

    }
}

