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

import java.util.Random;

/**
 * @author David Scianni. This is the object {@link Deck}. The {@link Deck}
 *         contains an array cards of type{@link Card} and of size
 *         {@link #DECK_SIZE}. The {@link Deck} will hold the cards that the
 *         game will distribute to the {@link Player} and the {@link House}. It
 *         will contain a 4 of each {@link Card#cardNumber}, with a different
 *         {@link Card#suit} for each.
 * 
 */
public class Deck {

	/**
	 * This is a constant that determines the size of the deck. The standard
	 * blackjack deck is 52 cards. It is made into a final int so that it will
	 * be easier to change if the standard deck size were ever to change.
	 */
	private final int DECK_SIZE = 52;

	/**
	 * This is the array of cards where all the cards in the deck are held. It
	 * is instantiated to be made as size {@link #DECK_SIZE}.
	 */
	private Card[] cards = new Card[DECK_SIZE];

	/**
	 * The constructor for {@link Deck} which will create a temporary int called
	 * temp to keep the current location in the cards array. It has two for
	 * loops. The first for loop is to add the four {@link AceCard}s, one of
	 * each suit, to the first four entries in the array cards. The
	 * second for loop is a nested for loop which will add 12 cards of each suit
	 * to the array cards, starting with 2 and ending with 13, which
	 * will become the King.
	 */
	public Deck() {
		int temp = 0;

		for (int i = 1; i <= 4; i++) {
			cards[temp++] = new AceCard(i);
		}
		for (int i = 1; i <= 4; i++) {
			for (int j = 2; j <= 13; j++) {
				cards[temp++] = new Card(j, i);
			}
		}
	}

	/**
	 * This behavior is used to get the {@link Card} located at cards[i].
	 * 
	 * @param i
	 *            is sent to determine which card in the array cards is
	 *            sent.
	 * @return the {@link Card} at location cards[i].
	 */
	public Card getCard(int i) {
		return cards[i];
	}

	/**
	 * The shuffle behavior will shuffle the {@link Card}s within the
	 * cards array. It does this by first setting up a temporary
	 * {@link Card} and a random number generator, r. It also creates an integer
	 * variable random to hold the number generated from r. Then it creates a
	 * for loop that will run for the length of the cards array. While
	 * in the loop, it will create a random number and set that number to the
	 * integer variable random. Then it will make the temp {@link Card} equal to
	 * the current {@link Card}, cards[i], and change the current {@link Card}
	 * to the card at cards[random]. Then it will put the temp card into the
	 * slot cards[random]. What this basically does is switch each card in the
	 * deck with another one at a random location in the deck.
	 */
	public void shuffle() {
		Card temp;
		Random r = new Random();
		int random;

		for (int i = 0; i < cards.length; i++) {
			random = r.nextInt(cards.length);
			temp = cards[i];
			cards[i] = cards[random];
			cards[random] = temp;
		}
	}

}
