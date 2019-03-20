package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.uglytrivia.player.Player;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class PlayerPositionUTest {

    @Nested
    class Constructor {
        @Test
        public void should_MapPlayersToInitialPosition() {
            // Given
            int expectedPosition = 0;
            Player player = mock(Player.class);

            // When
            PlayerPosition playerPosition = new PlayerPosition(asList(player));

            // Then
            assertThat(playerPosition.getPlayerPosition().get(player)).isEqualTo(expectedPosition);
        }
    }

    @Nested
    class getPlayerPositionList {
        @Test
        public void should_ReturnPlayerRelatedPosition() {
            // Given
            int expectedPosition = 0;
            Player player = mock(Player.class);
            PlayerPosition playerPosition = new PlayerPosition(asList(player));

            // When
            int playerPositionList = playerPosition.getPlayerPositionList(player);

            // Then
            assertThat(playerPositionList).isEqualTo(expectedPosition);
        }
    }

}
