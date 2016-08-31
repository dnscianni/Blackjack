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
 * @author David Scianni. The House class represents the character the
 *         {@link Player} is trying to beat. This class will have no control
 *         from the user, but will be controlled by the main method in
 *         {@link Game}.
 * 
 */
public class House extends Character {

	/**
	 * The House constructor calls the {@link Character} constructor and sends
	 * 5000, which represents how much {@link Character#money} the house starts
	 * the game with, $5000.
	 */
	public House() {
		super(5000);
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
			System.out.printf("|%s%s| |%s%s|   House Pot: %d\n",
					hand[0].getCardNumber(), hand[0].getSuit(),
					hand[1].getCardNumber(), hand[1].getSuit(), getMoney());
			break;
		case 3:
			System.out.printf("|%s%s| |%s%s| |%s%s|   House Pot: %d\n",
					hand[0].getCardNumber(), hand[0].getSuit(),
					hand[1].getCardNumber(), hand[1].getSuit(),
					hand[2].getCardNumber(), hand[2].getSuit(), getMoney());
			break;
		case 4:
			System.out.printf("|%s%s| |%s%s| |%s%s| |%s%s|   House Pot: %d\n",
					hand[0].getCardNumber(), hand[0].getSuit(),
					hand[1].getCardNumber(), hand[1].getSuit(),
					hand[2].getCardNumber(), hand[2].getSuit(),
					hand[3].getCardNumber(), hand[3].getSuit(), getMoney());
			break;
		default:
			System.out.printf(
					"|%s%s| |%s%s| |%s%s| |%s%s| |%s%s|   House Pot: %d\n",
					hand[0].getCardNumber(), hand[0].getSuit(),
					hand[1].getCardNumber(), hand[1].getSuit(),
					hand[2].getCardNumber(), hand[2].getSuit(),
					hand[3].getCardNumber(), hand[3].getSuit(),
					hand[4].getCardNumber(), hand[4].getSuit(), getMoney());
		}

	}

	/**
	 * The printFirstHand method is used to hide the second card in House's hand
	 * during the {@link Player}'s turn, so that the {@link Player} cannot see
	 * what the House's score is. It prints the first card but leaves the second
	 * card blank, and it shows how much {@link Character#money} the House still
	 * has.
	 */
	public void printFirstHand() {
		System.out.printf("|%s%s| |--|   House Pot: %d\n",
				hand[0].getCardNumber(), hand[0].getSuit(), getMoney());
	}
}
