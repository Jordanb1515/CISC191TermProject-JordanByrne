package edu.sdmesa.cisc191;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * Lead Author(s):
 * @ Jordan Byrne
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *  
 * Version/date: 1.0 11/7/25
 * 
 * Responsibilities of class: Takes care of actions when button is pressed
 * 
 */

public class GameButtonListener implements ActionListener
{
	private GameModel gameModel;
	private GameView gameView;
	private GameButton gameButton;
	
	/**
	 * Constructor for the GameButtonListener class
	 * @param gameModel
	 * @param gameView
	 * @param gameButton
	 */
	public GameButtonListener(GameModel gameModel, GameView gameView,
			GameButton gameButton)
	{
		this.gameModel = gameModel;
		this.gameView = gameView;
		this.gameButton = gameButton;
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
	    try {
	        int row = gameButton.getRow();
	        int col = gameButton.getColumn();

	        // make sure valid space is pressed
	        if (row < gameModel.ROWS - 1 && gameModel.getGrid()[row + 1][col] == 0) {
	            throw new IllegalMoveException( "Invalid move! Piece must be placed on the bottom or on another piece.");
	        }

	        // throw exception if player tries to place in occupied spot
	        if (gameModel.getGrid()[row][col] != 0) {
	            throw new IllegalMoveException("This space is already taken!");
	        }

	        // determine whose turn it is and place piece
	        int playerVal;
	        if (gameModel.player1Turn()) {
	            playerVal = 1;
	        } else {
	            playerVal = 2;
	        }
	        gameModel.getGrid()[row][col] = playerVal;

	        gameButton.setText("●");
	        gameButton.setFont(new Font("Arial", Font.BOLD, 36));
	        if (playerVal == 1) {
	            gameButton.setForeground(Color.RED);
	        } else {
	            gameButton.setForeground(Color.YELLOW);
	        }

	        // switch control to other player
	        gameModel.togglePlayer();
	        gameView.updateUI();

	    } catch (IllegalMoveException ex) {
	        // Show the error message without terminating the program
	        JOptionPane.showMessageDialog(null, ex.getMessage(), "Illegal Move", JOptionPane.ERROR_MESSAGE);
	    }
	}

}
