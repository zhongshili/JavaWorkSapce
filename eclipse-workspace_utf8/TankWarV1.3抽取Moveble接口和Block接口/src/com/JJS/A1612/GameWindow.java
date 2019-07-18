package com.JJS.A1612;

import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

import org.itheima.game.Window;
import org.itheima.game.business.Attackable;
import org.itheima.game.business.Blockable;
import org.itheima.game.business.Hitable;
import org.itheima.game.business.Moveable;
import org.lwjgl.input.Keyboard;

import com.JJS.A1612.domain.Blast;
import com.JJS.A1612.domain.Bullet;
import com.JJS.A1612.domain.Direction;
import com.JJS.A1612.domain.Element;
import com.JJS.A1612.domain.Grass;
import com.JJS.A1612.domain.MyTank;
import com.JJS.A1612.domain.Steel;
import com.JJS.A1612.domain.Wall;
import com.JJS.A1612.domain.Water;

public class GameWindow extends Window{
	/**
	 * 元素类
	 */
//	ArrayList<Element> list=new ArrayList<Element>();
	CopyOnWriteArrayList<Element> list=new CopyOnWriteArrayList<Element>();
	MyTank myTank;//自方坦克
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
		//	播放音乐
//		try {
//			SoundUtils.play("res\\snd\\start.wav", true);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		/**
		 * 添加普通墙
		 */
		for(int i=0;i<config.WIDTH/64-1;i++) {
			Wall wall= new Wall(64*i,64);
//			list.add(wall);
			addElement(wall);
		}
		/**
		 * 添加水墙
		 */
		for(int i=1;i<config.WIDTH/64;i++) {
			Water water= new Water(64 * i,64 *3);
//			list.add(water);
			addElement(water);
		}
		
		/**
		 * 添加铁墙
		 */
		for(int i=0;i<config.WIDTH/64-1;i++) {
			Steel steel= new Steel(64 * i,64 *5);
//			list.add(steel);
			addElement(steel);
		}
		
		/**
		 * 添加草坪
		 */
		for(int i=1;i<config.WIDTH/64;i++) {
			Grass grass= new Grass(64 * i,64 *7);
//			list.add(grass);
			addElement(grass);
		}
		
		/**
		 * 让坦克隐藏在草坪中
		 * 简单的算法：先绘制坦克，再绘制坦克，扩展性差
		 * 
		 * 推荐做法：Comparator比较接口实现
		 * 		每次集合中添加一个元素，就按照渲染级别进行排序
		 */
		
		myTank= new MyTank(config.WIDTH/2-32,64 * 8);
		//把坦克添加至集合中
//		list.add(myTank);
		addElement(myTank);
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
		switch (key) {
		case Keyboard.KEY_UP: //如果按下的是上键
		case Keyboard.KEY_W:
			myTank.move(Direction.UP);
			break;
		case Keyboard.KEY_S:
		case Keyboard.KEY_DOWN: //如果按下的是下键
			myTank.move(Direction.DOWN);
			break;
		case Keyboard.KEY_LEFT: //如果按下的是左键
		case Keyboard.KEY_A:
			myTank.move(Direction.LEFT);
			break;
		case Keyboard.KEY_RIGHT: //如果按下的是右键
		case Keyboard.KEY_D:
			myTank.move(Direction.RIGHT);
			break;
		case Keyboard.KEY_RETURN://按下回车键发射子弹
			Bullet shot=myTank.shot();
			if(shot!=null) {
//				list.add(shot);
				addElement(shot);
			}
			break;
		default:
			break;
		}
	}
	/**
	 * 	实时刷新屏幕
	 */
	@Override
	protected void onDisplayUpdate() {
		/**
		 * 绘制元素
		 */
		for(Element element:list) {
			element.draw();
		}
		/**
		 * 销毁出界子弹
		 */
		for(Element e:list) {
			// 遍历到的元素是子弹，就判断是否需要销毁
			if(e instanceof Bullet) {
				//	判断子弹是否需要销毁
				boolean flag = ((Bullet)e).isDestory();
				if(flag) {
					list.remove(e);
				}
				
			}
		}
		
		/**
		 *	 校验坦克有没有撞上
		 * 	 检验e1是具有移动功能的事物，并e2是具有阻挡功能的事物
		 * 	 有没有碰撞在一起
		 * alt+shift+R批量改名
		 */
		for(Element e1:list) {
			for(Element e2:list) {
				// 铁墙的检测
				if(e1 instanceof Moveable && e2 instanceof Blockable) {
					//调用MyTank#checkHit(),检测坦克和铁墙有没有碰上
					boolean flag = ((Moveable)e1).checkHit((Blockable)e2);
					// 如果碰上了，直接return即可
					if(flag) {
						break;
					}
				}
				
			}
		}
		
		
		/*
		 * 	校验子弹和铁墙是否碰撞上
		 * 检验具有攻击能力和打击能力的接口
		 */
		for(Element e1:list) {
			for(Element e2:list) {
				//如果e1是子弹，并且e2是铁墙，就校验他们是否有碰撞
				if(e1 instanceof Attackable && e2 instanceof Hitable) {
					//调用MyTank#checkHit(),检测坦克和铁墙有没有碰上
					boolean flag = ((Attackable)e1).checkAttack((Hitable)e2);
					// 如果碰上了，直接return即可
					if(flag) {
						//针对于子弹销毁
						list.remove(e1);
						
						//针对铁墙，给一个响应
						Blast blast = ((Hitable)e2).showAttack();
						addElement(blast);
						
					}
				}
			}
		}
		
//		System.out.println("元素数目："+list.size());
	}
	/**
	 * 往集合中添加元素，每添加一个元素，都升序排列
	 * @param e
	 */
	public void addElement(Element e) {
		list.add(e);
		list.sort(new Comparator<Element>() {

			@Override
			public int compare(Element e1, Element e2) {
				return e1.getOrder()-e2.getOrder();
			}
			
		});
		
	}
}
