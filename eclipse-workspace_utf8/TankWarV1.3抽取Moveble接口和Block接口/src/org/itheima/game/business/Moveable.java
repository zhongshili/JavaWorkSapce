package org.itheima.game.business;

/**
 * 	具有移动工能的事物体
 * @author Administrator
 *
 */
public interface Moveable {
	//校验具有移动功能和阻挡功能的物体，判断有没有碰上
	public abstract boolean checkHit(Blockable block);
}
