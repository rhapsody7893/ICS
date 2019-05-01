//imports
import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class
/*
*Name: Michael Zhou
*Teacher: Ms. Krasteva
*Date: Oct 13, 2018
*Description: This class animates the detective leaving the console from the right.
*/
public class DetectiveLeave extends Thread
{
    private Console c;

    public void detectiveLeave ()
    {
	//local colors
	Color peach = new Color (255, 229, 204);
	Color olive = new Color (204, 204, 0);
	Color darkBrown = new Color (51, 25, 0);
	Color darkOlive = new Color (150, 150, 0);
	Color black = new Color (0, 0, 0);
	Color white = new Color (255, 255, 255);
	Color lightBrown = new Color (102, 51, 0);
	for (int x = 0 ; x <= 562 ; x++)
	{
	    c.setColor (lightBrown);
	    c.fillRect (77 + x, 300, 84, 160); //erase
	    c.setColor (peach);
	    c.fillArc (98 + x, 300, 40, 40, 180, 180); //bottom head part
	    c.setColor (olive);
	    c.fillArc (98 + x, 300, 40, 40, 0, 180); //hat
	    c.fillArc (98 + x, 340, 40, 40, 0, 180); //top of body
	    c.fillRect (98 + x, 360, 40, 60); //body
	    c.drawLine (78 + x, 320, 158 + x, 320); //rim of hat
	    c.setColor (darkOlive);
	    c.fillRect (98 + x, 420, 40, 40); //legs
	    c.fillArc (110 + x, 350, 15, 15, 0, 180); //shoulder
	    c.fillRect (110 + x, 357, 15, 40); //arm
	    c.setColor (olive);
	    c.drawLine (118 + x, 459, 118 + x, 420); //separates legs
	    c.setColor (black);
	    c.fillRect (118 + x, 397, 30, 10); //flashlight
	    c.fillOval (145 + x, 394, 15, 15); //flashlight lens
	    c.drawLine (123 + x, 332, 143 + x, 332); //bubble blower
	    c.fillArc (143 + x, 327, 10, 10, 180, 180); //bubble blower end part
	    c.setColor (peach);
	    c.fillOval (110 + x, 397, 15, 15); //hand
	    try
	    {
		sleep (15); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }




    public DetectiveLeave (Console con)  //constructor
    {
	c = con;
    }


    public void run ()
    {
	detectiveLeave ();

    }
}
