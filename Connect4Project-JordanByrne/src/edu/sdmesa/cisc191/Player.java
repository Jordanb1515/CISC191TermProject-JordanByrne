/**
* Lead Author(s):
* @author jab45; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2025-11-09
*/
package edu.sdmesa.cisc191;


public abstract class Player {

    private int playerNumber;

    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    // Human player ignores computer logic
    public abstract boolean isComputer();

    // Return column the player chooses
    public abstract int chooseColumn(GameModel model);
}
