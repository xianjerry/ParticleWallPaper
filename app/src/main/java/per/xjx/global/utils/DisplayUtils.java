package per.xjx.global.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * 屏幕工具类 <br/>
 * 注意：使用前必须调用initDisplay()方法，否则获取不到正确的数值。
 * <p/>
 * 1.获取屏幕的高度 <br/>
 * 2.获取屏幕的宽度
 * 
 * @author 冼嘉贤
 * 
 */
public class DisplayUtils {
	private static int displayHeight = 0;
	private static int displayWidth = 0;

	private DisplayUtils() {

	}

	/**
	 * 初始化
	 * <p/>
	 * 使用此工具类，必须先调用此方法
	 * 
	 * @param applicationContext
	 *            应用程序的上下文对象
	 */
	public static void initDisplay(Context applicationContext) {
		if (applicationContext != null) {
			DisplayMetrics dm = applicationContext.getResources()
					.getDisplayMetrics();
			displayHeight = dm.heightPixels;
			displayWidth = dm.widthPixels;
		} else {
			throw new NullPointerException(
					"NullPointer in DisplayUtils.initDisplay(), applicationContext params can't be null");
		}
	}

	/**
	 * 取得屏幕的高度
	 * 
	 * @return
	 */
	public static int getDisplayHeight() {
		return displayHeight;
	}

	/**
	 * 取得屏幕的高度
	 * 
	 * @return
	 */
	public static int getDisplayWidth() {
		return displayWidth;
	}
}
