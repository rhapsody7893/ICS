/**
 * This class represents a snakes and ladders game
 * @author Feng, Michael
 */
public class SnakesAndLadders extends BoardGames {
  // instance vars
  private int[][] snakes;
  private int[][] ladders;
  private int numSnakes;
  private int numLadders;
  
  /**
   * Constructor - sets values for number of players, number of snakes, and number
   * of ladders and remaining default values 
   * @param players - number of players
   * @param numOfSnakes - number of snakes
   * @param numOfLadders - number of ladders
   */
  public SnakesAndLadders(int players, int numOfSnakes, int numOfLadders, int length, int width) {
  	//public BoardGames(String name, int length, int width, int numPieces, String company, int age)
    super("Snakes and Ladders", length, width, players, "Wind Bear", 8);// Creates a ten by ten board
    numSnakes = numOfSnakes;
    numLadders = numOfLadders;
    snakes = new int[numSnakes][4];// 0 is start x coord, 1 is start y coord, 2 is end x coord, 3 is end y coord
    for (int i = 0; i < numSnakes; i++) {
      for (int j = 0; j < 4; j++)
        snakes[i][j] = 0;
    }
    ladders = new int[numLadders][4];// 0 is start x coord, 1 is start y coord, 2 is end x coord, 3 is end y coord
    for (int i = 0; i < numLadders; i++) {
      for (int j = 0; j < 4; j++)
        ladders[i][j] = 0;
    }
  }
  
  /**
   * Constructor - sets values for default values
   */
  public SnakesAndLadders() {
    super("Snakes and Ladders", 10, 10, 2, "Wind Bear", 8);// Creates a ten by ten board
    numSnakes = 0;
    numLadders = 0;
    snakes = new int[numSnakes][4];// 0 is start x coord, 1 is start y coord, 2 is end x coord, 3 is end y coord
    for (int i = 0; i < numSnakes; i++) {
      for (int j = 0; j < 4; j++)
        snakes[i][j] = 0;
    }
    ladders = new int[numLadders][4];// 0 is start x coord, 1 is start y coord, 2 is end x coord, 3 is end y coord
    for (int i = 0; i < numLadders; i++) {
      for (int j = 0; j < 4; j++)
        ladders[i][j] = 0;
    }
  }
  
  /**
   * Sets the number of snakes
   * @param nSnakes - the number of snakes
   */
  public void setNumSnakes(int nSnakes) {
    numSnakes = nSnakes;
    snakes = new int[numSnakes][4];// 0 is start x coord, 1 is start y coord, 2 is end x coord, 3 is end y coord
    for (int i = 0; i < numSnakes; i++) {
      for (int j = 0; j < 4; j++)
        snakes[i][j] = 0;
    }
  }
  
  /**
   * Sets the number of ladders
   * @param nLadders - the number of ladders
   */
  public void setNumLadders(int nLadders) {
    numLadders = nLadders;
    ladders = new int[numLadders][4];// 0 is start x coord, 1 is start y coord, 2 is end x coord, 3 is end y coord
    for (int i = 0; i < numLadders; i++) {
      for (int j = 0; j < 4; j++)
        ladders[i][j] = 0;
    }
  }
  
  /**
   * Returns the number of snakes
   * @return the number of snakes
   */
  public int getNumSnakes() {
    return numSnakes;
  }
  
  /**
   * Returns the number of ladders
   * @return the number of ladders
   */
  public int getNumLadders() {
    return numLadders;
  }
  
  /**
   * Creates a certain snake starting at a certain x and y position and ending at
   * a certain x and y position
   * @param snakeNum - which snake
   * @param startX - start x cord
   * @param startY - start y cord
   * @param endX - end x cord
   * @param endY - end y cord
   * @return if the snake was generated successfully
   */
  public boolean generateSnake(int snakeNum, int startX, int startY, int endX, int endY) {// snakeNum is zero indexed
    if (snakeNum < numSnakes && snakeNum >= 0)
      if (startX < getWidthOfBoard() && startX >= 0)
        if (startY < getLengthOfBoard() && startY >= 0)
          if (endX < getWidthOfBoard() && endX >= 0)
            if (endY < getLengthOfBoard() && endY >= 0) {
              snakes[snakeNum][0] = startX;
              snakes[snakeNum][1] = startY;
              snakes[snakeNum][2] = endX;
              snakes[snakeNum][3] = endY;
              setBoard(startX, startY, -2);
              setBoard(endX, endY, -3);
              return true;
    }
    return false;
  }
  
  /**
   * Creates a certain ladder starting at a certain x and y position and ending at
   * a certain x and y position
   * @param ladderNum - which ladder
   * @param startX - start x cord
   * @param startY - start y cord
   * @param endX - end x cord
   * @param endY - end y cord
   * @return if the ladder was generated successfully
   */
  public boolean generateLadder(int ladderNum, int startX, int startY, int endX, int endY) {// ladderNum is zero
    // indexed
    if (ladderNum < numLadders && ladderNum >= 0)
      if (startX < getWidthOfBoard() && startX >= 0)
      if (startY < getLengthOfBoard() && startY >= 0)
      if (endX < getWidthOfBoard() && endX >= 0)
      if (endY < getLengthOfBoard() && endY >= 0) {
      ladders[ladderNum][0] = startX;
      ladders[ladderNum][1] = startY;
      ladders[ladderNum][2] = endX;
      ladders[ladderNum][3] = endY;
      setBoard(startX, startY, -4);
      setBoard(endX, endY, -5);
      return true;
    }
    return false;
  }
  
  /**
   * A helper method to move the pieces around the board
   */
  private void moveOnce() {
    int x = getPieceX(getCurrentPlayer());
    int y = getPieceY(getCurrentPlayer());
    if (y % 2 == 0) {// If y is even
      if (x == getWidthOfBoard()-1) {
        y++;
        setPiece(getCurrentPlayer(), x, y);// Move up the y
      } else {
        x++;
        setPiece(getCurrentPlayer(), x, y);// Move up the x
      }
    } else {
      if (x == 0 && y != 0) {
        y++;
        setPiece(getCurrentPlayer(), x, y);// Move up the y
      } else {
        x--;
        setPiece(getCurrentPlayer(), x, y);// Move up the x
      }
    }
  }
  
  /**
   * moves the current player, checks if the player labnded on a snake or ladder, checks if the player won 
   * @param numOfMoves
   * @return of the moving player has won
   */
  public boolean moveAndCheck (int numOfMoves) {// returns true if the moving player has won
    setBoard(getPieceX(getCurrentPlayer()), getPieceY(getCurrentPlayer()), -1);
    for (int i = 0; i < numOfMoves; i++) {
      moveOnce();
      if (getPieceY(getCurrentPlayer()) == getLengthOfBoard()-1 && getPieceX(getCurrentPlayer()) == (getLengthOfBoard()%2)*(getWidthOfBoard()-1))// when at the top row and
        // first column
        return true;// player has won
    }
    int currentSnake = checkSnake();
    if (currentSnake != -1) {
      System.out.println("You landed on a snake, you slid down to " + snakes[currentSnake][0] + ","
                           + snakes[currentSnake][1]);
      setPiece(getCurrentPlayer(), snakes[currentSnake][0], snakes[currentSnake][1]);
      setBoard(snakes[currentSnake][0], snakes[currentSnake][1], -2);
      setBoard(snakes[currentSnake][2], snakes[currentSnake][3], -3);
    }
    int currentLadder = checkLadder();
    if (currentLadder != -1) {
      System.out.println("You landed on a ladder, you climbed up to " + ladders[currentLadder][2] + ","
                           + ladders[currentLadder][3]);
      setPiece(getCurrentPlayer(), ladders[currentLadder][2], ladders[currentLadder][3]);
      setBoard(ladders[currentLadder][0], ladders[currentLadder][1], -4);
      setBoard(ladders[currentLadder][2], ladders[currentLadder][3], -5);
    }
    setBoard(getPieceX(getCurrentPlayer()), getPieceY(getCurrentPlayer()), getCurrentPlayer());
    if (getCurrentPlayer() == getNumOfPieces() - 1)
      setCurrentPlayer(0);
    else
      nextPlayer();
    return false;
  }
  
  /**
   * Returns the snake number, or -1 if there is no such snake
   * @return the snake number, or -1 if there is no such snake
   */
  public int checkSnake() {// returns the snake number, or -1 if there is no such snake
    for (int i = 0; i < numSnakes; i++)
      if (snakes[i][2] == getPieceX(getCurrentPlayer()) && snakes[i][3] == getPieceY(getCurrentPlayer()))
      return i;
    return -1;
  }
  
  /**
   * Returns the ladder number, or -1 if there is no such ladder
   * @return the ladder number, or -1 if there is no such ladder
   */
  public int checkLadder() {// returns the ladder number, or -1 if there is no such ladder
    for (int i = 0; i < numLadders; i++)
      if (ladders[i][0] == getPieceX(getCurrentPlayer()) && ladders[i][1] == getPieceY(getCurrentPlayer()))
      return i;
    return -1;
  }
  
}