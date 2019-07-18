package org.itheima.game.business;

import com.JJS.A1612.domain.Blast;

/**
 * 具有挨打功能的事物
 * @author Administrator
 *
 */
public interface Hitable {
	/**
	 * 挨打后，返回一个爆炸物对象
	 */
	public abstract Blast showAttack();
}
