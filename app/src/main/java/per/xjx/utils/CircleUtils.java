package per.xjx.utils;

import java.util.Random;

import per.xjx.model.Circle;
import android.graphics.Color;

/**
 * 
 * 圆形粒子工具类：
 * 1.改变粒子的颜色
 * 2.改变粒子的大小
 * 3.改变粒子的方向
 * 
 * @author 冼嘉贤
 * 
 */
public class CircleUtils {
	
	/**
	 * 改变粒子的颜色
	 */
	public static void changeColor(java.util.List<Circle> circles) {
		Random r = new Random();
		
		for (int i = -1; ++i < circles.size();) {
			// 随机更换颜色
			int[] colors = new int[] {
					Color.WHITE,
					Color.argb(r.nextInt(256), r.nextInt(256), r.nextInt(256),
							r.nextInt(256)), Color.TRANSPARENT };
			circles.get(i).setColors(colors);
		}
	}

	/**
	 * 改变粒子的半径
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
	 * 改变粒子的运动方向
	 * 
	 * @param circles
	 */
	public static void changeDirection(java.util.List<Circle> circles) {
		Random r = new Random();
		
		if (r.nextInt(2) == 0) { // 每一个粒子的运动方向随机
			for (int i = -1; ++i < circles.size();) {
				float vx = (r.nextFloat() * 5 + 5);
				vx = r.nextInt(2) == 0 ? vx : -vx;
				float vy = (r.nextFloat() * 5 + 5);
				vy = r.nextInt(2) == 0 ? vy : -vy;
				
				circles.get(i).setVx(vx);
				circles.get(i).setVy(vy);
			}
		} else {// 每一个粒子的运动方向一致
			float vx = (r.nextFloat() * 5 + 5);
			vx = r.nextInt(2) == 0 ? vx : -vx;
			float vy = (r.nextFloat() * 5 + 5);
			vy = r.nextInt(2) == 0 ? vy : -vy;
			
			for (int i = -1; ++i < circles.size();) {
				circles.get(i).setVx(vx);
				circles.get(i).setVy(vy);
			}
		}
	}
}
