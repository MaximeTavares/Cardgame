package com.myprojects.cardgame.model;

public enum Suit {

    HEARTS (1),
    DIAMONDS (2),
    CLUBS (3),
    SPADES (4);

    int suit;
    
    private Suit(int value) {
        suit = value;
    }

    public int value() {
        return suit;
    }

}
