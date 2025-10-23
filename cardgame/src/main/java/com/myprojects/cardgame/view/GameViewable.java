package com.myprojects.cardgame.view;

import com.myprojects.cardgame.controller.GameController;

public interface GameViewable {

    public void setController(GameController gc);

    public void promptForPlayerName();

    public void promptForFlip();

    public void promptForNewGame();

	public void showWinner(String name);

    public void showPlayerName(int playerIndex, String playerName);

	public void showFaceDownCardForPlayer(int playerIndex, String playerName);

    public void showCardForPlayer(int i, String playerName, String rank, String suit);

}
