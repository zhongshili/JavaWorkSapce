package com.JJS.A1612.domain;

import java.io.IOException;

import org.itheima.game.utils.DrawUtils;

/**
 * 	铁墙类。
 */
public class Steel {
	/**
	 * 	属性：坐标，宽高，血量。
	 */
	private int x;
	private int y;
	private int width;
	private int height;
	private int blood;
	
	//构造方法
	public Steel(int x,int y) {
		this.x=x;
		this.y=y;
		try {
			int[] size=DrawUtils.getSize("res\\img\\steel.gif");
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
			DrawUtils.draw("res\\img\\steel.gif", this.x, this.y);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
