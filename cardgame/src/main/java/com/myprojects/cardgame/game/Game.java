package com.myprojects.cardgame.game;

import com.myprojects.cardgame.controller.GameController;
import com.myprojects.cardgame.model.Deck;
import com.myprojects.cardgame.view.CommandLineView;

public class Game {
    public static void main(String[] args) {

        GameController controller = new GameController(new Deck(), new CommandLineView(), new HighCardGameEvaluator());
        controller.run();
        
        
    }
}