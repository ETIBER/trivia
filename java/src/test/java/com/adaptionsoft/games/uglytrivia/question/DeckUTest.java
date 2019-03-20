package com.adaptionsoft.games.uglytrivia.question;

import com.adaptionsoft.games.uglytrivia.DeckGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

class DeckUTest {

    private Deck deck;

    @Nested
    class getDeckByCategory {
        @ParameterizedTest(name = "Test category {0}")
        @EnumSource(QuestionCategory.class)
        void should_getRockQuestion_whenCategoryIsQuestion(QuestionCategory category) {
            // Given
            deck = new DeckGenerator(2).createDeck();

            // When
            LinkedList<Question> rockQuestion = deck.getQuestionsByCategory(category);

            // Then
            assertThat(rockQuestion).extracting(Question::getCategory).containsOnly((category));
        }
    }

}
