package com.gameprojekt.gottfried.controler;

import java.util.Random;

public class Simulator {

	public static void main(String[] args) {
		MainControler simulation = new MainControler();
		simulation.getModel().startNewGameAction();
		simulation.getModel().winAction();

		Random zufallsgenerator = new Random();

		for (int i = 0; i < 200000; i++) {
			int zahl = zufallsgenerator.nextInt(1001);
			if (zahl <= 510) {
				simulation.getModel().looseAction();
			}
			if (zahl >= 511) {
				simulation.getModel().winAction();
			}
		}

	}
}
