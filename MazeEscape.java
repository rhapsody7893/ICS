/**
 * This program will check if there is a escape path in a 5 by 5 maze
 * Krasetva
 * @version 1.0 April 12, 2019
 * @author Michael Zhou 
 */ 
public class MazeEscape {
  
  /** 
   * Sets up solve, checks each possible entry
   * @return if there is a possible path
   * @param maze the maze
   */ 
  public boolean solveMaze(int[] [] maze) {
    for (int i = 0; i < maze.length; i++)
    {
      if (maze [i][0] == 0)
      {
        if (solve (maze, i, 0))
          return true;
      }
    }
    for (int i = 1; i < maze.length; i++)
    {
      if (maze [0][i] == 0)
      {
        if (solve (maze, 0, i))
          return true;
      }
    }
    return false;
    
  }
  
  /** 
   * Checks for possible path
   * @return if the path exists
   * @param maze the maze
   * @param row the row
   * @param col the column
   * 
   */ 
  public boolean solve(int[][] maze, int row, int col) {
    if ((row == maze.length - 1 || col == maze[0].length - 1) && maze[row][col] == 0)
      return true;
    if (row >= 0 && row < maze.length && col >= 0 && col < maze.length && maze[row][col] == 0) {
      maze[row][col] = 2;
      return solve(maze, row - 1, col) || solve(maze, row + 1, col) || solve(maze, row, col + 1) || solve(maze, row, col - 1); //run the method again for each posible direction
    }    
    return false;    
  }
  
  /** Entry to the program
    * 
    * @param args the arguments passed from the command line
    */
  public static void main (String [] args) {
    int[][] maze = {
      {1, 1, 1, 0, 1},
      {1, 1, 0, 0, 1},
      {0, 1, 0, 1, 1},
      {0, 1, 0, 0, 0},
      {1, 1, 1, 1, 1}};
    MazeEscape mazeEscape = new MazeEscape();
    System.out.println(mazeEscape.solveMaze(maze));
  }
}