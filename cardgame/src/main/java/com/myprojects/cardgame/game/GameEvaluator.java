package com.myprojects.cardgame.game;

import java.util.List;

import com.myprojects.cardgame.model.Player;

public interface GameEvaluator {

    public Player evaluateWinner(List<Player> players);

}
