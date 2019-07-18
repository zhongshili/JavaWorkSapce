package com.JJS.A1612.domain;

import java.io.IOException;

import org.itheima.game.utils.DrawUtils;
import org.itheima.game.utils.SoundUtils;

import com.JJS.A1612.config;

/**
 * 子弹类
 * @author Administrator
 *
 */
public class Bullet extends Element{
	private Direction direction;//用来记录子弹的移动方向，应该和坦克的方向一致
	private int speed = 3; 
	public Bullet(MyTank myTank) {
		//	子弹的坐标是根据坦克的位置来计算的。
		//获取坦克的宽高、位置、和方向
		int myTankX = myTank.x;
		int myTankY = myTank.y;
		int myTankW = myTank.width;
		int myTankH = myTank.height;
		this.direction = myTank.getDirection();
		// 	获取子弹的宽高
		try {
			int[] size = DrawUtils.getSize("res\\img\\bullet_u.gif");
			width=size[0];
			height = size[1];
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		switch (direction) {
		case UP:
			x= Math.round(myTankX+(myTankW-width)/2.0F);
			y= Math.round(myTankY-height/2.0F);
			break;
		case DOWN:
			x= Math.round(myTankX+(myTankW-width)/2.0F);
			y= Math.round(myTankY+myTankH-height/2.0F);
			break;
		case LEFT:
			//x= Math.round(myTankX-width/2.0F);		// 这个是正确的算法，是图片素材有问题，我们把代码优化
			x= myTankX-width;
			y= Math.round(myTankY+(myTankH-height)/2.0F);
			break;
		case RIGHT:
			x= Math.round(myTankX+myTankW-width/2.0F);
			y= Math.round(myTankY+(myTankH-height)/2.0F);;
			break;

		default:
			break;
		}
		
		//播放声音
//		try {
//			SoundUtils.play("res\\snd\\fire.wav", false);
//			} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}

	@Override
	public void draw() {
		//	子弹的方向应该和坦克的方向一致
		String res = "";
		switch (direction) {
		case UP:
			res = "res\\img\\bullet_u.gif";
			y-=speed;
			break;
			
		case DOWN:
			res = "res\\img\\bullet_d.gif";
			y+=speed;
			break;
		case LEFT:
			res = "res\\img\\bullet_l.gif";
			x-=speed;
			break;
		case RIGHT:
			res = "res\\img\\bullet_r.gif";
			x+=speed;
			break;
		default:
			break;
		}
		
		
		try {
			DrawUtils.draw(res, x, y);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 判断子弹是否需要销毁
	 * @return
	 */
	public boolean isDestory() {
		//	判断子弹是否出界
		if(x<0-width||x>config.WIDTH||y<0-height||y>config.HEIGHT) {
			return true;
		}
		return false;
	}
	
}
