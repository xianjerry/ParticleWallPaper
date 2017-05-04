package per.xjx.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;

import java.util.Random;

import per.xjx.global.Application;

/**
 * 圆
 * 
 */
public class Circle {

	private static final Paint paint = new Paint();
	// 半径
	private float radius = 50; 
	// 当前x坐标和y坐标
	private float cx = 0;
	private float cy = 0;
	// x坐标和y坐标的移动速度
	private float vx = 3;
	private float vy = 3;
	private int[] colors;
	// 环形渐变
	private RadialGradient mRadialGradient;

	public Circle(float radius, int[] colors, float cx, float cy, float vx,
			float vy) {
		super();

		this.radius = radius;
		this.cx = cx;
		this.cy = cy;
		this.colors = colors;
		this.vx = vx;
		this.vy = vy;

		mRadialGradient = new RadialGradient(cx, cy, radius, colors, null,
				android.graphics.Shader.TileMode.REPEAT);
		paint.setShader(mRadialGradient);
	}

	private boolean increment = true;
	private int pointSize = 0;

	public void drawSelf(Canvas canvas) {

		// 更新圆形渐变
		if(increment){
			pointSize++;
			if(pointSize >= radius){
				increment = false;
			}
		}else{
			pointSize--;
			if(pointSize <= 0){
				increment = true;
			}
		}

		mRadialGradient = new RadialGradient(cx, cy, pointSize, colors,
				new float[] { 0.05f, 0.4f, 1 },
				android.graphics.Shader.TileMode.CLAMP);
		paint.setShader(mRadialGradient);
		
		canvas.drawCircle(cx, cy, radius, paint);

		// 位置移动
		cx += vx;
		cy += vy;

		// 是否在屏幕外
		if (cx > Application.getInstance().getDisplayWidth()) {
			vx = -Math.abs(vx);
		}
		if (cx < 0) {
			vx = Math.abs(vx);
		}
		if (cy > Application.getInstance().getDisplayHeight()) {
			vy = -Math.abs(vy);
		}
		if (cy < 0) {
			vy = Math.abs(vy);
		}

	}


	public int[] getColors() {
		return colors;
	}

	public void setColors(int[] colors) {
		this.colors = colors;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public float getVx() {
		return vx;
	}

	public void setVx(float vx) {
		this.vx = vx;
	}

	public float getVy() {
		return vy;
	}

	public void setVy(float vy) {
		this.vy = vy;
	}

}
