package org.jonathany23.javatests.player;

public class Player {

    private Dice dice;
    private int minDiceNumberToWin;

    public Player(Dice dice, int minDiceNumberToWin) {
        this.dice = dice;
        this.minDiceNumberToWin = minDiceNumberToWin;
    }

    public boolean play(){
        int diceNumber = dice.roll();
        return diceNumber > minDiceNumberToWin;
    }
}
