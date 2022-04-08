package com.johan.tesistingwithjava.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void playerLoosesWhenIsTooLow() {
//        Dice dice = new Dice(6);
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4);
        Player player = new Player(dice,5);
        assertFalse(player.play());
    }

    @Test
    public void playerWinsWhenIsBigger() {
//        Dice dice = new Dice(6);
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(6);
        Player player = new Player(dice,5);
        assertTrue(player.play());
    }
}