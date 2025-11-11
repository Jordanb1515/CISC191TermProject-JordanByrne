/**
* Lead Author(s):
* @author Jordan Byrne
* 
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
*
* Version: 2025-11-09, 1.0
* 
* Purpose: Exception class for making an illegal move in the game
*/
package edu.sdmesa.cisc191;

public class IllegalMoveException extends Exception
{
	public String getMessage() {
		return "Illegal move. Choose different button";
	}
}
