//imports
import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class
/*
*Name: Michael Zhou
*Teacher: Ms. Krasteva
*Date: Oct 13, 2018
*Description: This class animates a vampire entering from the right side of the screen and talking to the detective.
*/
public class VampireEnter extends Thread
{
    private Console c;
    Color white = new Color (255, 255, 255);
    Color lightBrown = new Color (102, 51, 0);

    public void vampireEnter ()
    {
	//local colors
	Color red = new Color (153, 0, 0);
	Color black = new Color (0, 0, 0);
	for (int x = 0 ; x <= 200 ; x++)
	{
	    c.setColor (lightBrown);
	    c.fillRect (640 - x, 300, 81, 160); //erase
	    c.setColor (white);
	    c.fillOval (660 - x, 300, 40, 40); //head
	    int a[] = {640 - x, 660 - x, 660 - x};
	    int y[] = {300, 320, 335};
	    c.fillPolygon (a, y, 3); //left ear
	    int a1[] = {720 - x, 700 - x, 700 - x};
	    int y1[] = {300, 320, 335};
	    c.fillPolygon (a1, y1, 3); //right ear
	    c.setColor (red);
	    c.fillOval (665 - x, 310, 15, 15); //left eye
	    c.fillOval (680 - x, 310, 15, 15); //right eye
	    c.setColor (black);
	    c.fillRoundRect (640 - x, 340, 40, 100, 20, 20); //left cape
	    c.fillRoundRect (680 - x, 340, 40, 100, 20, 20); //right cape
	    int a2[] = {640 - x, 650 - x, 660 - x, 670 - x, 680 - x};
	    int y2[] = {430, 460, 430, 460, 430};
	    c.fillPolygon (a2, y2, 5); //bottom of left cape
	    int a3[] = {680 - x, 690 - x, 700 - x, 710 - x, 720 - x};
	    int y3[] = {430, 460, 430, 460, 430};
	    c.fillPolygon (a3, y3, 5); //bottom of right cape
	    c.fillOval (669 - x, 314, 7, 7); //left pupil
	    c.fillOval (684 - x, 314, 7, 7); //right pupil
	    c.drawLine (670 - x, 330, 690 - x, 330); //mouth
	    try
	    {
		sleep (20); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void vampireAndDetectiveTalk ()
    {

	Color red2 = new Color (152, 0, 0);
	c.setFont (new Font ("Sans Serif", 1, 12));
	c.setColor (red2);
	c.drawString ("I vill suck your blood!", 290, 330); //vampire talks
	try
	{
	    Thread.sleep (4000); // delay
	}
	catch (InterruptedException e)
	{
	}

	for (int x = 0 ; x <= 140 ; x++)
	{
	    c.setColor (lightBrown);
	    c.drawLine (289 + x, 320, 289 + x, 333); //erase
	}

	c.setColor (white);
	c.drawString ("I had garlic bread for breakfast...", 180, 330); //detective talks
	try
	{
	    Thread.sleep (4000); //delay
	}
	catch (InterruptedException e)
	{
	}

	for (int x = 0 ; x <= 230 ; x++)
	{
	    c.setColor (lightBrown);
	    c.drawLine (179 + x, 320, 179 + x, 333); //erase
	}
    }




    public VampireEnter (Console con)  //constructor
    {
	c = con;
    }


    public void run ()
    {
	vampireEnter ();
	vampireAndDetectiveTalk ();
    }
}

