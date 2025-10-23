package com.myprojects.cardgame;

import com.myprojects.cardgame.controller.GameController;
import com.myprojects.cardgame.model.Deck;
import com.myprojects.cardgame.view.View;

public class Main {
    public static void main(String[] args) {

        GameController controller = new GameController(new Deck(), new View());
        controller.run();
        
        
    }
}