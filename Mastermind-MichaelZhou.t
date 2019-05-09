%Michael Zhou
%Mr. Rosen
%May 21, 2018
%This program will allow the user to play a game of mastermind against the computer. I made this for my grade 9 ISP.

%Setup GUI
import GUI

%Declaration Section
var numColours : int := 4 %number of colours to chose from
var ballColour : int := 87 %chosen colour for inputing (87 is defult beacuse it matched the background colour)
var row : int := 1 %row the user is on
var totalMatchingColoursPositions, totalMatchingColours : int := 0 % Matching colours in correct positions count, Matching colours in wrong positions count
%Buttons
var exitButton, easyButton, mediumButton, hardButton, instructionsButton, playButton, mainMenuButton : int
%Windows
var mainWin : int := Window.Open ("position:300;300, graphics:640;400")
var winWin : int
var gameWin : int
%Mousewere
var rangeX, rangeY, button : int
%Arrays
var selectedColours : array 1 .. 4 of int %inputed colour sequence
var expectColours : array 1 .. 4 of int %randomed colour sequence
%Fonts
var font2 := Font.New ("Times:15")
var font1 := Font.New ("Times:25")
%Boolean
var exitloop, medium, hard, returnToMenu : boolean := false

%Forwarding procedures
forward procedure mainMenu
forward procedure patternEnter

procedure title %Clear screen, display a backgorund, and display the title
    cls %Clear the screem
    for x : 0 .. 640
	drawline (0 + x, 0, 0 + x, 700, 80) %Colour the background (bigger than the defult screen size because of the gameWin)
    end for
    Font.Draw ("Mastermind", 241, 370, font1, 7) %title
end title

process backgroundMusic %Plays music in the background
    loop
	Music.Play ("2d2e2ff2f2f2d2e2f2f2f2d2e2f2f2g2f2e22c2d2e2e2e2c2d2e2e2e2c") %route 1 music
	exit when GUI.ProcessEvent
    end loop
end backgroundMusic

procedure instructions %Insctructions to teach the user how to play the game
    var font3 := Font.New ("Times:12")
    GUI.Hide (instructionsButton) %Hide the buttons from the main menu
    GUI.Hide (playButton) %Hide the buttons from the main menu
    GUI.Hide (exitButton) %Hide the buttons from the main menu
    title
    Font.Draw ("Insturctions", 271, 350, font2, 7)
    Font.Draw ("Mastermind is a game based on codebreaking. The codemaker (computer), will randomly chose a pattern ", 1, 330, font3, 7)
    Font.Draw ("of balls with each ball being a different colour. You; the the code breaker must try to guess the ", 1, 315, font3, 7)
    Font.Draw ("computer's pattern in the correct order by entering a sequence of coloured balls of your own into the rows", 1, 300, font3, 7)
    Font.Draw ("on the gameboard.", 1, 285, font3, 7)
    Font.Draw ("Step 1: Select a colour by clicking a coloured ball on the right of your sceen.", 1, 255, font3, 7)
    Font.Draw ("Step 2: Then click on a circle in your row on the gameboard to enter the colour. (The row you are on is ", 1, 225, font3, 7)
    Font.Draw ("indicated by a red arrow to the right of your row.)", 1, 210, font3, 7)
    Font.Draw ("Step 3: Once you have entered a colour in to each of the four circles in your row, press the check button.", 1, 180, font3, 7)
    Font.Draw ("This will be your guess of the computers pattern.", 1, 165, font3, 7)
    Font.Draw ("Note: The computer generated pattern will not have duplicate colours.", 1, 150, font3, 7)
    Font.Draw ("Step 4: The computer will display 0-4 black or white balls beside your guess as feedback. Each black ball", 1, 120, font3, 7)
    Font.Draw ("means that your guess has a ball with the correct colour in the correct position compared to the", 1, 105, font3, 7)
    Font.Draw ("computer. Each white ball means you have a ball of the correct colour but in the wrong positon compared", 1, 90, font3, 7)
    Font.Draw ("to the computer. If you have entered duplicates in your guess, the computer will only display feedback for ", 1, 75, font3, 7)
    Font.Draw ("one of the balls. You will have up to 10 guesses so modify each of your guess based on the omputer's", 1, 60, font3, 7)
    Font.Draw ("feedback. Good Luck!", 1, 45, font3, 7)
    GUI.Show (mainMenuButton)  %Show a button that allows the user to return to the main menu
end instructions

procedure outcome %Tells the user if they won or lost
    Window.Close (gameWin) %Close the game window
    mainWin := Window.Open ("position:300;300, graphics:640;400") %Open the main window
    title
    if totalMatchingColoursPositions = 4 then %if all inputed balls match then...
	Font.Draw ("Congratulations! You win!", 141, 300, font1, 14) %Draw a message to tell the user they won
	%Draw a smily face :)
	for x : 0 .. 100
	    drawoval (320, 175, x, 100, 14) %Face
	end for
	for x : 0 .. 15
	    drawoval (285, 200, x, 15, 7) %Left eye
	    drawoval (355, 200, x, 15, 7) %Right eye
	end for
	for x : 0 .. 50
	    drawarc (320, 150, 60, x, 180, 0, 4) %Mouth
	end for
	%Music.PlayFile ("applause2.mp3") %play applause
    else
	Font.Draw ("You ran out of guesses... better luck next time!", 134, 330, font2, 7) %Draw a message to tell the user they lost (ran out of tries)
	Font.Draw ("The correct sequence was:", 220, 300, font2, 7) %Tell the user to look at the correct pattern
	for x : 0 .. 50  % Show the correct pattern for the user
	    drawoval (95, 200, 50, x, expectColours (1)) %First circle in the correct pattern
	    drawoval (245, 200, 50, x, expectColours (2)) %Second circle in the correct pattern
	    drawoval (395, 200, 50, x, expectColours (3)) %Third circle in the correct pattern
	    drawoval (545, 200, 50, x, expectColours (4)) %Forth circle in the correct pattern
	    drawoval (95, 200, x, 50, expectColours (1))
	    drawoval (245, 200, x, 50, expectColours (2))
	    drawoval (395, 200, x, 50, expectColours (3))
	    drawoval (545, 200, x, 50, expectColours (4))
	end for
	%Music.PlayFile ("Price-is-right-losing-horn.mp3") %Play sad music
    end if
    mainMenuButton := GUI.CreateButton (277, 25, 0, "Main Menu", mainMenu) %Show the main menu button
end outcome

procedure feedbackDisplay %Shows the computers's feedback based on the user's pattern and checks if the user has won
    Font.Draw ("You are on row: ", 230, 60, font2, 7) %Tell the user what row they are on
    locate (40, 48)
    put row .. %Display the row number
    for x : 0 .. 9
	if totalMatchingColoursPositions = 0 then %If there are no correct colours in the correct position
	    if totalMatchingColours = 4 then %4 correct colours in wrong positions
		drawoval (360, 150 + (row - 1) * 40, x, 9, 0) %Draw 4 white balls
		drawoval (380, 150 + (row - 1) * 40, x, 9, 0)
		drawoval (360, 130 + (row - 1) * 40, x, 9, 0)
		drawoval (380, 130 + (row - 1) * 40, x, 9, 0)
		drawoval (360, 150 + (row - 1) * 40, 9, x, 0)
		drawoval (380, 150 + (row - 1) * 40, 9, x, 0)
		drawoval (360, 130 + (row - 1) * 40, 9, x, 0)
		drawoval (380, 130 + (row - 1) * 40, 9, x, 0)
	    elsif totalMatchingColours = 3 then %3 correct colours in wrong positions
		drawoval (360, 150 + (row - 1) * 40, x, 9, 0) %Draw 3 white balls
		drawoval (380, 150 + (row - 1) * 40, x, 9, 0)
		drawoval (360, 130 + (row - 1) * 40, x, 9, 0)
		drawoval (360, 150 + (row - 1) * 40, 9, x, 0)
		drawoval (380, 150 + (row - 1) * 40, 9, x, 0)
		drawoval (360, 130 + (row - 1) * 40, 9, x, 0)
	    elsif totalMatchingColours = 2 then %2 correct colours in wrong positions
		drawoval (380, 150 + (row - 1) * 40, x, 9, 0) %Draw 2 white balls
		drawoval (360, 150 + (row - 1) * 40, x, 9, 0)
		drawoval (380, 150 + (row - 1) * 40, 9, x, 0)
		drawoval (360, 150 + (row - 1) * 40, 9, x, 0)
	    elsif totalMatchingColours = 1 then %1 correct colours in wrong positions
		drawoval (360, 150 + (row - 1) * 40, x, 9, 0) %Draw 1 white ball
		drawoval (360, 150 + (row - 1) * 40, 9, x, 0)
	    end if
	elsif totalMatchingColoursPositions = 1 then %1 correct colour in the correct position
	    drawoval (360, 150 + (row - 1) * 40, x, 9, black) %Draw 1 black ball
	    drawoval (360, 150 + (row - 1) * 40, 9, x, black)
	    if totalMatchingColours = 1 then %1 correct colour in wrong position
		drawoval (380, 150 + (row - 1) * 40, x, 9, 0) %Draw 1 white ball
		drawoval (380, 150 + (row - 1) * 40, 9, x, 0)
	    elsif totalMatchingColours = 2 then %2 correct colours in wrong positions
		drawoval (380, 150 + (row - 1) * 40, x, 9, 0) %Draw 2 white balls
		drawoval (360, 130 + (row - 1) * 40, x, 9, 0)
		drawoval (380, 150 + (row - 1) * 40, 9, x, 0)
		drawoval (360, 130 + (row - 1) * 40, 9, x, 0)
	    elsif totalMatchingColours = 3 then %3 correct colours in wrong positions
		drawoval (380, 150 + (row - 1) * 40, x, 9, 0) %Draw 3 white balls
		drawoval (360, 130 + (row - 1) * 40, x, 9, 0)
		drawoval (380, 130 + (row - 1) * 40, x, 9, 0)
		drawoval (380, 150 + (row - 1) * 40, 9, x, 0)
		drawoval (360, 130 + (row - 1) * 40, 9, x, 0)
		drawoval (380, 130 + (row - 1) * 40, 9, x, 0)
	    end if
	elsif totalMatchingColoursPositions = 2 then %2 correct colours in the correct position
	    drawoval (360, 150 + (row - 1) * 40, x, 9, black) %Draw 2 black balls
	    drawoval (380, 150 + (row - 1) * 40, x, 9, black)
	    drawoval (360, 150 + (row - 1) * 40, 9, x, black)
	    drawoval (380, 150 + (row - 1) * 40, 9, x, black)
	    if totalMatchingColours = 1 then %1 correct colour in wrong position
		drawoval (360, 130 + (row - 1) * 40, x, 9, 0) %Draw 1 white ball
		drawoval (360, 130 + (row - 1) * 40, 9, x, 0)
	    elsif totalMatchingColours = 2 then %2 correct colours in wrong positions
		drawoval (360, 130 + (row - 1) * 40, x, 9, 0) %Draw 2 white balls
		drawoval (380, 130 + (row - 1) * 40, x, 9, 0)
		drawoval (360, 130 + (row - 1) * 40, 9, x, 0)
		drawoval (380, 130 + (row - 1) * 40, 9, x, 0)
	    end if
	elsif totalMatchingColoursPositions = 3 then %3 correct colours in the correct position
	    drawoval (360, 150 + (row - 1) * 40, x, 9, black) %Draw 3 black balls
	    drawoval (380, 150 + (row - 1) * 40, x, 9, black)
	    drawoval (360, 130 + (row - 1) * 40, x, 9, black)
	    drawoval (360, 150 + (row - 1) * 40, 9, x, black)
	    drawoval (380, 150 + (row - 1) * 40, 9, x, black)
	    drawoval (360, 130 + (row - 1) * 40, 9, x, black)
	    if totalMatchingColours = 1 then %1 correct colour in wrong position
		drawoval (380, 130 + (row - 1) * 40, x, 9, 0) %Draw 1 white ball
		drawoval (380, 130 + (row - 1) * 40, 9, x, 0)
	    end if
	end if
    end for
    for x : 1 .. 4
	selectedColours (x) := 87 %Reset the users selected colours
    end for
    if totalMatchingColoursPositions not= 4 and row not= 11 then %Check if user has not figured out the pattern or ran out of rows
	exitloop := false %don't exit mousewhere loop
    end if
    if totalMatchingColoursPositions = 4 then % if user has guess the correct pattern then...
	outcome
    elsif row = 11 then %if the user ran out of tries then...
	outcome
    end if
end feedbackDisplay

procedure compareResult %Compare the user's pattern to the computer's pattern
    var matchingColourValue : array 1 .. 4 of int
    var matchedColourFlag : array 1 .. 4 of int
    row := row + 1 %increase the rows by 1
    totalMatchingColoursPositions := 0 %reset the amout of matching balls
    totalMatchingColours := 0 %reset the amount of matching colours
    for x : 1 .. 4
	matchingColourValue (x) := 0 %reset
	matchedColourFlag (x) := 0 %reset
    end for
    %check for correct colours in the correct position
    for x : 1 .. 4
	if selectedColours (x) = expectColours (x) then %check if the entered colours match the randomed colours in the correct positions
	    totalMatchingColoursPositions := totalMatchingColoursPositions + 1 %increase the count of colours in the correct positions by 1
	    matchingColourValue (x) := selectedColours (x) %set the colour value for the matched colour
	end if
    end for
    %flag the already matched colours
    for x : 1 .. 4
	for y : 1 .. 4
	    if selectedColours (x) = matchingColourValue (y) then %if the selected colour matches in colour value
		matchedColourFlag (x) := 1 %flag that ball
	    end if
	end for
    end for
    %check if the first ball matches the colour but not the position
    if matchedColourFlag (1) = 0 then %only check if colour is not flaged
	for y : 1 .. 4
	    if y not= 1 and selectedColours (1) = expectColours (y) then %check if the selected colour matches but its not in the right position
		totalMatchingColours := totalMatchingColours + 1 %increase the matching colours in wrong position count
	    end if
	end for
    end if
    %check if the second ball matches the colour
    if matchedColourFlag (2) = 0 and selectedColours (2) not= selectedColours (1) then %only check if colour is not flaged and is not duplicated
	for y : 1 .. 4
	    if y not= 2 and selectedColours (2) = expectColours (y) then %check if the selected colour matches but its not in the right position
		totalMatchingColours := totalMatchingColours + 1  %increase the matching colours in wrong position count
	    end if
	end for
    end if
    %check if the third ball matches the colour
    if matchedColourFlag (3) = 0 and selectedColours (3) not= selectedColours (1) and selectedColours (3) not= selectedColours (2) then %only check if colour is not flaged and is not duplicated
	for y : 1 .. 4
	    if y not= 3 and selectedColours (3) = expectColours (y) then %check if the selected colour matches but its not in the right position
		totalMatchingColours := totalMatchingColours + 1  %increase the matching colours in wrong position count
	    end if
	end for
    end if
    %check if the fourth ball matches the colour
    if matchedColourFlag (4) = 0 and selectedColours (4) not= selectedColours (1)
	    and selectedColours (4) not= selectedColours (2) and selectedColours (4) not= selectedColours (3) then %only check if colour is not flaged and is not duplicated
	for y : 1 .. 4
	    if y not= 4 and selectedColours (4) = expectColours (y) then %check if the selected colour matches but its not in the right position
		totalMatchingColours := totalMatchingColours + 1  %increase the matching colours in wrong position count
	    end if
	end for
    end if
    feedbackDisplay
end compareResult

procedure drawGameBoard %Draws the game board as well as most of the user interface
    Window.Close (mainWin) %Close the mainMenu window
    gameWin := Window.Open ("position:300;300, graphics:600;700")  %Open a new window (for the game)
    title
    Font.Draw ("Mastermind", 235, 675, font1, 7)     %Draw the title
    for x : 1 .. 4
	selectedColours (x) := 87 %Set the users selected sequence to nothing (87 beacuse its the colour of the background
    end for
    ballColour := 87 %Set the selected colour to the defult (87) (background colour)
    for x : 0 .. 95
	drawline (80 + x, 50, 80 + x, 80, 25)     %Menu Button (mousewhere)
    end for
    Font.Draw ("Main Menu", 82, 60, font2, 7)
    Font.Draw ("Colours:", 485, 620, font2, 7)
    for x : 0 .. 320
	drawline (80 + x, 160, 80 + x, 600, 64)     %Base of board
	drawline (80 + x, 600, 80 + x, 640, 136)     %Top edge of board
	drawline (80 + x, 120, 80 + x, 160, 136)     %Bottom edge of board
    end for
    for x : 0 .. 40
	drawline (400 + x, 160, 400 + x, 600, 136)     %Right edge of board
	drawline (40 + x, 160, 40 + x, 600, 136)     %Left edge of board
    end for
    for x : 0 .. 40
	drawarc (80, 600, x, 40, 90, 180, 231)     %Top left corner
	drawarc (400, 600, x, 40, 0, 90, 231)     %Top right corner
	drawarc (80, 160, x, 40, 180, 270, 231)     %Bottom left corner
	drawarc (400, 160, x, 40, 270, 0, 231)     %Bottom right orner
	drawarc (80, 600, 40, x, 90, 180, 231)
	drawarc (400, 600, 40, x, 0, 90, 231)
	drawarc (80, 160, 40, x, 180, 270, 231)
	drawarc (400, 160, 40, x, 270, 0, 231)
    end for
    for y : 0 .. 10
	for x : 0 .. 18
	    drawoval (120, 580 - y * 40, x, 18, 87)     %First column of balls
	    drawoval (180, 580 - y * 40, x, 18, 87)     %Second column of balls
	    drawoval (240, 580 - y * 40, x, 18, 87)     %Thrid column of balls
	    drawoval (300, 580 - y * 40, x, 18, 87)     %Forth column of balls
	end for
    end for
    for x : 0 .. 9
	for y : 0 .. 19
	    drawoval (360, 550 - y * 20, x, 9, 87)     %First column of smaller balls
	    drawoval (380, 550 - y * 20, x, 9, 87)     %Second column of smaller balls
	end for
    end for
    for x : 0 .. 11
	drawline (80, 600 - x * 40, 400, 600 - x * 40, 7)     %Lines that seperate the rows
    end for
    for x : 0 .. 3
	Font.Draw ("?", 115 + x * 60, 575, font2, 7) %Draws question marks for the top row of balls
    end for
    for x : 0 .. 20 %Draw 4 coloured balls for easy mode
	drawoval (520, 580, x, 20, 9)
	drawoval (520, 520, x, 20, 10)
	drawoval (520, 460, x, 20, 11)
	drawoval (520, 400, x, 20, 12)
	if medium = true then %Draw 2 more coloured balls for medium mode
	    drawoval (520, 340, x, 20, 13)
	    drawoval (520, 280, x, 20, 14)
	elsif hard = true then  %Draw 4 more coloured balls for hard mode
	    drawoval (520, 340, x, 20, 13)
	    drawoval (520, 280, x, 20, 14)
	    drawoval (520, 220, x, 20, 15)
	    drawoval (520, 160, x, 20, 16)
	end if
    end for
    patternEnter
end drawGameBoard

body procedure patternEnter
    Window.Show (gameWin)
    Font.Draw ("You are on row: ", 230, 60, font2, 7) %Tell the user they are on row 1
    locate (40, 48)
    put "1" .. %row 1
    loop %mousewhere loop
	if ballColour = 87 then
	    Font.Draw ("Hint: Select a colour from the coloured balls to your right.", 80, 25, font2, 7) %Hint for the user if they don't know how to select colours
	elsif selectedColours (1) not= 87 and selectedColours (2) not= 87 and selectedColours (3) not= 87 and selectedColours (4) not= 87 then
	    Font.Draw ("Hint: Press Check.", 250, 25, font2, 7) %Hint for user if they don't know what to do after they entered thier colours
	else
	    for x : 0 .. 20
		drawline (50, 20 + x, 550, 20 + x, 80) %Erase the hints
	    end for
	end if
	for x : 0 .. 40
	    drawline (450, 140 + (row - 1) * 40, 480, 120 + (row - 1) * 40 + x, 80) %Erase arrow
	    drawline (450, 140 + row * 40, 480, 120 + row * 40 + x, 4) %Draw arrow to point at the row you are on
	end for
	mousewhere (rangeX, rangeY, button)
	if selectedColours (1) not= 87 and selectedColours (2) not= 87 and selectedColours (3) not= 87 and selectedColours (4) not= 87 then %If the user has entered all four colours then...
	    for x : 0 .. 60
		drawline (450 + x, 50, 450 + x, 80, 25) %Check Button
	    end for
	    Font.Draw ("Check", 457, 60, font2, 7) %Text on the check button
	    if button = 1 and rangeX >= 450 and rangeX <= 510 and rangeY >= 50 and rangeY <= 80 then   %If they click on the check button
		exitloop := true %exit mousewhere (more to this in compareResult)
		compareResult %compare the patterns
	    end if
	else
	    for x : 0 .. 60
		drawline (450 + x, 50, 450 + x, 80, 80)     %Erase Check Button
	    end for
	end if
	if button = 1 then     %If they click
	    if rangeX >= 80 and rangeX <= 175 and rangeY >= 50 and rangeY <= 80 then %Check if the user clicked the main menu button
		returnToMenu := true
		mainMenu
		Window.Hide (gameWin)
	    end if
	    if (520 - rangeX) ** 2 + (580 - rangeY) ** 2 <= 400 then %Check if the user clicks on the blue ball
		ballColour := 9 %Set the selected colour to blue
	    elsif (520 - rangeX) ** 2 + (520 - rangeY) ** 2 <= 400 then %Check if the user clicks on the green ball
		ballColour := 10 %Set the selected colour to green
	    elsif (520 - rangeX) ** 2 + (460 - rangeY) ** 2 <= 400 then %Check if the user clicks on the light-blue ball
		ballColour := 11 %Set the selected colour to light-blue
	    elsif (520 - rangeX) ** 2 + (400 - rangeY) ** 2 <= 400 then %Check if the user clicks on the red ball
		ballColour := 12 %Set the selected colour to red
	    end if
	    if medium = true then %If the mode is medium
		if (520 - rangeX) ** 2 + (340 - rangeY) ** 2 <= 400 then %Check if the user clicks on the purple ball
		    ballColour := 13 %Set the selected colour to purple
		elsif (520 - rangeX) ** 2 + (280 - rangeY) ** 2 <= 400 then %Check if the user clicks on the yellow ball
		    ballColour := 14 %Set the selected colour to yellow
		end if
	    elsif hard = true then %If the mode is hard
		if (520 - rangeX) ** 2 + (340 - rangeY) ** 2 <= 400 then %Check if the user clicks on the purple ball
		    ballColour := 13 %Set the selected colour to purple
		elsif (520 - rangeX) ** 2 + (280 - rangeY) ** 2 <= 400 then %Check if the user clicks on the yellow ball
		    ballColour := 14 %Set the selected colour to yellow
		elsif (520 - rangeX) ** 2 + (220 - rangeY) ** 2 <= 400 then %Check if the user clicks on the grey ball
		    ballColour := 15 %Set the selected colour to grey
		elsif (520 - rangeX) ** 2 + (160 - rangeY) ** 2 <= 400 then %Check if the user clicks on the black ball
		    ballColour := 16 %Set the selected colour to black
		end if
	    end if
	    for y : 1 .. 10 %rows 1- 10
		if row = y then %Find the row the user is on
		    if (120 - rangeX) ** 2 + (140 + y * 40 - rangeY) ** 2 <= 324 then %Check if the user clicks on the first slot in the row the user is on
			for x : 0 .. 18
			    drawoval (120, 140 + y * 40, x, 18, ballColour) %Draw a ball with the colour the user selected in that slot
			end for
			selectedColours (1) := ballColour %Store the colour as the first colour in the users selected pattern
		    elsif (180 - rangeX) ** 2 + (140 + y * 40 - rangeY) ** 2 <= 324 then %Check if the user clicks on the second slot in the row the user is on
			for x : 0 .. 18
			    drawoval (180, 140 + y * 40, x, 18, ballColour) %Draw a ball with the colour the user selected in that slot
			end for
			selectedColours (2) := ballColour %Store the colour as the second colour in the users selected pattern
		    elsif (240 - rangeX) ** 2 + (140 + y * 40 - rangeY) ** 2 <= 324 then %Check if the user clicks on the third slot in the row the user is on
			for x : 0 .. 18
			    drawoval (240, 140 + y * 40, x, 18, ballColour) %Draw a ball with the colour the user selected in that slot
			end for
			selectedColours (3) := ballColour %Store the colour as the third colour in the users selected pattern
		    elsif (300 - rangeX) ** 2 + (140 + y * 40 - rangeY) ** 2 <= 324 then %Check if the user clicks on the fourth slot in the row the user is on
			for x : 0 .. 18
			    drawoval (300, 140 + y * 40, x, 18, ballColour) %Draw a ball with the colour the user selected in that slot
			end for
			selectedColours (4) := ballColour %Store the colour as the fourth colour in the users selected pattern
		    end if
		end if
	    end for
	end if
	exit when (button = 1 and rangeX >= 80 and rangeX <= 175 and rangeY >= 50 and rangeY <= 80) or exitloop = true %exit when they click the main menu button or when exitloop is true
    end loop
end patternEnter

procedure gnColourSequence %Generate a random colour sequence to be guessed
    var colorSize : int := 12
    GUI.Hide (easyButton)     %Hide the buttons from the difficulty selection
    GUI.Hide (mediumButton)     %Hide the buttons from the difficulty selection
    GUI.Hide (hardButton)     %Hide the buttons from the difficulty selection
    if medium = true then     %Determine the range of colours to be randomed based on difficulty
	colorSize := 14
    elsif hard = true then     %Determine the range of colours to be randomed based on difficulty
	colorSize := 16
    else     %Determine the range of colours to be randomed based on difficulty
	colorSize := 12
    end if
    var isDuplicate : boolean := false
    randint (expectColours (1), 9, colorSize)     % Random a integer (colour value) for the first ball in the computer's sequence
    for x : 2 .. 4
	loop %make sure there are no duplicates
	    isDuplicate := false     %reset the duplicate value
	    randint (expectColours (x), 9, colorSize) %random a colour value
	    for y : 1 .. x - 1
		if expectColours (y) = expectColours (x) then     %Make sure there are no duplicates
		    isDuplicate := true     %if the pervious balls have the same colour of the ball being randomed, then re-random
		end if
	    end for
	    exit when isDuplicate = false %exit when there are no duplicates
	end loop
    end for
    drawGameBoard
end gnColourSequence

procedure mediumIsTrue %Procedure for the medium button to go to
    medium := true %Difficulty is set to medium
    gnColourSequence
end mediumIsTrue

procedure hardIsTrue %Procedure for the hard button to go to
    hard := true %Difficulty is set to hard
    gnColourSequence
end hardIsTrue

procedure setDifficulty %Allows the user to choose the difficulty to play at (number of colours)
    GUI.Hide (playButton) %Hide button from main menu
    GUI.Hide (exitButton) %Hide button from main menu
    GUI.Hide (instructionsButton) %Hide button from main menu
    title
    medium := false %reset the difficulty
    hard := false %reset the difficulty
    easyButton := GUI.CreateButton (263, 250, 0, "Esay (4 colours)", gnColourSequence)
    mediumButton := GUI.CreateButton (254, 200, 0, "Medium (6 colours)", mediumIsTrue)
    hardButton := GUI.CreateButton (263, 150, 0, "Hard (8 colours)", hardIsTrue)
    GUI.Show (easyButton)
    GUI.Show (mediumButton)
    GUI.Show (hardButton)
    GUI.Show (mainMenuButton)
end setDifficulty

body procedure mainMenu
    Window.Show (mainWin)
    if returnToMenu = true then %If the user returned to the main menu from the gameWin
	mainWin := Window.Open ("position:300;300, graphics:640;400") %Reopen mainWin
	mainMenuButton := GUI.CreateButton (277, 25, 0, "Main Menu", mainMenu) %Recreate main menu button
	returnToMenu := false %reset
    end if
    GUI.Hide (mainMenuButton) %Hide the main menu button
    title
    exitloop := false
    row := 1 %Reset the row the user is on
    medium := false %rest the difficulty
    hard := false %reset the difficulty
    playButton := GUI.CreateButton (280, 225, 0, "Play  Game", setDifficulty) %Make a button that allows the user to go to the difficulty screen
    instructionsButton := GUI.CreateButton (277, 175, 0, "Instructions", instructions) %Make a button that allows the user to go to the instructions screen
    exitButton := GUI.CreateButtonFull (292, 125, 0, "Exit", GUI.Quit, 0, KEY_ESC, false) %Make a button that allows the user to exit the game
end mainMenu


procedure introduction %Program intro animation
    title
    Font.Draw ("The classic game of codebreaking!", 188, 340, font2, 7) %write a sentence to discribe the game
    for x : 0 .. 600
	%Blue M ball animation
	drawfilloval (-534 + x, 266, 35, 35, 80) %erase
	drawfilloval (-534 + x, 266, 34, 34, 9) %blue ball
	Draw.ThickLine (-551 + x, 249, -551 + x, 283, 4, 7) %writes the letter M
	Draw.ThickLine (-551 + x, 283, -534 + x, 249, 4, 7)
	Draw.ThickLine (-534 + x, 249, -517 + x, 283, 4, 7)
	Draw.ThickLine (-517 + x, 283, -517 + x, 249, 4, 7)
	%Green A ball animation
	drawfilloval (-434 + x, 266, 35, 35, 80) %erase
	drawfilloval (-434 + x, 266, 34, 34, 10) %green ball
	Draw.ThickLine (-451 + x, 249, -434 + x, 283, 4, 7) %writes the letter A
	Draw.ThickLine (-434 + x, 283, -417 + x, 249, 4, 7)
	Draw.ThickLine (-442 + x, 266, -426 + x, 266, 4, 7)
	%Light blue S ball animation
	drawfilloval (-334 + x, 266, 35, 35, 80) %erase
	drawfilloval (-334 + x, 266, 34, 34, 11) %light blue ball
	Draw.ThickLine (-317 + x, 283, -351 + x, 266, 4, 7) %writes the letter S
	Draw.ThickLine (-351 + x, 266, -317 + x, 266, 4, 7)
	Draw.ThickLine (-317 + x, 266, -351 + x, 249, 4, 7)
	%Red T ball animation
	drawfilloval (-234 + x, 266, 35, 35, 80) %erase
	drawfilloval (-234 + x, 266, 34, 34, 12) %red ball
	Draw.ThickLine (-251 + x, 283, -217 + x, 283, 4, 7) %writes the letter T
	Draw.ThickLine (-234 + x, 283, -234 + x, 249, 4, 7)
	%Purple E ball animation
	drawfilloval (-134 + x, 266, 35, 35, 80) %erase
	drawfilloval (-134 + x, 266, 34, 34, 13) %purple ball
	Draw.ThickLine (-151 + x, 283, -117 + x, 283, 4, 7) %writes the letter E
	Draw.ThickLine (-151 + x, 266, -117 + x, 266, 4, 7)
	Draw.ThickLine (-151 + x, 249, -117 + x, 249, 4, 7)
	Draw.ThickLine (-151 + x, 283, -151 + x, 249, 4, 7)
	%Yellow R ball animation
	drawfilloval (-34 + x, 266, 35, 35, 80) %erase
	drawfilloval (-34 + x, 266, 34, 34, 14) %yellow ball
	Draw.ThickLine (-51 + x, 283, -51 + x, 249, 4, 7) %writes the letter R
	Draw.ThickLine (-51 + x, 283, -17 + x, 283, 4, 7)
	Draw.ThickLine (-51 + x, 266, -17 + x, 266, 4, 7)
	Draw.ThickLine (-17 + x, 266, -17 + x, 283, 4, 7)
	Draw.ThickLine (-51 + x, 266, -17 + x, 249, 4, 7)
	delay (5) %moving
    end for
    for x : 0 .. 508
	%Grey M ball animation
	drawfilloval (674 - x, 166, 35, 35, 80) %erase
	drawfilloval (674 - x, 166, 34, 34, 15) %grey ball
	Draw.ThickLine (657 - x, 149, 657 - x, 183, 4, 7) %writes the letter M
	Draw.ThickLine (657 - x, 183, 674 - x, 149, 4, 7)
	Draw.ThickLine (674 - x, 149, 691 - x, 183, 4, 7)
	Draw.ThickLine (691 - x, 183, 691 - x, 149, 4, 7)
	%Blue I ball animation
	drawfilloval (774 - x, 166, 35, 35, 80) %erase
	drawfilloval (774 - x, 166, 34, 34, 9) %blue ball
	Draw.ThickLine (774 - x, 183, 774 - x, 149, 4, 7) %writes the letter I
	%Green N ball animation
	drawfilloval (874 - x, 166, 35, 35, 80) %erase
	drawfilloval (874 - x, 166, 34, 34, 10) %grren ball
	Draw.ThickLine (857 - x, 183, 857 - x, 149, 4, 7) %writes the letter N
	Draw.ThickLine (857 - x, 183, 891 - x, 149, 4, 7)
	Draw.ThickLine (891 - x, 149, 891 - x, 183, 4, 7)
	%Light blue D ball animation
	drawfilloval (974 - x, 166, 35, 35, 80) %erase
	drawfilloval (974 - x, 166, 34, 34, 11) %light blue ball
	Draw.ThickLine (957 - x, 183, 957 - x, 149, 4, 7) %writes the letter D
	Draw.ThickLine (957 - x, 183, 991 - x, 166, 4, 7)
	Draw.ThickLine (957 - x, 149, 991 - x, 166, 4, 7)
	delay (5) %moving
    end for
    mainMenuButton := GUI.CreateButton (277, 25, 0, "Main Menu", mainMenu) %Create a button to take the user to the mainMenu
end introduction

procedure goodbye %Display a finial message to the user and play music before closing the program
    GUI.Hide (exitButton)
    title
    Font.Draw ("Thanks for playing!", 250, 300, font2, 7)
    Font.Draw ("This game is written by: Michael Zhou", 165, 250, font2, 7)
    for x : 1 .. 4
	play (">f<f>f<f") %Play goodbye music
    end for
    Window.Close (mainWin) %Close window after the music
end goodbye

fork backgroundMusic %Play music in the background

%Main Program
introduction
loop
    exit when GUI.ProcessEvent
end loop
goodbye
%End of Main Program




