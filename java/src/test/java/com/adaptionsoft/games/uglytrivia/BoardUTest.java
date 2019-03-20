package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.uglytrivia.question.QuestionCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class BoardUTest {
    @Nested
    class Constructor {
        @Test
        public void should_BindArrayOfPlaces() {
            // Given
            List<QuestionCategory> expectedPlaces = asList(QuestionCategory.POP);

            // When
            Board board = new Board(expectedPlaces);

            // Then
            assertThat(board.getPlaces()).isEqualTo(expectedPlaces);
        }
    }

    @Nested
    class getCategoryAtPosition {
        Board board;

        @BeforeEach
        void setUp() {
            board = new Board(asList(QuestionCategory.POP, QuestionCategory.POP, QuestionCategory.SCIENCE, QuestionCategory.SPORTS, QuestionCategory.ROCK));
        }

        @Test
        public void should_ReturnPopAtRelatedPosition() {
            // Given
            QuestionCategory expectedCategory = QuestionCategory.POP;
            int relatedPosition = 1;

            // When
            QuestionCategory category = board.getCategoryAtPosition(relatedPosition);

            // Then
            assertThat(category).isEqualTo(expectedCategory);
        }

        @Test
        public void should_ReturnRockAtRelatedPosition() {
            // Given
            QuestionCategory expectedCategory = QuestionCategory.ROCK;
            int relatedPosition = 4;

            // When
            QuestionCategory category = board.getCategoryAtPosition(relatedPosition);

            // Then
            assertThat(category).isEqualTo(expectedCategory);
        }
    }
}
