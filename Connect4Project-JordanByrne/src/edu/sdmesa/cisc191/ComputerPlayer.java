/**
* Lead Author(s):
* @author Jordan Byrne, jbyrne@student.sdccd.edu
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
*
* Version: 2025/11/9, 1.0
* 
* Purpose: Responsibilities of ComputerPlayer class
*/
package edu.sdmesa.cisc191;


public class ComputerPlayer extends Player{
	
    private ComputerAI ai = new ComputerAI(); //logic for computer's moves

    /**
     * Constructor for ComputerPlayer with the given player number
     * 
     * @param playerNumber the player number
     */
    public ComputerPlayer(int playerNumber)
    {
        super(playerNumber);
    }

    /**
     * Tell that this player is a computer
     * 
     * @return true, since this is a computer player
     */
    @Override
    public boolean isComputer()
    {
        return true;
    }

    /**
     * Chooses a column using the computer logic
     * 
     * @param model the current game model
     * @return the selected column index
     */
    @Override
    public int chooseColumn(GameModel model)
    {
        return ai.chooseColumn(model);
    }
}

