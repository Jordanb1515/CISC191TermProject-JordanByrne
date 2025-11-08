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
	private boolean[][] grid = new boolean[7][6]; //2D array to resemble a grid pattern for the game
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


}
