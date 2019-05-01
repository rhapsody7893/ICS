//imports
import java.awt.*;
import hsa.Console;

/*
*Michael Zhou
*Ms. Krasteva
*Oct 13, 2018
*This class draws the third background. It includes spiders, candle, and webs.
*/

public class Background3
{
    private Console c;

    public void drawBackground ()
    {
	//local colors
	Color darkBrown = new Color (51, 25, 0);
	Color lightBrown = new Color (102, 51, 0);
	Color black = new Color (0, 0, 0);
	Color white = new Color (255, 255, 255);
	Color orange = new Color (255, 128, 0);
	Color yellow = new Color (255, 255, 0);
	Color silver = new Color (192, 192, 192);
	Color maroon = new Color (128, 0, 0);
	for (int x = 0 ; x <= 640 ; x++)
	{
	    //brown wall (background)
	    c.setColor (lightBrown);
	    c.drawLine (0 + x, 0, 0 + x, 500);
	}
	for (int x = 0 ; x <= 640 ; x++)
	{
	    //floor
	    c.setColor (darkBrown);
	    c.drawLine (0 + x, 462, 0 + x, 500);
	}
	for (int x = 0 ; x <= 80 ; x++)
	{
	    //candle holders
	    c.setColor (silver);
	    c.drawArc (160 - x / 2, 95 - x / 2, x, x, 180, 180);
	    c.drawArc (480 - x / 2, 95 - x / 2, x, x, 180, 180);
	}
	for (int x = 0 ; x <= 20 ; x++)
	{
	    //candle sticks
	    c.setColor (white);
	    c.drawLine (150 + x, 60, 150 + x, 95);
	    c.drawLine (470 + x, 60, 470 + x, 95);
	    //flame
	    c.setColor (orange);
	    c.drawOval (160 - x / 2, 50 - x / 2, x, x);
	    c.drawOval (480 - x / 2, 50 - x / 2, x, x);
	    //spider bodies (red spiders)
	    c.setColor (maroon);
	    c.drawOval (240 - x / 2, 60 - x / 2, x, x);
	    c.drawOval (320 - x / 2, 40 - x / 2, x, x);
	    c.drawOval (400 - x / 2, 80 - x / 2, x, x);
	}
	for (int x = 0 ; x <= 10 ; x++)
	{
	    //flame
	    c.setColor (yellow);
	    c.drawOval (160 - x / 2, 55 - x / 2, x, x);
	    c.drawOval (480 - x / 2, 55 - x / 2, x, x);
	}
	for (int x = 0 ; x <= 108 ; x = x + 27)
	{
	    //spider web (arc)
	    c.setColor (black);
	    c.drawArc (0 - x / 2, 0 - x / 2, x, x, 270, 90);
	    c.drawArc (640 - x / 2, 0 - x / 2, x, x, 180, 90);
	}
	//spider web (lines)
	c.drawLine (0, 0, 80, 20);
	c.drawLine (0, 0, 60, 40);
	c.drawLine (0, 0, 40, 60);
	c.drawLine (0, 0, 20, 80);
	c.drawLine (640, 0, 560, 20);
	c.drawLine (640, 0, 580, 40);
	c.drawLine (640, 0, 600, 60);
	c.drawLine (640, 0, 620, 80);
	//spider strings
	c.drawLine (240, 0, 240, 50);
	c.drawLine (320, 0, 320, 30);
	c.drawLine (400, 0, 400, 70);
	for (int x = 0 ; x <= 40 ; x = x + 10)
	{
	    //spider legs
	    c.setColor (maroon);
	    c.drawLine (220, 40 + x, 260, 80 - x);
	    c.drawLine (300, 20 + x, 340, 60 - x);
	    c.drawLine (380, 60 + x, 420, 100 - x);
	}
    }


    public Background3 (Console con)  //Constructor
    {
	c = con;
	drawBackground ();
    }
}
