package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.uglytrivia.question.QuestionCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BoardGenerator {

    public Board createBoard() {
        List<QuestionCategory> categoryList = new ArrayList<>();

        IntStream.range(0, 4).forEach(i -> {
            categoryList.add(QuestionCategory.POP);
            categoryList.add(QuestionCategory.SCIENCE);
            categoryList.add(QuestionCategory.SPORTS);
            categoryList.add(QuestionCategory.ROCK);
        });

        return new Board(categoryList);
    }
}
