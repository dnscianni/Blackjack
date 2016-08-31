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
 * @author David Scianni. The Card class represents the physical cards that are
 *         used in a blackjack game. The card has 3 values. The first is a
 *         {@link #cardNumber} which will help determine what type of card it
 *         is, for example it could be an Ace, a 6, or a Queen. Next the card
 *         has a {@link #suit}, which determines the card's suit. Lastly it has
 *         a value which will help the game determine the score that
 *         the player and the house have.
 * 
 */
public class Card {

	/**
	 * cardNumber is a String, containing one of thirteen lines, including A,
	 * for Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, for Jack, Q, for Queen, and K,
	 * for King. This determines the card type.
	 */
	private String cardNumber;

	/**
	 * The suit variable will contain either an h for hearts, a d for diamonds,
	 * an s for spades, or a c for clubs. This will help distinguish two cards
	 * of the same {@link #cardNumber} from each other.
	 */
	private char suit;

	/**
	 * The value will contain the amount of points each card is worth. 11 or 1
	 * for Ace, 10 for the {@link #cardNumber}s 10, J, Q, and K, and the rest
	 * will correspond to their {@link #cardNumber}, i.e. a 4 card will have a
	 * value of 4.
	 */
	protected int value;

	/**
	 * The Card constructor will give each card a {@link #cardNumber}, a
	 * {@link #suit}, and a value based on the parameters n, and s that
	 * are sent. The value that is given to the card is either the same as n for
	 * the numbered cards, 11 for A, or 10 for J, Q, and K.
	 * 
	 * @param n
	 *            will correspond to the {@link #cardNumber}: 1 for A, 11 for J,
	 *            12 for Q, and 13 for K. The numbered cards will directly
	 *            reflect n.
	 * @param s
	 *            determines the suit: 1 for h, 2 for d, 3 for s, and 4 for c.
	 */
	public Card(int n, int s) {

		switch (s) {
		case 1:
			suit = 'h';
			break;
		case 2:
			suit = 'd';
			break;
		case 3:
			suit = 's';
			break;
		default:
			suit = 'c';
		}

		if (n <= 10 && n >= 2) {
			value = n;
			switch (n) {
			case 2:
				cardNumber = "2";
				break;
			case 3:
				cardNumber = "3";
				break;
			case 4:
				cardNumber = "4";
				break;
			case 5:
				cardNumber = "5";
				break;
			case 6:
				cardNumber = "6";
				break;
			case 7:
				cardNumber = "7";
				break;
			case 8:
				cardNumber = "8";
				break;
			case 9:
				cardNumber = "9";
				break;
			default:
				cardNumber = "10";
				break;
			}
		} else if (n == 1) {
			value = 11;
			cardNumber = "A";
		} else {
			value = 10;
			if (n == 11) {
				cardNumber = "J";
			} else if (n == 12) {
				cardNumber = "Q";
			} else {
				cardNumber = "K";
			}
		}
	}

	/**
	 * The getValue behavior is used to receive the {@link #value} of the card.
	 * This could be used to determine the score of the {@link Player} or
	 * {@link House}.
	 * 
	 * @return the {@link #value} of the card.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * The getValue behavior is used to receive the {@link #suit} of the card.
	 * This could be used to help print out the card.
	 * 
	 * @return the {@link #suit} of the card
	 */
	public char getSuit() {
		return suit;
	}

	/**
	 * The getValue behavior is used to receive the {@link #cardNumber} of the
	 * card. This could be used to help print out the card.
	 * 
	 * @return the {@link #cardNumber} of the card
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * This method is placed so that when an {@link AceCard} calls the method,
	 * the one in {@link AceCard} will override this one. It is empty so that if
	 * a non AceCard Card tries to call it it will do nothing. The AceCard
	 * changeAceValue method changes the value to 1. This can be used for when
	 * the ace is causing the {@link Character} to bust, so that it will change
	 * its value to 1 instead of 11 to help out the {@link Character}.
	 */
	public void changeAceValue() {

	}

}
