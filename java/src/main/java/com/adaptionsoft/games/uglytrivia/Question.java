package com.adaptionsoft.games.uglytrivia;

public class Question {
    private final QuestionType type;
    private final int number;


    public Question(QuestionType type, int number) {
        this.type = type;
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("%s Question%d", this.type, this.number);
    }


    public QuestionType getType() {
        return this.type;
    }

    public int getNumber() {
        return number;
    }
}
