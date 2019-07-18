package com.JJS;

import org.itheima.game.Window;
import org.lwjgl.input.Keyboard;

public class GameWindow extends Window{
	
	// 调用父类的带参构造方法
	public GameWindow(String title, int width, int height, int fps) {
		super(title, width, height, fps);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 窗体创建时执行，只执行一次。
	 */
	@Override
	protected void onCreate() {
		// TODO Auto-generated method stub
		System.out.println("窗体创建成功");
		
	}

	@Override
	protected void onMouseEvent(int key, int x, int y) {
		// TODO Auto-generated method stub
		/**
		 * 鼠标左右键
		 */
		if(key==0) {
			System.out.println("左键");
		}else if(key==1) {
			System.out.println("右键");
		}
	}
	
	/**
	 * 键盘键监听事件
	 */
	@Override
	protected void onKeyEvent(int key) {
		// TODO Auto-generated method stub
		if(key==Keyboard.KEY_UP) {
			System.out.println("上");
		}else if(key==Keyboard.KEY_DOWN) {
			System.out.println("下");
		}else if(key==Keyboard.KEY_LEFT) {
			System.out.println("左");
		}else if(key==Keyboard.KEY_RIGHT) {
			System.out.println("右");
		}else if(key==Keyboard.KEY_SPACE) {
			System.out.println("空格");
		}else if(key==Keyboard.KEY_RETURN) {
			System.out.println("回车键");
		}else {
			System.out.println("无用键");
		}
	}
	
	/**
	 * 实时刷新，这里相当于死循环，一直执行的代码。
	 * 很对显示屏都是以超过肉眼的速度处于刷新图片的状态。
	 */
	@Override
	protected void onDisplayUpdate() {
		//System.out.println("看看我执行了吗");
		
	}
	
}
