//imports
import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class
/*
*Name: Michael
*Program Name: Monopoly
*Teacher: Ms. Krasteva
*Date: Dec 17, 2018
*Description: The purpose of this method is to animate a timer and stop the game when the timer ends

Variable dictionary:
Name:                   Type:               Purpose:
c                       Console             This variable is used to display and get input on the console.
minutes                 Console             Stores the minute limit
isTimeOutFlag           boolean             Indicates if the timer ran out
*/
public class TimeLimit extends Thread
{
    private Console c;
    int minutes;
    boolean isTimeOutFlag = false;
    
    /*
    The purpose of this method is to animate a timer ticking down
    The while loop is used to constantly tick down the time
    The first if statement is used to check if the time ran out, if so, a flag is set true, and the loop is broken out of
    The second if statement is used to check if the minute ran out, if so, the second values are reset and the minute value decreased by 1
    The last if statement is used to check if 10 seconds ran out, if so, the second value is resent and the 10 second value is decreased by 1
    The try catch is used to catch expections for the thread.sleep 
    Variable dictionary:
    Name:               Type:               Purpose:
    tenSeconds          int                 Stores the tens second value
    seconds             int                 Stores the seconds value
    */
    
    public void timer ()
    {
	int tenSeconds = 0;
	int seconds = 0;

	while (true)
	{
	    c.setColor (new Color (229, 255, 244));
	    c.fillRect (320, 420, 100, 20);
	    c.setColor (Color.black);
	    c.setFont (new Font ("Times", 1, 25));
	    c.drawString (minutes + " : " + tenSeconds + seconds, 320, 440); //display the time
	    if (minutes == 0 && tenSeconds == 0 && seconds == 0)
	    {
		isTimeOutFlag = true;
		break;
	    }
	    if (tenSeconds == 0 && seconds == 0)
	    {
		tenSeconds = 5;
		seconds = 10;
		minutes -= 1;
	    }
	    if (seconds == 0)
	    {
		seconds = 10; 
		tenSeconds -= 1;
	    }
	    seconds -= 1; //count down
	    try
	    {
		Thread.sleep (1000); //delay 1 sec
	    }
	    catch (Exception e)
	    {
	    }

	}
    }

    /*
    The purpose of this method (constructor) is to create a new object of console and assign it the reference variable c.
    Variable dictionary:
    Name:               Type:               Purpose:
    con                 Console             reference variable to my main console
    timeLimit           int                 Stores the max time limit
    */
    public TimeLimit (Console con, int timeLimit)  //constructor
    {
	c = con;
	minutes = timeLimit;
    }


    //This method will be called when the thread starts
    public void run ()
    {
	timer ();
    }


    //The purpose of this method is to reutrn true if the time has ran out
    public boolean isTimeOut ()
    {
	return isTimeOutFlag;
    }
}

