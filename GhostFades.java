//imports
import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class
/*
*Name: Michael Zhou
*Teacher: Ms. Krasteva
*Date: Oct 13, 2018
*Description: This class animates the ghost fading from the bottom up.
*/

public class GhostFades extends Thread
{
    private Console c;

    public void ghostFades ()
    {
	//local colors
	Color lightBrown = new Color (102, 51, 0);
	for (int x = 0 ; x <= 160 ; x++)
	{
	    c.setColor (lightBrown);
	    c.drawLine (340, 449 - x, 440, 449 - x); //erase for ghost (fading)
	    try
	    {
		sleep (25); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}

    }


    public GhostFades (Console con)  //constructor
    {
	c = con;
    }


    public void run ()
    {

	ghostFades ();
    }
}
