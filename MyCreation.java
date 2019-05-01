//imports
import java.awt.*;
import hsa.Console;

/*
*Name: Michael Zhou
*Teacher: Ms. Krasteva
*Date: Oct 13, 2018
*Description: This class runs all the other classes (threads) in one console to animate a short story.
*/

public class MyCreation
{
    Console c; //output console

    //adds the Intro thread to MyCreation
    public void intro ()
    {

	Intro i = new Intro (c);
    }


    //adds the Background1 thread to MyCreation
    public void background1 ()
    {

	Background1 b = new Background1 (c);
    }


    //adds the DetectiveEnter thread to MyCreation
    public void detectiveEnter ()
    {
	//https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html
	DetectiveEnter d = new DetectiveEnter (c); //creates a runnable object
	Thread thread = new Thread (d); //Create a thread on that object (so I can use join())
	thread.start (); //start the thread
	try
	{
	    thread.join (); //wait
	}
	catch (InterruptedException e)
	{
	}

    }


    //adds the BatsFly thread to MyCreation
    public void batsFly ()
    {
	BatsFly b = new BatsFly (c);
	b.start ();
	BatsFly b1 = new BatsFly (c, Color.green, 500);
	b1.start ();
	BatsFly b2 = new BatsFly (c, Color.blue, 300);
	b2.start ();
    }


    //adds the VampireEnter thread to MyCreation
    public void vampireEnter ()
    {
	VampireEnter v = new VampireEnter (c);
	v.start ();
	try
	{
	    v.join ();
	}
	catch (InterruptedException e)
	{
	}
    }


    //adds the VampireLeave thread to MyCreation
    public void vampireLeave ()
    {
	VampireLeave v = new VampireLeave (c);
	v.start ();
	try
	{
	    v.join ();
	}
	catch (InterruptedException e)
	{
	}
    }


    //adds the DetectiveLeave thread to MyCreation
    public void detectiveLeave ()
    {
	DetectiveLeave d = new DetectiveLeave (c);
	d.start ();
	try
	{
	    d.join ();
	}
	catch (InterruptedException e)
	{
	}
    }


    //adds the EyesFollow thread to MyCreation
    public void eyesFollow ()
    {
	EyesFollow e = new EyesFollow (c);
	e.start ();
    }


    //adds the GhostFollows thread to MyCreation
    public void ghostFollows ()
    {
	GhostFollows g = new GhostFollows (c);
	g.start ();
	try
	{
	    g.join ();
	}
	catch (InterruptedException e)
	{
	}
    }


    //adds the Background2 thread to MyCreation
    public void background2 ()
    {
	Background2 b2 = new Background2 (c);
    }


    //adds the CyclopsEnter thread to MyCreation
    public void cyclopsEnter ()
    {
	CyclopsEnter d = new CyclopsEnter (c);
	d.start ();
	try
	{
	    d.join ();
	}
	catch (InterruptedException e)
	{
	}
    }


    //adds the MummyEnter thread to MyCreation
    public void mummyEnter ()
    {
	MummyEnter m = new MummyEnter (c);
	m.start ();
	try
	{
	    m.join ();
	}
	catch (InterruptedException e)
	{
	}
    }


    //adds the GhostMovesChair thread to MyCreation
    public void ghostMovesChair ()
    {
	GhostMovesChair g = new GhostMovesChair (c);
	g.start ();
	try
	{
	    g.join ();
	}
	catch (InterruptedException e)
	{
	}
    }


    //adds the Background3 thread to MyCreation
    public void background3 ()
    {
	Background3 b = new Background3 (c);
    }


    //adds the Chase thread to MyCreation
    public void chase ()
    {
	Chase u = new Chase (c);
	u.start ();
	try
	{
	    u.join ();
	}
	catch (InterruptedException e)
	{
	}

    }


    //adds the ShineLight thread to MyCreation
    public void shineLight ()
    {
	ShineLight s = new ShineLight (c);
	s.start ();
	try
	{
	    s.join ();
	}
	catch (InterruptedException e)
	{
	}
    }


    //adds the GhostFades thread to MyCreation
    public void ghostFades ()
    {
	GhostFades g = new GhostFades (c);
	g.start ();
	try
	{
	    g.join ();
	}
	catch (InterruptedException e)
	{
	}
    }


    //adds the VictoryDance thread to MyCreation
    public void victoryDance ()
    {
	VictoryDance v = new VictoryDance (c);
	v.start ();
	try
	{
	    v.join ();
	}
	catch (InterruptedException e)
	{
	}
    }


    //adds the Ending thread to MyCreation
    public void ending ()
    {
	Ending e = new Ending (c);
    }


    //creates a new window and gives window a title
    public MyCreation ()  //constructor
    {
	c = new Console ("Huanted House Mystery");
    }


    public static void main (String[] args)  //main method
    {
	MyCreation z = new MyCreation ();
	z.intro ();
	z.background1 ();
	z.detectiveEnter ();
	z.batsFly ();
	z.vampireEnter ();
	z.vampireLeave ();
	z.detectiveLeave ();
	z.eyesFollow ();
	z.ghostFollows ();
	z.background2 ();
	z.detectiveEnter ();
	z.cyclopsEnter ();
	z.mummyEnter ();
	z.ghostMovesChair ();
	z.background3 ();
	z.chase ();
	z.shineLight ();
	z.ghostFades ();
	z.victoryDance ();
	z.ending ();
    }
}


