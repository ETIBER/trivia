package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.uglytrivia.question.QuestionCategory;

import java.util.List;

public class Board {
    private final List<QuestionCategory> places;

    public Board(List<QuestionCategory> places) {
        this.places = places;
    }

    public List<QuestionCategory> getPlaces() {
        return places;
    }

    public QuestionCategory getCategoryAtPosition(int relatedPosition) {
        return this.places.get(relatedPosition);
    }
}
