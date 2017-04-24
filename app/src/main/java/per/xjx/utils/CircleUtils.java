package per.xjx.utils;

import java.util.Random;

import per.xjx.model.Circle;
import android.graphics.Color;

/**
 * 
 * Բ�����ӹ����ࣺ<br/>
 * 1.�ı����ӵ���ɫ<br/>
 * 2.�ı����ӵĴ�С<br/>
 * 3.�ı����ӵķ���
 * 
 * @author ������
 * 
 */
public class CircleUtils {
	
	/**
	 * �ı����ӵ���ɫ
	 */
	public static void changeColor(java.util.List<Circle> circles) {
		Random r = new Random();
		
		for (int i = -1; ++i < circles.size();) {
			// ���������ɫ
			int[] colors = new int[] {
					Color.WHITE,
					Color.argb(r.nextInt(256), r.nextInt(256), r.nextInt(256),
							r.nextInt(256)), Color.TRANSPARENT };
			circles.get(i).setColors(colors);
		}
	}

	/**
	 * �ı����ӵİ뾶
	 * 
	 * @param circles
	 */
	public static void changeRadius(java.util.List<Circle> circles) {
		Random r = new Random();
		
		for (int i = -1; ++i < circles.size();) {
			float radius = r.nextFloat() * 50 + 20;
			circles.get(i).setRadius(radius);
		}
	}

	/**
	 * �ı����ӵ��˶�����
	 * 
	 * @param circles
	 */
	public static void changeV(java.util.List<Circle> circles) {
		Random r = new Random();
		
		if (r.nextInt(2) == 0) { // ÿһ�����ӵ��˶��������
			for (int i = -1; ++i < circles.size();) {
				float vx = (float) (r.nextFloat() * 5 + 5);
				vx = r.nextInt(2) == 0 ? vx : -vx;
				float vy = (float) (r.nextFloat() * 5 + 5);
				vy = r.nextInt(2) == 0 ? vy : -vy;
				
				circles.get(i).setVx(vx);
				circles.get(i).setVy(vy);
			}
		} else {// ÿһ�����ӵ��˶�����һ��
			float vx = (float) (r.nextFloat() * 5 + 5);
			vx = r.nextInt(2) == 0 ? vx : -vx;
			float vy = (float) (r.nextFloat() * 5 + 5);
			vy = r.nextInt(2) == 0 ? vy : -vy;
			
			for (int i = -1; ++i < circles.size();) {
				circles.get(i).setVx(vx);
				circles.get(i).setVy(vy);
			}
		}
	}
}
