package com.adaptionsoft.games.uglytrivia.question;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class Questions {

    private static final int NB_QUESTIONS = 50;
    private final LinkedList<Question> popQuestions;
    private final LinkedList<Question> scienceQuestions;
    private final LinkedList<Question> sportsQuestions;
    private final LinkedList<Question> rockQuestions;

    public Questions() {
        this.popQuestions = new LinkedList<Question>();
        this.scienceQuestions = new LinkedList<Question>();
        this.sportsQuestions = new LinkedList<Question>();
        this.rockQuestions = new LinkedList<>();
        initializeQuestions();
    }

    private void initializeQuestions() {
        IntStream.range(0, NB_QUESTIONS).forEachOrdered(i -> {
            popQuestions.addLast(new Question(QuestionCategory.POP, i));
            scienceQuestions.addLast(new Question(QuestionCategory.SCIENCE, i));
            sportsQuestions.addLast(new Question(QuestionCategory.SPORTS, i));
            rockQuestions.addLast(new Question(QuestionCategory.ROCK, i));
        });
    }

    public LinkedList<Question> getQuestionsByCategory(QuestionCategory category){
        switch (category){
            case POP:
                return popQuestions;
            case SCIENCE:
                return scienceQuestions;
            case SPORTS:
                return sportsQuestions;
            default:
                return rockQuestions;
        }
    }

    public LinkedList<Question> getPopQuestions() {
        return popQuestions;
    }

    public LinkedList<Question> getScienceQuestions() {
        return scienceQuestions;
    }

    public LinkedList<Question> getSportsQuestions() {
        return sportsQuestions;
    }

    public LinkedList<Question> getRockQuestions() {
        return rockQuestions;
    }
}
