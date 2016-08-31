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
 * @author David Scianni. The Player class extends the {@link Character} class.
 *         This class represents the user, who is playing the Blackjack game.
 */
public class Player extends Character {

	/**
	 * The Player constructor calls the constructor of {@link Character}, and
	 * sends it 500, which represents the amount of {@link Character#money} the
	 * Player starts the game with, $500.
	 */
	public Player() {
		super(500);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.csupomona.cs.cs141.Assignment2.Character#printHand()
	 */
	@Override
	public void printHand() {
		switch (currentCardCount) {
		case 2:
			System.out.printf("|%s%s| |%s%s|\n", hand[0].getCardNumber(),
					hand[0].getSuit(), hand[1].getCardNumber(),
					hand[1].getSuit());
			break;
		case 3:
			System.out.printf("|%s%s| |%s%s| |%s%s|\n",
					hand[0].getCardNumber(), hand[0].getSuit(),
					hand[1].getCardNumber(), hand[1].getSuit(),
					hand[2].getCardNumber(), hand[2].getSuit());
			break;
		case 4:
			System.out.printf("|%s%s| |%s%s| |%s%s| |%s%s|\n",
					hand[0].getCardNumber(), hand[0].getSuit(),
					hand[1].getCardNumber(), hand[1].getSuit(),
					hand[2].getCardNumber(), hand[2].getSuit(),
					hand[3].getCardNumber(), hand[3].getSuit());
			break;
		default:
			System.out.printf("|%s%s| |%s%s| |%s%s| |%s%s| |%s%s|\n",
					hand[0].getCardNumber(), hand[0].getSuit(),
					hand[1].getCardNumber(), hand[1].getSuit(),
					hand[2].getCardNumber(), hand[2].getSuit(),
					hand[3].getCardNumber(), hand[3].getSuit(),
					hand[4].getCardNumber(), hand[4].getSuit());
		}

	}

}
