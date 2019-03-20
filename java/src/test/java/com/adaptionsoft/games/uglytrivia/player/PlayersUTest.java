package com.adaptionsoft.games.uglytrivia.player;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class PlayersUTest {
    @Nested
    class Constructor {
        @Test
        void should_initializePlayers() {
            // Given

            // When
            Players players = new Players();

            //Then
            assertThat(players.getPlayers()).isNotNull();
        }
    }

    @Nested
    class addPlayer {
        @Test
        void should_addGivenPlayerToPlayerList() {
            // Given
            Player expectedPlayer = new Player("Bob");
            Players players = new Players();

            // When
            players.addPlayer(expectedPlayer);

            //Then
            assertThat(players.getPlayers()).contains(expectedPlayer);
        }
    }

    @Nested
    class getSize {
        @Test
        void should_returnCurrentSize() {
            // Given
            int expectedSize = 1;
            Player player = mock(Player.class);
            Players players = new Players();
            players.getPlayers().add(player);

            // When
            int size = players.getSize();

            //Then
            assertThat(size).isEqualTo(expectedSize);
        }
    }
}
