package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.uglytrivia.player.Player;
import com.adaptionsoft.games.uglytrivia.player.Players;
import com.adaptionsoft.games.uglytrivia.question.QuestionCategory;
import com.adaptionsoft.games.uglytrivia.question.Deck;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private static final int NB_QUESTION = 50;
	private final Players players;

	private boolean isInitialized = false;

	private final Deck deck;
	private final DeckGenerator deckGenerator = new DeckGenerator(NB_QUESTION);

	private final Board board;
	private final BoardGenerator boardGenerator = new BoardGenerator();

	int[] places = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];

	int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;
	private PlayerPosition playersPosition;

	public String getLogsAsString() {
		return logs.toString();
	}

	public List<String> logs;

	public Game(){
		logs = new ArrayList<>();
		players = new Players();
		deck = deckGenerator.createDeck();
		board = boardGenerator.createBoard();
	}

	public boolean add(Player player) {
		players.addPlayer(player);

		places[players.getSize()] = 0;
		inPenaltyBox[players.getSize()] = false;

	    print(player.getName() + " was added");
		print("They are player number " + players.getSize());
		return true;
	}

	public void roll(int roll) {
		if (! isInitialized){
			playersPosition = new PlayerPosition(players.getPlayers());
		}
		print(players.getPlayers().get(currentPlayer).getName() + " is the current player");
		print("They have rolled a " + roll);

		if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;

				print(players.getPlayers().get(currentPlayer).getName() + " is getting out of the penalty box");
				places[currentPlayer] = places[currentPlayer] + roll;

				if (places[currentPlayer] > 11) {
					places[currentPlayer] = places[currentPlayer] - 12;
				}

				printPlayerLocation();
				askQuestion();
			} else {
				print(players.getPlayers().get(currentPlayer).getName() + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}

		} else {

			places[currentPlayer] = places[currentPlayer] + roll;

			if (places[currentPlayer] > 11) {
				places[currentPlayer] = places[currentPlayer] - 12;
			}

			printPlayerLocation();
			askQuestion();
		}

	}

	private void printPlayerLocation() {
		print(players.getPlayers().get(currentPlayer).getName()
				+ "'s new location is "
				+ places[currentPlayer]);
		print("The category is " + currentCategory().getValue());
	}

	private void askQuestion() {
		System.out.println(deck.getQuestionsByCategory(currentCategory()).removeFirst());
	}


	private QuestionCategory currentCategory() {
		return board.getCategoryAtPosition(places[currentPlayer]);
	}

	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]){
			if (isGettingOutOfPenaltyBox) {
				print("Answer was correct!!!!");
				return checkIfCurrentPlayerWon();
			} else {
				currentPlayer++;
				if (currentPlayer == players.getSize()) currentPlayer = 0;
				return true;
			}
		} else {

			print("Answer was corrent!!!!");
			return checkIfCurrentPlayerWon();
		}
	}

	private boolean checkIfCurrentPlayerWon() {
		players.getPlayers().get(currentPlayer).increasePurseBy1();
		printPlayerStats();

		boolean winner = didPlayerWin();
		currentPlayer++;
		if (currentPlayer == players.getSize()) currentPlayer = 0;

		return winner;
	}

	private void printPlayerStats() {
		print(players.getPlayers().get(currentPlayer).getName()
				+ " now has "
				+ players.getPlayers().get(currentPlayer).getPurse()
				+ " Gold Coins.");
	}

	public boolean wrongAnswer(){
		print("Question was incorrectly answered");
		print(players.getPlayers().get(currentPlayer).getName() + " was sent to the penalty box");
		inPenaltyBox[currentPlayer] = true;

		currentPlayer++;
		if (currentPlayer == players.getSize()) currentPlayer = 0;
		return true;
	}


	private boolean didPlayerWin() {
		return !(players.getPlayers().get(currentPlayer).getPurse() == 6);
	}

	private void print(String string) {
    	System.out.println(string);
    	logs.add(string);
	}
}
