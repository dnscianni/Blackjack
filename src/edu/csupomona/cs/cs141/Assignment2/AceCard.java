/**
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment #2
 *
 * The assignment is to create a fully functional Blackjack game.
 *
 * David Scianni
 */
package edu.csupomona.cs.cs141.Assignment2;

/**
 * @author David Scianni. The AceCard class is a subclass of {@link Card}. It is
 *         its own class because it is the only card that can change its value,
 *         and should be the only card that is allowed to change its value.
 * 
 */
public class AceCard extends Card {

	/**
	 * The AceCard constructor will call the Card constructor and send it the
	 * {@link Card#cardNumber} 1 representing the Ace, and the parameter s which
	 * represents the suit that is called.
	 * 
	 * @param s
	 *            is the suit that AceCard will send to the Card constructor.
	 */
	public AceCard(int s) {
		super(1, s);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.csupomona.cs.cs141.Assignment2.Card#changeAceValue()
	 */
	public void changeAceValue() {

		value = 1;
	}

}
