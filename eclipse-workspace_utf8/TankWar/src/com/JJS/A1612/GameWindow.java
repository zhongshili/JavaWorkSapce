package com.JJS.A1612;

import java.util.ArrayList;

import org.itheima.game.Window;

import com.JJS.A1612.domain.Grass;
import com.JJS.A1612.domain.Steel;
import com.JJS.A1612.domain.Wall;
import com.JJS.A1612.domain.Water;

public class GameWindow extends Window{
	/**
	 * 普通墙
	 */
	ArrayList<Wall> listWall=new ArrayList<Wall>();
	/**
	 * 水墙
	 */
	ArrayList<Water> listWater=new ArrayList<Water>();
	/**
	 * 铁墙
	 */
	ArrayList<Steel> listSteel=new ArrayList<Steel>();
	/**
	 * 草坪
	 */
	ArrayList<Grass> listGrass=new ArrayList<Grass>();
	/**
	 * 	窗口父类的构造方法
	 * @param title
	 * @param width
	 * @param height
	 * @param fps
	 */
	public GameWindow(String title, int width, int height, int fps) {
		super(title, width, height, fps);
	}
	
	/**
	 * 	创建窗口时执行的代码
	 */
	@Override
	protected void onCreate() {
		/**
		 * 添加普通墙
		 */
		for(int i=0;i<config.WIDTH/64-1;i++) {
			Wall wall= new Wall(64*i,64);
			listWall.add(wall);
		}
		/**
		 * 添加水墙
		 */
		for(int i=1;i<config.WIDTH/64;i++) {
			Water water= new Water(64 * i,64 *3);
			listWater.add(water);
		}
		
		/**
		 * 添加铁墙
		 */
		for(int i=0;i<config.WIDTH/64-1;i++) {
			Steel steel= new Steel(64 * i,64 *5);
			listSteel.add(steel);
		}
		
		/**
		 * 添加草坪
		 */
		for(int i=1;i<config.WIDTH/64;i++) {
			Grass grass= new Grass(64 * i,64 *7);
			listGrass.add(grass);
		}
		
	}
	/**
	 * 	鼠标监听
	 */
	@Override
	protected void onMouseEvent(int key, int x, int y) {
		
	}
	/**
	 *	键盘监听事件
	 */
	@Override
	protected void onKeyEvent(int key) {
		
	}
	/**
	 * 	实时刷新屏幕
	 */
	@Override
	protected void onDisplayUpdate() {
		/**
		 * 绘制普通墙
		 */
		for(Wall wall:listWall) {
			wall.draw();
		}
		/**
		 * 绘制水墙
		 */
		for(Water water:listWater) {
			water.draw();
		}
		
		/**
		 * 绘制铁墙
		 */
		for(Steel steel:listSteel) {
			steel.draw();
		}
		
		/**
		 * 绘制草坪
		 */
		for(Grass grass:listGrass) {
			grass.draw();
		}
		
	}

}
