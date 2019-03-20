package com.adaptionsoft.games.uglytrivia.question;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QuestionUTest {
    @Nested
    class Constructor {
        @Test
        void should_BindQuestionType() {
            // Given
            QuestionCategory expectedQuestionCategory = QuestionCategory.ROCK;

            // When
            Question question = new Question(expectedQuestionCategory, 1);

            //Then
            assertThat(question.getCategory()).isEqualTo(expectedQuestionCategory);

        }

        @Test
        void should_BindQuestionNumber() {
            // Given
            int expectedNumber = 1;

            // When
            Question question = new Question(null, expectedNumber);

            //Then
            assertThat(question.getNumber()).isEqualTo(expectedNumber);

        }
    }

}
