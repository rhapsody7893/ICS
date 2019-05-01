//imports
import java.awt.*;
import hsa.Console;

/*
*Name: Michael Zhou
*Teacher: Ms. Krasteva
*Date: Oct 13, 2018
*Description: This class dispays a final ending screen.
*/
public class Ending
{
    private Console c;

    public void ending ()
    {
	//local colors
	Color orange = new Color (255, 128, 0);
	Color aqua = new Color (102, 205, 170);
	for (int x = 0 ; x <= 640 ; x++)
	{
	    c.setColor (orange);
	    c.drawLine (0 + x, 0, 0 + x, 500); //background
	}
	c.setColor (aqua);
	c.setFont (new Font ("Algerian", 1, 110));
	c.drawString ("The End", 80, 180); //The End
	c.setFont (new Font ("Algerian", 1, 30));
	c.drawString ("By: Michael Zhou", 80, 380); //my name
    }


    public Ending (Console con)  //constuctor
    {
	c = con;
	ending ();
    }
}
