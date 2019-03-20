package com.adaptionsoft.games.uglytrivia.player;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private List<Player> players;

    public Players() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public int getSize() {
        return this.players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
