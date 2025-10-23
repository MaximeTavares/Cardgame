package com.myprojects.cardgame.view;

import java.util.Scanner;

import com.myprojects.cardgame.controller.GameController;

public class CommandLineView implements GameViewable {

	GameController controller;
	Scanner keyboard = new Scanner(System.in);

	public void setController(GameController gc) {
		this.controller = gc;
	}

	public void promptForPlayerName() {
		System.out.print("Enter player name (or 'start' to begin): ");
		String name = keyboard.nextLine();
		if (name.equalsIgnoreCase("start")) {
			controller.startGame();
		} else {
			controller.addPlayer(name);
		}
	}

	public void promptForFlip() {
		System.out.print("Press Enter to flip cards...");
		keyboard.nextLine();
		controller.flipCards();
	}

	public void promptForNewGame() {
		System.out.print("Play again? (y/n): ");
		String response = keyboard.nextLine();
		if (response.equalsIgnoreCase("y")) {
			controller.startGame();
		} else {
			controller.exitGame();
		}
	}

	public void showWinner(String name) {
		System.out.println("The winner is: " + name + "!");
	}

	public void showPlayerName(int playerIndex, String playerName) {
		System.out.println("Player " + playerIndex + " added: " + playerName);

	}

	public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
		System.out.println("Player " + playerIndex + " (" + playerName + ") has a face-down card.");
	}

	public void showCardForPlayer(int i, String playerName, String rank, String suit) {
		System.out.println("Player " + i + " (" + playerName + ") flips: [" + rank + "][" + suit + "]");
	};

}
