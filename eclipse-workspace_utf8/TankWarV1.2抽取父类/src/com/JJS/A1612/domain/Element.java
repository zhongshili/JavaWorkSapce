package com.JJS.A1612.domain;


/**
 * 	砖墙类。
 */
public abstract class Element {
	/**
	 * 	属性：坐标，宽高。
	 */
	protected int x;
	protected int y;
	protected int width;
	protected int height;	
	
	
	//空参构造
	public Element() {
		
	}
	
	
	//构造方法
	public Element(int x,int y) {
		this.x=x;
		this.y=y;
		
	}
	
	/**
	 *	常用方法：画
	 */
	public abstract void draw();
	/**
	 * 返回元素的渲染级别,渲染级别越大，越靠后绘制
	 */
	public int getOrder() {
		return 0;
	}
}
