package com.JJS;

public class App {
	/**
	 * 因为这个地方涉及到需要用什么系统运行（natives中），所以不能直接使用运行，需点击运行配置。
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 作为游戏的入口
		 * 
		 * 每秒钟刷新的帧率
		 */
		GameWindow gw = new GameWindow("第一个窗口",800,600,50);
		gw.start();//开始游戏
	}
}
