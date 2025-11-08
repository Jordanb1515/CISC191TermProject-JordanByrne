package edu.sdmesa.cisc191;

import javax.swing.JButton;

/**
 * Lead Author(s):
 * @ Jordan Byrne 

 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *  
 * Version/date: 1.0, 11/2/25
 * 
 * Responsibilities of class: Duties of the GameButton for the connect 4 game
 * 
 */

public class GameButton extends JButton
{
	private int row; //each connect 4 space has a row
	private int column; //each connect 4 row has a column
	
	/**
	 * Constructor for the GameButton class
	 * @param row
	 * @param column
	 */
	public GameButton(int row, int column)
	{
		this.row = row;
		this.column = column;
	}
	
	/**
	 * Getter for the row instance variable
	 * @return int row number
	 */
	public int getRow()
	{
		return row;
	}
	
	/**
	 * Getter for the column instance variable
	 * @return int column number
	 */
	public int getColumn()
	{
		return column;
	}

}