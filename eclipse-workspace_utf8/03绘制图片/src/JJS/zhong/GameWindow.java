package JJS.zhong;

import java.io.IOException;

import org.itheima.game.Window;
import org.itheima.game.utils.DrawUtils;

public class GameWindow extends Window {
	/**
	 * 构造父类的带参函数
	 * @param title
	 * @param width
	 * @param height
	 * @param fps
	 */
	public GameWindow(String title, int width, int height, int fps) {
		super(title, width, height, fps);
	}
	/**
	 * 窗体创建是执行，只执行一次
	 */
	@Override
	protected void onCreate() {
		
	}
	/**
	 * 鼠标事件
	 */
	@Override
	protected void onMouseEvent(int key, int x, int y) {
		
	}
	/**
	 * 键盘事件
	 */
	@Override
	protected void onKeyEvent(int key) {
		
	}
	/**
	 * 屏幕的实时刷新
	 */
	@Override
	protected void onDisplayUpdate() {
		try {
			/**
			 * 后面的0,0是指图片的位置。
			 */
			DrawUtils.draw("res\\img\\01.jpg", 0, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
