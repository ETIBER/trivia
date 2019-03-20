package com.adaptionsoft.games.uglytrivia.question;

public class Question {
    private final QuestionCategory category;
    private final int number;


    public Question(QuestionCategory category, int number) {
        this.category = category;
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("%s Question%d", this.category, this.number);
    }


    public QuestionCategory getCategory() {
        return this.category;
    }

    public int getNumber() {
        return number;
    }
}
