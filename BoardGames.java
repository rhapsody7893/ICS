/**
 * This class represents a generic board game
 * @author Feng X, Michael Zhou
 */
public class BoardGames {
  // instance Variables
  private String gameName;
  private String gameCompany;
  private int suggestedAge;
  private int numOfPieces;// Number of pieces
  private int pieces[][];// For each piece, x and y coords.
  private int lengthOfBoard;// Number of positions on the y axis
  private int widthOfBoard;// Number of positions on the x axis
  private int[][] board;// The full board. -1 means empty. any other number means the piece number
  private int turns; // number of turns
  private int currentPlayer;  
  
  /**
   * Constructor - sets defualt values for all instance variables
   */
  public BoardGames() {
    gameName = "Board Game";
    lengthOfBoard = 5;
    widthOfBoard = 5;
    board = new int[widthOfBoard][lengthOfBoard];
    for (int i = 0; i < widthOfBoard; i++)
      for (int j = 0; j < lengthOfBoard; j++)
      board[i][j] = -1;
    numOfPieces = 0;
    turns = 0;
    currentPlayer = 0;
    gameCompany = "Company.inc";
    suggestedAge = 10;
  }
  
  /**
   * Constructor - sets passed values for gameName, lengthOfBoard, widthOfBoard,
   * sets default values for the other instance variables
   * @param name - gameName of the board game
   * @param length - length of the board
   * @param width - width of the board
   */
  public BoardGames(String name, int length, int width) {
    gameName = name;
    lengthOfBoard = length;
    widthOfBoard = width;
    board = new int[widthOfBoard][lengthOfBoard];
    for (int i = 0; i < widthOfBoard; i++)
      for (int j = 0; j < lengthOfBoard; j++)
      board[i][j] = -1;
    numOfPieces = 0;
    turns = 0;
    currentPlayer = 0;
    gameCompany = "Company.inc";
    suggestedAge = 10;
  }
  
  /**
   * Constructor - sets passed values for gameName, lengthOfBoard, widthOfBoard,
   * and numOfPieces, gameCompany and suggestedAge
   * @param name - gameName of the board game
   * @param length - length of the board
   * @param width - width of the board
   * @param numPieces - number of pieces in the board game
   * @param company - the name of the game company
   * @param age - the suggested age
   */
  public BoardGames(String name, int length, int width, int numPieces, String company, int age) {
    gameName = name;
    lengthOfBoard = length;
    widthOfBoard = width;
    board = new int[widthOfBoard][lengthOfBoard];
    for (int i = 0; i < widthOfBoard; i++)
      for (int j = 0; j < lengthOfBoard; j++)
      board[i][j] = -1;
    numOfPieces = numPieces;
    pieces = new int[numOfPieces][2];
    turns = 0;
    currentPlayer = 0;
    gameCompany = company;
    suggestedAge = age;
  }
  
   /**
   * Returns the game company name
   * @return the game company name   
   */
  public String getGameCompany() {
    return gameCompany;
  } 
  
  /**
   * Sets the game company name
   * @param name - the name of the game company
   */
  public void setGameCompany(String name) {
    gameCompany = name;
  }
  
  /**
   * Gets the suggested age
   * @return the suggested age 
   */
  public int getSuggestedAge() {
    return suggestedAge;
  }
  
  /**
   * Sets the suggested age
   * @param age - the suggested age
   */
  public void setSuggestedAge(int age) {
    suggestedAge = age;
  }
  
   /**
   * Sets the game name
   * @param name - the name of the game
   */
  public void setGameName(String name) {
    gameName = name;
  }
  
   /**
   * Sets the length of board and modifies the array
   * @param length - the length of the board
   */
  public void setLengthOfBoard(int length) {
    lengthOfBoard = length;
    board = new int[widthOfBoard][lengthOfBoard];
    for (int i = 0; i < widthOfBoard; i++)
      for (int j = 0; j < lengthOfBoard; j++)
      board[i][j] = -1;
  }
  
   /**
   * Sets the width of board and modify the board array
   * @param width - width of board
   */
  public void setWidthOfBoard(int width) {
    widthOfBoard = width;
    board = new int[widthOfBoard][lengthOfBoard];
    for (int i = 0; i < widthOfBoard; i++)
      for (int j = 0; j < lengthOfBoard; j++)
      board[i][j] = -1;
  }

  /**
   * Places a piece in a certain location on the board
   * @param pieceNumber - the number value of the piece
   * @param x - x location
   * @param y - y location
   * @return if it was placed successfully
   */
  public boolean setPiece(int pieceNumber, int x, int y) {
    if (x >= 0 && x < widthOfBoard && y >= 0 && y < lengthOfBoard) {
      pieces[pieceNumber][0] = x;
      pieces[pieceNumber][1] = y;
      return true;
    }
    return false;
  }
  
  /**
   * Returns the value of the current player
   * @return the current player
   */
  public int getCurrentPlayer() {
    return currentPlayer;
  }
  
  /**
   * Gets the xPos of the piece
   * @param pieceNumber - the number value of the piece
   * @return The x value
   */
  public int getPieceX(int pieceNumber) {
    return pieces[pieceNumber][0];
  }
  
  /**
   * Gets the yPos of the piece
   * @param pieceNumber - the number value of the piece
   * @return The y value
   */
  public int getPieceY(int pieceNumber) {
    return pieces[pieceNumber][1];
  }
  
  /**
   * Returns the value of the specified position
   * @param x - x location
   * @param y - y location
   */
  public void setBoard(int x, int y, int val) {
    board[x][y] = val;
  }
  
  /**
   * Returns the value of the specified position
   * @param x - x location
   * @param y - y location
   * @return the value of the specified position
   */
  public int getBoard(int x, int y) {
    return board[x][y];
  }
  
  /**
   * Returns the name of the game
   * @return the name of the game
   */
  public String getGameName() {
    return gameName;
  }
  
  /**
   * Returns the number of pieces
   * @return the number of pieces
   */
  public int getNumOfPieces() {
    return numOfPieces;
  }
  
  /**
   * Increases the number of turns by 1
   */
  public void iterateTurns() {
    turns++;
  }
  
  /**
   * Returns the number of turns
   * @return the number of turns
   */
  public int getTurns() {
    return turns;
  }
  
  /**
   * Returns the width of the board
   * @return the width of the board
   */
  public int getWidthOfBoard() {
    return widthOfBoard;
  }
  
  /**
   * Returns the length of the board
   * @return the length of the board
   */
  public int getLengthOfBoard() {
    return lengthOfBoard;
  }
  
  /**
   * Prints an array to display the board
   */
  public void displayBoard() {
    for (int i = lengthOfBoard-1; i >=0; i--){
      for (int j = 0; j < widthOfBoard; j++)
        System.out.print(board[j][i] + " ");
      System.out.println();
    }
  }
  
  /**
   * Sets the number of pieces
   * @param nPieces - number of pieces to be set
   */
  public void setNumOfPieces(int nPieces) {
    numOfPieces = nPieces;
    pieces = new int[numOfPieces][2];
  }
  
  /** Sets the current player
   * @param newPlayer the new current player
   */
  public void setCurrentPlayer(int newPlayer) {
    currentPlayer = newPlayer;
  }
  
  /** Increases the current player
   */
  public void nextPlayer() {
    currentPlayer++;
  }
  
  /**
   * Returns a random value between 1 to 6
   * @return a a random value between 1 to 6
   */
  public static int rollDice() {
    return (int) (Math.random() * 6 + 1);
  }
}