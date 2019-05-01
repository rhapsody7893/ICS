// Imports
import java.awt.*; //gives access to java command libraries
import hsa.Console; //gives access to Console class file

/**
* Michael Zhou, Nicholas Glenn
* Mrs. Krasteva
* Oct. 3, 2018
* This program makes a constellation "trading card" with a front and back page design along with infomation
*/

public class TradingCard // creates new class called TradingCard
{
    Console c; // creates an instance variable of Console class

    public TradingCard ()  // class constructor1
    {
	c = new Console (30, 60, "Constellation Trading Card");
    }


    public void drawTitle ()  // drawTitle method
    {
	c.setColor (Color.white);
	c.setFont (new Font ("Castellar", 1, 29));
	c.drawString ("Scorpio Trading Card", 22, 62);
	c.setFont (new Font ("Castellar", 1, 15));
	c.drawString ("By: Nicholas and Michael", 22, 83);
	c.drawString ("October 3, 2018", 310, 83);
    }


    public void drawFrontCard ()  // drawFrontCard method
    {
	c.fillRect (0, 0, 480, 600); //background
	drawTitle (); //executes drawTitle method
	//draw scorpio design
	c.drawLine (100, 180, 100, 480);
	c.drawArc (100, 130, 100, 100, 0, 180);
	c.drawLine (200, 180, 200, 480);
	c.drawArc (200, 130, 100, 100, 0, 180);
	c.drawLine (300, 180, 300, 480);
	c.drawArc (300, 425, 100, 100, 180, 180);
	c.drawLine (400, 473, 400, 410);
	c.drawLine (400, 410, 350, 460);
	c.drawLine (400, 410, 450, 460);
	//get key press
	c.drawString ("Press any key to open the card", 80, 570);
	char input = c.getChar ();

    }


    public void drawBackCard ()  // drawBackCard method
    {
	c.clear (); //clear the screen
	c.setColor (Color.black);
	c.fillRect (0, 0, 480, 600); //background
	c.setColor (Color.white);
	c.setFont (new Font ("Castellar", 1, 20));
	c.drawString ("Scorpio", 190, 50);
	//scorpio constellation
	c.fillOval (160, 210, 10, 10);
	c.fillOval (140, 230, 10, 10);
	c.fillOval (120, 250, 10, 10);
	c.fillOval (150, 272, 10, 10);
	c.fillOval (190, 270, 10, 10);
	c.fillOval (223, 260, 10, 10);
	c.fillOval (224, 230, 10, 10);
	c.fillOval (221, 200, 10, 10);
	c.fillOval (250, 155, 10, 10);
	c.fillOval (260, 140, 10, 10);
	c.fillOval (280, 125, 10, 10);
	c.fillOval (330, 100, 10, 10);
	c.fillOval (315, 80, 10, 10);
	c.fillOval (332, 120, 10, 10);
	c.fillOval (325, 150, 10, 10);
	c.drawLine (165, 215, 145, 235);
	c.drawLine (145, 235, 125, 255);
	c.drawLine (125, 255, 155, 277);
	c.drawLine (155, 277, 195, 275);
	c.drawLine (195, 275, 228, 265);
	c.drawLine (228, 265, 229, 235);
	c.drawLine (229, 235, 226, 205);
	c.drawLine (226, 205, 255, 160);
	c.drawLine (255, 160, 265, 145);
	c.drawLine (265, 145, 285, 130);
	c.drawLine (285, 130, 335, 105);
	c.drawLine (320, 85, 335, 105);
	c.drawLine (335, 105, 337, 125);
	c.drawLine (337, 125, 330, 155);
	//grid
	c.drawRoundRect (50, 60, 380, 260, 10, 10);
	//paragraph
	c.setFont (new Font ("Calibri", 1, 16));
	c.drawString ("Scorpio is the 8th astrological sign in the Zodiac. It", 50, 360);
	c.drawString ("comes from the constellation of Scorpius. It is one of", 50, 380);
	c.drawString ("the 3 water signs and was associated with Mars and", 50, 400);
	c.drawString ("later, Pluto. It is also associated with the scorpion,", 50, 420);
	c.drawString ("snake, and eagle. It is said that the greek goddess", 50, 440);
	c.drawString ("Artemis is the one who created this constellation.", 50, 460);
	c.drawString ("Those who were born from October 23 - November 21", 50, 480);
	c.drawString ("are often very mysterious. However, if you get to", 50, 500);
	c.drawString ("know them, they can be very knowledgeable and", 50, 520);
	c.drawString ("intuitive.", 50, 540);
	c.setFont (new Font ("Calibri", 1, 12));
	c.drawString ("Text from https://en.wikipedia.org/wiki/Scorpio_(astrology)", 50, 570);
    }


    public static void main (String[] args)  // Main Method
    {
	TradingCard t = new TradingCard (); // creates instance variable of TradingCard and constructs and new TradingCard object
	t.drawFrontCard (); //executes drawFrontCard method
	t.drawBackCard (); //executes drawBackCard method
    }
} // End of Class
