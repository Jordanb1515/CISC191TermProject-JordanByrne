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


public class ComputerPlayer extends Player {


    private ComputerAI ai = new ComputerAI(); 


    public ComputerPlayer(int playerNumber) {
        super(playerNumber);
    }


    @Override
    public boolean isComputer() {
        return true;
    }


    @Override
    public int chooseColumn(GameModel model) {
        return ai.chooseColumn(model);
    }
}

