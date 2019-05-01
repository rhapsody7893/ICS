//imports
import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class
/*
*Name: Michael Zhou
*Teacher: Ms. Krasteva
*Date: Oct 13, 2018
*Description: This class animates a ghost that enters, picks up a chair, and exits. The cyclops and mummy talk.
*/
public class GhostMovesChair extends Thread
{
    private Console c;
    //global colors
    Color lightBrown = new Color (102, 51, 0);
    Color lime = new Color (0, 255, 0);
    Color grey = new Color (200, 200, 200);
    Color black = new Color (0, 0, 0);
    Color white = new Color (255, 255, 255);
    Color yellow = new Color (255, 255, 0);
    Color red = new Color (152, 0, 0);

    public void ghostEnters ()
    {
	for (int x = 0 ; x <= 260 ; x++) //moving right
	{
	    c.setColor (lightBrown);
	    c.fillRect (-101 + x, 140, 100, 150); //erase
	    c.setColor (white);
	    c.fillArc (-100 + x, 140, 100, 80, 0, 180); //top of ghost
	    c.fillRect (-100 + x, 180, 100, 100); //body of ghost
	    //bottom part of ghost (frills?)
	    c.fillArc (-100 + x, 270, 20, 20, 180, 180);
	    c.fillArc (-60 + x, 270, 20, 20, 180, 180);
	    c.fillArc (-20 + x, 270, 20, 20, 180, 180);
	    c.setColor (lightBrown);
	    //bottom part of ghost
	    c.fillArc (-80 + x, 270, 20, 20, 0, 180);
	    c.fillArc (-40 + x, 270, 20, 20, 0, 180);
	    c.setColor (grey);
	    //eyes
	    c.fillOval (-70 + x, 150, 20, 20); //left eye
	    c.fillOval (-50 + x, 150, 20, 20); //right eye
	    c.setColor (black);
	    c.fillOval (-65 + x, 155, 10, 10); //left pupil
	    c.fillOval (-45 + x, 155, 10, 10); //right pupil
	    c.drawLine (-80 + x, 180, -60 + x, 200); //left part of smile
	    c.drawLine (-60 + x, 200, -40 + x, 200); //middle part of smile
	    c.drawLine (-40 + x, 200, -20 + x, 180); //right part of smile
	    try
	    {
		sleep (15); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void ghostFloatsDown ()
    {
	for (int x = 0 ; x <= 160 ; x++) //moving down
	{
	    c.setColor (lightBrown);
	    c.fillRect (160, 139 + x, 100, 150); //erase
	    c.setColor (white);
	    c.fillArc (160, 140 + x, 100, 80, 0, 180); //top of ghost
	    c.fillRect (160, 180 + x, 100, 100); //body
	    //bottom part
	    c.fillArc (160, 270 + x, 20, 20, 180, 180);
	    c.fillArc (200, 270 + x, 20, 20, 180, 180);
	    c.fillArc (240, 270 + x, 20, 20, 180, 180);
	    c.setColor (lightBrown);
	    //bottom part
	    c.fillArc (180, 270 + x, 20, 20, 0, 180);
	    c.fillArc (220, 270 + x, 20, 20, 0, 180);
	    c.setColor (grey);
	    c.fillOval (190, 150 + x, 20, 20); //left eye
	    c.fillOval (210, 150 + x, 20, 20); //right eye
	    c.setColor (black);
	    c.fillOval (195, 155 + x, 10, 10); //left pupil
	    c.fillOval (215, 155 + x, 10, 10); //right pupil
	    c.drawLine (180, 180 + x, 200, 200 + x); //left part of smile
	    c.drawLine (200, 200 + x, 220, 200 + x); //middle part of smile
	    c.drawLine (220, 200 + x, 240, 180 + x); //right part of smile
	    try
	    {
		sleep (15); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void ghostFloatsUp ()
    {
	for (int x = 0 ; x <= 160 ; x++) //moving up
	{
	    c.setColor (lightBrown);
	    c.fillRect (160, 300 - x, 222, 160); //erase
	    c.setColor (white);
	    c.fillArc (160, 300 - x, 100, 80, 0, 180); //top of ghost
	    c.fillRect (160, 340 - x, 100, 100); //body
	    //bottom part
	    c.fillArc (160, 430 - x, 20, 20, 180, 180);
	    c.fillArc (200, 430 - x, 20, 20, 180, 180);
	    c.fillArc (240, 430 - x, 20, 20, 180, 180);
	    c.setColor (lightBrown);
	    //bottom part
	    c.fillArc (180, 430 - x, 20, 20, 0, 180);
	    c.fillArc (220, 430 - x, 20, 20, 0, 180);
	    c.setColor (grey);
	    c.fillOval (190, 310 - x, 20, 20); //left eye
	    c.fillOval (210, 310 - x, 20, 20); //right eye
	    c.setColor (black);
	    c.fillOval (195, 315 - x, 10, 10); //left pupil
	    c.fillOval (215, 315 - x, 10, 10); //right pupil
	    c.drawLine (180, 340 - x, 200, 360 - x); //left part of smile
	    c.drawLine (200, 360 - x, 220, 360 - x); //middle part of smile
	    c.drawLine (220, 360 - x, 240, 340 - x); //right part of smile
	    //chair moving up
	    c.setColor (red);
	    c.fillRect (281, 339 - x, 80, 120); //middle part
	    c.fillArc (281, 299 - x, 80, 80, 0, 180); //top part
	    c.fillRect (361, 379 - x, 20, 80); //right arm rest
	    c.fillRect (261, 379 - x, 20, 80); //left armrest
	    c.setColor (black);
	    c.drawRoundRect (281, 418 - x, 80, 40, 20, 20); //bottom cushion
	    c.drawLine (280, 458 - x, 280, 379 - x); //left arm rest seperator
	    c.drawLine (360, 458 - x, 360, 379 - x); //right arm rest seperator
	    c.setColor (yellow);
	    c.fillOval (315, 339 - x, 10, 10); //top button
	    c.fillOval (315, 379 - x, 10, 10); //bottom button

	    try
	    {
		sleep (15); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void ghostFloatsAway ()
    {
	for (int x = 0 ; x <= 480 ; x++) //moving right
	{
	    c.setColor (lightBrown);
	    c.fillRect (159 + x, 139, 222, 160); //erase
	    c.setColor (white);
	    c.fillArc (160 + x, 140, 100, 80, 0, 180); //top part
	    c.fillRect (160 + x, 180, 100, 100); //body
	    //bottom part
	    c.fillArc (160 + x, 270, 20, 20, 180, 180);
	    c.fillArc (200 + x, 270, 20, 20, 180, 180);
	    c.fillArc (240 + x, 270, 20, 20, 180, 180);
	    c.setColor (lightBrown);
	    //bottom part
	    c.fillArc (180 + x, 270, 20, 20, 0, 180);
	    c.fillArc (220 + x, 270, 20, 20, 0, 180);
	    c.setColor (grey);
	    c.fillOval (190 + x, 150, 20, 20); //left eye
	    c.fillOval (210 + x, 150, 20, 20); //right eye
	    c.setColor (black);
	    c.fillOval (195 + x, 155, 10, 10); //left pupil
	    c.fillOval (215 + x, 155, 10, 10); //right pupil
	    c.drawLine (180 + x, 180, 200 + x, 200); //left part of smile
	    c.drawLine (200 + x, 200, 220 + x, 200); //middle part of smile
	    c.drawLine (220 + x, 200, 240 + x, 180); //right part of smile
	    //chair
	    c.setColor (red);
	    c.fillRect (281 + x, 179, 80, 120); //middle part
	    c.fillArc (281 + x, 139, 80, 80, 0, 180); //top part of chair
	    c.fillRect (361 + x, 219, 20, 80); //right arm rest
	    c.fillRect (261 + x, 219, 20, 80); //left arm rest
	    c.setColor (black);
	    c.drawRoundRect (281 + x, 258, 80, 40, 20, 20); //bottom cushion
	    c.drawLine (280 + x, 298, 280 + x, 219); //left arm rest seperator
	    c.drawLine (360 + x, 298, 360 + x, 219); //right arm rest seperator
	    c.setColor (yellow);
	    c.fillOval (315 + x, 179, 10, 10); //top button
	    c.fillOval (315 + x, 219, 10, 10); //bottom button
	    try
	    {
		sleep (15); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void cyclopsSpeak ()
    {
	Color olive = new Color (204, 204, 0);
	c.setFont (new Font ("Sans Serif", 1, 12));
	c.setColor (olive);
	c.drawString ("HEY! THAT'S MY FAVOURITE CHAIR!", 360, 270); //cyclops talks
	try
	{
	    Thread.sleep (3000); //delay
	}
	catch (InterruptedException e)
	{
	}
	for (int x = 0 ; x <= 197 ; x++)
	{
	    c.setColor (lightBrown);
	    c.drawLine (359 + x, 260, 359 + x, 270); //erase
	}
    }


    public void mummySpeak ()
    {
	c.setFont (new Font ("Sans Serif", 1, 12));
	c.setColor (lime);
	c.drawString ("CATCH THAT GHOST!", 360, 270); //mummy talks

	try
	{
	    Thread.sleep (5000); //delay
	}
	catch (InterruptedException e)
	{
	}
	for (int x = 0 ; x <= 120 ; x++)
	{
	    c.setColor (lightBrown);
	    c.drawLine (359 + x, 260, 359 + x, 270); //erase
	}
    }


    public GhostMovesChair (Console con)  //constructor
    {
	c = con;
    }


    public void run ()
    {
	ghostEnters ();
	ghostFloatsDown ();
	ghostFloatsUp ();
	ghostFloatsAway ();
	cyclopsSpeak ();
	mummySpeak ();

    }
}
