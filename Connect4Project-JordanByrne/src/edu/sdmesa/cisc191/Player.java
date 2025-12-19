/**
* Lead Author(s):
* @author Jordan Byrne, jbyrne001@student.sdccd.edu
* 
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
*
* Version: 2025/11/9, 1.0
*/
package edu.sdmesa.cisc191;


public abstract class Player{
    private int playerNumber;

    /**
     * Constructor for Player with the given player number
     * 
     * @param playerNumber the player number
     */
    public Player(int playerNumber)
    {
        this.playerNumber = playerNumber;
    }

    /**
     * Returns players number
     * 
     * @return the player number
     */
    public int getPlayerNumber()
    {
        return playerNumber;
    }

    /**
     * Tells whether this is a computer player
     * 
     * @return true if computer or false if human
     */
    public abstract boolean isComputer();

    /**
     * Determines which column the player chooses to place a piece
     * 
     * @param model the current game model
     * @return the chosen column index
     */
    public abstract int chooseColumn(GameModel model);
}
