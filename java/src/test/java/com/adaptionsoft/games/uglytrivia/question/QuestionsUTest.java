package com.adaptionsoft.games.uglytrivia.question;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

class QuestionsUTest {

    @Nested
    class constructor {
        @Test
        void should_initializePopQuestions() {
            // Given

            // When
            Questions questions = new Questions();

            //Then
            assertThat(questions.getPopQuestions().toString()).isEqualTo("[POP Question0, POP Question1, POP Question2, POP Question3, POP Question4, POP Question5, POP Question6, POP Question7, POP Question8, POP Question9, POP Question10, POP Question11, POP Question12, POP Question13, POP Question14, POP Question15, POP Question16, POP Question17, POP Question18, POP Question19, POP Question20, POP Question21, POP Question22, POP Question23, POP Question24, POP Question25, POP Question26, POP Question27, POP Question28, POP Question29, POP Question30, POP Question31, POP Question32, POP Question33, POP Question34, POP Question35, POP Question36, POP Question37, POP Question38, POP Question39, POP Question40, POP Question41, POP Question42, POP Question43, POP Question44, POP Question45, POP Question46, POP Question47, POP Question48, POP Question49]");
        }

        @Test
        void should_initializeScienceQuestions() {
            // Given

            // When
            Questions questions = new Questions();

            //Then
            assertThat(questions.getScienceQuestions().toString()).isEqualTo("[SCIENCE Question0, SCIENCE Question1, SCIENCE Question2, SCIENCE Question3, SCIENCE Question4, SCIENCE Question5, SCIENCE Question6, SCIENCE Question7, SCIENCE Question8, SCIENCE Question9, SCIENCE Question10, SCIENCE Question11, SCIENCE Question12, SCIENCE Question13, SCIENCE Question14, SCIENCE Question15, SCIENCE Question16, SCIENCE Question17, SCIENCE Question18, SCIENCE Question19, SCIENCE Question20, SCIENCE Question21, SCIENCE Question22, SCIENCE Question23, SCIENCE Question24, SCIENCE Question25, SCIENCE Question26, SCIENCE Question27, SCIENCE Question28, SCIENCE Question29, SCIENCE Question30, SCIENCE Question31, SCIENCE Question32, SCIENCE Question33, SCIENCE Question34, SCIENCE Question35, SCIENCE Question36, SCIENCE Question37, SCIENCE Question38, SCIENCE Question39, SCIENCE Question40, SCIENCE Question41, SCIENCE Question42, SCIENCE Question43, SCIENCE Question44, SCIENCE Question45, SCIENCE Question46, SCIENCE Question47, SCIENCE Question48, SCIENCE Question49]");
        }

        @Test
        void should_initializeSportQuestions() {
            // Given

            // When
            Questions questions = new Questions();

            //Then
            assertThat(questions.getSportsQuestions().toString()).isEqualTo("[SPORTS Question0, SPORTS Question1, SPORTS Question2, SPORTS Question3, SPORTS Question4, SPORTS Question5, SPORTS Question6, SPORTS Question7, SPORTS Question8, SPORTS Question9, SPORTS Question10, SPORTS Question11, SPORTS Question12, SPORTS Question13, SPORTS Question14, SPORTS Question15, SPORTS Question16, SPORTS Question17, SPORTS Question18, SPORTS Question19, SPORTS Question20, SPORTS Question21, SPORTS Question22, SPORTS Question23, SPORTS Question24, SPORTS Question25, SPORTS Question26, SPORTS Question27, SPORTS Question28, SPORTS Question29, SPORTS Question30, SPORTS Question31, SPORTS Question32, SPORTS Question33, SPORTS Question34, SPORTS Question35, SPORTS Question36, SPORTS Question37, SPORTS Question38, SPORTS Question39, SPORTS Question40, SPORTS Question41, SPORTS Question42, SPORTS Question43, SPORTS Question44, SPORTS Question45, SPORTS Question46, SPORTS Question47, SPORTS Question48, SPORTS Question49]");
        }

        @Test
        void should_initializeRockQuestions() {
            // Given

            // When
            Questions questions = new Questions();

            //Then
            assertThat(questions.getRockQuestions().toString()).isEqualTo("[ROCK Question0, ROCK Question1, ROCK Question2, ROCK Question3, ROCK Question4, ROCK Question5, ROCK Question6, ROCK Question7, ROCK Question8, ROCK Question9, ROCK Question10, ROCK Question11, ROCK Question12, ROCK Question13, ROCK Question14, ROCK Question15, ROCK Question16, ROCK Question17, ROCK Question18, ROCK Question19, ROCK Question20, ROCK Question21, ROCK Question22, ROCK Question23, ROCK Question24, ROCK Question25, ROCK Question26, ROCK Question27, ROCK Question28, ROCK Question29, ROCK Question30, ROCK Question31, ROCK Question32, ROCK Question33, ROCK Question34, ROCK Question35, ROCK Question36, ROCK Question37, ROCK Question38, ROCK Question39, ROCK Question40, ROCK Question41, ROCK Question42, ROCK Question43, ROCK Question44, ROCK Question45, ROCK Question46, ROCK Question47, ROCK Question48, ROCK Question49]");
        }
    }

    @Nested
    class getQuestionsByCategory {
        @ParameterizedTest(name = "Test category {0}")
        @EnumSource(QuestionCategory.class)
        void should_getRockQuestion_whenCategoryIsQuestion(QuestionCategory category) {
            // Given
            Questions questions = new Questions();

            // When
            LinkedList<Question> rockQuestion = questions.getQuestionsByCategory(category);

            // Then
            assertThat(rockQuestion).extracting("category").containsOnly((category));
        }
    }

}
