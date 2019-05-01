//imports
import java.awt.*;
import hsa.Console;

/*
*Michael Zhou
*Ms. Krasteva
*Oct 13, 2018
*This class draws the second background. This includes windows, stars, moon, and a sofa.
*/

public class Background2
{
    private Console c;

    public void drawBackground ()
    {
	//local colors
	Color darkBrown = new Color (51, 25, 0);
	Color lightBrown = new Color (102, 51, 0);
	Color black = new Color (0, 0, 0);
	Color white = new Color (255, 255, 255);
	Color yellow = new Color (255, 255, 0);
	Color navy = new Color (0, 0, 128);
	Color red = new Color (152, 0, 0);

	for (int x = 0 ; x <= 640 ; x++)
	{
	    //wall (background)
	    c.setColor (lightBrown);
	    c.drawLine (0 + x, 0, 0 + x, 500);
	}
	for (int x = 0 ; x <= 640 ; x++)
	{
	    //floor
	    c.setColor (darkBrown);
	    c.drawLine (0 + x, 460, 0 + x, 500);
	}
	for (int x = 0 ; x <= 80 ; x++)
	{
	    //sky (through windows)
	    c.setColor (navy);
	    c.drawLine (80 + x, 15, 80 + x, 135);
	    c.drawLine (280 + x, 15, 280 + x, 135);
	    c.drawLine (480 + x, 15, 480 + x, 135);
	    //sofa (middle and top part)
	    c.setColor (red);
	    c.drawLine (281 + x, 339, 281 + x, 459);
	    c.drawArc (321 - x / 2, 340 - x / 2, x, x, 0, 180);
	    //softa (bottom cushion)
	    c.setColor (black);
	    c.drawRoundRect (281, 419, 80, 40, 20, 20);
	}
	for (int x = 0 ; x <= 40 ; x++)
	{
	    //shutters?
	    c.setColor (darkBrown);
	    c.drawLine (40 + x, 15, 40 + x, 135);
	    c.drawLine (160 + x, 15, 160 + x, 135);
	    c.drawLine (240 + x, 15, 240 + x, 135);
	    c.drawLine (360 + x, 15, 360 + x, 135);
	    c.drawLine (440 + x, 15, 440 + x, 135);
	    c.drawLine (560 + x, 15, 560 + x, 135);
	    //moon
	    c.setColor (white);
	    c.drawOval (320 - x / 2, 60 - x / 2, x, x);
	    //dark side of moon
	    c.setColor (navy);
	    c.drawOval (325 - x / 2, 60 - x / 2, x, x);
	}
	for (int x = 0 ; x <= 20 ; x++)
	{
	    //stars
	    c.setColor (yellow);
	    c.drawStar (540 - x / 2, 120 - x / 2, x, x);
	    c.drawStar (100 - x / 2, 60 - x / 2, x, x);
	    //arm rests of the sofa
	    c.setColor (red);
	    c.drawRect (361, 379, 20 - x, 80);
	    c.drawRect (261, 379, 20 - x, 80);
	}
	for (int x = 0 ; x <= 10 ; x++)
	{
	    //sofa buttons?
	    c.setColor (yellow);
	    c.drawOval (320 - x / 2, 340 - x / 2, x, x);
	    c.drawOval (320 - x / 2, 380 - x / 2, x, x);
	}
	//lines on the shutters
	c.setColor (black);
	c.drawLine (60, 15, 60, 135);
	c.drawLine (180, 15, 180, 135);
	c.drawLine (260, 15, 260, 135);
	c.drawLine (380, 15, 380, 135);
	c.drawLine (460, 15, 460, 135);
	c.drawLine (580, 15, 580, 135);
	c.drawLine (40, 55, 80, 55);
	c.drawLine (40, 95, 80, 95);
	c.drawLine (240, 55, 280, 55);
	c.drawLine (240, 95, 280, 95);
	c.drawLine (440, 55, 480, 55);
	c.drawLine (440, 95, 480, 95);
	c.drawLine (160, 55, 200, 55);
	c.drawLine (160, 95, 200, 95);
	c.drawLine (360, 55, 400, 55);
	c.drawLine (360, 95, 400, 95);
	c.drawLine (560, 55, 600, 55);
	c.drawLine (560, 95, 600, 95);
	//line that seperates arm rests from sofa body
	c.drawLine (280, 459, 280, 380);
	c.drawLine (360, 459, 360, 380);

    }


    public Background2 (Console con)  // constructor
    {
	c = con;
	drawBackground ();
    }
}
