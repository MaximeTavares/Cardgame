package com.myprojects.cardgame.controller;

import java.util.ArrayList;
import java.util.List;

import com.myprojects.cardgame.game.GameEvaluator;
import com.myprojects.cardgame.model.Deck;
import com.myprojects.cardgame.model.Player;
import com.myprojects.cardgame.model.PlayingCard;
import com.myprojects.cardgame.view.View;

public class GameController {

    enum GameState {
        ADDING_PLAYERS,
        CARDS_DISTRIBUTED,
        WINNER_REVEALED
    }

    Deck deck;
    List<Player> players;
    Player winner;
    View view;
    GameEvaluator evaluator;

    GameState gameState;

    public GameController(Deck deck, View view) {
        this.deck = deck;
        this.view = view;
        this.players = new ArrayList<Player>();
        this.gameState = GameState.ADDING_PLAYERS;
        this.evaluator = new GameEvaluator();
        view.setController(this);
    }

    public void run() {
        while (gameState == GameState.ADDING_PLAYERS) {
            view.promptForPlayerName();
        }
        switch (gameState) {
            case CARDS_DISTRIBUTED:
                view.promptForFlip();
                break;
            case WINNER_REVEALED:
                view.promptForNewGame();
            default:
                break;
        }
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
        view.showPlayerName(players.size(), name);
    }

    public void startGame() {
        if (gameState != GameState.CARDS_DISTRIBUTED) {
            deck.shuffle();
            int playerIndex = 1;
            for (Player player : players) {
                player.addCardToHand(deck.removeTopCard());
                view.showFaceDownCardForPlayer(playerIndex++, player.getName());
            }
            gameState = GameState.CARDS_DISTRIBUTED;
        }
        this.run();
    }

    public void flipCards() {
        int playerIndex = 1;
        for (Player player : players) {
            PlayingCard card = player.getCardFromHand(0);
            card.flip();
            view.showCardForPlayer(playerIndex++, player.getName(), card.getRank().toString(), card.getSuit().toString());
        }

        winner = evaluator.evaluateWinner(players);

        displayWinner();

        rebuiltDeck();

        gameState = GameState.WINNER_REVEALED;

        this.run();
    }

    void displayWinner() {
        view.showWinner(winner.getName());
    }

    void rebuiltDeck() {
        for (Player player : players) {
            deck.returnCardToDeck(player.removeCardFromHand());
        }
    }
}
