package com.myprojects.cardgame.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<PlayingCard> cards;

    public Hand() {
        cards = new ArrayList<PlayingCard>();
    }

    public void addCard(PlayingCard card) {
        cards.add(card);
    }

    public PlayingCard removeCard() {
        return cards.remove(0);
    }

    public PlayingCard getCard(int index) {
        return cards.get(index);
    }

}
