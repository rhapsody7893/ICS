//imports
import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class
/*
*Name: Michael Zhou
*Teacher: Ms. Krasteva
*Date: Oct 13, 2018
*Description: This class animates the detective, cyclops, and mummy chasing after the ghost.
*/

public class Chase extends Thread
{
    private Console c;
    //global colors
    Color grey = new Color (200, 200, 200);
    Color black = new Color (0, 0, 0);
    Color white = new Color (255, 255, 255);
    Color lightBrown = new Color (102, 51, 0);
    Color yellow = new Color (255, 255, 0);
    Color red = new Color (152, 0, 0);
    Color olive = new Color (204, 204, 0);
    Color darkOlive = new Color (150, 150, 0);
    public void ghostRuns ()
    {

	for (int x = 0 ; x <= 560 ; x++)
	{
	    //ghost
	    c.setColor (lightBrown);
	    c.fillRect (-221 + x, 139, 222, 160); //erase
	    c.setColor (white);
	    c.fillArc (-220 + x, 140, 100, 80, 0, 180); //top of ghost
	    c.fillRect (-220 + x, 180, 100, 100); //body
	    //bottom part
	    c.fillArc (-220 + x, 270, 20, 20, 180, 180);
	    c.fillArc (-180 + x, 270, 20, 20, 180, 180);
	    c.fillArc (-140 + x, 270, 20, 20, 180, 180);
	    c.setColor (lightBrown);
	    //bottom part
	    c.fillArc (-200 + x, 270, 20, 20, 0, 180);
	    c.fillArc (-160 + x, 270, 20, 20, 0, 180);
	    c.setColor (grey);
	    c.fillOval (-190 + x, 150, 20, 20); //left eye
	    c.fillOval (-170 + x, 150, 20, 20); //right eye
	    c.setColor (black);
	    c.fillOval (-185 + x, 155, 10, 10); //left pupil
	    c.fillOval (-165 + x, 155, 10, 10); //right pupil
	    c.drawLine (-200 + x, 180, -180 + x, 200); //left part of smile
	    c.drawLine (-180 + x, 200, -160 + x, 200); //middle part of smile
	    c.drawLine (-160 + x, 200, -140 + x, 180); //right part of smile
	    //chair
	    c.setColor (red);
	    c.fillRect (-99 + x, 179, 80, 120); //middle part of chair
	    c.fillArc (-99 + x, 139, 80, 80, 0, 180); //top part
	    c.fillRect (-19 + x, 219, 20, 80); //right arm rest
	    c.fillRect (-119 + x, 219, 20, 80); //left arm rest
	    c.setColor (black);
	    c.drawRoundRect (-99 + x, 258, 80, 40, 20, 20); //bottom cushion
	    c.drawLine (-100 + x, 298, -100 + x, 219); //left arm rest separator
	    c.drawLine (-20 + x, 298, -20 + x, 219); //right arm rest separator
	    c.setColor (yellow);
	    c.fillOval (-65 + x, 179, 10, 10); //top button
	    c.fillOval (-65 + x, 219, 10, 10); //bottom button
	    try
	    {
		sleep (15); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void ghostRunsDown ()
    {
	for (int x = 0 ; x <= 160 ; x++)
	{
	    //ghost
	    c.setColor (lightBrown);
	    c.fillRect (338, 138 + x, 223, 160); //erase
	    c.setColor (white);
	    c.fillArc (340, 140 + x, 100, 80, 0, 180); //top part of ghost
	    c.fillRect (340, 180 + x, 100, 100); //body
	    //bottom part
	    c.fillArc (340, 270 + x, 20, 20, 180, 180);
	    c.fillArc (380, 270 + x, 20, 20, 180, 180);
	    c.fillArc (420, 270 + x, 20, 20, 180, 180);
	    c.setColor (lightBrown);
	    //bottom part
	    c.fillArc (360, 270 + x, 20, 20, 0, 180);
	    c.fillArc (400, 270 + x, 20, 20, 0, 180);
	    c.setColor (grey);
	    c.fillOval (370, 150 + x, 20, 20); //left eye
	    c.fillOval (390, 150 + x, 20, 20); //right eye
	    c.setColor (black);
	    c.fillOval (375, 155 + x, 10, 10); //left pupil
	    c.fillOval (395, 155 + x, 10, 10); //right pupil
	    c.drawLine (360, 180 + x, 380, 200 + x); //left part of smile
	    c.drawLine (380, 200 + x, 400, 200 + x); //middle part of smile
	    c.drawLine (400, 200 + x, 420, 180 + x); //right part of smile
	    //chair
	    c.setColor (red);
	    c.fillRect (461, 179 + x, 80, 120); //middle part of chair
	    c.fillArc (461, 139 + x, 80, 80, 0, 180); //top part of chair
	    c.fillRect (541, 219 + x, 20, 80); //right arm rest
	    c.fillRect (441, 219 + x, 20, 80); //left arm rest
	    c.setColor (black);
	    c.drawRoundRect (461, 258 + x, 80, 40, 20, 20); //bottom cushion
	    c.drawLine (460, 298 + x, 460, 219 + x); //left arm rest separator
	    c.drawLine (540, 298 + x, 540, 219 + x); //right arm rest separator
	    c.setColor (yellow);
	    c.fillOval (495, 179 + x, 10, 10); //top  button
	    c.fillOval (495, 219 + x, 10, 10); // bottom button
	    try
	    {
		sleep (15); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void detectiveChase ()
    {
	//local color
	Color peach = new Color (255, 229, 204);
	for (int x = 0 ; x <= 280 ; x++)
	{
	    //detective
	    c.setColor (lightBrown);
	    c.fillRect (-101 + x, 300, 81, 160); //erase
	    c.setColor (peach);
	    c.fillArc (-80 + x, 300, 40, 40, 180, 180); //bottom half of head
	    c.setColor (olive);
	    c.fillArc (-80 + x, 300, 40, 40, 0, 180); //hat
	    c.fillArc (-80 + x, 340, 40, 40, 0, 180); //top of body
	    c.fillRect (-80 + x, 360, 40, 60); //body
	    c.drawLine (-100 + x, 320, -20 + x, 320); //rim of hat
	    c.setColor (darkOlive);
	    c.fillRect (-80 + x, 420, 40, 40); //legs
	    c.fillArc (-68 + x, 350, 15, 15, 0, 180); //shoulder
	    c.fillRect (-68 + x, 357, 15, 40); //arm
	    c.setColor (olive);
	    c.drawLine (-60 + x, 459, -60 + x, 420); //leg separator
	    c.setColor (black);
	    c.fillRect (-60 + x, 397, 30, 10); //flashlight
	    c.fillOval (-33 + x, 395, 13, 13); //end part of flashlight
	    c.drawLine (-55 + x, 332, -35 + x, 332); //bubble blower
	    c.fillArc (-35 + x, 327, 10, 10, 180, 180); //end part of bubbleblower
	    c.setColor (peach);
	    c.fillOval (-68 + x, 397, 15, 15); //hand
	    try
	    {
		sleep (15); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void cyclopsChase ()
    {
	//local color
	Color darkGreen = new Color (0, 51, 0);
	for (int x = 0 ; x <= 197 ; x++)
	{
	    //cyclops
	    c.setColor (lightBrown);
	    c.fillRect (-101 + x, 300, 80, 160); //erase
	    c.setColor (olive);
	    c.fillOval (-80 + x, 300, 40, 40); //head
	    c.fillRect (-80 + x, 340, 40, 60); //body
	    c.fillArc (-100 + x, 340, 40, 40, 90, 90); //left shoulder
	    c.fillArc (-60 + x, 340, 40, 40, 0, 90); //right shoulder
	    c.fillRect (-100 + x, 360, 20, 20); //left arm
	    c.fillRect (-40 + x, 360, 20, 20); //right arm
	    c.setColor (darkOlive);
	    c.fillRect (-100 + x, 380, 20, 20); //left hand
	    c.fillRect (-40 + x, 380, 20, 20);  //right hand
	    c.setColor (white);
	    c.fillOval (-67 + x, 310, 15, 15); //eye
	    c.setColor (darkGreen);
	    c.fillRect (-80 + x, 400, 40, 60); //legs
	    c.setColor (black);
	    c.fillOval (-63 + x, 314, 7, 7); //pupil
	    c.drawLine (-70 + x, 330, -50 + x, 330); //mouth
	    c.drawArc (-67 + x, 304, 15, 15, 0, 180); //eyebrow
	    c.drawLine (-60 + x, 459, -60 + x, 400); //leg separator
	    try
	    {
		sleep (20); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void mummyChase ()
    {
	//local color
	Color lime = new Color (0, 255, 0);
	for (int x = 0 ; x <= 110 ; x++)
	{
	    //mummy
	    c.setColor (lightBrown);
	    c.fillRect (-101 + x, 300, 81, 160); //erase
	    c.setColor (white);
	    c.fillOval (-80 + x, 300, 40, 40); //head
	    c.fillRect (-80 + x, 360, 40, 100); //body
	    c.fillArc (-80 + x, 340, 40, 40, 0, 180); //top part of body
	    c.fillRect (-100 + x, 300, 20, 60); //left arm
	    c.fillRect (-40 + x, 300, 20, 60); //right arm
	    c.setColor (lime);
	    c.fillOval (-70 + x, 314, 7, 7); //left eye
	    c.fillOval (-56 + x, 314, 7, 7); //right eye
	    c.setColor (black);
	    //rag texture
	    c.drawLine (-80 + x, 320, -40 + x, 320);
	    c.drawLine (-80 + x, 360, -40 + x, 360);
	    c.drawLine (-80 + x, 380, -40 + x, 380);
	    c.drawLine (-80 + x, 400, -40 + x, 400);
	    c.drawLine (-80 + x, 420, -40 + x, 420);
	    c.drawLine (-80 + x, 440, -40 + x, 440);
	    c.drawLine (-60 + x, 459, -60 + x, 400); //leg separator
	    c.drawLine (-100 + x, 340, -80 + x, 340);
	    c.drawLine (-100 + x, 320, -80 + x, 320);
	    c.drawLine (-40 + x, 340, -21 + x, 340);
	    c.drawLine (-40 + x, 320, -21 + x, 320);
	    try
	    {
		sleep (20); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }



    public Chase (Console con)  //constructor
    {
	c = con;
    }


    public void run ()
    {
	ghostRuns ();
	ghostRunsDown ();
	detectiveChase ();
	cyclopsChase ();
	mummyChase ();
    }
}

