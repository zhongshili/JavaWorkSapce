package JJS.zhong;

import java.io.IOException;

import org.itheima.game.Window;
import org.itheima.game.utils.DrawUtils;
import org.itheima.game.utils.SoundUtils;
import org.lwjgl.input.Keyboard;

public class GameWindow extends Window {
	//	如果用户按下的是回车键，就播放音乐，（false）设置了开始为播放状态。
	boolean flag = false; //true就是播放音乐，false就是停止播放
	public GameWindow(String title, int width, int height, int fps) {
		super(title, width, height, fps);
	}
//	创建窗体时执行，只执行一次
	@Override
	protected void onCreate() {
		try {
			SoundUtils.play("res\\snd\\start.wav", true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	鼠标事件
	@Override
	protected void onMouseEvent(int key, int x, int y) {
		
	}
//	键盘事件
	@Override
	protected void onKeyEvent(int key) {
		/**
		 * 如果用户按下回车键。
		 */
		if(key == Keyboard.KEY_RETURN) {
			if(flag) {
				try {
					SoundUtils.play("res\\snd\\start.wav", true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				flag = false;
			}else {
				SoundUtils.stop("res\\snd\\start.wav");
				flag = true;
			}
		}
	}
//	实时刷新
	@Override
	protected void onDisplayUpdate() {
		try {
			DrawUtils.draw("res\\img\\01.jpg", 0, 0);
			DrawUtils.draw("res\\img\\tank_u.gif", 100, 100);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
