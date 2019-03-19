package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList();

    int[] places = new int[6];
    int[] purses  = new int[6];
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


	    players.add(player);

	    places[howManyPlayers()] = 0;
	    purses[howManyPlayers()] = 0;
	    inPenaltyBox[howManyPlayers()] = false;

	    print(player.getName() + " was added");
	    print("They are player number " + players.size());
		return true;
	}

	public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll) {
		print(players.get(currentPlayer).getName() + " is the current player");
		print("They have rolled a " + roll);

		if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;

				print(players.get(currentPlayer).getName() + " is getting out of the penalty box");
				places[currentPlayer] = places[currentPlayer] + roll;
				if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

				print(players.get(currentPlayer).getName()
						+ "'s new location is "
						+ places[currentPlayer]);
				print("The category is " + currentCategory());
				askQuestion();
			} else {
				print(players.get(currentPlayer).getName() + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}

		} else {

			places[currentPlayer] = places[currentPlayer] + roll;
			if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

			print(players.get(currentPlayer).getName()
					+ "'s new location is "
					+ places[currentPlayer]);
			print("The category is " + currentCategory());
			askQuestion();
		}

	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			System.out.println(popQuestions.removeFirst());
		if (currentCategory() == "Science")
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			System.out.println(rockQuestions.removeFirst());
	}


	private String currentCategory() {
		if (places[currentPlayer] == 0) return "Pop";
		if (places[currentPlayer] == 4) return "Pop";
		if (places[currentPlayer] == 8) return "Pop";
		if (places[currentPlayer] == 1) return "Science";
		if (places[currentPlayer] == 5) return "Science";
		if (places[currentPlayer] == 9) return "Science";
		if (places[currentPlayer] == 2) return "Sports";
		if (places[currentPlayer] == 6) return "Sports";
		if (places[currentPlayer] == 10) return "Sports";
		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]){
			if (isGettingOutOfPenaltyBox) {
				print("Answer was correct!!!!");
				return checkIfCurrentPlayerWon();
			} else {
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				return true;
			}
		} else {

			print("Answer was corrent!!!!");
			return checkIfCurrentPlayerWon();
		}
	}

	private boolean checkIfCurrentPlayerWon() {
		purses[currentPlayer]++;
		printPlayerStats();

		boolean winner = didPlayerWin();
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;

		return winner;
	}

	private void printPlayerStats() {
		print(players.get(currentPlayer).getName()
				+ " now has "
				+ purses[currentPlayer]
				+ " Gold Coins.");
	}

	public boolean wrongAnswer(){
		print("Question was incorrectly answered");
		print(players.get(currentPlayer).getName() + " was sent to the penalty box");
		inPenaltyBox[currentPlayer] = true;

		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
		return true;
	}


	private boolean didPlayerWin() {
		return !(purses[currentPlayer] == 6);
	}

	private void print(String string) {
    	System.out.println(string);
    	logs.add(string);
	}
}
