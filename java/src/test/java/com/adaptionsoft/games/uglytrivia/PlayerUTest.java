package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerUTest {
    @Nested
    class Constructor {
        @Test
        void shouldBindName() {
            // Given
            String expectedName = "Toto";

            // When
            Player player = new Player(expectedName);

            //Then
            assertThat(player.getName()).isEqualTo(expectedName);

        }

        @Test
        void should_setPurseTo0() {
            // Given
            int expectedPurseValue = 0;

            // When
            Player player = new Player("Toto");

            //Then
            assertThat(player.getPurse()).isEqualTo(expectedPurseValue);

        }
    }

    @Nested
    class increasePurseBy1 {
        @Test
        void should_increasePurseBy1() {
            // Given
            Player player = new Player("Toto");
            int expectedPurse = 1;

            // When
            player.increasePurseBy1();

            //Then
            assertThat(player.getPurse()).isEqualTo(expectedPurse);

        }
    }
}
