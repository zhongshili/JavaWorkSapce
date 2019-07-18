package com.JJS.A1612.domain;

import java.io.IOException;

import org.itheima.game.utils.DrawUtils;

/**
 * 	砖墙类。
 */
public class Wall extends Element{
	/**
	 * 	属性：坐标,血量。
	 */
	private int blood;
	
	//构造方法
	public Wall(int x,int y) {
		super(x,y);
		try {
			int[] size=DrawUtils.getSize("res\\img\\wall.gif");
			this.width=size[0];
			this.height=size[1];
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 *	常用方法：画，挨打
	 */
	public void draw() {
		try {
			DrawUtils.draw("res\\img\\wall.gif", this.x, this.y);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
