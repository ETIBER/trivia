package com.adaptionsoft.games.uglytrivia;

public class Player {
    private final String name;
    private int purse;

    public Player(String name) {
        this.name = name;
        this.purse = 0;
    }

    public void increasePurseBy1() {
        this.purse += 1;
    }

    public String getName() {
        return name;
    }

    public int getPurse() {
        return purse;
    }
}
