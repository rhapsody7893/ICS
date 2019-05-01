//imports
import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class
/*
*Name: Michael Zhou
*Teacher: Ms. Krasteva
*Date: Oct 13, 2018
*Description: This class animates a mummy that enters from the right side of the console and greets the detective.
*/
public class MummyEnter extends Thread
{
    private Console c;
    //global colors
    Color lime = new Color (0, 255, 0);
    Color lightBrown = new Color (102, 51, 0);
    public void mummyEnter ()
    {
	//local colors
	Color black = new Color (0, 0, 0);
	Color white = new Color (255, 255, 255);
	for (int x = 0 ; x <= 140 ; x++)
	{
	    c.setColor (lightBrown);
	    c.fillRect (640 - x, 300, 81, 160); //erase
	    c.setColor (white);
	    c.fillOval (660 - x, 300, 40, 40); //head
	    c.fillRect (660 - x, 360, 40, 100); //body and legs
	    c.fillArc (660 - x, 340, 40, 40, 0, 180); //top of body
	    c.fillRect (640 - x, 300, 20, 60); //left arm
	    c.fillRect (700 - x, 300, 20, 60); //right arm
	    c.setColor (lime);
	    c.fillOval (670 - x, 314, 7, 7); //left eye
	    c.fillOval (684 - x, 314, 7, 7); //right eye
	    c.setColor (black);
	    //texture of rags
	    c.drawLine (660 - x, 320, 700 - x, 320);
	    c.drawLine (660 - x, 360, 700 - x, 360);
	    c.drawLine (660 - x, 380, 700 - x, 380);
	    c.drawLine (660 - x, 400, 700 - x, 400);
	    c.drawLine (660 - x, 420, 700 - x, 420);
	    c.drawLine (660 - x, 440, 700 - x, 440);
	    c.drawLine (680 - x, 459, 680 - x, 400); //separates legs
	    c.drawLine (640 - x, 340, 660 - x, 340);
	    c.drawLine (640 - x, 320, 660 - x, 320);
	    c.drawLine (700 - x, 340, 719 - x, 340);
	    c.drawLine (700 - x, 320, 719 - x, 320);
	    try
	    {
		sleep (20); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void mummySpeak ()
    {
	c.setFont (new Font ("Sans Serif", 1, 12));
	c.setColor (lime);
	//mummy talks
	c.drawString ("Hi, I'm Mummy. It's like theres a ghost in", 390, 250);
	c.drawString ("this house! But ghosts don't exist..", 390, 260);

	try
	{
	    Thread.sleep (6000); //delay
	}
	catch (InterruptedException e)
	{
	}
	for (int x = 0 ; x <= 230 ; x++)
	{
	    c.setColor (lightBrown);
	    c.drawLine (389 + x, 240, 389 + x, 261); //erase
	}
    }


    public MummyEnter (Console con)  //constructor
    {
	c = con;
    }


    public void run ()
    {
	mummyEnter ();
	mummySpeak ();
    }
}
