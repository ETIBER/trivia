package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.uglytrivia.player.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerPosition {
    private final Map<Player, Integer> playerPosition;

    public PlayerPosition(List<Player> players) {
        this.playerPosition = new HashMap<>();
        players.forEach(player -> this.playerPosition.put(player, 0));
    }

    public int getPlayerPositionList(Player player) {
        return this.playerPosition.get(player);
    }

    public Map<Player, Integer> getPlayerPosition() {
        return playerPosition;
    }
}
