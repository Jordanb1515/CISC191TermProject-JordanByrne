/**
* Lead Author(s):
* @author Jordan Byrne
* 
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2025-11-09, 1.0
* 
* Purpose: Keeps track of moves of human player(s) in the game
*/
package edu.sdmesa.cisc191;


public class HumanPlayer extends Player
{
	private String name; //a human player has a name
	
	public HumanPlayer(String name) {
		this.name = name;
	}
	
	public void move(int row, int col) {
		
	}
}
