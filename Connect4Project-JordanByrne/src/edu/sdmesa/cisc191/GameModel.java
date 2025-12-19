package edu.sdmesa.cisc191;

/**
 * Lead Author(s):
 * @author Jordan Byrne
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *  
 * Version/date: 1.0 11/7/25
 * 
 * Responsibilities of class: Takes care of calculations and placement of the pieces
 * 
 */

import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class GameModel{
	
    public static final int ROWS = 6; //the game board has 6 rows
    public static final int COLUMNS = 7; //the game board has 7 columns

    private int[][] grid = new int[ROWS][COLUMNS];
    private int totalSpaces = ROWS * COLUMNS;

    private Player player1; //the game has a player 1
    private Player player2; //the game has a player 2

    private int currentPlayer = 1;


    /**
     * Returns the game grid
     * 
     * @return the 2D grid array
     */
    public int[][] getGrid()
    {
        return grid;
    }

    /**
     * Returns the current player
     * 
     * @return current player number
     */
    public int getCurrentPlayer()
    {
        return currentPlayer;
    }

    /**
     * Switches turn to next player
     */
    public void togglePlayer()
    {
        if (currentPlayer == 1) {
            currentPlayer = 2;
        } else {
            currentPlayer = 1;
        }
    }

    /**
     * Assigns the two players for this game
     * 
     * @param p1 player 1
     * @param p2 player 2
     */
    public void setPlayers(Player p1, Player p2)
    {
        player1 = p1;
        player2 = p2;
    }

    /**
     * Returns the Player object whose turn it is
     * 
     * @return the current Player
     */
    public Player getCurrentPlayerObject()
    {
    	if (currentPlayer == 1) {
    	    return player1;
    	} else {
    	    return player2;
    	}
    }

    /**
     * Check for win condition
     * 
     * @param row the row of the last move
     * @param col the column of the last move
     * @param player the player number
     * @return true if the player has won, false otherwise
     */
    public boolean checkWin(int row, int col, int player)
    {
        return checkDirection(row, col, player, 1, 0)   // vertical
            || checkDirection(row, col, player, 0, 1)   // horizontal
            || checkDirection(row, col, player, 1, 1)   // diagonal down-right
            || checkDirection(row, col, player, 1, -1); // diagonal down-left
    }

    /**
     * Checks for four connected pieces 
     */
    private boolean checkDirection(int row, int col, int player, int dRow, int dCol)
    {
        int count = 1;

        int r = row + dRow;
        int c = col + dCol;
        while (r >= 0 && r < ROWS && c >= 0 && c < COLUMNS && grid[r][c] == player) {
            count++;
            r += dRow;
            c += dCol;
        }

        r = row - dRow;
        c = col - dCol;
        while (r >= 0 && r < ROWS && c >= 0 && c < COLUMNS && grid[r][c] == player) {
            count++;
            r -= dRow;
            c -= dCol;
        }

        return count >= 4;
    }

    /**
     * Saves the winning player to file
     * 
     * @param player the winning player number
     */
    public void saveWinnerToFile(int player)
    {
        try (PrintWriter out = new PrintWriter(new FileWriter("connect4_results.txt", true))) {
            out.println("Player " + player + " won the game.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
