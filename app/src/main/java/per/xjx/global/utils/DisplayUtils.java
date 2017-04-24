package per.xjx.global.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * ��Ļ������ <br/>
 * ע�⣺ʹ��ǰ�������initDisplay()�����������ȡ������ȷ����ֵ��
 * <p/>
 * 1.��ȡ��Ļ�ĸ߶� <br/>
 * 2.��ȡ��Ļ�Ŀ��
 * 
 * @author ������
 * 
 */
public class DisplayUtils {
	private static int displayHeight = 0;
	private static int displayWidth = 0;

	private DisplayUtils() {

	}

	/**
	 * ��ʼ��
	 * <p/>
	 * ʹ�ô˹����࣬�����ȵ��ô˷���
	 * 
	 * @param applicationContext
	 *            Ӧ�ó���������Ķ���
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
	 * ȡ����Ļ�ĸ߶�
	 * 
	 * @return
	 */
	public static int getDisplayHeight() {
		return displayHeight;
	}

	/**
	 * ȡ����Ļ�ĸ߶�
	 * 
	 * @return
	 */
	public static int getDisplayWidth() {
		return displayWidth;
	}
}
