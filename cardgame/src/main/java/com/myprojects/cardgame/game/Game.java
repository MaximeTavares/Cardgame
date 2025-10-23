package com.myprojects.cardgame.game;

import com.myprojects.cardgame.controller.GameController;
import com.myprojects.cardgame.model.Deck;
import com.myprojects.cardgame.view.View;

public class Game {
    public static void main(String[] args) {

        GameController controller = new GameController(new Deck(), new View(), new HighCardGameEvaluator());
        controller.run();
        
        
    }
}