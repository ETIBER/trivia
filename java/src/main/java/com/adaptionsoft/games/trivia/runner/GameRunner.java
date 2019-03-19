
package com.adaptionsoft.games.trivia.runner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Player;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		Game aGame = new Game();

		List<Integer> rolls1 = new ArrayList<>();
		List<Integer> rolls2 = new ArrayList<>();

		aGame.add(new Player("Chet"));
		aGame.add(new Player("Pat"));
		aGame.add(new Player("Sue"));

		Random rand = new Random();

		do {

			int roll1 = rand.nextInt(5) + 1;
			rolls1.add(roll1);
			aGame.roll(roll1);

			int roll2 = rand.nextInt(9);
			rolls2.add(roll2);
			if (roll2 == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}



		} while (notAWinner);

		printRoll(rolls1);
		printRoll(rolls2);

	}

	private static void printRoll(List<Integer> rolls1) {
		String joined = rolls1
				.stream()
				.map(Object::toString)
				.collect(Collectors.joining(", "));

		System.out.println(joined);
	}
}
