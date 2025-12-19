/**
* Lead Author(s):
* @author Jordan Byrne
* 
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* Version: 2025/11/09, 1.0
* 
* Purpose: Keeps track of moves of human player(s) in the game
*/
package edu.sdmesa.cisc191;


public class HumanPlayer extends Player{
    /**
     * Constructor for HumanPlayer with the given player number
     * 
     * @param playerNumber the player number
     */
    public HumanPlayer(int playerNumber)
    {
        super(playerNumber);
    }

    /**
     * Tells that this player is not a computer
     * 
     * @return false, since this is a human player
     */
    @Override
    public boolean isComputer()
    {
        return false;
    }

    /**
     * Human players choose their own columns
     * 
     * @param model the current game model (unused)
     * @return -1 to indicate no auto column selection
     */
    @Override
    public int chooseColumn(GameModel model)
    {
        return -1;
    }
}
