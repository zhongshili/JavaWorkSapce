package org.itheima.game.business;

public interface Attackable {
	/**
	 * 校验具有攻击能力的事物是否与具有挨打能力的事物是否碰到一起
	 */
	public abstract boolean checkAttack(Hitable hit);
}
