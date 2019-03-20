package com.adaptionsoft.games.uglytrivia.question;

import java.util.LinkedList;

public class Deck {

    private final LinkedList<Question> popQuestions;
    private final LinkedList<Question> scienceQuestions;
    private final LinkedList<Question> sportsQuestions;
    private final LinkedList<Question> rockQuestions;

    public Deck(LinkedList<Question> popQuestions, LinkedList<Question> scienceQuestions, LinkedList<Question> sportsQuestions, LinkedList<Question> rockQuestions) {
        this.popQuestions = popQuestions;
        this.scienceQuestions = scienceQuestions;
        this.sportsQuestions = sportsQuestions;
        this.rockQuestions = rockQuestions;
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
