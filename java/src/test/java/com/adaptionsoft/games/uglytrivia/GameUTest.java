package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.uglytrivia.player.Player;
import com.adaptionsoft.games.uglytrivia.question.Deck;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class GameUTest {

	@Nested
	public static class Caracterisation {
		private static final List<Integer> ROLLS_GAME_RUN_1 = asList(1, 5, 2, 2, 4, 3, 5, 1, 1, 3, 1, 1, 2, 1, 5, 4, 3, 5, 2, 1);

		private static final List<Integer> ROLLS_ANSWER_RUN_1 = asList(6, 2, 6, 7, 3, 3, 8, 8, 0, 6, 7, 7, 5, 0, 4, 3, 3, 2, 2, 0);

		private static final String EXPECTED_LOG_RUN_1 = "[Chet was added, They are player number 1, Pat was added, They are player number 2, Sue was added, They are player number 3, Chet is the current player, They have rolled a 1, Chet's new location is 1, The category is Science, Answer was corrent!!!!, Chet now has 1 Gold Coins., Pat is the current player, They have rolled a 5, Pat's new location is 5, The category is Science, Answer was corrent!!!!, Pat now has 1 Gold Coins., Sue is the current player, They have rolled a 2, Sue's new location is 2, The category is Sports, Answer was corrent!!!!, Sue now has 1 Gold Coins., Chet is the current player, They have rolled a 2, Chet's new location is 3, The category is Rock, Question was incorrectly answered, Chet was sent to the penalty box, Pat is the current player, They have rolled a 4, Pat's new location is 9, The category is Science, Answer was corrent!!!!, Pat now has 2 Gold Coins., Sue is the current player, They have rolled a 3, Sue's new location is 5, The category is Science, Answer was corrent!!!!, Sue now has 2 Gold Coins., Chet is the current player, They have rolled a 5, Chet is getting out of the penalty box, Chet's new location is 8, The category is Pop, Answer was correct!!!!, Chet now has 2 Gold Coins., Pat is the current player, They have rolled a 1, Pat's new location is 10, The category is Sports, Answer was corrent!!!!, Pat now has 3 Gold Coins., Sue is the current player, They have rolled a 1, Sue's new location is 6, The category is Sports, Answer was corrent!!!!, Sue now has 3 Gold Coins., Chet is the current player, They have rolled a 3, Chet is getting out of the penalty box, Chet's new location is 11, The category is Rock, Answer was correct!!!!, Chet now has 3 Gold Coins., Pat is the current player, They have rolled a 1, Pat's new location is 11, The category is Rock, Question was incorrectly answered, Pat was sent to the penalty box, Sue is the current player, They have rolled a 1, Sue's new location is 7, The category is Rock, Question was incorrectly answered, Sue was sent to the penalty box, Chet is the current player, They have rolled a 2, Chet is not getting out of the penalty box, Pat is the current player, They have rolled a 1, Pat is getting out of the penalty box, Pat's new location is 0, The category is Pop, Answer was correct!!!!, Pat now has 4 Gold Coins., Sue is the current player, They have rolled a 5, Sue is getting out of the penalty box, Sue's new location is 0, The category is Pop, Answer was correct!!!!, Sue now has 4 Gold Coins., Chet is the current player, They have rolled a 4, Chet is not getting out of the penalty box, Pat is the current player, They have rolled a 3, Pat is getting out of the penalty box, Pat's new location is 3, The category is Rock, Answer was correct!!!!, Pat now has 5 Gold Coins., Sue is the current player, They have rolled a 5, Sue is getting out of the penalty box, Sue's new location is 5, The category is Science, Answer was correct!!!!, Sue now has 5 Gold Coins., Chet is the current player, They have rolled a 2, Chet is not getting out of the penalty box, Pat is the current player, They have rolled a 1, Pat is getting out of the penalty box, Pat's new location is 4, The category is Pop, Answer was correct!!!!, Pat now has 6 Gold Coins.]";

		private static final List<Integer> ROLLS_GAME_RUN_2 = asList(3, 5, 1, 1, 1, 1, 4, 3, 4, 4, 4, 3, 1, 4, 1, 5, 1);

		private static final List<Integer> ROLLS_ANSWER_RUN_2 = asList(0, 0, 7, 4, 4, 3, 4, 1, 4, 7, 6, 2, 6, 4, 6, 8, 8);

		private static final String EXPECTED_LOG_RUN_2 = "[Chet was added, They are player number 1, Pat was added, They are player number 2, Sue was added, They are player number 3, Chet is the current player, They have rolled a 3, Chet's new location is 3, The category is Rock, Answer was corrent!!!!, Chet now has 1 Gold Coins., Pat is the current player, They have rolled a 5, Pat's new location is 5, The category is Science, Answer was corrent!!!!, Pat now has 1 Gold Coins., Sue is the current player, They have rolled a 1, Sue's new location is 1, The category is Science, Question was incorrectly answered, Sue was sent to the penalty box, Chet is the current player, They have rolled a 1, Chet's new location is 4, The category is Pop, Answer was corrent!!!!, Chet now has 2 Gold Coins., Pat is the current player, They have rolled a 1, Pat's new location is 6, The category is Sports, Answer was corrent!!!!, Pat now has 2 Gold Coins., Sue is the current player, They have rolled a 1, Sue is getting out of the penalty box, Sue's new location is 2, The category is Sports, Answer was correct!!!!, Sue now has 1 Gold Coins., Chet is the current player, They have rolled a 4, Chet's new location is 8, The category is Pop, Answer was corrent!!!!, Chet now has 3 Gold Coins., Pat is the current player, They have rolled a 3, Pat's new location is 9, The category is Science, Answer was corrent!!!!, Pat now has 3 Gold Coins., Sue is the current player, They have rolled a 4, Sue is not getting out of the penalty box, Chet is the current player, They have rolled a 4, Chet's new location is 0, The category is Pop, Question was incorrectly answered, Chet was sent to the penalty box, Pat is the current player, They have rolled a 4, Pat's new location is 1, The category is Science, Answer was corrent!!!!, Pat now has 4 Gold Coins., Sue is the current player, They have rolled a 3, Sue is getting out of the penalty box, Sue's new location is 5, The category is Science, Answer was correct!!!!, Sue now has 2 Gold Coins., Chet is the current player, They have rolled a 1, Chet is getting out of the penalty box, Chet's new location is 1, The category is Science, Answer was correct!!!!, Chet now has 4 Gold Coins., Pat is the current player, They have rolled a 4, Pat's new location is 5, The category is Science, Answer was corrent!!!!, Pat now has 5 Gold Coins., Sue is the current player, They have rolled a 1, Sue is getting out of the penalty box, Sue's new location is 6, The category is Sports, Answer was correct!!!!, Sue now has 3 Gold Coins., Chet is the current player, They have rolled a 5, Chet is getting out of the penalty box, Chet's new location is 6, The category is Sports, Answer was correct!!!!, Chet now has 5 Gold Coins., Pat is the current player, They have rolled a 1, Pat's new location is 6, The category is Sports, Answer was corrent!!!!, Pat now has 6 Gold Coins.]";

		@ParameterizedTest
		@MethodSource("argumentGoldenMaster")
		public void goldenMaster(List<Integer> rollsGame, List<Integer> rollsAnswer, String expectedResult) {
			// Given
			Game aGame = new Game();

			aGame.add(new Player("Chet"));
			aGame.add(new Player("Pat"));
			aGame.add(new Player("Sue"));

			// When
			for (int i = 0; i < rollsGame.size(); i++) {
				Integer rollGame = rollsGame.get(i);
				Integer rollAnswer = rollsAnswer.get(i);
				aGame.roll(rollGame);

				if (rollAnswer == 7) {
					aGame.wrongAnswer();
				} else {
					aGame.wasCorrectlyAnswered();
				}
			}

			// Then

			assertThat(aGame.getLogsAsString()).isEqualTo(expectedResult);

		}

		private static Stream<Arguments> argumentGoldenMaster() {
			return Stream.of(
					Arguments.of(ROLLS_GAME_RUN_1, ROLLS_ANSWER_RUN_1, EXPECTED_LOG_RUN_1),
					Arguments.of(ROLLS_GAME_RUN_2, ROLLS_ANSWER_RUN_2, EXPECTED_LOG_RUN_2)
			);
		}
	}

	@Nested
	public class UnitTest {
	}



}
