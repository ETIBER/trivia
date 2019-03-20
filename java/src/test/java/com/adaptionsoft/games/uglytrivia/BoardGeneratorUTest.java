package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BoardGeneratorUTest {
    @Nested
    class Constructor {

    }

    @Nested
    class createBoard {
       @Test
       public void should_generateCustomBoard() {
           // Given
           String expectedBoard = "[POP, SCIENCE, SPORTS, ROCK, POP, SCIENCE, SPORTS, ROCK, POP, SCIENCE, SPORTS, ROCK, POP, SCIENCE, SPORTS, ROCK]";

           // When
           Board board = new BoardGenerator().createBoard();

           // Then
           assertThat(board.getPlaces().toString()).isEqualTo(expectedBoard);
       }
    }
}
