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
     */
    public GameButtonListener(GameModel gameModel, GameView gameView,
                              GameButton gameButton)
    {
        this.gameModel = gameModel;
        this.gameView = gameView;
        this.gameButton = gameButton;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        try {
            int row = gameButton.getRow();
            int col = gameButton.getColumn();

            // make sure valid space is pressed
            if (row < GameModel.ROWS - 1 &&
                gameModel.getGrid()[row + 1][col] == 0) {
                throw new IllegalMoveException(
                    "Invalid move! Piece must be placed on the bottom or on another piece."
                );
            }

            // throw exception if player tries to place in occupied spot
            if (gameModel.getGrid()[row][col] != 0) {
                throw new IllegalMoveException("This space is already taken!");
            }

            // use player object to keep track of turns
            Player current = gameModel.getCurrentPlayerObject();
            int playerVal = current.getPlayerNumber();

            // place piece in model
            gameModel.getGrid()[row][col] = playerVal;

            // update button appearance
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

            // decide whose has next turn
            Player next = gameModel.getCurrentPlayerObject();
            if (next.isComputer()) {
                makeComputerMove();
            }

        } catch (IllegalMoveException ex) {
            JOptionPane.showMessageDialog(
                null,
                ex.getMessage(),
                "Illegal Move",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    /**
    * Purpose: Take computer's move
    */
    private void makeComputerMove()
    {
        Player cpu = gameModel.getCurrentPlayerObject();

        // check which column to play
        int col = cpu.chooseColumn(gameModel);

        int[][] grid = gameModel.getGrid();

        // find lowest row in chosen column
        int row = -1;
        for (int r = GameModel.ROWS - 1; r >= 0; r--) {
            if (grid[r][col] == 0) {
                row = r;
                break;
            }
        }

        // check if column is full
        if (row == -1) 
        	return;

        // place computer piece
        grid[row][col] = cpu.getPlayerNumber();
        gameView.updateBoardButton(row, col, cpu.getPlayerNumber());

        // switch to human player
        gameModel.togglePlayer();
        gameView.updateUI();
    }
}
