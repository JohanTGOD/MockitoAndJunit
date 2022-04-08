package com.johan.tesistingwithjava.player;

import java.util.Random;

public class Dice {

    private int side;

    public Dice(int side) {
        this.side = side;
    }

    protected int roll() {
        return new Random().nextInt(side)+1;
    }
}
