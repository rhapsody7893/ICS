//imports
import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class
/*
*Name: Michael Zhou
*Teacher: Ms. Krasteva
*Date: Oct 13, 2018
*Description: This class animates the vampires leaving through the right side of the screen.
*/
public class VampireLeave extends Thread
{
    private Console c;

    public void vampireLeave ()
    {
	for (int x = 0 ; x <= 200 ; x++)
	{
	    //local colors
	    Color red = new Color (153, 0, 0);
	    Color black = new Color (0, 0, 0);
	    Color white = new Color (255, 255, 255);
	    Color lightBrown = new Color (102, 51, 0);
	    c.setColor (lightBrown);
	    c.fillRect (439 + x, 300, 80, 160); //erase
	    c.setColor (white);
	    c.fillOval (460 + x, 300, 40, 40); //head
	    int a[] = {440 + x, 460 + x, 460 + x};
	    int y[] = {300, 320, 335};
	    c.fillPolygon (a, y, 3);  //left ear
	    int a1[] = {520 + x, 500 + x, 500 + x};
	    int y1[] = {300, 320, 335};
	    c.fillPolygon (a1, y1, 3); //right ear
	    c.setColor (red);
	    c.fillOval (465 + x, 310, 15, 15); ///left eye
	    c.fillOval (480 + x, 310, 15, 15); //right eye
	    c.setColor (black);
	    c.fillRoundRect (440 + x, 340, 40, 100, 20, 20); //left eye
	    c.fillRoundRect (480 + x, 340, 40, 100, 20, 20); //right eye
	    int a2[] = {440 + x, 450 + x, 460 + x, 470 + x, 480 + x};
	    int y2[] = {430, 460, 430, 460, 430};
	    c.fillPolygon (a2, y2, 5); //bottom of left cape
	    int a3[] = {480 + x, 490 + x, 500 + x, 510 + x, 520 + x};
	    int y3[] = {430, 460, 430, 460, 430};
	    c.fillPolygon (a3, y3, 5); //bottom of right cape
	    c.fillOval (469 + x, 314, 7, 7); //left pupil
	    c.fillOval (484 + x, 314, 7, 7); //right pupil
	    c.drawLine (470 + x, 330, 490 + x, 330); //mouth
	    try
	    {
		sleep (15); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public VampireLeave (Console con)  //constructor
    {
	c = con;
    }


    public void run ()
    {
	vampireLeave ();
    }
}

