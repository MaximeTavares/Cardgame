package com.myprojects.cardgame.model;

public class Player {

    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public void addCardToHand(PlayingCard card) {
        hand.addCard(card);
    }

    public PlayingCard removeCardFromHand() {
        return hand.removeCard();
    }

    public PlayingCard getCardFromHand(int index) {
        return hand.getCard(index);
    }

}
