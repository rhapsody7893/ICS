import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class
/*
*Name: Michael Zhou
*Teacher: Ms. Krasteva
*Date: Oct 13, 2018
*Description: This class animates three bats that fly in from the top of the screen (overloaded).
*/

public class BatsFly extends Thread
{
    private Console c;
    private Color bat;
    private int pos = 100;

    public void batsFly ()
    {
	//local colors
	Color red = new Color (153, 0, 0);
	Color black = new Color (0, 0, 0);
	Color white = new Color (255, 255, 255);
	Color lightBrown = new Color (102, 51, 0);
	for (int x = 0 ; x <= 80 ; x++)
	{
	    c.setColor (lightBrown);
	    c.fillRect (540 - pos, -61 + x, 180, 61); //erase
	    c.setColor (bat);
	    c.fillOval (600 - pos, -60 + x, 60, 60); //head
	    c.fillArc (540 - pos, -60 + x, 60, 40, 0, 180); //top left wing part
	    c.fillArc (660 - pos, -60 + x, 60, 40, 0, 180); //top right wing part
	    c.setColor (red);
	    c.fillOval (615 - pos, -40 + x, 10, 10); //left eye
	    c.fillOval (635 - pos, -40 + x, 10, 10); //right eye
	    c.drawLine (615 - pos, -21 + x, 645 - pos, -21 + x); //mouth
	    c.setColor (white);
	    int xpoints[] = {615 - pos, 625 - pos, 620 - pos};
	    int ypoints[] = { - 20 + x, -20 + x, -10 + x};
	    int points = 3;
	    c.fillPolygon (xpoints, ypoints, points); //left tooth
	    int xpoints2[] = {635 - pos, 645 - pos, 640 - pos};
	    int ypoints2[] = { - 20 + x, -20 + x, -10 + x};
	    int points2 = 3;
	    c.fillPolygon (xpoints2, ypoints2, points2); //right tooth
	    c.setColor (bat);
	    int xpoints3[] = {540 - pos, 550 - pos, 560 - pos, 570 - pos, 580 - pos, 590 - pos, 600 - pos};
	    int ypoints3[] = { - 40 + x, -20 + x, -40 + x, -20 + x, -40 + x, -20 + x, -40 + x};
	    int points3 = 7;
	    c.fillPolygon (xpoints3, ypoints3, points3); //bottom left wing part
	    int xpoints4[] = {660 - pos, 670 - pos, 680 - pos, 690 - pos, 700 - pos, 710 - pos, 720 - pos, };
	    int ypoints4[] = { - 40 + x, -20 + x, -40 + x, -20 + x, -40 + x, -20 + x, -40 + x};
	    int points4 = 7;
	    c.fillPolygon (xpoints4, ypoints4, points4); //bottom right wing part


	    try
	    {
		sleep (15); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public BatsFly (Console con)  //constructor - passing in console
    {
	c = con;
	bat = new Color (0, 0, 0);
    }


    public BatsFly (Console con, Color n)  //constructor - passing in console and color
    {
	c = con;
	bat = n;
    }


    public BatsFly (Console con, Color n, int t)  //constructor - passing in console and color and postition
    {
	c = con;
	bat = n;
	pos = t;
    }


    public void run ()
    {
	batsFly ();
    }
}

