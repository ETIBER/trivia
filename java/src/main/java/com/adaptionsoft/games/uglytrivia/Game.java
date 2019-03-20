package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.uglytrivia.player.Player;
import com.adaptionsoft.games.uglytrivia.player.Players;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {
	final Players players = new Players();

	int[] places = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

	public String getLogsAsString() {
		return logs.toString();
	}

	public List<String> logs;

	public  Game(){
		logs = new ArrayList<>();
    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast(new Question(QuestionType.POP, i));
			scienceQuestions.addLast(new Question(QuestionType.SCIENCE, i));
			sportsQuestions.addLast(new Question(QuestionType.SPORTS, i));
			rockQuestions.addLast(new Question(QuestionType.ROCK, i));
    	}
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
		if (currentCategory() == QuestionType.POP)
			System.out.println(popQuestions.removeFirst());
		if (currentCategory() == QuestionType.SCIENCE)
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory() == QuestionType.SPORTS)
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory() == QuestionType.ROCK)
			System.out.println(rockQuestions.removeFirst());
	}


	private QuestionType currentCategory() {
		if (places[currentPlayer] == 0) return QuestionType.POP;
		if (places[currentPlayer] == 4) return QuestionType.POP;
		if (places[currentPlayer] == 8) return QuestionType.POP;
		if (places[currentPlayer] == 1) return QuestionType.SCIENCE;
		if (places[currentPlayer] == 5) return QuestionType.SCIENCE;
		if (places[currentPlayer] == 9) return QuestionType.SCIENCE;
		if (places[currentPlayer] == 2) return QuestionType.SPORTS;
		if (places[currentPlayer] == 6) return QuestionType.SPORTS;
		if (places[currentPlayer] == 10) return QuestionType.SPORTS;
		return QuestionType.ROCK;
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
