//imports
import java.awt.*;
import hsa.Console;
/*
*Name: Michael Zhou
*Teacher: Ms. Krasteva
*Date: Oct 13, 2018
*Description: This class draws the first background. This includes 3 portraits, webs, a shelf, and some candles.
*/

public class Background1
{
    private Console c;

    public void drawBackground ()
    {
	//local colors
	Color darkBrown = new Color (51, 25, 0);
	Color lightBrown = new Color (102, 51, 0);
	Color gold = new Color (218, 165, 32);
	Color black = new Color (0, 0, 0);
	Color darkGreen = new Color (0, 51, 0);
	Color peach = new Color (255, 229, 204);
	Color olive = new Color (204, 204, 0);
	Color white = new Color (255, 255, 255);
	Color orange = new Color (255, 128, 0);
	Color yellow = new Color (255, 255, 0);
	Color navy = new Color (0, 0, 128);
	Color purple = new Color (76, 0, 153);
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
	    c.drawLine (0 + x, 460, 0 + x, 500);
	}
	for (int x = 0 ; x <= 120 ; x++)
	{
	    //portrait frames (left and right)
	    c.setColor (gold);
	    c.drawLine (80 + x, 280, 80 + x, 140);
	    c.drawLine (515 + x, 280, 515 + x, 140);
	}
	for (int x = 0 ; x <= 160 ; x++)
	{
	    //shelf (rectangle)
	    c.setColor (darkBrown);
	    c.drawLine (280 + x, 260, 280 + x, 295);
	    //portrait frame (middle)
	    c.setColor (gold);
	    c.drawLine (280 + x, 140, 280 + x, 260);
	}
	for (int x = 0 ; x <= 80 ; x++)
	{
	    //portrait backgrounds (left and right)
	    c.setColor (darkGreen);
	    c.drawLine (100 + x, 160, 100 + x, 260);
	    c.drawLine (540 + x, 160, 540 + x, 260);
	    //left portrait shirt
	    c.setColor (olive);
	    c.drawLine (100 + x, 220, 100 + x, 260);
	    //right portrait shirt
	    c.setColor (navy);
	    c.drawLine (540 + x, 220, 540 + x, 260);
	}
	for (int x = 0 ; x <= 120 ; x++)
	{
	    //middle portrait background
	    c.setColor (darkGreen);
	    c.drawLine (300 + x, 160, 300 + x, 240);
	    //middle portrait shirt
	    c.setColor (purple);
	    c.drawLine (300 + x, 220, 300 + x, 240);
	}

	for (int x = 0 ; x <= 40 ; x++)
	{
	    //corners of shelf
	    c.setColor (darkBrown);
	    c.drawLine (280, 295, 240 + x, 260);
	    c.drawLine (440, 295, 440 + x, 260);
	}
	for (int x = 0 ; x <= 20 ; x++)
	{
	    //candle sticks
	    c.setColor (white);
	    c.drawLine (240 + x, 260, 240 + x, 220);
	    c.drawLine (460 + x, 260, 460 + x, 220);
	    //flame
	    c.setColor (orange);
	    c.drawOval (250 - x / 2, 210 - x / 2, x, x);
	    c.drawOval (470 - x / 2, 210 - x / 2, x, x);
	}
	for (int x = 0 ; x <= 10 ; x++)
	{
	    //flame
	    c.setColor (yellow);
	    c.drawOval (250 - x / 2, 215 - x / 2, x, x);
	    c.drawOval (470 - x / 2, 215 - x / 2, x, x);
	}
	for (int x = 0 ; x <= 60 ; x++)
	{
	    //heads
	    c.setColor (peach);
	    c.drawOval (140 - x / 2, 190 - x / 2, x, x);
	    c.drawOval (580 - x / 2, 190 - x / 2, x, x);
	    c.drawOval (360 - x / 2, 190 - x / 2, x, x);
	}
	for (int x = 0 ; x <= 25 ; x++)
	{
	    //eyes
	    c.setColor (white);
	    c.drawOval (125 - x / 2, 185 - x / 2, x, x);
	    c.drawOval (155 - x / 2, 185 - x / 2, x, x);
	    c.drawOval (345 - x / 2, 185 - x / 2, x, x);
	    c.drawOval (375 - x / 2, 185 - x / 2, x, x);
	    c.drawOval (565 - x / 2, 185 - x / 2, x, x);
	    c.drawOval (595 - x / 2, 185 - x / 2, x, x);

	}
	for (int x = 0 ; x <= 8 ; x++)
	{
	    //pupils
	    c.setColor (black);
	    c.drawOval (125 - x / 2, 185 - x / 2, x, x);
	    c.drawOval (155 - x / 2, 185 - x / 2, x, x);
	    c.drawOval (345 - x / 2, 185 - x / 2, x, x);
	    c.drawOval (375 - x / 2, 185 - x / 2, x, x);
	    c.drawOval (565 - x / 2, 185 - x / 2, x, x);
	    c.drawOval (595 - x / 2, 185 - x / 2, x, x);

	}

	for (int x = 0 ; x <= 108 ; x = x + 27)
	{
	    //spider webs (arc)
	    c.drawArc (0 - x / 2, 160 - x / 2, x, x, 270, 180);
	    c.drawArc (640 - x / 2, 140 - x / 2, x, x, 90, 90);
	}
	//spider webs (lines)
	c.drawLine (125, 205, 155, 205);
	c.drawLine (345, 205, 375, 205);
	c.drawLine (565, 205, 595, 205);
	c.drawLine (0, 160, 20, 90);
	c.drawLine (0, 160, 60, 110);
	c.drawLine (0, 160, 80, 130);
	c.drawLine (0, 160, 75, 160);
	c.drawLine (0, 160, 60, 200);
	c.drawLine (0, 160, 20, 240);
	c.drawLine (640, 140, 580, 120);
	c.drawLine (640, 140, 620, 80);
    }


    public Background1 (Console con)  //constructor
    {
	c = con;
	drawBackground ();
    }
}
