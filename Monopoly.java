/*
*Name: Michael Zhou
*Program Name: Monopoly
*Teacher: Ms. Krasteva
*Date: Dec 17, 2018
*Description: The main purpose of this program is to allow the user(s) to play monopoly.
The first screen the user(s) will see is the intro splash screen which has animations of a top hat, money, as well as the title
The next screen they will see is the main menu. In the main menu, the user can enter numbers to navigate the program
If the user entered 1, they will be sent to another screen to play 2 player monopoly
If the user entered 2, they will be sent to another screen to select the game mode of their choice
If the user entered 3, they will be sent to view the instructions of the game
If the user entered 4, they will be sent to view the high scores of past players
If the user entered 5, they will be send to a goodbye screen to read a final message and the program will close

Variable dictionary:
Name:                   Type:               Purpose:
c                       Console             This variable represents the console where the game is played
gameOver                boolean             This variable is used as a flag for a win condition
conceded                boolean             This variable is used to check if either player conceded
menuChoice              char                This variable stores the user's input in the main menu
gameMode                String              This variable stores the user's choice for the game mode
turn                    int                 This variable keeps track of the the turns
player1Balance          int                 This variable stores the first player's money
player2Balance          int                 This variable stores the second player's money
player1Position         int                 This variable stores the first player's position
player2Position         int                 This variable stores the second player's position
player1GetOutOfJail     boolean             This variable stores if the first player has a get out of jail free card
player2GetOutOfJail     boolean             This variable stores if the second player has a get out of jail free card
PANELDATA               int [] []           This variable stores the data for all of the properties, retrieved from https://monopoly.fandom.com/wiki/Monopoly
PANELNAMES              String []           This variable stores all the names of the properties
propertiesOwned         int []              This variable stores the information of if a property is owned, and how many buildings are on it (0 means not owned, a -1 or 1 means owned by player 1 or or 2, each house will decrease the or increase the value by 1, hotels are -6, or 6)
isDoubles               boolean             This variable stores whether the player rolled doubles
player1InJail           boolean             This variable stores if player1 is in Jail
player2InJail           boolean             This variable stores if player2 is in Jail
gameBoardColor          Color               This variable stores the color of the game board
*/

//imports
import java.awt.*;
import hsa.*;
import java.io.*;
import javax.swing.JOptionPane;
public class Monopoly

{
    Console c;       // The output console
    boolean gameOver = false;
    boolean conceded = false;
    char menuChoice = ' ';
    String gameMode = "Classic";
    int turn = 0;
    int player1Balance = 1500;
    int player2Balance = 1500;
    int player1Position = 0;
    int player2Position = 0;
    boolean player1GetOutOfJail = false;
    boolean player2GetOutOfJail = false;
    final int[] [] PANELDATA = {{255, 0, 0},
	    {102, 51, 0, 2, 4, 10, 30, 90, 160, 250, 60, 50, 50, 1},
	    {204, 255, 255},
	    {102, 51, 0, 4, 8, 20, 60, 180, 320, 450, 60, 50, 50, 1},
	    {229, 255, 244, 25, 200},
	    {204, 255, 255, 6, 12, 30, 90, 270, 400, 550, 100, 50, 50, 2},
	    {255, 128, 0},
	    {204, 255, 255, 6, 12, 30, 90, 270, 400, 550, 100, 50, 50, 2},
	    {204, 255, 255, 8, 16, 40, 100, 300, 450, 600, 120, 50, 50, 2},
	    {255, 128, 0},
	    {255, 102, 178, 10, 20, 50, 150, 450, 625, 750, 140, 100, 100, 3},
	    {229, 255, 244},
	    {255, 102, 178, 10, 20, 50, 150, 450, 625, 750, 140, 100, 100, 3},
	    {255, 102, 178, 12, 24, 60, 180, 500, 700, 900, 160, 100, 100, 3},
	    {255, 128, 0, 14, 28, 70, 200, 550, 750, 950, 180, 100, 100, 4},
	    {204, 255, 255},
	    {255, 128, 0, 14, 28, 70, 200, 550, 750, 950, 180, 100, 100, 4},
	    {255, 128, 0, 16, 32, 80, 220, 600, 800, 1000, 200, 100, 100, 4},
	    {255, 0, 0},
	    {255, 255, 0, 22, 44, 110, 330, 800, 975, 1150, 260, 130, 150, 5},
	    {255, 255, 0, 22, 44, 110, 330, 800, 975, 1150, 260, 130, 150, 5},
	    {255, 128, 0},
	    {255, 255, 0, 24, 48, 120, 360, 850, 1025, 1200, 280, 150, 150, 5},
	    {229, 255, 244, 25, 200},
	    {255, 0, 0, 18, 36, 90, 250, 700, 875, 1050, 220, 150, 150, 6},
	    {255, 0, 0, 18, 36, 90, 250, 700, 875, 1050, 220, 150, 150, 6},
	    {255, 0, 0, 20, 40, 100, 300, 750, 925, 1100, 240, 150, 150, 6},
	    {0, 0, 255},
	    {0, 153, 0, 26, 52, 130, 390, 900, 1100, 1275, 300, 200, 200, 7},
	    {0, 153, 0, 26, 52, 130, 390, 900, 1100, 1275, 300, 200, 200, 7},
	    {204, 255, 255},
	    {0, 153, 0, 28, 56, 150, 450, 1000, 1200, 1400, 320, 200, 200, 7},
	    {255, 128, 0},
	    {0, 0, 255, 35, 70, 175, 500, 1100, 1300, 1500, 350, 200, 200, 8},
	    {229, 255, 244},
	    {0, 0, 255, 50, 100, 200, 600, 1400, 1700, 2000, 400, 200, 200, 8}};
    final String[] PANELNAMES = {"Go", "Mediterranean Avenue", "Community Chest", "Baltic Avenue", "King's Cross Station", "Oriental Avenue", "Chance", "Vermont Avenue", "Connecticut Avenue", " Visiting Jail", "St.Charles Place", "Income Tax", "States Avenue", "Virginia Avenue", "St.James Place", "Community Chest", "Tennessee Avenue",
	"New York Avenue", "Free Parking", "Kentucky Avenue", "Indiana Avenue", "Chance", "Illinois Avenue", "St. Clair Station", "Atlantic Avenue", "Ventnor Avenue", "Marvin Gardens", "Go to Jail", "Pacific Avenue", "North Carolina Avenue", "Community Chest", "Pennsylvania Avenue", "Chance", "Park Place", "Luxury Tax", "Boardwalk"};
    int[] propertiesOwned = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    boolean isDoubles = false;
    boolean player1InJail = false;
    boolean player2InJail = false;
    Color gameBoardColor = new Color (229, 255, 244);

    //The purpose of this method (constructor) is to create a new object of console and assign it the reference variable c.
    public Monopoly ()
    {
	c = new Console (26, 80, 20, "Monopoly");
    }


    /*
    The purpose of this method is to check if the player owns all the properties of the color group they landed on
    The for loop loops through the all the properties in the panel data information
    The if statement inside is used to check if the amount of info in each position is more than 5 (to make sure its a property)
    The if statement inside of that is used to check is the colour group of the looped properties match the property the player is on
    The if statement inside is used to check wether to check owership for the current player or their opponent
    If its for the current player
    The if statements inside is to check if its player 1's turn and if they don't own the property of the same color group.
    If so, the method will return false
    The other if statement inside is used to check if its player 2's turn and if they don't own the property of the same color group.
    If so, the method will return false
    Otherwise,
    The if statements inside is to check if its player 1's turn and if player 2 doesn't own the property of the same color group.
    If so, the method will return false
    The other if statement inside is used to check if its player 2's turn and if player 1 doesn't own the property of the same color group.
    If so, the method will return false


    Variable dictionary:
    Name:               Type:               Purpose:
    x                   int                 Loop variable
    playerPosition      int                 Stores the player's position
    whichPlayer         int                 Stores if I want to check monoploy for the current player or the opponent
    */
    private boolean checkMonopoly (int playerPosition, int whichPlayer)
    {
	for (int x = 0 ; x < PANELDATA.length ; x++)
	{
	    if (PANELDATA [x].length > 5)
	    {
		if (PANELDATA [x] [13] == PANELDATA [playerPosition] [13])
		{
		    if (whichPlayer == 1)
		    {
			if (turn % 2 == 1 && propertiesOwned [x] < 1)
			{
			    return false;
			}
			else if (turn % 2 == 0 && propertiesOwned [x] > -1)
			{
			    return false;
			}
		    }
		    else
		    {
			if (turn % 2 == 1 && propertiesOwned [x] > -1)
			{
			    return false;
			}
			else if (turn % 2 == 0 && propertiesOwned [x] < 1)
			{
			    return false;
			}
		    }
		}
	    }
	}
	return true;
    }


    /*
    The purpose of this method is to clear the screen and draw a title
    The for loop is used to draw/cover the background
    Variable dictionary:
    Name:               Type:               Purpose:
    x                   int                 Loop variable
    */
    private void drawTitle ()
    {
	c.clear ();
	c.setColor (new Color (204, 255, 255));
	for (int x = 0 ; x <= 700 ; x++)
	{
	    c.drawLine (0, x, 960, x); //background
	}
	c.setColor (Color.black);
	//title
	c.setFont (new Font ("Times", 1, 25));
	c.drawString ("Monopoly", 430, 20);
    }


    /*
    The purpose of this method is to pause the program by getting a character input
    */
    private void pauseProgram ()
    {
	c.setFont (new Font ("Courier", 1, 25));
	c.drawString ("Press any key to continue...", 300, 640);
	c.getChar (); //get input
    }


    /*
    The purpose of this method is to display a main menu and let the user chose how navigate the program
    The while loop is used to constantly get user input
    The first if statement is used to check if the user didn't enter a correct input (1, 2, 3, 4, or 5) is so, an error message is printed
    Else, the user breaks out of the for loop
    */
    public void mainMenu ()
    {
	drawTitle ();
	//menu
	c.drawString ("Menu", 450, 130);
	c.drawString ("1. Start Game (" + gameMode + ")", 370, 170);
	c.drawString ("2. Choose Gamemode", 370, 210);
	c.drawString ("3. View Instructions", 370, 250);
	c.drawString ("4. View Highscores", 370, 290);
	c.drawString ("5. Exit Game", 370, 330);
	c.drawString ("Please enter your option (1, 2, 3, 4, or 5): ", 200, 400);
	c.setCursor (15, 60);
	c.setTextBackgroundColor (new Color (204, 255, 255));
	while (true)
	{
	    menuChoice = c.getChar (); //get input //get input
	    if (menuChoice != '1' && menuChoice != '2' && menuChoice != '3' && menuChoice != '4' && menuChoice != '5')
	    {
		JOptionPane.showMessageDialog (null, "Please enter 1, 2, 3, 4, or 5"); //error message
	    }
	    else
		break;

	}
    }


    /*
    The purpose of this method is to display the gamemodes and get the user's choice of game mode
    The while loop is used to constantly get the user's choice of gamemode
    The if statement is used to check if the user didn't enter a correct input (1, 2, 3, or 4), if so an error message will be displayed
    The other if statements are used to check which number the user entered, and will set the current gamemode to the gamemode that corresponds to their number, an error message will also be displayed
    If the user enters 4, they will break out of the loop
    Variable dictionary:
    Name:               Type:               Purpose:
    gameChoice          char                This variable stores the user's input
    */
    public void gameMode ()
    {
	char gameChoice = ' ';
	drawTitle ();
	//gamemodes
	c.drawString ("Gamemodes:", 410, 130);
	c.drawString ("1. Classic (No Time Limit)", 350, 170);
	c.drawString ("2. Rush (30 Minutes)", 350, 210);
	c.drawString ("3. Bliz (15 Minutes)", 350, 250);
	c.drawString ("4. Back to Main Menu", 350, 290);
	c.drawString ("Please enter your option (1, 2, 3, or 4): ", 240, 400);
	do
	{
	    gameChoice = c.getChar (); //get input
	    if (gameChoice != '1' && gameChoice != '2' && gameChoice != '3' && gameChoice != '4')
	    {
		JOptionPane.showMessageDialog (null, "Please enter 1, 2, 3, or 4"); //error message

	    }
	    else if (gameChoice == '1')
	    {
		JOptionPane.showMessageDialog (null, "Classic mode has been selected"); //message
		gameMode = "Classic";
	    }
	    else if (gameChoice == '2')
	    {
		JOptionPane.showMessageDialog (null, "Rush mode has been selected"); //message
		gameMode = "Rush";
	    }
	    else if (gameChoice == '3')
	    {
		JOptionPane.showMessageDialog (null, "Blitz mode has been selected"); //message
		gameMode = "Blitz";
	    }
	    else if (gameChoice == '4')
	    {
		break;
	    }


	}
	while (true);
    }


    /*
    The purpose of this method is to animate a top hat sliding in, money rising, and a title sliding in
    The first for loop is used to draw the background
    The next for loop is used to animate the title sliding in
    Variable dictionary:
    Name:               Type:               Purpose:
    x                   int                 Loop variable
    */
    public void splashScreen ()
    {
	c.setColor (new Color (204, 255, 255));
	for (int x = 0 ; x <= 700 ; x++)
	{
	    c.drawLine (0, x, 960, x); //background
	}
	TopHatSlide t = new TopHatSlide (c);
	t.start (); //top hat slides in
	MoneyRises m = new MoneyRises (c);
	m.run (); //money rises slides in
	c.setFont (new Font ("Algerian", 1, 130));
	for (int x = 0 ; x <= 880 ; x++)
	{
	    c.setColor (new Color (204, 255, 255));
	    c.fillRect (-760 + x, 0, 725, 200); //erase
	    c.setColor (Color.black);
	    c.drawString ("Monopoly", -750 + x, 120); //title
	    try
	    {
		Thread.sleep (25); //delay
	    }
	    catch (Exception e)
	    {
		JOptionPane.showMessageDialog (null, "Please enter 1 or e"); //error message

	    }
	}
    }


    /*
    The purpose of this method is to display the instructions to the game
    */
    public void instructions ()
    {
	drawTitle ();
	c.setFont (new Font ("Arial", 1, 20));
	c.drawString ("This game follows the rules of classic Monopoly. The goal is to make the most money or bankrupt", 20, 50);
	c.drawString ("the other player. Both players start off with $1500. Both players start at GO. Every time they", 20, 70);
	c.drawString ("pass GO, they are given $200. If you land on a property, you will be given the option to buy it.", 20, 90);
	c.drawString ("If you do, when the opponent lands on your property, they must pay you rent (the value will be", 20, 110);
	c.drawString ("specified on the deed card). If you own all the properties of a color, the opponent must pay ", 20, 130);
	c.drawString ("double the rent. If you own all the properties of a color, you will be able to build houses on", 20, 150);
	c.drawString ("either of those properties the next time you land on any of them. Houses increase the rent of", 20, 170);
	c.drawString ("the property they are on. If you have 4 houses on each of the properties in a color group, you", 20, 190);
	c.drawString ("may remove all of them and build a hotel. Hotels greatly increase the rent of all your properties.", 20, 210);
	c.drawString ("If you land on a chance/community chest tile, a corresponding card will be drawn for you and you", 20, 230);
	c.drawString ("will have to follow the instructions on the card. If you land on the tile that says go to jail,", 20, 250);
	c.drawString ("you must go to jail. When in jail, you will be stuck there. During each turn, you.", 20, 270);
	c.drawString ("will able to roll 2 dice. If you roll doubles, you will be allowed to get out of jail on the next", 20, 290);
	c.drawString ("turn. You can also instead pay $50 to get out of jail on your next turn or use a \"Get Out Of Jail", 20, 310);
	c.drawString ("Free \" card. If you land on a tax tile, you must pay $200 to the bank.", 20, 330);
	c.drawString ("There are 3 game modes. Classic, Rush, and Blitz. In Classic mode, there is no time limit. In Rush", 20, 370);
	c.drawString ("mode, there is a 30 minute time limit. In Blitz Mode, there is a 15 minute time limit. When the", 20, 390);
	c.drawString ("time runs out, the game will end after the player finishes the current turn. Each player can concede", 20, 410);
	c.drawString ("at the start of their turn. Player 1 is represented by the black circle, player 2 is represented", 20, 430);
	c.drawString ("by the black rectangle", 20, 450);
	pauseProgram ();
    }


    /*
    The purpose of this method is to get the info from the Highscores.txt file, sort them, and display them.
    The option to erase the scores is also given
    The try catch is used to catch IOExecptions from BufferedReader
    The while loop is used to loop through each line of the file as long as the line is not equal to null
    The first if statement is used to check if the number of scores in the file is bigger than 0, the try catch inside is used to catch IOExecptions from BufferedReader, a while loop is used to loop through each line of the file as long as the line is not equal to null
    the next 2 for loops and if statement are used to sort the scores from highest to lowest
    The next if statement is used to check if there are more than 10 scores, if there are only 10 scores will be printed
    The next for loop is used to print the top 10 scores (or less)
    The while loop is used to loop for the user's input
    The if statement is used to check if the user entered 1 if so the user breaks out of the loop
    The else if statement is used to check is the user entered e if so, the highscores will be erased
    The try catch is used to catch IOExecptions from PrintWritter
    Otherwise, an error message will show if the user didn't enter the correct input
    Variable dictionary:
    Name:               Type:               Purpose:
    lineCount           int                 This variable stores the number of line in the file
    lineContent         String              This variable stores the contents of the line in the file
    choice              char                This variable stores the user's input
    arrayLength         int                 This variable stores the number of lines in the file
    tempScore           int                 This variable stores the temporary score
    tempName            String              This variable stores the temporary username
    tempGame            String              This variable stores the temporary gamemode
    numberOfScores      int                 This variable stores the number of previous scores
    x                   int                 Loop variable
    br                  BufferedReader      reference variable
    pr                  PrintWritter        reference variable
    */
    public void highScores ()
    {
	drawTitle ();
	int lineCount = 0;
	String lineContent = " ";
	char choice = ' ';
	int arrayLength = 0;
	int tempScore = 1;
	String tempName = " ";
	String tempGame = " ";
	int numberOfScores = 0;
	c.setFont (new Font ("Arial", 1, 42));
	c.drawString ("High Scores", 400, 100);
	c.setFont (new Font ("Arial", 1, 25));
	try
	{
	    BufferedReader br = new BufferedReader (new FileReader ("Highscores.txt"));
	    while ((lineContent = br.readLine ()) != null)
	    {
		arrayLength++; //count the number of scores
	    }
	    br.close (); //close file
	}
	catch (IOException e)
	{
	    JOptionPane.showMessageDialog (null, "Please enter 1 or e"); //error message

	}
	//create the arrays
	int[] orderScores = new int [arrayLength];
	String[] orderNames = new String [arrayLength];
	String[] orderGames = new String [arrayLength];
	if (orderScores.length > 0)
	{
	    try
	    {
		BufferedReader br = new BufferedReader (new FileReader ("Highscores.txt"));
		while ((lineContent = br.readLine ()) != null)
		{
		    //split and store each part of the line based on its info
		    String[] score = lineContent.split (" ");
		    orderScores [lineCount] = Integer.parseInt (score [1]); //store score
		    orderNames [lineCount] = score [0]; //store username
		    orderGames [lineCount] = score [2]; //store gameode
		    lineCount++;
		}
		br.close (); //close file
	    }
	    catch (IOException e)
	    {
		JOptionPane.showMessageDialog (null, "File Error"); //error message
	    }
	}
	for (int pass = 1 ; pass < orderScores.length ; pass++) //loop through the second element to the last element
	{
	    for (int i = 0 ; i < orderScores.length - 1 ; i++) //loop through the first element to the second last element
	    {
		if (orderScores [i] < orderScores [i + 1])
		{
		    //swap values of the elements
		    tempScore = orderScores [i];
		    tempName = orderNames [i];
		    tempGame = orderGames [i];
		    orderScores [i] = orderScores [i + 1];
		    orderNames [i] = orderNames [i + 1];
		    orderGames [i] = orderGames [i + 1];
		    orderScores [i + 1] = tempScore;
		    orderNames [i + 1] = tempName;
		    orderGames [i + 1] = tempGame;
		}
	    }
	}

	numberOfScores = arrayLength;
	if (numberOfScores > 10)
	    numberOfScores = 10;
	for (int i = 0 ; i < numberOfScores ; i++)  //loop through each element
	{
	    c.drawString (i + 1 + ". " + orderNames [i], 100, 200 + i * 30); //print each element
	    c.drawString (" Score: " + orderScores [i], 400, 200 + i * 30);
	    c.drawString ("Gamemode: " + orderGames [i], 600, 200 + i * 30);
	}
	c.setFont (new Font ("Courier", 1, 25));
	//options
	c.drawString ("Press 1 to exit to the main menu...", 200, 640);
	c.drawString ("Press e to erase the current highscores...", 200, 660);
	while (true)
	{
	    choice = c.getChar (); //get input //get input
	    if (choice == '1')
		break;
	    else if (choice == 'e')
	    {
		try
		{ //overwrite file with nothing
		    PrintWriter pr = new PrintWriter (new FileWriter ("Highscores.txt"));
		    pr.close (); //close file
		}
		catch (IOException e)
		{
		    JOptionPane.showMessageDialog (null, "File Error"); //error message

		}
		break;
	    }
	    else
		JOptionPane.showMessageDialog (null, "Please enter 1 or e"); //error message


	}

    }


    /*
    The purpose of this method is to animate 2 dies rolling and to return the total of the roll
    The for loop is used to roll the first dice 10 times
    The if statements inside are used to check what the result of each roll was, and to draw the corresponding dice face with that result
    The second for loop is used to roll second dice 10 times
    The if statements inside are used to check what the result of each roll was, and to draw the corresponding dice face with that result
    The last if statement is used to check if the player rolled doubles, if they did, a message is displayed and a flag is set to true
    The try catch statements  are used to catch exceptions from thread.sleep
    Variable dictionary:
    Name:               Type:               Purpose:
    dice1               int                 This variable stores the value of the first dice
    dice2               int                 This variable stores the value of the second dice
    x                   int                 Loop variable
    */

    private int rollDice ()
    {
	int dice1 = 0;
	int dice2 = 0;
	isDoubles = false; //reset
	for (int x = 0 ; x < 10 ; x++)
	{
	    dice1 = (int) (6 * Math.random () + 1); //random dice face
	    c.setColor (Color.white);
	    c.fillRect (250, 450, 100, 100); //dice face
	    c.setColor (Color.black); // outline
	    c.drawRect (250, 450, 100, 100);
	    if (dice1 == 1)
	    {
		//draw dice face 1
		c.fillOval (291, 490, 22, 22);
	    }
	    else if (dice1 == 2)
	    {
		//draw dice face 2
		c.fillOval (271, 470, 22, 22);
		c.fillOval (311, 510, 22, 22);
	    }
	    else if (dice1 == 3)
	    {
		//draw dice face 3
		c.fillOval (265, 465, 22, 22);
		c.fillOval (291, 490, 22, 22);
		c.fillOval (316, 515, 22, 22);
	    }
	    else if (dice1 == 4)
	    {
		//draw dice face 4
		c.fillOval (265, 465, 22, 22);
		c.fillOval (316, 465, 22, 22);
		c.fillOval (316, 515, 22, 22);
		c.fillOval (265, 515, 22, 22);
	    }
	    else if (dice1 == 5)
	    {
		//draw dice face 5
		c.fillOval (265, 465, 22, 22);
		c.fillOval (316, 465, 22, 22);
		c.fillOval (291, 490, 22, 22);
		c.fillOval (316, 515, 22, 22);
		c.fillOval (265, 515, 22, 22);
	    }
	    else if (dice1 == 6)
	    {
		//draw dice face 6
		c.fillOval (265, 465, 22, 22);
		c.fillOval (316, 465, 22, 22);
		c.fillOval (316, 515, 22, 22);
		c.fillOval (265, 515, 22, 22);
		c.fillOval (265, 490, 22, 22);
		c.fillOval (316, 490, 22, 22);
	    }
	    try
	    {
		Thread.sleep (100); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}
	for (int x = 0 ; x < 10 ; x++)
	{
	    dice2 = (int) (6 * Math.random () + 1); //random dice face
	    c.setColor (Color.white); //dice face
	    c.fillRect (360, 450, 100, 100);
	    c.setColor (Color.black);
	    c.drawRect (360, 450, 100, 100); //outline
	    if (dice2 == 1)
	    {
		//draw dice face 1
		c.fillOval (401, 490, 22, 22);
	    }
	    else if (dice2 == 2)
	    {
		//draw dice face 2
		c.fillOval (381, 470, 22, 22);
		c.fillOval (421, 510, 22, 22);
	    }
	    else if (dice2 == 3)
	    {
		//draw dice face 3
		c.fillOval (375, 465, 22, 22);
		c.fillOval (401, 490, 22, 22);
		c.fillOval (426, 515, 22, 22);
	    }
	    else if (dice2 == 4)
	    {
		//draw dice face 4
		c.fillOval (375, 465, 22, 22);
		c.fillOval (426, 465, 22, 22);
		c.fillOval (426, 515, 22, 22);
		c.fillOval (375, 515, 22, 22);
	    }
	    else if (dice2 == 5)
	    {
		//draw dice face 5
		c.fillOval (375, 465, 22, 22);
		c.fillOval (426, 465, 22, 22);
		c.fillOval (401, 490, 22, 22);
		c.fillOval (426, 515, 22, 22);
		c.fillOval (375, 515, 22, 22);
	    }
	    else if (dice2 == 6)
	    {
		//draw dice face 6
		c.fillOval (375, 465, 22, 22);
		c.fillOval (426, 465, 22, 22);
		c.fillOval (426, 515, 22, 22);
		c.fillOval (375, 515, 22, 22);
		c.fillOval (375, 490, 22, 22);
		c.fillOval (426, 490, 22, 22);
	    }
	    try
	    {
		Thread.sleep (100); //delay
	    }
	    catch (Exception e)
	    {
	    }
	}

	c.setColor (gameBoardColor); // backround
	c.fillOval (151, 166, 399, 249); //erase
	c.setColor (Color.black);
	//commentary
	c.drawString ("You Rolled a " + (dice1 + dice2), 260, 260);
	if (dice1 == dice2)
	{
	    c.drawString ("You Rolled a double!", 240, 290);
	    isDoubles = true;
	}
	c.drawString ("Press any key to continue... ", 200, 320);
	c.getChar (); //get input
	c.setColor (gameBoardColor); // backround
	c.fillOval (151, 166, 399, 249);
	return dice1 + dice2;
    }


    /*
    The purpose of this method is to draw the game board
    The first for loop is used to draw the tip of the arrow
    The second for loop is used to draw all the vertical lines that separate the panels
    The third for loop is used to draw all the horizontal lines that separate the panels
    */
    private void gameBoard ()
    {
	c.setColor (gameBoardColor); // backround
	c.fillRect (30, 30, 650, 650);
	c.fillRect (700, 30, 240, 150);
	c.fillRect (700, 200, 240, 370);
	c.fillRect (700, 590, 240, 90);
	c.setColor (new Color (102, 51, 0)); //brown
	//brown properties
	c.fillRect (518, 570, 53, 30);
	c.fillRect (410, 570, 54, 30);
	c.setColor (new Color (204, 255, 255)); //light blue
	//light blue properties
	c.fillRect (302, 570, 54, 30);
	c.fillRect (194, 570, 54, 30);
	c.fillRect (140, 570, 54, 30);
	//community chest
	c.fillRect (464, 570, 54, 110);
	c.fillRect (30, 248, 110, 54);
	c.fillRect (570, 248, 110, 54);
	c.setColor (new Color (255, 102, 178)); //purple
	//purple properties
	c.fillRect (110, 518, 30, 53);
	c.fillRect (110, 410, 30, 54);
	c.fillRect (110, 356, 30, 54);
	c.setColor (new Color (255, 128, 0)); //orange
	//orange properties
	c.fillRect (110, 302, 30, 54);
	c.fillRect (110, 195, 30, 54);
	c.fillRect (110, 141, 30, 54);
	//chance cards
	c.fillRect (60, 570, 80, 80);
	c.fillRect (248, 570, 54, 110);
	c.fillRect (248, 30, 54, 110);
	//jail
	c.fillRect (570, 356, 110, 54);
	c.setColor (Color.red);
	//red properties
	c.fillRect (518, 110, 53, 30);
	c.fillRect (464, 110, 54, 30);
	c.fillRect (410, 110, 54, 30);
	c.setFont (new Font ("Arial", 1, 40));
	c.drawString ("GO", 595, 610);
	for (int x = 0 ; x <= 30 ; x++)
	{
	    c.drawLine (580, 660, 610, 675 - x); //go arrow tip
	}
	c.fillRect (610, 652, 60, 15); //arrow
	//car
	c.fillRoundRect (50, 75, 70, 25, 5, 5);
	c.fillRoundRect (66, 40, 40, 40, 5, 5);
	c.setColor (Color.white);
	c.fillOval (76, 72, 20, 20);
	c.fillRect (74, 52, 25, 10);
	c.setColor (Color.yellow);
	//yellow properties
	c.fillRect (302, 110, 54, 30);
	c.fillRect (194, 110, 54, 30);
	c.fillRect (140, 110, 54, 30);
	c.setColor (new Color (0, 0, 255)); //green
	//green properties
	c.fillRect (570, 518, 30, 53);
	c.fillRect (570, 410, 30, 54);
	c.setColor (new Color (0, 153, 0)); //dark blue
	//darkblue properties
	c.fillRect (570, 302, 30, 54);
	c.fillRect (570, 195, 30, 54);
	c.fillRect (570, 141, 30, 54);
	c.setColor (Color.black);
	c.drawString ("?", 264, 605);
	c.drawString ("?", 264, 130);
	c.drawString ("?", 575, 400);
	c.drawString ("!", 485, 605);
	c.drawString ("!", 575, 290);
	c.drawString ("!", 115, 290);
	//tires
	c.fillRect (60, 90, 10, 20);
	c.fillRect (100, 90, 10, 20);
	//ui andboard outline
	c.drawRect (30, 30, 650, 650);
	c.drawLine (30, 140, 680, 140);
	c.drawLine (30, 570, 680, 570);
	c.drawLine (140, 30, 140, 680);
	c.drawLine (570, 30, 570, 680);
	c.drawRect (700, 30, 240, 150);
	c.drawRect (700, 200, 240, 370);
	c.drawRect (700, 590, 240, 90);
	for (int x = 140 ; x < 560 ; x = x + 54)
	{
	    //vertical panel seperator
	    c.drawLine (x, 30, x, 140);
	    c.drawLine (x, 570, x, 680);
	}
	for (int x = 140 ; x < 560 ; x = x + 54)
	{
	    //horizontoal panel seperator
	    c.drawLine (30, x, 140, x);
	    c.drawLine (570, x, 680, x);
	}
	//text box outline
	c.drawOval (150, 165, 400, 250);
	//starting placemarkers
	c.fillOval (600, 620, 20, 20);
	c.fillRect (630, 620, 20, 20);
	//jail bars
	c.fillRect (60, 570, 5, 80);
	c.fillRect (60, 645, 80, 5);
	c.fillRect (60, 570, 80, 5);
	c.fillRect (135, 570, 5, 80);
	c.setFont (new Font ("Times", 1, 17));
	//panel labels
	c.drawString ("Visiting Jail", 40, 670);
	c.drawString ("Go To Jail", 585, 55);
	c.setFont (new Font ("Times", 1, 12));
	c.drawString ("T", 125, 477);
	c.drawString ("a", 125, 487);
	c.drawString ("x", 125, 497);
	c.drawString ("e", 125, 507);
	c.drawString ("s", 125, 517);
	c.drawString ("T", 575, 477);
	c.drawString ("a", 575, 487);
	c.drawString ("x", 575, 497);
	c.drawString ("e", 575, 507);
	c.drawString ("s", 575, 517);
	c.drawString ("Railway", 358, 590);
	c.drawString ("Railway", 358, 130);
	c.setColor (new Color (0, 0, 255));
	c.fillOval (595, 60, 55, 55);
	//sad face
	c.setColor (Color.black);
	c.fillOval (605, 75, 10, 10);
	c.fillOval (625, 75, 10, 10);
	c.fillArc (610, 90, 20, 20, 0, 180);

    }


    /*
    The purpose of this method is to control the flow of the gameplay
    the first for loop is used to reset the values in an array
    the first 2 if statements are used to check the gamemodes and set timers
    The while loop is used to constantly allow the users to play the game
    The next if statement is used to check if the flag that checks if the game is over is true, if so the loop is broken. If statement inside checks if there is a timer, if so, the timer is stopped
    The next if statement checks if the timer ran out, if so the loop is broken.
    The next if statement is used to check if its player 1's turn (if the turns are not divisible by 2)
    The if statement inside is used to check if player 1 is not in jail, if not, the if statement insisde is used to check if the user entered c, if they did, a flag is set and an if statement inside checks if there is a timer, if so, the timer is stopped
    If not the jail method is called
    The next if statement is used to check if its player 2's turn (if the turns are divisible by 2)
    The if statement inside is used to check if player 2 is not in jail, if not, the if statement insisde is used to check if the user entered c, if they did, a flag is set and an if statement inside checks if there is a timer, if so, the timer is stopped
    If not the jail method is called
    Variable dictionary:
    Name:               Type:               Purpose:
    choice              char                This variable stores the user input
    t                   TimeLimit           Reference variable
    x                   int                 Loop variable
    */
    public void playGame ()
    {
	TimeLimit t = null;
	char choice;
	//reset values
	player1Position = 0;
	player2Position = 0;
	player1Balance = 1500;
	player2Balance = 1500;
	gameOver = false;
	conceded = false;
	player1GetOutOfJail = false;
	player2GetOutOfJail = false;
	player1InJail = false;
	player2InJail = false;
	for (int x = 0 ; x < propertiesOwned.length ; x++)
	{
	    propertiesOwned [x] = 0;
	}
	turn = 0;
	//draw the title and baord
	drawTitle ();
	gameBoard ();

	if (gameMode.equals ("Rush"))
	{
	    //d = new Console (4, 35, "Timer");
	    t = new TimeLimit (c, 15);
	    t.start ();
	}
	else if (gameMode.equals ("Blitz"))
	{
	    //d = new Console (4, 35, "Timer");
	    t = new TimeLimit (c, 15);
	    t.start ();
	}

	while (true)
	{
	    if (gameOver)
	    {
		if (t != null)
		{
		    t.stop ();
		    //d.close ();
		}
		break;
	    }
	    else if (t != null && t.isTimeOut ())
	    {
		JOptionPane.showMessageDialog (null, "The limit has been reached. The game is now over."); //message
		//d.close ();
		break;
	    }
	    turn++;
	    c.setColor (gameBoardColor); // backround
	    //background erase
	    c.fillRect (701, 31, 239, 149);
	    c.fillRect (701, 201, 239, 369);
	    c.fillRect (701, 591, 239, 89);
	    c.fillOval (151, 166, 399, 249);
	    c.setColor (Color.black);
	    //display turn and money info
	    c.setFont (new Font ("Times", 1, 25));
	    c.drawString ("Turn: " + turn, 720, 70);
	    if (turn % 2 == 1)
	    {
		c.drawString ("Money: $" + player1Balance, 720, 150);
		c.drawString ("Player 1's turn", 720, 110);
		if (!player1InJail)
		{
		    c.drawString ("Player 1's turn", 260, 240);
		    c.drawString ("Press any key to roll dice...", 200, 270);
		    c.drawString ("Press c to concede...", 200, 300);
		    choice = c.getChar (); //get input //get input
		    if (choice == 'c')
		    {
			conceded = true;
			if (t != null)
			{
			    t.stop ();
			    //d.close ();
			}
			break;
		    }
		    movePlayer (player1Position);
		    displayCards (player1Position);
		}
		else
		    isInJail ();
	    }
	    else
	    {
		//display turn and money info
		c.drawString ("Money: $" + player2Balance, 720, 150);
		c.drawString ("Player 2's turn", 720, 110);
		if (!player2InJail)
		{
		    c.drawString ("Player 2's turn", 260, 240);
		    c.drawString ("Press any key to roll dice...", 200, 270);
		    c.drawString ("Press c to concede...", 200, 300);
		    choice = c.getChar (); //get input
		    if (choice == 'c')
		    {
			conceded = true;
			if (t != null)
			    t.stop ();
			    //d.close ();
			break;
		    }
		    movePlayer (player2Position);
		    displayCards (player2Position);
		}
		else
		    isInJail ();
	    }
	}

    }


    /*
    The purpose of this method is move the player and draw their place maker on the new tile and erase the old place marker
    The the first 3 if statements are used to check what position the player was just on, and set the erase color to the position they were just on
    The next if statement and else are used to check whose turn it is and manipulate that player's position
    The first if statement inside of the previous 2 if statements are used to check if the player's landed on go to jail, if so a message is displayed and a flag is set to true
    Variable dictionary:
    Name:               Type:               Purpose:
    lastPosition        int                 Stores the last position of the player
    PLAYER1XLOCATIONS   int[]               This variable stores all the possible x locations for the first player to land on
    PLAYER1YLOCATIONS   int[]               This variable stores all the possible y locations for the first player to land on
    PLAYER2XLOCATIONS   int[]               This variable stores all the possible x locations for the second player to land on
    PLAYER2YLOCATIONS   int[]               This variable stores all the possible y locations for the second player to land on
    */
    private void movePlayer (int lastPosition)
    {
	final int[] PLAYER1XLOCATIONS = {600, 535, 481, 427, 373, 319, 265, 211, 157, 35, 50, 50, 50, 50, 50, 50, 50, 50, 50, 157, 211, 265, 319, 373, 427, 481, 535, 600, 610, 610, 610, 610, 610, 610, 610, 610, 610};
	final int[] PLAYER1YLOCATIONS = {620, 610, 610, 610, 610, 610, 610, 610, 610, 580, 535, 481, 427, 373, 319, 265, 211, 157, 115, 40, 40, 40, 40, 40, 40, 40, 40, 115, 157, 211, 265, 319, 373, 427, 481, 535, 580};
	final int[] PLAYER2XLOCATIONS = {630, 535, 481, 427, 373, 319, 265, 211, 157, 35, 80, 80, 80, 80, 80, 80, 80, 80, 100, 157, 211, 265, 319, 373, 427, 481, 535, 640, 640, 640, 640, 640, 640, 640, 640, 640, 640};
	final int[] PLAYER2YLOCATIONS = {620, 640, 640, 640, 640, 640, 640, 640, 640, 610, 535, 481, 427, 373, 319, 265, 211, 157, 115, 70, 70, 70, 70, 70, 70, 70, 70, 115, 157, 211, 265, 319, 373, 427, 481, 535, 580};
	//roll dice
	int moveBy = rollDice ();
	if (lastPosition != 0 && lastPosition != 2 && lastPosition != 4 && lastPosition != 6 && lastPosition != 9 && lastPosition != 11 && lastPosition != 15 && lastPosition != 18 && lastPosition != 21 && lastPosition != 23 && lastPosition != 27 && lastPosition != 30 && lastPosition != 32 && lastPosition != 34)
	    c.setColor (gameBoardColor); // backround
	else if (lastPosition == 6 || lastPosition == 21 || lastPosition == 32)
	    c.setColor (new Color (255, 128, 0)); //orange
	else if (lastPosition == 2 || lastPosition == 15 || lastPosition == 30)
	    c.setColor (new Color (204, 255, 255)); //light blue
	if (turn % 2 == 1)
	{
	    player1Position += moveBy;
	    if (player1Position == 27)
	    {
		//going to jail
		player1InJail = true;
		JOptionPane.showMessageDialog (null, "You have landed on Go To Jail. You have been sent to jail"); //message

	    }
	    c.fillOval (PLAYER1XLOCATIONS [lastPosition], PLAYER1YLOCATIONS [lastPosition], 20, 20); //erase place marker
	    if (!player1InJail)
	    {
		c.setColor (Color.black);
		if (player1Position > 35)
		{
		    //passing go
		    player1Position = player1Position - 36;
		    calcMoney (200);
		    c.setFont (new Font ("Arial", 1, 16));
		    c.drawString ("You passed GO and collected $200", 220, 210);
		}

		c.fillOval (PLAYER1XLOCATIONS [player1Position], PLAYER1YLOCATIONS [player1Position], 20, 20); //draw place marker
	    }
	    else
		isInJail ();

	}
	else
	{
	    player2Position += moveBy;
	    if (player2Position == 27)
	    {
		//going to jail
		player2InJail = true;
		JOptionPane.showMessageDialog (null, "You have landed on Go To Jail. You have been sent to jail"); //message


	    }
	    c.fillRect (PLAYER2XLOCATIONS [lastPosition], PLAYER2YLOCATIONS [lastPosition], 20, 20); //erase place marker
	    if (!player2InJail)
	    {
		c.setColor (Color.black);
		if (player2Position > 35)
		{
		    //passing go
		    player2Position = player2Position - 36;
		    calcMoney (200);
		    c.setFont (new Font ("Arial", 1, 16));
		    c.drawString ("You passed GO and collected $200", 220, 210);
		}
		c.fillRect (PLAYER2XLOCATIONS [player2Position], PLAYER2YLOCATIONS [player2Position], 20, 20); //draw place marker
	    }
	    else
		isInJail ();

	}
    }


    /*
    The purpose of this method is to check is the user is in jail. If they are, a list of choices are displayed and the user can enter an input to choose an option.
    The first if statement is used to check if the either player is in Jail
    The if statement inside is used to check if the turn is divisible by 2 (to see whos turn it is). Based on the result, either player 1 or player 2's place marker is drawn in jail
    The while loop inside is used to constantly get the user's input
    The if statement is used to check if the user entered a 1, if so, dice are rolled. The if statement inside is used to check if the player rolled doubles. If they did, a flag is set to true, a message is displayed
    Otherwise, a message is displayed and the user breaks out of the loop
    The next if statement is used to check if the user entered a 2, if they did, $50 is subtracted from their balance. A message is displayed and a flag is set to true.
    The next if statement is used to check if the user entered a 3, if they did, 2 if statements are used to check whose turn it is and if they have a get out of jail free card, if the do, a message is displayed and a flag is set to true, another flag is set to false
    Otherwise, if they do not have a get out of jail free card, an error message is displayed.
    If the user did not enter any of the correct input, an error message is displayed.
    The last if statement is used to check if a flag is true (if the player is now out of jail), if so, an if statement is used to check whoose turn it is and that player is moved out of jail
    Variable dictionary:
    Name:               Type:               Purpose:
    jailChoice          char                Stores the user input
    playerPosition      int                 Stores the player's position
    isOutOfJail         boolean             Stores if the player got out of jail
    */
    private void isInJail ()
    {
	char jailChoice = ' ';
	boolean isOutOfJail = false;
	if ((turn % 2 == 1 && player1InJail) || (turn % 2 == 0 && player2InJail))
	{
	    c.setColor (Color.black);
	    if (turn % 2 == 1)
	    {
		c.fillOval (110, 600, 20, 20); //draw place marker
	    }
	    else
	    {
		c.fillRect (70, 600, 20, 20); //draw place marker
	    }
	    c.setColor (new Color (0, 0, 255));
	    c.fillOval (595, 60, 55, 55);
	    c.setColor (Color.black);
	    //options
	    c.setFont (new Font ("Times", 1, 16));
	    c.drawString ("You are in jail", 300, 220);
	    c.drawString ("1. Roll For Doubles", 200, 240);
	    c.drawString ("2. Pay Bail ($50)", 200, 260);
	    c.drawString ("3. Use a Get Out Of Jail Free Card", 200, 280);
	    c.drawString ("Enter the number that corresponds to", 200, 300);
	    c.drawString ("your choice...", 300, 320);
	    while (true)
	    {
		jailChoice = c.getChar (); //get input
		if (jailChoice == '1')
		{
		    rollDice ();
		    if (isDoubles)
		    {
			JOptionPane.showMessageDialog (null, "You rolled doubles! You will be let out of jail."); //message
			isOutOfJail = true;
			break;
		    }
		    else
		    {
			JOptionPane.showMessageDialog (null, "Too Bad! Try again next turn."); //message
			break;
		    }

		}
		else if (jailChoice == '2')
		{
		    calcMoney (-50);
		    JOptionPane.showMessageDialog (null, "Bail Paid. You will be let out of jail."); //message
		    isOutOfJail = true;
		    break;
		}
		else if (jailChoice == '3')
		{
		    if (turn % 2 == 1 && player1GetOutOfJail)
		    {
			player1GetOutOfJail = false;
			isOutOfJail = true;
			JOptionPane.showMessageDialog (null, "Card accepted. You will be let out of jail."); //message
			break;
		    }
		    else if (turn % 2 == 0 && player2GetOutOfJail)
		    {
			player2GetOutOfJail = false;
			isOutOfJail = true;
			JOptionPane.showMessageDialog (null, "Card accepted. You will be let out of jail."); //message
			break;
		    }
		    else
			JOptionPane.showMessageDialog (null, "You do not have a Get Out Of Jail Free Card."); //message
		}
		else
		    JOptionPane.showMessageDialog (null, "Please enter 1, 2, or 3."); //errpr message
	    }
	}
	if (isOutOfJail)
	{
	    c.setColor (gameBoardColor); // backround
	    c.fillOval (151, 166, 399, 249); //erase
	    if (turn % 2 == 1)
	    {
		player1InJail = false;
		player1Position = 9;
		c.setColor (new Color (255, 128, 0)); //orange
		c.fillOval (110, 600, 20, 20); //erase
		c.setColor (Color.black);
		c.fillOval (35, 580, 20, 20);
	    }
	    else
	    {
		player2InJail = false;
		player2Position = 9;
		c.setColor (new Color (255, 128, 0)); //orange
		c.fillRect (70, 600, 20, 20); //erase
		c.setColor (Color.black);
		c.fillRect (35, 610, 20, 20);

	    }
	}
    }


    /*
    The purpose of this method is to check if the user landed on a property, chance or chest card. If they did, the information of that card will be displayed to the side.

    The first if statement is used to check if the user landed on a property, if so the property info will be displayed
    The if statement inside are used to check if no players own the property, if so, that information will be displayed as well as the fact that there are no houses or hotels
    The next if statement inside is used to check if player 1 owns the property, if so, that information will be displayed. The if statement inside that is used to check if there are no hotels on the property, if so the number of houses is
    displayed and the fact there are 0 hotels, otherwise, the fact that there is 1 hotel and 0 houses is displayed
    The next if statement inside is used to check if player 2 owns the property, if so, that information will be displayed. The if statement inside is used to check if there are no hotels on the property, if so the number of houses is
    displayed and the fact there are 0 hotels, otherwise, the fact that there is 1 hotel and 0 houses is displayed
    The next if statement inside is used to check if the property is not owned, or owned by the player that is playing this turn, if so, the method to buy properties will be called, otherwise, the pay rent method will be called

    The second if statement is used to check if the user landed on a railroad, if so the railroad info will be displayed
    The three if statements inside are used to check if the property is owned by either player, if so, the corresponding info will be displayed
    The next if statement inside is used to check if the property is not owned, or owned by the player that is playing this turn, if so, the method to buy properties will be called, otherwise, the pay rent method will be called

    The third if statement is used to check if the user landed on a tax tile, if so they will be asked to pay tax

    The fourth if statement is used to check if the user landed on a chance tile, if so a chance card will be randomed and its info will be displayed

    The fifth if statement is used to check if the user landed on a community chest tile, if so a community chest card will be randomed and its info will be displayed

    The last if statement is used to check if the user landed on a panel with no actions (visiting jail, free parking, go)
    Name:               Type:               Purpose:
    CHANCEDATA          String [] []          This variable stores all the data of the chance cards
    CHESTDATA           String [] []          This variable stores all the data of the chest cards
    playerPosition      int                 This variable stores the player's position
    */
    private void displayCards (int playerPosition)
    {
	final String[] [] CHANCEDATA = {{"Get Out Of Jail Free", "You may keep this card"}, {"Mega Lottery Winner", "Collect $700", "700"}, {"Taxi Fee", "Pay $50 to the bank", "-50"}, {"Happy Birthday", "Bank Pays You $50", "50"}, {"Poor Tax Evasion", "Pay $15 To The Bank", "-15"}, {"Lottery Winner", "Collect $300", "300"}, {"Bad Publicity", "Pay the bank $100", "100"}};
	final String[] [] CHESTDATA = {{"Trust Fund Matures", "Collect $100 From The Bank", "100"}, {"Doctor Fees", "Pay $50 To The Bank", "-50"}, {"World Tour", "Collect $100 From The Bank", "100"}, {"Good Publicity", "Collect $100 from the bank", "100"}, {"Bank Error", "Collect $200 from the bank", "200"}, {"Income Tax Refund", "Collect $20 from the bank", "20"}, {"Hospital Fees", "Pay $50 to the bank", "-50"}};

	if (playerPosition != 0 && playerPosition != 2 && playerPosition != 4 && playerPosition != 6 && playerPosition != 9 && playerPosition != 11 && playerPosition != 15 && playerPosition != 18 && playerPosition != 21 && playerPosition != 23 && playerPosition != 27 && playerPosition != 30 && playerPosition != 32 && playerPosition != 34)
	{
	    c.setColor (new Color (PANELDATA [playerPosition] [0], PANELDATA [playerPosition] [1], PANELDATA [playerPosition] [2])); //draw panel color
	    c.fillRect (701, 201, 239, 59);
	    c.setColor (Color.black);
	    c.drawLine (700, 260, 940, 260);
	    c.setFont (new Font ("Arial", 1, 22));
	    c.drawString (PANELNAMES [playerPosition], 710, 240); //draw name of property
	    if (propertiesOwned [playerPosition] == 0)
	    {
		//ownership and house info
		c.drawString ("Not Owned", 760, 560);
		c.drawString ("Houses built: 0", 710, 630);
		c.drawString ("Hotels built: 0", 710, 660);
	    }
	    else if (propertiesOwned [playerPosition] > 0)
	    {
		//ownership and house info
		c.drawString ("Owned By Player 1", 710, 560);
		c.setFont (new Font ("Arial", 1, 24));
		if (propertiesOwned [playerPosition] != 6)
		{
		    c.drawString ("Houses built:" + (propertiesOwned [playerPosition] - 1), 710, 630);
		    c.drawString ("Hotels built: 0", 710, 660);
		}
		else
		{
		    c.drawString ("Houses built: 0", 710, 630);
		    c.drawString ("Hotels built: 1", 710, 660);
		}
	    }
	    else if (propertiesOwned [playerPosition] < 0)
	    {
		//ownership and house info
		c.drawString ("Owned By Player 2", 710, 560);
		c.setFont (new Font ("Arial", 1, 24));
		if (propertiesOwned [playerPosition] != -6)
		{
		    c.drawString ("Houses built:" + (propertiesOwned [playerPosition] + 1) * -1, 710, 630);
		    c.drawString ("Hotels built: 0", 710, 660);
		}
		else
		{
		    c.drawString ("Houses built: 0", 710, 630);
		    c.drawString ("Hotels built: 1", 710, 660);
		}
	    }
	    //draw property info
	    c.setFont (new Font ("Arial", 1, 16));
	    c.drawString ("Rent: $" + PANELDATA [playerPosition] [3], 780, 280);
	    c.drawString ("Rent with color group: $" + PANELDATA [playerPosition] [4], 720, 295);
	    c.drawString ("With 1 house:        $" + PANELDATA [playerPosition] [5], 720, 330);
	    c.drawString ("With 2 house:        $" + PANELDATA [playerPosition] [6], 720, 345);
	    c.drawString ("With 3 house:        $" + PANELDATA [playerPosition] [7], 720, 360);
	    c.drawString ("With 4 house:        $" + PANELDATA [playerPosition] [8], 720, 375);
	    c.drawString ("With hotel:              $" + PANELDATA [playerPosition] [9], 720, 390);
	    c.drawString ("Building Costs", 760, 450);
	    c.drawString ("Each house costs:   $" + PANELDATA [playerPosition] [11], 720, 480);
	    c.drawString ("Each hotel costs:     $" + PANELDATA [playerPosition] [12], 720, 495);
	    c.drawString ("Deed cost:          $" + PANELDATA [playerPosition] [10], 720, 520);
	    if ((turn % 2 == 1 && propertiesOwned [playerPosition] >= 0) || (turn % 2 == 0 && propertiesOwned [playerPosition] <= 0))
		buyProperty (playerPosition);
	    else
		payRent (playerPosition);

	}

	else if (playerPosition == 4 || playerPosition == 23)
	{
	    c.setFont (new Font ("Arial", 1, 22));
	    c.setColor (Color.black);
	    c.drawString (PANELNAMES [playerPosition], 720, 240); //draw pannel name
	    //ownership and house info
	    if (propertiesOwned [playerPosition] == 0)
	    {
		c.drawString ("Not Owned", 760, 560);
	    }
	    else if (propertiesOwned [playerPosition] > 0)
	    {
		c.drawString ("Owned By Player 1", 710, 560);

	    }
	    else if (propertiesOwned [playerPosition] < 0)
	    {
		c.drawString ("Owned By Player 2", 710, 560);
	    }
	    c.setFont (new Font ("Arial", 1, 16));
	    c.drawString ("Rent with 1 Railroad $" + PANELDATA [playerPosition] [3], 720, 280);
	    c.drawString ("Rent with 2 Railroads $" + PANELDATA [playerPosition] [3] * 2, 720, 310);
	    c.setFont (new Font ("Times", 1, 16));
	    c.drawString ("You have landed on " + PANELNAMES [playerPosition], 200, 240);
	    c.drawString ("1. Buy the station ($" + PANELDATA [playerPosition] [4] + ")", 200, 260);
	    c.drawString ("2. End Turn ", 200, 280);
	    c.drawString ("Press the key that corresponds with your ", 200, 300);
	    c.drawString ("choice...", 200, 320);
	    if ((turn % 2 == 1 && propertiesOwned [playerPosition] >= 0) || (turn % 2 == 0 && propertiesOwned [playerPosition] <= 0))
		buyProperty (playerPosition);
	    else
		payRent (playerPosition);
	}

	else if (playerPosition == 11 || playerPosition == 34)
	{
	    //panel info
	    c.setColor (Color.black);
	    c.setFont (new Font ("Times", 1, 16));
	    c.drawString ("You have landed on a tax tile.", 220, 240);
	    c.drawString ("You must pay $200 to the bank.", 220, 260);
	    c.drawString ("Press any key to continue...", 220, 280);
	    c.getChar (); //get input
	    calcMoney (-200);
	    c.setFont (new Font ("Times", 1, 16));
	    c.drawString ("Press any key to end turn...", 220, 300);
	    c.getChar (); //get input
	}

	else if (playerPosition == 6 || playerPosition == 21 || playerPosition == 32)
	{
	    //draw orange box
	    c.setColor (new Color (255, 128, 0));
	    c.fillRect (701, 201, 239, 369);
	    c.setColor (Color.black);
	    c.setFont (new Font ("Arial", 1, 22));
	    c.drawString (PANELNAMES [playerPosition], 780, 240); //chance
	    int randomChance = (int) (6 * Math.random ());
	    c.drawString (CHANCEDATA [randomChance] [0], 720, 300); // chance card name
	    c.setFont (new Font ("Arial", 1, 18));
	    c.drawString (CHANCEDATA [randomChance] [1], 720, 350); // chace card details
	    c.setFont (new Font ("Times", 1, 16));
	    c.drawString ("You have landed on a Chance Card", 200, 240);
	    c.drawString (CHANCEDATA [randomChance] [1], 200, 260); // chance card detial
	    c.drawString ("Press any key to continue...", 200, 280);
	    c.getChar (); //get input
	    if (randomChance != 0)
	    {
		calcMoney (Integer.parseInt (CHANCEDATA [randomChance] [2]));
		c.setFont (new Font ("Times", 1, 16));
		//display remaining money
		if (turn % 2 == 1)
		    c.drawString ("You now have $" + player1Balance, 200, 300);
		else
		    c.drawString ("You now have $" + player2Balance, 200, 300);
	    }
	    else
	    {
		if (turn % 2 == 1)
		    player1GetOutOfJail = true;
		else
		    player2GetOutOfJail = true;
	    }
	    c.drawString ("Press any key to end turn...", 200, 320);
	    c.getChar (); //get input


	}

	else if (playerPosition == 2 || playerPosition == 15 || playerPosition == 30)
	{
	    c.setColor (Color.black);
	    c.setFont (new Font ("Arial", 1, 22));
	    c.drawString (PANELNAMES [playerPosition], 720, 240); // panel name
	    int randomChance = (int) (6 * Math.random ());
	    c.drawString (CHESTDATA [randomChance] [0], 720, 300); //chest card name
	    c.setFont (new Font ("Arial", 1, 14));
	    c.drawString (CHESTDATA [randomChance] [1], 720, 350); //chest card data
	    c.setFont (new Font ("Times", 1, 16));
	    c.drawString ("You have landed on a Community", 200, 240);
	    c.drawString ("Chest Card", 200, 260);
	    c.drawString (CHESTDATA [randomChance] [1], 200, 280);  //chest card data
	    c.drawString ("Press any key to continue...", 200, 300);
	    c.getChar (); //get input
	    calcMoney (Integer.parseInt (CHESTDATA [randomChance] [2]));
	    c.setFont (new Font ("Times", 1, 16));
	    //display remaining money
	    if (turn % 2 == 1)
		c.drawString ("You now have $" + player1Balance, 200, 320);
	    else
		c.drawString ("You now have $" + player2Balance, 200, 320);
	    c.drawString ("Press any key to end turn...", 200, 340);
	    c.getChar (); //get input
	}
	else if (playerPosition == 9 || playerPosition == 18 || playerPosition == 0)
	{
	    c.drawString ("You landed on: " + PANELNAMES [playerPosition], 180, 280);
	    c.drawString ("Press any key to end turn...", 200, 320);
	    c.getChar (); //get input
	}
    }


    /*
    The purpose of this method is to make the player pay rent to the other player, based on the property they landed on
    The first if statement is used to check if the user did not land on a railroad
    The first if statement and else statement inside are used to check whose turn it is and will display the rent info
    Inside:
    The first if statement inside is used to check if that player owns a hotel on the position, if so the number of hotels is increased by 1, otherwise the number of houses is calculated
    The next if statement inside is used to check if the opponent owns all of the properties of the same color group, if so, the rent is doubled
    The next if statement inside is used to check if the player has houses, if so the rent is increased
    The next if statement inside is used to check if the player has a hotel, if so the rent is increased
    Otherwise if the user did land on a rail road,
    The first if statement inside is used to check if its player 1's turn and they own 2 rail roads, if so, the corresponding info is displayed and calculated
    The second if statement inside is used to check if its player 1's turn and they don't own 2 rail roads, if so, the corresponding info is displayed and calculated
    The third if statement inside is used to check if its player 2's turn and they own 2 rail roads, if so, the corresponding info is displayed and calculated
    The fourth if statement inside is used to check if its player 2's turn and they dont own 2 rail roads, if so, the corresponding info is displayed and calculated
    The fifth if/else statement inside is used to whose turn it is, and money will be subtracted from their balance and printed
    Variable dictionary:
    Name:               Type:               Purpose:
    houses              int                 Stores the number of houses
    hotel               int                 Stores the number of hotels
    totalRent           int                 Store the total rent the player must pays
    playerPosition      int                 Stores the player's position
    */
    private void payRent (int playerPosition)
    {
	int houses = 0;
	int hotel = 0;
	int totalRent = 0;
	c.setColor (gameBoardColor); // backround
	c.fillOval (151, 166, 399, 249);
	c.setColor (Color.black);
	c.setFont (new Font ("Times", 1, 13));
	if (playerPosition != 4 && playerPosition != 23)
	{
	    if (turn % 2 == 1)
	    {
		if (propertiesOwned [playerPosition] == -6)
		    hotel++;
		else
		    houses = (propertiesOwned [playerPosition] + 1) * -1; //calc number of houses
		c.drawString ("You have landed on your opponent\'s property ", 190, 240);
		c.drawString ("Your opponent has a total of " + houses + " houses and " + hotel + " hotel(s)", 190, 260);
		totalRent = PANELDATA [playerPosition] [3];
		//calc rent
		if (checkMonopoly (playerPosition, 2))
		    totalRent *= 2;
		if (houses > 0)
		    totalRent += PANELDATA [playerPosition] [4 + houses];
		if (hotel > 0)
		    totalRent += PANELDATA [playerPosition] [9];
		//display rent pay info
		c.drawString ("You must pay a total of $" + totalRent + " to Player 2", 190, 280);
		c.drawString ("Press any key to continue...", 190, 300);
		c.getChar (); //get input
		calcMoney (-totalRent);
		player2Balance += totalRent;
		c.setFont (new Font ("Times", 1, 16));
		c.drawString ("You now have $" + player1Balance, 190, 320);
		c.drawString ("Your opponent now has $" + player2Balance, 190, 340);
		c.drawString ("Press any key to end turn...", 190, 360);
		c.getChar (); //get input
	    }

	    else
	    {
		if (propertiesOwned [playerPosition] == 6)
		    hotel++;
		else
		    houses = (propertiesOwned [playerPosition] - 1); //calc number of houses
		c.drawString ("You have landed on your opponents property", 190, 240);
		c.drawString ("Your opponent has a total of " + houses + " houses and " + hotel + " hotel(s)", 190, 260);
		totalRent = PANELDATA [playerPosition] [3];
		//calc rend
		if (checkMonopoly (playerPosition, 2))
		    totalRent *= 2;
		if (houses > 0)
		    totalRent += PANELDATA [playerPosition] [4 + houses];
		if (hotel > 0)
		    totalRent += PANELDATA [playerPosition] [9];
		//display rent pay info
		c.drawString ("You must pay a total of $" + totalRent + " to Player 1", 190, 280);
		c.drawString ("Press any key to continue...", 190, 300);
		c.getChar (); //get input
		calcMoney (-totalRent);
		player1Balance += totalRent;
		c.setFont (new Font ("Times", 1, 16));
		c.drawString ("You now have $" + player2Balance, 190, 320);
		c.drawString ("Your opponent now has $" + player1Balance, 190, 340);
		c.drawString ("Press any key to end your turn...", 190, 360);
		c.getChar (); //get input
	    }
	}
	else

	    {
		//display railroad property
		c.drawString ("You have landed on your opponents property", 190, 240);
		if (turn % 2 == 1 && propertiesOwned [4] < 0 && propertiesOwned [23] < 0)
		{
		    c.drawString ("Your opponent has a total of 2 railroads", 190, 260);
		    totalRent = 50;
		    c.drawString ("You must pay a total of $" + totalRent + " to Player 2", 190, 280);
		    c.drawString ("Press any key to continue...", 190, 300);
		}
		else if (turn % 2 == 1)
		{
		    c.drawString ("Your opponent has a total of 1 railroad", 190, 260);
		    totalRent = 25;
		    c.drawString ("You must pay a total of $" + totalRent + " to Player 2", 190, 280);
		    c.drawString ("Press any key to continue...", 190, 300);
		}
		else if (turn % 2 == 0 && propertiesOwned [4] > 0 && propertiesOwned [23] > 0)
		{
		    c.drawString ("Your opponent has a total of 2 railroads", 190, 260);
		    totalRent = 50;
		    c.drawString ("You must pay a total of $" + totalRent + " to Player 1", 190, 280);
		    c.drawString ("Press any key to continue...", 190, 300);

		}
		else if (turn % 2 == 0)
		{
		    c.drawString ("Your opponent has a total of 1 railroad", 190, 260);
		    totalRent = 25;
		    c.drawString ("You must pay a total of $" + totalRent + " to Player 1", 190, 280);
		    c.drawString ("Press any key to continue...", 190, 300);
		}
		c.getChar (); //get input
		c.setFont (new Font ("Times", 1, 16));
		if (turn % 2 == 1)
		{
		    calcMoney (-totalRent);
		    player2Balance += totalRent;
		    c.setFont (new Font ("Times", 1, 16));
		    c.drawString ("You now have $" + player1Balance, 190, 320);
		    c.drawString ("Your opponent now has $" + player2Balance, 190, 340);
		}
		else
		{
		    calcMoney (-totalRent);
		    player1Balance += totalRent;
		    c.setFont (new Font ("Times", 1, 16));
		    c.drawString ("You now have $" + player2Balance, 190, 320);
		    c.drawString ("Your opponent now has $" + player1Balance, 190, 340);
		}
		c.drawString ("Press any key to end your turn...", 190, 360);
		c.getChar (); //get input

	    }
    }


    /*
    The purpose of this method is to allow the user to buy property and houses and hotel(s)
    The first if statement is used to check if the property the player is on is not a railroad (so its a property)
    Inside, the while loop is used to get user input over and over again
    The if statements inside are used to check what the user input is (1, 2, 3, or 4)
    If the user did not enter a correct input, an error message will display
    If the user input is 1, an if statement inside is used to check if the property is not owned, if so money is subtracted and the if statement inside is used to check who bought the property and records the corresponding info
    If the property is already owned, if statements are used to check whose turn it is, and if statements inside are used to check if the property is already owned by you or the opponent, an error message is displayed showing that info
    If the user input is 2, an if statement checks if the user did not already by a house, owns all the property of that color group, and owns less than 4 houses, if so, if statements inside are used to check whos turn it is and records the corresponding purchase
    If the user already bought a house, an error message will display
    If the user does not own the property or has too many houses, an error message will display
    If the user already has a hotel, an error message will display
    If the user doesn't own all the properties in the same color group, an error message will display
    If the user input is 3, an if statement checks if the user has 4 houses on the property, if so a hotel is bought and recorded based on whose turn it is. 2 If statements inside are used to check if the player already has or hotel or does not have 4 houses, if so an error message is displayed
    If the user input is 4, the user breaks out of the loop

    Otherwise, if the user is on a rail road
    a while loop is used to get user input over and over again
    It the user enters 1, an if statement checks whos turn it is and an if statement inside checks if the railroad is not owned. If it is, an error message is displayed based on who owned the rail road
    If the user enters a 2, they will break out of the loop
    if the user enters anything else, an error message will display
    Variable dictionary:
    Name:               Type:               Purpose:
    alreadyBoughtHouse  boolean             Stores whether or not the user has bought a house this turn
    purchaseChoice      char                Stores the user input
    playerPosition      int                 Stores the player's position
    */
    private void buyProperty (int playerPosition)
    {
	boolean alreadyBoughtHouse = false;
	char purchaseChoice = ' ';
	if (playerPosition != 4 && playerPosition != 23)
	{
	    c.setColor (gameBoardColor); // backround
	    c.fillOval (151, 166, 399, 249);
	    c.setColor (Color.black);
	    //buy menu
	    c.setFont (new Font ("Times", 1, 16));
	    c.drawString ("You have landed on " + PANELNAMES [playerPosition], 200, 240);
	    c.drawString ("Please enter one of the following options", 200, 260);
	    c.drawString ("1. Buy Property ($" + PANELDATA [playerPosition] [10] + ")", 200, 280);
	    c.drawString ("2. Build A House ($" + PANELDATA [playerPosition] [11] + ")", 200, 300);
	    c.drawString ("3. Build A Hotel ($" + PANELDATA [playerPosition] [12] + ")", 200, 320);
	    c.drawString ("4. End Turn", 200, 340);
	    c.drawString ("Enter the number that corresponds to", 200, 360);
	    c.drawString ("your choice...", 300, 380);
	    while (true)
	    {
		purchaseChoice = c.getChar (); //get input
		if (purchaseChoice != '1' && purchaseChoice != '2' && purchaseChoice != '3' && purchaseChoice != '4')
		    JOptionPane.showMessageDialog (null, "Please enter 1, 2, 3, or 4!");
		if (purchaseChoice == '1')
		{
		    if (propertiesOwned [playerPosition] == 0)
		    {
			calcMoney (-PANELDATA [playerPosition] [10]); //purchase
			c.setColor (gameBoardColor); // backround
			c.fillRect (740, 540, 200, 20);
			c.setColor (Color.black);
			if (turn % 2 == 1)
			{
			    propertiesOwned [playerPosition] = 1;
			    c.drawString ("Owned By Player 1", 710, 560);
			}
			else
			{
			    propertiesOwned [playerPosition] = -1;
			    c.drawString ("Owned By Player 2", 710, 560);
			}
		    }
		    else if (propertiesOwned [playerPosition] != 0)
		    {
			if (turn % 2 == 1)
			{
			    if (propertiesOwned [playerPosition] > 0)
			    {
				JOptionPane.showMessageDialog (null, "You already own this property!");
			    }
			    else
			    {
				JOptionPane.showMessageDialog (null, "Your opponent already owns this property!");
			    }
			}
			else
			{
			    if (propertiesOwned [playerPosition] < 0)
			    {
				JOptionPane.showMessageDialog (null, "You already own this property!");
			    }
			    else
			    {
				JOptionPane.showMessageDialog (null, "Your opponent already owns this property!");
			    }
			}
		    }
		}

		if (purchaseChoice == '2')
		{
		    if (alreadyBoughtHouse == false && checkMonopoly (playerPosition, 1) == true && ((turn % 2 == 1 && propertiesOwned [playerPosition] < 5 && propertiesOwned [playerPosition] >= 1) || (turn % 2 == 0 && propertiesOwned [playerPosition] > -5 && propertiesOwned [playerPosition] <= -1)))
		    {
			calcMoney (-PANELDATA [playerPosition] [11]); //purchase
			if (turn % 2 == 1)
			    propertiesOwned [playerPosition] += 1;
			else
			    propertiesOwned [playerPosition] += -1;
			alreadyBoughtHouse = true;
			c.setColor (gameBoardColor); // backround
			c.fillRect (701, 591, 239, 89); //erase
			c.setFont (new Font ("Arial", 1, 24));
			c.setColor (Color.black);
			//print houses build again
			if (turn % 2 == 1)
			{
			    c.drawString ("Houses built:" + (propertiesOwned [playerPosition] - 1), 710, 630);
			    c.drawString ("Hotels built: 0", 710, 660);
			}
			else
			{
			    c.drawString ("Houses built:" + ((propertiesOwned [playerPosition] + 1) * -1), 710, 630);
			    c.drawString ("Hotels built: 0", 710, 660);


			}
		    }
		    else if (alreadyBoughtHouse)
		    {
			JOptionPane.showMessageDialog (null, "You already bought a house this turn!"); //error message
		    }
		    else if (turn % 2 == 1)
		    {
			if (propertiesOwned [playerPosition] <= 0)
			{
			    JOptionPane.showMessageDialog (null, "You do not own this property!"); //error message
			}
			else if (propertiesOwned [playerPosition] >= 5)
			{
			    JOptionPane.showMessageDialog (null, "You have reached the max number of houses on this property!"); //error message
			}
		    }
		    else if (turn % 2 == 0)
		    {
			if (propertiesOwned [playerPosition] >= 0)
			{
			    JOptionPane.showMessageDialog (null, "You do not own this property!"); //error message
			}
			else if (propertiesOwned [playerPosition] <= -5)
			{
			    JOptionPane.showMessageDialog (null, "You have reached the max number of houses on this property!"); //error message
			}
		    }
		    else if (propertiesOwned [playerPosition] > 5 || propertiesOwned [playerPosition] < -5)
		    {
			JOptionPane.showMessageDialog (null, "You already have a hotel on this property! You cannot build any more houses"); //error message
		    }
		    if (checkMonopoly (playerPosition, 1) == false)
		    {
			JOptionPane.showMessageDialog (null, "You do not own all of the properties of this color group!"); //error message
		    }
		}
		if (purchaseChoice == '3')
		{
		    if (propertiesOwned [playerPosition] == 5 || propertiesOwned [playerPosition] == -5)
		    {
			calcMoney (-PANELDATA [playerPosition] [12]); //purchase
			if (turn % 2 == 1)
			    propertiesOwned [playerPosition] += 1;
			else
			    propertiesOwned [playerPosition] += -1;
			c.setColor (gameBoardColor); // backround
			c.fillRect (701, 591, 239, 89);
			c.setFont (new Font ("Arial", 1, 24));
			c.setColor (Color.black);
			//display hotel built
			c.drawString ("Houses built: 0", 710, 630);
			c.drawString ("Hotels built: 1", 710, 660);

		    }
		    else if (propertiesOwned [playerPosition] == 6 || propertiesOwned [playerPosition] == -6)
			JOptionPane.showMessageDialog (null, "You already own a hotel on this property"); //error message

		    else
			JOptionPane.showMessageDialog (null, "You do not own 4 houses on this property"); //error message
		}
		if (purchaseChoice == '4')
		{
		    alreadyBoughtHouse = false;
		    break;
		}
	    }
	}
	else
	{
	    while (true)
	    {
		purchaseChoice = c.getChar (); //get input
		if (purchaseChoice == '1')
		{
		    if (turn % 2 == 1)
		    {
			if (propertiesOwned [playerPosition] == 0)
			{
			    propertiesOwned [playerPosition]++;
			    calcMoney (-PANELDATA [playerPosition] [4]); //purchase
			    c.setColor (gameBoardColor); // backround
			    c.fillRect (740, 540, 200, 20); //erase
			    c.setColor (Color.black);
			    c.drawString ("Owned By Player 1", 710, 560);

			}
			else if (propertiesOwned [playerPosition] > 0)
			{
			    JOptionPane.showMessageDialog (null, "You already own this railroad"); //error message
			}
			else if (propertiesOwned [playerPosition] < 0)
			{
			    JOptionPane.showMessageDialog (null, "Your opponent already owns this railroad"); //error message
			}
		    }
		    else
		    {
			if (propertiesOwned [playerPosition] == 0)
			{
			    propertiesOwned [playerPosition]--;
			    calcMoney (-PANELDATA [playerPosition] [4]); //purchase
			    c.setColor (gameBoardColor); // backround
			    c.fillRect (740, 540, 200, 20); //erase
			    c.setColor (Color.black);
			    c.drawString ("Owned By Player 2", 710, 560);

			}
			else if (propertiesOwned [playerPosition] > 0)
			{
			    JOptionPane.showMessageDialog (null, "Your opponent already owns this railroad"); //error message

			}
			else if (propertiesOwned [playerPosition] < 0)
			{
			    JOptionPane.showMessageDialog (null, "You already own this railroad"); //error message
			}
		    }
		}
		else if (purchaseChoice == '2')
		    break;
		else
		    JOptionPane.showMessageDialog (null, "Please enter 1 or 2!"); //error message
	    }
	}
    }


    /*
    The purpose of this method is to calculate and display price changes after purchases/fines
    The first if statement is used to check if the number of turns is divisible by 1 (whose turn it is) if so, player 1's balance will be modified and displayed
    Otherwise, player 2's balance will be modified and displayed
    The next if statement is used to either player has ran out of money after the recent balance modification, if so, a flag will be set to true and an message will display
    Variable dictionary:
    Name:               Type:               Purpose:
    priceChance         int                 Store's the amount added/deducted from a player's balance
    */
    private void calcMoney (int priceChange)
    {
	c.setColor (gameBoardColor); // backround
	c.fillRect (720, 130, 200, 20);
	c.setColor (Color.black);
	c.setFont (new Font ("Times", 1, 25));
	if (turn % 2 == 1)
	{
	    player1Balance += priceChange;
	    c.drawString ("Money: $" + player1Balance, 720, 150); //print the new balance
	}


	else
	{
	    player2Balance += priceChange;
	    c.drawString ("Money: $" + player2Balance, 720, 150); //print the new balance
	}


	if (player1Balance <= 0 || player2Balance <= 0)
	{
	    gameOver = true;
	    JOptionPane.showMessageDialog (null, "You have ran out of money. The game will end after you end your turn."); //message
	}

    }


    /*
    The purpose of this method is used to calculate the score of either player
    The first if statement is used to check is the passed in player is 1, if so, the score for player 1 will be calculated
    Otherwise, the player 2 score will be calculated
    Variable dictionary:
    Name:               Type:               Purpose:
    player              int                 Stores which player to calculate the score for
    */
    private int calcScore (int player)
    {
	int playerScore = 0;
	if (player == 1)
	{
	    playerScore = (player1Balance - player2Balance) - turn * 10; //calc score
	}
	else
	{
	    playerScore = (player2Balance - player1Balance) - turn * 10; //calc score
	}
	return playerScore;
    }


    /*
    The purpose of this method is to display the result of the game (who won)
    The first if statement is used to check if either player conceded, if so, the if/else statements inside are used to check who conceded (whose turn the game ended on) and display the corresponding result
    If neither player conceded, 2 if statements are used to check which player won based on which player had the most money and will display the corresponding result
    the else is true when both players had the same amount of money
    The next 2 while loops with if statements inside are used to continuously get the username input and check if it is the correct length, if not, an error message is displayed and input is asked for again
    The try catch block is used to handle IOExecptions from BufferedRead and PrintWritter
    The while loop inside is used to loop through each line of the file as long as the line contains something (is not null)
    The for loop inside is used to loop through all the lines that exist and read and store each line
    The next for loop inside is used to loop through all the lines that were just stored and print them out one by one
    Variable dictionary:
    Name:               Type:               Purpose:
    player1Name         String              Stores player 1's username
    player2Name         String              Stores player 2's username
    lineCount           int                 Stores the number of lines in the file
    x                   int                 Loop variable
    br                  BufferedReader      reference variable
    pr                  PrintWritter        reference variable
    */
    public void displayResult ()
    {
	String player1Name, player2Name = " ";
	int lineCount = 0;
	drawTitle ();
	c.setFont (new Font ("Arial", 1, 30));
	//display the player scores
	c.drawString ("Player 1 Score: " + calcScore (1), 350, 240);
	c.drawString ("Player 2 Score: " + calcScore (2), 350, 280);
	c.setFont (new Font ("Arial", 1, 90));
	if (conceded)
	{
	    if (turn % 2 == 1)
	    {
		//display result
		c.drawString ("Player 2 Won!", 200, 150);
		c.setFont (new Font ("Arial", 1, 30));
		c.drawString ("Player 1 Conceded", 350, 200);
	    }
	    else
	    {
		//display result
		c.drawString ("Player 1 Won!", 200, 150);
		c.setFont (new Font ("Arial", 1, 30));
		c.drawString ("Player 2 Conceded", 350, 200);
	    }
	}
	else
	{
	    if (player1Balance > player2Balance)
	    {
		//display result
		c.drawString ("Player 1 Won!", 200, 150);
	    }
	    else if (player1Balance < player2Balance)
	    {
		//display result
		c.drawString ("Player 2 Won!", 200, 150);
	    }
	    else
	    {
		//display result
		c.drawString ("Wow It's A Tie!", 190, 150);
	    }
	}
	c.setFont (new Font ("Arial", 1, 30));
	//get player usernames
	c.drawString ("Player 1 please enter a username: ", 50, 640);
	c.setTextBackgroundColor (new Color (204, 255, 255));
	while (true)
	{
	    c.setCursor (24, 46);
	    player1Name = c.readString (); //get username
	    if (player1Name.length () <= 10)
		break;
	    else
	    {
		c.setColor (new Color (204, 255, 255));
		c.fillRect (540, 615, 400, 30); //erase old input
		new Message ("Names must be less than or equal too 10 characters in length", "Error"); //message
	    }

	}
	c.setColor (Color.black);
	c.drawString ("Player 2 please enter a username: ", 50, 670);
	while (true)
	{
	    c.setCursor (25, 46);
	    player2Name = c.readString (); //get username
	    if (player2Name.length () <= 10)
		break;
	    else
	    {
		c.setColor (new Color (204, 255, 255));
		c.fillRect (540, 645, 400, 30); //erase old input
		new Message ("Names must be less than or equal too 10 characters in length", "Error"); //message
	    }

	}
	try
	{
	    BufferedReader br = new BufferedReader (new FileReader ("Highscores.txt"));
	    while (br.readLine () != null)
	    {
		lineCount++;
	    }
	    br.close (); //close file
	    String[] previousScores = new String [lineCount];
	    BufferedReader br2 = new BufferedReader (new FileReader ("Highscores.txt"));
	    for (int x = 0 ; x < lineCount ; x++)
	    {
		previousScores [x] = br2.readLine (); //store each score
	    }
	    br2.close (); //close file
	    PrintWriter pr = new PrintWriter (new FileWriter ("Highscores.txt"));
	    for (int x = 0 ; x < lineCount ; x++)
	    {
		if (previousScores [x] != null)
		    pr.println (previousScores [x]); //print each score
	    }
	    //print the new scores
	    pr.println (player1Name + " " + calcScore (1) + " " + gameMode);
	    pr.println (player2Name + " " + calcScore (2) + " " + gameMode);
	    pr.close (); //close the file
	}
	catch (IOException e)
	{
	}
    }


    /*
    The purpose of this method is to give a final message to the users before closing the program
    */
    public void goodbye ()
    {
	drawTitle ();
	c.drawString ("Thanks for using this program! This Monopoly program was made by Michael", 30, 120);
	c.drawString ("Zhou on December 17, 2018 at Willaim Lyon Mackenzie.", 165, 155);
	pauseProgram ();
	c.close (); //close the program
    }


    /*
    The purpose of this method is to control the flow of the program based on the user's input in the main menu and call other methods
    A new object of Monopoly is also created
    The while loop is used to allow the user to continue using the program as long as he/she does not enter 5 (exit option)
    The first if statement is used to check if the user entered 1, if so, they will be able to play the game
    The next if statement is used to check if the user entered 2, if so, they will be able to select the game mode
    The next if statement is used to check if the user entered 3, if so, they will be able to view the instructions
    The next if statement is used to check if the user entered 4, if so, they will be able to view the highscores
    */
    public static void main (String[] args)
    {

	Monopoly m = new Monopoly ();
	m.splashScreen ();
	while (!(m.menuChoice == '5'))
	{
	    m.mainMenu ();
	    if (m.menuChoice == '1')
	    {
		m.playGame ();
		m.displayResult ();
	    }
	    else if (m.menuChoice == '2')
		m.gameMode ();
	    else if (m.menuChoice == '3')
		m.instructions ();
	    else if (m.menuChoice == '4')
		m.highScores ();
	}
	m.goodbye ();
    } // main method
} // Monopoly class


