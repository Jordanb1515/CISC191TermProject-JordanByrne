package edu.sdmesa.cisc191;

import java.awt.*;
import javax.swing.*;

/**
 * Lead Author(s):
 * @ Jordan Byrne
 *  
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * Version/date: 1.0 10/10/25
 * 
 * Responsibilities of class: The GUI component for the connect 4 game responsible for the view
 * 
 */

public class GameView extends JFrame
{
	private GameModel model;
	private JLabel turnLabel;
	
	/**
	 * Constructor for the GameView class
	 * @param model
	 */
	public GameView(GameModel model)
	{
		
		this.model = model;
		//set title and layout 
		this.setTitle("Connect 4");
		this.setLayout(new BorderLayout(10,15)); //to create gaps
		this.setBackground(Color.LIGHT_GRAY);
		
		//create a panel and label for the instructions of the game
		JPanel instructions = new JPanel();                                    
		JLabel instructionLabel = new JLabel("Try to connect 4 of your color pieces in a row"); 
		instructions.add(instructionLabel);           
		this.add(instructions, BorderLayout.WEST);  
		
		//add panel to top
		JPanel turn = new JPanel();                                    
		turnLabel = new JLabel("Player 1's Turn"); //changes for whose turn
		turn.add(turnLabel);           
		this.add(turn, BorderLayout.NORTH);
		
		//create a panel and label for the buttons of the game
		JPanel buttons = new JPanel();
		buttons.setPreferredSize(new Dimension(400, 300)); 
		buttons.setLayout(new GridLayout(6, 7));
		for(int i = 0; i < model.ROWS; i++) {
			for(int j = 0; j < model.COLUMNS; j++) {
				GameButton newButton = new GameButton(i,j);
				newButton.setBackground(Color.BLUE);
				newButton.addActionListener(new GameButtonListener(model, this, newButton));
				buttons.add(newButton);
			}
			
		}
		this.pack();
		this.add(buttons, BorderLayout.CENTER);
		
		//add final panel and label at bottom to show programmer
		JPanel bottom = new JPanel();
		JLabel label = new JLabel("Programmed by: Jordan Byrne");
		bottom.add(label);
		this.add(bottom, BorderLayout.SOUTH);
		
		//make GUI visible
		this.pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	

	public static void main(String[] args)
	{
		new GameView(new GameModel());
	}
	
	/**
	 * Purpose: Update GUI for user
	 */
	public void updateUI()
	{
		if(model.getTotalSpaces() % 2 == 0) {
			turnLabel.setText("Player 1's Turn");
		}
		else {
			turnLabel.setText("Player 2's Turn");
		}
	}

}