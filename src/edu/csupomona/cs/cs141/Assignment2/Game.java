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

import java.util.Scanner;

/**
 * @author David Scianni. This is the Game class, which contains the main method
 *         of the Blackjack game. This class controls all the game-play aspects
 *         of the Blackjack program.
 * 
 */
public class Game {
	/**
	 * deck is the {@link Deck} that the Game class will use to distribute cards
	 * to each {@link Character}.
	 */
	private static Deck deck = new Deck();

	/**
	 * user is the {@link Player} that the person playing the game will control.
	 */
	private static Player user = new Player();

	/**
	 * house is the {@link House} that will be playing against the user. All of
	 * house's actions are determined by the code in main.
	 */
	private static House house = new House();

	/**
	 * main contains the game-play aspects of the game Blackjack.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * currentCardNumber keeps track of the place in deck that we are in.
		 */
		int currentCardNumber;
		/**
		 * currentUserCardNumber keeps track of the place in the user's hand
		 * that we are in.
		 */
		int currentUserCardNumber;
		/**
		 * currentHouseCardNumber keeps track of the place in the house's hand
		 * that we are in.
		 */
		int currentHouseCardNumber;
		/**
		 * A Scanner so we can take in the user's inputs.
		 */
		Scanner kb = new Scanner(System.in);
		/**
		 * amount is the amount of money that the user wants to add to his or
		 * her bet. it must be between
		 * {@code 0 <= amount <= (user's money or house's money)}. If it is less
		 * than 0, it quits the program.
		 */
		int amount;
		/**
		 * answer determines whether the user wants to hit or stand. It is
		 * either 1 for hit or 2 for stand.
		 */
		int answer;
		/**
		 * userTotal is the total score of the user, or all of the cards in
		 * user's hand's values added together.
		 */
		int userTotal;
		/**
		 * houseTotal is the total score of the house, or all of the cards in
		 * house's hand's values added together.
		 */
		int houseTotal;
		/**
		 * DEFAULT_BET is the constant that determines the default bet of user.
		 */
		final int DEFAULT_BET = 10;

		System.out.println("Welcome to Blackjack!\n");

		/**
		 * This do while loop will continuously repeat the game until either the
		 * user quits, wins the game, or loses the game. First it sets
		 * userTotal, currentUserCardNumber, houseTotal, currentHouseCardNumber,
		 * and currentCardNumber to 0 so to refresh them all after each round.
		 * Then it checks to see if either user or house has run out of money,
		 * thus ending the game. If someone did run out of money it breaks the
		 * loop.
		 */
		do {
			userTotal = 0;
			currentUserCardNumber = 0;
			houseTotal = 0;
			currentHouseCardNumber = 0;
			currentCardNumber = 0;

			if (user.getMoney() < 10) {
				System.out.println("You Lose, game over.");
				break;
			}

			if (house.getMoney() < 10) {
				System.out.println("You win! Congratulations!");
				break;
			}

			/**
			 * The deck is shuffled after each round, and the user's hand and
			 * the house's hand are refreshed as well.
			 */
			deck.shuffle();
			user.newHand();
			house.newHand();

			/**
			 * The user and house are each given two cards added to their hands.
			 * currentCardNumber, currentUserCardNumber, and
			 * currentHouseCardNumber are all increased each time a card is
			 * given to their respective Character. userTotal and houseTotal are
			 * also changed to reflect the two cards each Character was given.
			 */
			user.addCard(deck.getCard(currentCardNumber++));
			userTotal += user.getCard(currentUserCardNumber++).getValue();

			house.addCard(deck.getCard(currentCardNumber++));
			houseTotal += house.getCard(currentHouseCardNumber++).getValue();

			user.addCard(deck.getCard(currentCardNumber++));
			userTotal += user.getCard(currentUserCardNumber++).getValue();

			house.addCard(deck.getCard(currentCardNumber++));
			houseTotal += house.getCard(currentHouseCardNumber++).getValue();

			/**
			 * The user's money and the house's money are now printed and the
			 * user is asked if he or she would like to either add money to the
			 * default bet or quit. A check is done to see if the user selected
			 * a negative number, and if so, then it breaks the loop and
			 * terminates the program. It also checks to see if the amount of
			 * money the user wants to add is with the bounds acceptable. If
			 * not, it will continuously ask the user for another, correct
			 * number.
			 */
			System.out.println("Current Money: " + user.getMoney());
			System.out.println("Current House Pot: " + house.getMoney());
			System.out
					.print("Current bet is $10, would you like to add to that?\n(Please enter amount you want to add, or -1 to quit)");
			amount = kb.nextInt();

			if (amount < 0) {
				break;
			}

			while ((amount + 10) > user.getMoney()
					|| (amount + 10) > house.getMoney()) {
				System.out
						.print("Not enough money, please enter another bet: ");
				amount = kb.nextInt();
			}

			/**
			 * The game now calls each Character's printHand method to display
			 * the cards on the screen. house has its printFirstHand method
			 * called so that it's second card is hidden from the user's view.
			 */
			System.out.println();
			house.printFirstHand();
			System.out.println();
			user.printHand();

			/**
			 * Two checks are done to see if either the user or the house has
			 * gotten a blackjack. If so, the results of the bet are set and it
			 * continues the loop.
			 */
			if (userTotal == 21) {
				System.out.println("Blackjack! You Win!\n");
				user.winMoney(DEFAULT_BET + amount);
				house.loseMoney(DEFAULT_BET + amount);
				continue;
			}

			if (houseTotal == 21) {
				System.out.println("House got a Blackjack! You lose.\n");
				house.winMoney(DEFAULT_BET + amount);
				user.loseMoney(DEFAULT_BET + amount);
				continue;
			}

			/**
			 * The user is now given the option to either hit or stand. If they
			 * choose an incorrect number, it will continuously ask for a
			 * correct number.
			 */
			System.out.print("Would you like to hit(1) or stand(2): ");
			answer = kb.nextInt();

			while (answer != 1 && answer != 2) {
				System.out
						.print("Im sorry, that is an incorrect response, press 1 to hit, 2 to stand.");
				answer = kb.nextInt();
			}

			/**
			 * If the user decides to hit, it will run a while loop as long as
			 * the user continues to hit. First it will add another card to the
			 * user's hand, then increase currentCardNumber,
			 * currentUserCardNumber, and userTotal accordingly. Then it will
			 * print out the two hands again, this time including the user's new
			 * card. Then it will check to see if the user has 5 cards in his or
			 * her hand and if the userTotal is less than 21. If so, the user
			 * wins with a 5 card charlie, and the results of the bet are
			 * calculated, and the do loop is repeated. Then it checks to see if
			 * it needs to change any Ace values to 1, and if so, it does, and
			 * also changes the userToatl to reflect the change in value. Then
			 * it checks if the user busted, and if so deals with the results of
			 * the bet and the do loop repeats. If it passes all those tests,
			 * then the user is asked if they would like to hit or stand again,
			 * and a check is done again to make sure they enter a correct
			 * number. if yes, the loops repeats, if no the loop ends.
			 */
			while (answer == 1) {
				user.addCard(deck.getCard(currentCardNumber++));
				userTotal += user.getCard(currentUserCardNumber++).getValue();

				System.out.println();
				house.printFirstHand();
				System.out.println();
				user.printHand();

				if (user.getCurrentCardCount() == 5 && userTotal <= 21) {
					System.out.println("Five Card Charlie! You Win!\n");
					user.winMoney(DEFAULT_BET + amount);
					house.loseMoney(DEFAULT_BET + amount);
					break;
				}

				while (userTotal > 21 && user.hasAce() >= 0) {
					int temp = user.hasAce();
					user.getCard(temp).changeAceValue();
					userTotal -= 11;
					userTotal += user.getCard(temp).getValue();
				}

				if (userTotal > 21) {
					System.out.println("You have busted!\n");
					user.loseMoney(DEFAULT_BET + amount);
					house.winMoney(DEFAULT_BET + amount);
					break;
				}

				System.out.print("Would you like to hit(1) or stand(2): ");
				answer = kb.nextInt();

				while (answer != 1 && answer != 2) {
					System.out
							.print("Im sorry, that is an incorrect response, press 1 to hit, 2 to stand.");
					answer = kb.nextInt();
				}
			}

			/**
			 * If the user chose to stand, then it prints out the hands again,
			 * but this time it shows the house's second card. Then it checks to
			 * see if any Aces need their values changed, and does so if needed.
			 * Then it checks to see if the house has beaten the user, and if so
			 * it deals with the results of the bet. Then it checks to see if
			 * the houseTotal is 17 or above, since the house cannot hit if its
			 * total is 17 or above. If it's total is 17 or above, but not above
			 * userTotal, then the user wins and the bet is dealt with. If the
			 * houseTotal is less than 17, then it will run a while loop which
			 * will run until houseTotal is 17 or above. In the while loop, it
			 * will add a Card to house's hand, and then print out the new
			 * hands. Then it will check for a 5 card charlie, and if any Ace's
			 * value needs to be changed. After the houseTotal is 17 or over, it
			 * will exit the while loop and check to see if the house has either
			 * busted, beat the user, or lost to the user. Whatever the result,
			 * the bet is dealt with and the do loop is repeated.
			 */
			if (answer == 2) {
				System.out.println();
				house.printHand();
				System.out.println();
				user.printHand();

				while (houseTotal > 21 && house.hasAce() >= 0) {
					int temp = house.hasAce();
					house.getCard(temp).changeAceValue();
					houseTotal -= 11;
					houseTotal += house.getCard(temp).getValue();
				}

				if (houseTotal > userTotal) {
					System.out.println("You lose!\n");
					user.loseMoney(DEFAULT_BET + amount);
					house.winMoney(DEFAULT_BET + amount);
					continue;
				}

				if (houseTotal >= 17) {
					System.out.println("You win!\n");
					house.loseMoney(DEFAULT_BET + amount);
					user.winMoney(DEFAULT_BET + amount);
					continue;
				}

				while (houseTotal < 17) {
					house.addCard(deck.getCard(currentCardNumber++));
					houseTotal += house.getCard(currentHouseCardNumber++)
							.getValue();

					System.out.println();
					house.printHand();
					System.out.println();
					user.printHand();

					if (house.getCurrentCardCount() == 5 && houseTotal <= 21) {
						System.out.println("Five Card Charlie! You Lose.\n");
						house.winMoney(DEFAULT_BET + amount);
						user.loseMoney(DEFAULT_BET + amount);
						break;
					}

					while (houseTotal > 21 && house.hasAce() >= 0) {
						int temp = house.hasAce();
						house.getCard(temp).changeAceValue();
						houseTotal -= 11;
						houseTotal += house.getCard(temp).getValue();
					}

				}

				if (houseTotal > 21) {
					System.out.println("You win!\n");
					house.loseMoney(DEFAULT_BET + amount);
					user.winMoney(DEFAULT_BET + amount);
					continue;
				}

				if (houseTotal <= userTotal) {
					System.out.println("You win!\n");
					house.loseMoney(DEFAULT_BET + amount);
					user.winMoney(DEFAULT_BET + amount);
					continue;
				}

				if (houseTotal > userTotal) {
					System.out.println("You lose!\n");
					user.loseMoney(DEFAULT_BET + amount);
					house.winMoney(DEFAULT_BET + amount);
					continue;
				}
			}
		} while (true);

		/**
		 * Before the program is terminated, it displays a thanks for playing
		 * line.
		 */
		System.out.println("Thank you for playing Blackjack!");
	}
}
