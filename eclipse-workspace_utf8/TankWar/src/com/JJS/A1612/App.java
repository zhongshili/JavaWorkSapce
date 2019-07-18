package com.JJS.A1612;

public class App {
	public static void main(String[] args) {
		/**
		 * 	作为程序入口
		 */
		GameWindow gm = new GameWindow(config.TITLE,config.WIDTH,config.HEIGHT,config.FPS);
		gm.start();
	}
}
