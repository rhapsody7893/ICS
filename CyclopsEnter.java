//imports
import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class
/*
*Name: Michael Zhou
*Teacher: Ms. Krasteva
*Date: Oct 13, 2018
*Description: This class animates a cyclops that enters form the right of the console and greets the detective.
*/
public class CyclopsEnter extends Thread
{
    private Console c;
    //global colors
    Color olive = new Color (204, 204, 0);
    Color lightBrown = new Color (102, 51, 0);

    public void cyclopsEnter ()
    {
	//local colors
	Color black = new Color (0, 0, 0);
	Color white = new Color (255, 255, 255);
	Color darkOlive = new Color (170, 170, 0);
	Color darkGreen = new Color (0, 51, 0);
	for (int x = 0 ; x <= 220 ; x++)
	{
	    c.setColor (lightBrown);
	    c.fillRect (640 - x, 300, 81, 160); //erase
	    c.setColor (olive);
	    c.fillOval (660 - x, 300, 40, 40); //head
	    c.fillRect (660 - x, 340, 40, 60); //body
	    c.fillArc (640 - x, 340, 40, 40, 90, 90); //left shoulder
	    c.fillArc (680 - x, 340, 40, 40, 0, 90); //right shoulder
	    c.fillRect (640 - x, 360, 20, 20); //left arm
	    c.fillRect (700 - x, 360, 20, 20); //right arm
	    c.setColor (darkOlive);
	    c.fillRect (640 - x, 380, 20, 20); //left hand
	    c.fillRect (700 - x, 380, 20, 20); //right hand
	    c.setColor (white);
	    c.fillOval (673 - x, 310, 15, 15); //eye
	    c.setColor (darkGreen);
	    c.fillRect (660 - x, 400, 40, 60); //legs
	    c.setColor (black);
	    c.fillOval (677 - x, 314, 7, 7); //pupil
	    c.drawLine (670 - x, 330, 690 - x, 330); //mouth
	    c.drawArc (673 - x, 304, 15, 15, 0, 180); //eyebrow
	    c.drawLine (680 - x, 459, 680 - x, 400); //line that separates legs

	    try
	    {
		sleep (20); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void cyclopsSpeak ()
    {
	c.setFont (new Font ("Sans Serif", 1, 12));
	c.setColor (olive);
	//cyclops speaks
	c.drawString ("I live here with Mummy. I need your help because", 360, 250);
	c.drawString ("wierd stuff is happening. Furniture is moving", 360, 260);
	c.drawString ("around on its own and I need your skills.", 360, 270);

	try
	{
	    Thread.sleep (6000); //delay
	}
	catch (InterruptedException e)
	{
	}
	for (int x = 0 ; x <= 275 ; x++)
	{
	    c.setColor (lightBrown);
	    c.drawLine (359 + x, 240, 359 + x, 272); //erase
	}
    }


    public CyclopsEnter (Console con)  //constructor
    {
	c = con;
    }


    public void run ()
    {
	cyclopsEnter ();
	cyclopsSpeak ();
    }
}
