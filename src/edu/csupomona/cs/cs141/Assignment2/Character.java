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
 * @author David Scianni. The Character class is an abstract class that keeps
 *         track of the Character's {@link #money}, their {@link #hand}, and the
 *         current amount of cards in their hand, {@link #currentCardCount}. It
 *         also has an abstract {@link #printHand} method that determines how
 *         its subclasses will print their {@link #hand}.
 * 
 */
public abstract class Character {
	/**
	 * The money variable determines the amount of money the Character owns.
	 */
	private int money;

	/**
	 * hand is an array of type {@link Card}. This is the set of cards that the
	 * Character currently has in its possession. It is protected because its
	 * subclasses need to call this variable at certain times.
	 */
	protected Card[] hand;

	/**
	 * currentCardCount keeps track of how many cards the Character currently
	 * has in its hand. It is protected because its subclasses need to call this
	 * variable at certain times.
	 */
	protected int currentCardCount;

	/**
	 * The Character constructor takes in a parameter m, and sets {@link #money}
	 * to that integer. It also instantiates {@link #hand} as a {@link Card}
	 * array of size 5. it also sets the {@link #currentCardCount} to 0 since
	 * the Character has no cards in its hand.
	 * 
	 * @param m
	 *            is the amount of {@link #money} the Character starts off with.
	 */
	public Character(int m) {
		money = m;
		hand = new Card[5];
		currentCardCount = 0;
	}

	/**
	 * This will send the amount of {@link #money} that the Character currently
	 * has. This can be used for determining whether the Character has enough
	 * money to bet, or if they have won/lost the game.
	 * 
	 * @return the amount of {@link #money} the Character has.
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * This method is used to send the {@link Card} that is in the i position of
	 * the Character's hand.
	 * 
	 * @param i
	 *            is the position in {@link #hand} of the {@link Card} to be
	 *            returned.
	 * @return the {@link Card} inside hand[i]
	 */
	public Card getCard(int i) {
		return hand[i];
	}

	/**
	 * This is used to send the {@link #currentCardCount} of the Character's
	 * hand. It can be used to check where to add a new card, or whether or not
	 * they have 5 cards in their hand already.
	 * 
	 * @return the {@link #currentCardCount} of the Character.
	 */
	public int getCurrentCardCount() {
		return currentCardCount;
	}

	/**
	 * This will recieve a {@link Card} and put it into the next available slot
	 * in the array {@link #hand}. It will also increase the
	 * {@link #currentCardCount} by 1.
	 * 
	 * @param c
	 *            is the {@link Card} that is to be added to the {@link #hand}
	 */
	public void addCard(Card c) {
		hand[currentCardCount++] = c;
	}

	/**
	 * This is called when the character has lost a bet and will subtract
	 * {@link #money} by m.
	 * 
	 * @param m
	 *            is the amount of {@link #money} the Character lost.
	 */
	public void loseMoney(int m) {
		money -= m;
	}

	/**
	 * This is called when the character has won a bet and will add
	 * {@link #money} by m
	 * 
	 * @param m
	 *            is the amount of {@link #money} the Character has won
	 */
	public void winMoney(int m) {
		money += m;
	}

	/**
	 * The newHand method will reset the {@link #hand}, making it a new array of
	 * size 5. It will also reset the {@link #currentCardCount} to 0. This is
	 * used when a round is over and the player needs a new hand.
	 */
	public void newHand() {
		hand = new Card[5];
		currentCardCount = 0;
	}

	/**
	 * The hasAce method will check every card in the Character's {@link #hand}
	 * and see if there is an {@link AceCard} in it. If there is, it will return
	 * the position of the {@link AceCard}. If there is no {@link AceCard}, then
	 * it returns a -1.
	 * 
	 * @return either the location of the {@link AceCard} or a -1 if no
	 *         {@link AceCard} exists in {@link #hand}
	 */
	public int hasAce() {
		for (int i = 0; i < currentCardCount; i++) {
			if (hand[i].getCardNumber() == "A" && hand[i].getValue() == 11) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * This abstract method will print out the Character's {@link #hand}
	 * depending on which subclass calls it. If the {@link Player} class calls
	 * this method, it will print out each card in its hand in a graphical way,
	 * i.e. |Ad| |Kh|. If the {@link House} class calls the method, it will
	 * print the same as {@link Player}, but will also display the current
	 * amount of {@link #money} that the house has in its pot. Both classes will
	 * check to see how many cards are in their hand, and will display that many
	 * cards on the screen.
	 */
	public abstract void printHand();
}
