package com.adaptionsoft.games.uglytrivia.question;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QuestionCategoryUTest {
    @Nested
    class constructor {
        @Test
        void should_bindValue() {
            // Given
            String expectedValue = "Pop";

            // When
            QuestionCategory questionCategory = QuestionCategory.POP;

            //Then
            assertThat(questionCategory.getValue()).isEqualTo(expectedValue);
        }
    }

}
