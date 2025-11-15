package edu.sdmesa.cisc191;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
//		try{// TODO Auto-generated method stub
//			if (gameModel.grid[gameButton.getRow][gameButton.getCol] != 0) 
//				throw (new IllegalMoveException());
//		
		if(gameModel.player1Turn()) { //player1turn is boolean
			gameButton.setText("O");
			//set text color red
			gameButton.setForeground(Color.RED);
		}else {
			gameButton.setText("O");
			//set color yellow
			gameButton.setForeground(Color.YELLOW);
		}
//		}catch(Exception i) {
//			i.getStackTrace();
//			//print getMessage
//		}
		//update the screen 
				gameView.updateUI();
		
	}


}
