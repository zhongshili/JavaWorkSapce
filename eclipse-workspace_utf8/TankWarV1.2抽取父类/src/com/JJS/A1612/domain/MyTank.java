package com.JJS.A1612.domain;

import java.io.IOException;

import org.itheima.game.utils.CollsionUtils;
import org.itheima.game.utils.DrawUtils;
import org.itheima.game.utils.SoundUtils;
import org.lwjgl.input.Keyboard;

import com.JJS.A1612.config;

/**
 * 自方坦克
 */
public class MyTank extends Element{
	//1、血量
	private int blood;
	//2、攻击力
	private int power;
	//3、移动方向
	private Direction direction =Direction.UP; //要有初始值
	//4、移动速度
	private int speed = 16;
	//5、用来计算最后一颗子弹发射的是时间
	private long lastShotTime;
	//6、用来记录坦克不能移动的方向
	private Direction badDirection;
	//7、用来棘突坦克移动的最小间隙
	private int badSpeed;
	
	public MyTank(int x, int y) {
		super(x, y);
		try {
			int[] size=DrawUtils.getSize("res\\img\\tank_u.gif");
			width=size[0];
			height=size[1];
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	@Override
	public void draw() {
		// 加入坦克的炮口方向
		String res = "";
		switch (direction) {
		case UP:
			res = "res\\img\\tank_u.gif";
			break;
			
		case DOWN:
			res = "res\\img\\tank_d.gif";
			break;
		case LEFT:
			res = "res\\img\\tank_l.gif";
			break;
		case RIGHT:
			res = "res\\img\\tank_r.gif";
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
	 * 坦克的移动方向
	 * @param direction
	 */
	public void move(Direction direction) {
		//	如果坦克不能移动的方向和传入的方向一致，则就return，提示不能移动
		if(badDirection !=null&&badDirection ==direction ) {
			System.out.println("不能移动");
			// 让坦克移动最小间隙
			switch (direction) {
			case UP:
				y -= badSpeed;
				break;
			case DOWN:
				y += badSpeed;	
				break;
			case LEFT:
				x -= badSpeed;
				break;
			case RIGHT:
				x += badSpeed;
				break;
			default:
				break;
			}
			return;
		}
		//	如果传过来的方向和坦克的方向不一致，就把穿过来的方向赋值给坦克方向，然后return
		if(this.direction !=direction) {
			this.direction = direction;
			return;
		}
		switch (direction) {
		case UP:
			y -= speed;
			break;
		case DOWN:
			y += speed;	
			break;
		case LEFT:
			x -= speed;
			break;
		case RIGHT:
			x += speed;
			break;
		default:
			break;
		}
		
		//越界处理
		if(x<0) {//往左不能越界
			x=0;
		}
		if(y<0) {//往上不能出界
			y=0;
		}
		if(x>config.WIDTH-64) {//往右不能出界
			x=config.WIDTH-64;
		}
		if(y>config.HEIGHT-64) {//往下不能出界
			y=config.HEIGHT-64;
		}
	}
	
	/**
	 * 坦克发射子弹，子弹对象
	 * @return
	 */
	public Bullet shot() {
		//	this代表当前类
		// 如果最后一颗子弹发射的时间，和现在要发射的时间间隔小于400毫秒就不发射
		long nowTime = System.currentTimeMillis();
		if(nowTime-lastShotTime<400) {
			return null;
		}
		//lastShotTime变量重置.
		lastShotTime = nowTime;
		
		return new Bullet(this);
	}
	
	/**
	 * 检查坦克是否碰上
	 * 1、Steel 校验具有移动功能和阻挡功能的物体。
	 * 2、ture:碰上，false:没有碰上
	 * @return
	 */
	public boolean checkHit(Steel steel) {
		//获取铁墙的坐标和宽高
		int x1 = steel.x;
		int y1 = steel.y;
		int w1 = steel.width;
		int h1 = steel.height;
		
		//预判坦克的下一步坐标
		int x2 = x;
		int y2 = y;
		switch (direction) {
		case UP:
			y2 -= speed;
			break;
		case DOWN:
			y2 += speed;	
			break;
		case LEFT:
			x2 -= speed;
			break;
		case RIGHT:
			x2 += speed;
			break;
		default:
			break;
		}
		//通过工具类collisionUtils工具类校验,一定要预判坦克 的下一步坐标，然后预判后的坐标去校验。
		boolean flag = CollsionUtils.isCollsionWithRect(x1, y1, w1, h1, x2 , y2, width, height );
		// 如果碰上了，使用badDirection变量记录不能走的方向
		if(flag) {
			// 获取坦克不能移动 的方向，和最小间隙值
			badDirection = direction;
			//  一定要主要，最小间隙是通过当前的坐标计算的，千万不要用预判的坐标计算
			switch (direction) {
			case UP:
				badSpeed = y - y1- h1;//坦克的y坐标减去铁墙的y轴-铁墙的高度
				break;
			case DOWN:
				badSpeed = y1 - y- height;//铁墙 的y轴-坦克 的y轴-坦克的高度
				break;
			case LEFT:
				badSpeed = x - x1-w1;//坦克的x轴-铁墙 的x轴-铁墙的宽度
				break;
			case RIGHT:
				badSpeed = x1 -x-width;	//铁墙 的x轴-坦克 的x轴-坦克的宽度
				break;
			default:
				break;
			}
		}else {
			//说明没有撞上，需要将badDirection和badSpeed就进行重置
			badDirection = null;
			badSpeed = 0;
		}
		
		return flag;
	}
}
