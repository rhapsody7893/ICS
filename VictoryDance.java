//imports
import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class
/*
*Name: Michael Zhou
*Teacher: Ms. Krasteva
*Date: Oct 13, 2018
*Description: This class animates a dance (jumping up and down) that the detective, cyclops, and mummy do.
*/

public class VictoryDance extends Thread
{
    private Console c;
    //global colors
    Color olive = new Color (204, 204, 0);
    Color darkOlive = new Color (150, 150, 0);
    Color black = new Color (0, 0, 0);
    Color white = new Color (255, 255, 255);
    Color lightBrown = new Color (102, 51, 0);
    Color lime = new Color (0, 255, 0);
    Color darkGreen = new Color (0, 51, 0);
    Color peach = new Color (255, 229, 204);

    public void detectiveDance ()
    {
	for (int x = 0 ; x <= 100 ; x++)
	{
	    //detective
	    c.setColor (lightBrown);
	    c.fillRect (180, 301 - x, 81, 161); //erase
	    c.setColor (peach);
	    c.fillArc (200, 300 - x, 40, 40, 180, 180); //bottom half of head
	    c.setColor (olive);
	    c.fillArc (200, 300 - x, 40, 40, 0, 180); //hat
	    c.fillArc (200, 340 - x, 40, 40, 0, 180); //top part of body
	    c.fillRect (200, 360 - x, 40, 60); //body
	    c.drawLine (180, 320 - x, 260, 320 - x); //rim of hat
	    c.setColor (darkOlive);
	    c.fillRect (200, 420 - x, 40, 40); //legs
	    c.fillArc (212, 350 - x, 15, 15, 0, 180); //shoulder
	    c.fillRect (212, 357 - x, 15, 40); //arm
	    c.setColor (olive);
	    c.drawLine (220, 459 - x, 220, 420 - x); //leg serparator
	    c.setColor (black);
	    c.fillRect (220, 397 - x, 30, 10); //flashlight
	    c.fillOval (247, 395 - x, 13, 13); //flashlight end part
	    c.drawLine (225, 332 - x, 245, 332 - x); //bubble blower
	    c.fillArc (245, 327 - x, 10, 10, 180, 180); //bubble blower end part
	    c.setColor (peach);
	    c.fillOval (212, 397 - x, 15, 15); //hand

	    try
	    {
		sleep (15); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void cyclopsDance ()
    {
	for (int x = 0 ; x <= 100 ; x++)
	{
	    //cyclops
	    c.setColor (lightBrown);
	    c.fillRect (97, 300 - x, 80, 161); //erase
	    c.setColor (olive);
	    c.fillOval (117, 300 - x, 40, 40); //head
	    c.fillRect (117, 340 - x, 40, 60); //body
	    c.fillArc (97, 340 - x, 40, 40, 90, 90); //left shoulder
	    c.fillArc (137, 340 - x, 40, 40, 0, 90); //right shoulder
	    c.fillRect (97, 360 - x, 20, 20); //left arm
	    c.fillRect (157, 360 - x, 20, 20); //right arm
	    c.setColor (darkOlive);
	    c.fillRect (97, 380 - x, 20, 20); //left hand
	    c.fillRect (157, 380 - x, 20, 20); //right hand
	    c.setColor (white);
	    c.fillOval (130, 310 - x, 15, 15); //eye
	    c.setColor (darkGreen);
	    c.fillRect (117, 400 - x, 40, 60);
	    c.setColor (black);
	    c.fillOval (134, 314 - x, 7, 7); //pupil
	    c.drawLine (127, 330 - x, 147, 330 - x); //mouth
	    c.drawArc (130, 304 - x, 15, 15, 0, 180); //eyebrow
	    c.drawLine (137, 459 - x, 137, 400 - x); //leg separator
	    try
	    {
		sleep (20); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void mummyDance ()
    {
	for (int x = 0 ; x <= 100 ; x++)
	{
	    //mummy
	    c.setColor (lightBrown);
	    c.fillRect (9, 300 - x, 81, 161); //erase
	    c.setColor (white);
	    c.fillOval (30, 300 - x, 40, 40); //head
	    c.fillRect (30, 360 - x, 40, 100); //body
	    c.fillArc (30, 340 - x, 40, 40, 0, 180); //top part of body
	    c.fillRect (10, 300 - x, 20, 60); //left arm
	    c.fillRect (70, 300 - x, 20, 60); //right arm
	    c.setColor (lime);
	    c.fillOval (40, 314 - x, 7, 7); //left eye
	    c.fillOval (54, 314 - x, 7, 7); //right eye
	    c.setColor (black);
	    //rag texure
	    c.drawLine (30, 320 - x, 70, 320 - x);
	    c.drawLine (30, 360 - x, 70, 360 - x);
	    c.drawLine (30, 380 - x, 70, 380 - x);
	    c.drawLine (30, 400 - x, 70, 400 - x);
	    c.drawLine (30, 420 - x, 70, 420 - x);
	    c.drawLine (30, 440 - x, 70, 440 - x);
	    c.drawLine (50, 458 - x, 50, 400 - x); //leg separator
	    c.drawLine (10, 340 - x, 30, 340 - x);
	    c.drawLine (10, 320 - x, 30, 320 - x);
	    c.drawLine (70, 340 - x, 89, 340 - x);
	    c.drawLine (70, 320 - x, 89, 320 - x);
	    try
	    {
		sleep (20); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void detectiveDanceDown ()
    {
	for (int x = 0 ; x <= 100 ; x++)
	{
	    //detective
	    c.setColor (lightBrown);
	    c.fillRect (180, 199 + x, 81, 161); //erase
	    c.setColor (peach);
	    c.fillArc (200, 200 + x, 40, 40, 180, 180); //bottom part of head
	    c.setColor (olive);
	    c.fillArc (200, 200 + x, 40, 40, 0, 180); //hat
	    c.fillArc (200, 240 + x, 40, 40, 0, 180); //top part of body
	    c.fillRect (200, 260 + x, 40, 60); //body
	    c.drawLine (180, 220 + x, 260, 220 + x); //rim of hat
	    c.setColor (darkOlive);
	    c.fillRect (200, 320 + x, 40, 40); //legs
	    c.fillArc (212, 250 + x, 15, 15, 0, 180); //shoulder
	    c.fillRect (212, 257 + x, 15, 40); //arm
	    c.setColor (olive);
	    c.drawLine (220, 359 + x, 220, 320 + x); //leg separator
	    c.setColor (black);
	    c.fillRect (220, 297 + x, 30, 10); //flashlight
	    c.fillOval (247, 295 + x, 13, 13); //end part of flashlight
	    c.drawLine (225, 232 + x, 245, 232 + x); //bubble blower
	    c.fillArc (245, 227 + x, 10, 10, 180, 180); //end part of bubble blower
	    c.setColor (peach);
	    c.fillOval (212, 297 + x, 15, 15); //hand

	    try
	    {
		sleep (15); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void cyclopsDanceDown ()
    {
	for (int x = 0 ; x <= 100 ; x++)
	{
	    //cyclops
	    c.setColor (lightBrown);
	    c.fillRect (97, 199 + x, 80, 161); //erase
	    c.setColor (olive);
	    c.fillOval (117, 200 + x, 40, 40); //head
	    c.fillRect (117, 240 + x, 40, 60); //body
	    c.fillArc (97, 240 + x, 40, 40, 90, 90); //left shoulder
	    c.fillArc (137, 240 + x, 40, 40, 0, 90); //rught shoulder
	    c.fillRect (97, 260 + x, 20, 20); //left arm
	    c.fillRect (157, 260 + x, 20, 20); //right arm
	    c.setColor (darkOlive);
	    c.fillRect (97, 280 + x, 20, 20); //left hand
	    c.fillRect (157, 280 + x, 20, 20); //right hand
	    c.setColor (white);
	    c.fillOval (130, 210 + x, 15, 15); //eye
	    c.setColor (darkGreen);
	    c.fillRect (117, 300 + x, 40, 60); //legs
	    c.setColor (black);
	    c.fillOval (134, 214 + x, 7, 7); //pupil
	    c.drawLine (127, 230 + x, 147, 230 + x); //mouth
	    c.drawArc (130, 204 + x, 15, 15, 0, 180); //eyebrow
	    c.drawLine (137, 359 + x, 137, 300 + x); //leg separator

	    try
	    {
		sleep (20); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void mummyDanceDown ()
    {
	for (int x = 0 ; x <= 100 ; x++)
	{
	    //mummy
	    c.setColor (lightBrown);
	    c.fillRect (9, 199 + x, 81, 161); //erase
	    c.setColor (white);
	    c.fillOval (30, 200 + x, 40, 40); //head
	    c.fillRect (30, 260 + x, 40, 100); //body
	    c.fillArc (30, 240 + x, 40, 40, 0, 180); //top part of body
	    c.fillRect (10, 200 + x, 20, 60); //left arm
	    c.fillRect (70, 200 + x, 20, 60); //right arm
	    c.setColor (lime);
	    c.fillOval (40, 214 + x, 7, 7); //left eye
	    c.fillOval (54, 214 + x, 7, 7); //right eye
	    c.setColor (black);
	    //rag texture
	    c.drawLine (30, 220 + x, 70, 220 + x);
	    c.drawLine (30, 260 + x, 70, 260 + x);
	    c.drawLine (30, 280 + x, 70, 280 + x);
	    c.drawLine (30, 300 + x, 70, 300 + x);
	    c.drawLine (30, 320 + x, 70, 320 + x);
	    c.drawLine (30, 340 + x, 70, 340 + x);
	    c.drawLine (50, 358 + x, 50, 300 + x); //leg separator
	    c.drawLine (10, 240 + x, 30, 240 + x);
	    c.drawLine (10, 220 + x, 30, 220 + x);
	    c.drawLine (70, 240 + x, 89, 240 + x);
	    c.drawLine (70, 220 + x, 89, 220 + x);
	    try
	    {
		sleep (20); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void victorySpeach ()
    {
	c.setFont (new Font ("Sans Serif", 1, 12));
	c.setColor (white);
	c.drawString ("We did it!", 180, 280); //detective talks
	try
	{
	    Thread.sleep (4000); //delay
	}
	catch (InterruptedException e)
	{
	}
	for (int x = 0 ; x <= 60 ; x++)
	{
	    c.setColor (lightBrown);
	    c.drawLine (179 + x, 270, 179 + x, 283); //erase
	}
	c.setColor (lime);
	c.drawString ("Yay!", 50, 280); //mummy talks
	try
	{
	    Thread.sleep (4000); //delay
	}
	catch (InterruptedException e)
	{
	}
	for (int x = 0 ; x <= 30 ; x++)
	{
	    c.setColor (lightBrown);
	    c.drawLine (49 + x, 270, 49 + x, 283); //erase
	}
    }


    public VictoryDance (Console con)  //constructor
    {
	c = con;
    }


    public void run ()
    {
	detectiveDance ();
	cyclopsDance ();
	mummyDance ();
	detectiveDanceDown ();
	cyclopsDanceDown ();
	mummyDanceDown ();
	victorySpeach ();
    }
}

