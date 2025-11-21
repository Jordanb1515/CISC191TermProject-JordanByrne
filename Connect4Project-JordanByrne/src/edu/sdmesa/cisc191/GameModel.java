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


public class GameModel
{
	public static final int ROWS = 6;
	public static final int COLUMNS = 7;
	private int[][] grid = new int[ROWS][COLUMNS]; //2D array to resemble a grid pattern for the game
	private int totalSpaces = 42; //max number of turns
	

	/**
	 * Constructor for GameModel 
	 */
	public GameModel()
	{
	
	}

	/**
	 * Actions to perform when a button is pressed
	 * @param row of the pressed button
	 * @param column of the pressed button
	 * @return boolean 4row for if player has won
	 */
	public boolean placePiece(int row, int column)
	{
		return false;
		//return for win condition
	}
	
	
	public int getTotalSpaces() {
		return totalSpaces;
	}

	/**
	 * @return the grid
	 */
	public int[][] getGrid()
	{
		return grid;
	}

	/**
	 * @param grid the grid to set
	 */
	public void setGrid(int[][] grid)
	{
		this.grid = grid;
	}
	
	
    private int currentPlayer = 1;

    public boolean player1Turn() {
        return currentPlayer == 1;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void togglePlayer() {
    	if (currentPlayer == 1) {
    	    currentPlayer = 2;
    	} else {
    	    currentPlayer = 1;
    	}
    }
	


}
