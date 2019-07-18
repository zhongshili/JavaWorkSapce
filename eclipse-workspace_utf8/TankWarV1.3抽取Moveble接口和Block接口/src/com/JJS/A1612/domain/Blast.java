package com.JJS.A1612.domain;

import java.io.IOException;

import org.itheima.game.business.Hitable;
import org.itheima.game.utils.DrawUtils;

public class Blast extends Element{
	//属性
	//记录的是爆炸物路径
	private String[] arr = { "res\\img\\blast_1.gif", "res\\img\\blast_2.gif", "res\\img\\blast_3.gif",
			"res\\img\\blast_4.gif", "res\\img\\blast_5.gif", "res\\img\\blast_6.gif", "res\\img\\blast_7.gif",
			"res\\img\\blast_8.gif" };
	//这里是记录索引，用来记录要绘制的图片号
	private int index = 0;
	//构造方法
	//这里爆炸物的坐标是根据铁墙的坐标生成的
	public Blast(Hitable hit) {
		Element element = (Element)hit;
		x = element.x;
		y = element.y;
	}
	
	
	@Override
	public void draw() {
		//获取绘制的图片。绘制完就下一张
		String res = arr[index++];
		if(index >= arr.length) {
			index = 0;
		}
		try {
			DrawUtils.draw(res, x, y);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
