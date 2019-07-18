package com.JJS.A1612.domain;

import java.io.IOException;

import org.itheima.game.utils.DrawUtils;

/**
 * 	草坪类。
 */
public class Grass extends Element{
	
	
	//构造方法
	public Grass(int x,int y) {
		super(x,y);
		try {
			int[] size=DrawUtils.getSize("res\\img\\grass.gif");
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
			DrawUtils.draw("res\\img\\grass.gif", this.x, this.y);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int getOrder() {
		return 1;
	}
}
