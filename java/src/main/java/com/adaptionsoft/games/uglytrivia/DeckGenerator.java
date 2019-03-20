package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.uglytrivia.question.Deck;
import com.adaptionsoft.games.uglytrivia.question.Question;
import com.adaptionsoft.games.uglytrivia.question.QuestionCategory;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class DeckGenerator {
    private final int nb_question;

    public DeckGenerator(Integer nb_question) {
        this.nb_question = nb_question;
    }

    public Deck createDeck() {
        LinkedList<Question> popQuestions = new LinkedList<Question>();
        LinkedList<Question> scienceQuestions = new LinkedList<Question>();
        LinkedList<Question> sportsQuestions = new LinkedList<Question>();
        LinkedList<Question> rockQuestions = new LinkedList<Question>();
        IntStream.range(0, this.nb_question).forEachOrdered(i -> {
            popQuestions.addLast(new Question(QuestionCategory.POP, i));
            scienceQuestions.addLast(new Question(QuestionCategory.SCIENCE, i));
            sportsQuestions.addLast(new Question(QuestionCategory.SPORTS, i));
            rockQuestions.addLast(new Question(QuestionCategory.ROCK, i));
        });
        return new Deck(popQuestions, scienceQuestions, sportsQuestions, rockQuestions);
    }
}
