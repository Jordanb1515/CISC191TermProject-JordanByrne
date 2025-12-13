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
    private GameButton[][] buttons = new GameButton[6][7];

    /**
     * Constructor for the GameView class
     * @param model
     */
    public GameView(GameModel model)
    {
        // first ask user if they want a 1 or 2 player game
        String[] options = {"One Player", "Two Player"};
        int choice = JOptionPane.showOptionDialog(
                this,
                "Select Game Mode:", "Game Mode", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        if (choice == 0) {
            // Player 1 is Human, Player 2 is a computer
            model.setPlayers(new HumanPlayer(1), new ComputerPlayer(2));
        } else {
            // both human
            model.setPlayers(new HumanPlayer(1), new HumanPlayer(2));
        }

        this.model = model;

        // set title and layout
        this.setTitle("Connect 4");
        this.setLayout(new BorderLayout(10, 15));
        this.setBackground(Color.LIGHT_GRAY);

        // instructions panel
        JPanel instructions = new JPanel();
        JLabel instructionLabel = new JLabel("Try to connect 4 of your color pieces in a row");
        instructions.add(instructionLabel);
        this.add(instructions, BorderLayout.WEST);

        // top panel for turn display
        JPanel turn = new JPanel();
        turnLabel = new JLabel("Player 1's Turn");
        turn.add(turnLabel);
        this.add(turn, BorderLayout.NORTH);

        // game board panel
        JPanel board = new JPanel();
        board.setPreferredSize(new Dimension(400, 300));
        board.setLayout(new GridLayout(6, 7));

        for (int i = 0; i < model.ROWS; i++) {
            for (int j = 0; j < model.COLUMNS; j++) {
                GameButton newButton = new GameButton(i, j);
                newButton.setBackground(Color.BLUE);
                buttons[i][j] = newButton;
                newButton.addActionListener(
                        new GameButtonListener(model, this, newButton));

                board.add(newButton);
            }
        }

        this.add(board, BorderLayout.CENTER);

        // bottom panel
        JPanel bottom = new JPanel();
        JLabel label = new JLabel("Programmed by: Jordan Byrne");
        bottom.add(label);
        this.add(bottom, BorderLayout.SOUTH);

        // finalize GUI
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
        if (model.getTotalSpaces() % 2 == 0) {
            turnLabel.setText("Player 1's Turn");
        } else {
            turnLabel.setText("Player 2's Turn");
        }
    }

    /**
    * Purpose: Tells controller to update board buttons
    * @param row, int row value of button pressed
    * @param col, int column value of button pressed
    * @param player, of whose turn it is
    */
    public void updateBoardButton(int row, int col, int player)
    {
        GameButton b = buttons[row][col];
        b.setText("●");
        b.setFont(new Font("Arial", Font.BOLD, 36));

        if (player == 1) {
            b.setForeground(Color.RED);
        } else {
            b.setForeground(Color.YELLOW);
        }
    }
}