package per.xjx.model;

import per.xjx.global.utils.DisplayUtils;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;

/**
 * Բ
 * 
 */
public class Circle {

	private static final Paint paint = new Paint();
	// �뾶
	private float radius = 50; 
	// ��ǰx�����y����
	private float cx = 0;
	private float cy = 0;
	// x�����y������ƶ��ٶ�
	private float vx = 3;
	private float vy = 3;
	private int[] colors;
	// ���ν���
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

	public void drawSelf(Canvas canvas) {

		// ����Բ�ν���
		mRadialGradient = new RadialGradient(cx, cy, radius, colors,
				new float[] { 0.05f, 0.4f, 1 },
				android.graphics.Shader.TileMode.CLAMP);
		paint.setShader(mRadialGradient);
		
		canvas.drawCircle(cx, cy, radius, paint);

		// λ���ƶ�
		cx += vx;
		cy += vy;

		// �Ƿ�����Ļ��
		if (cx > DisplayUtils.getDisplayWidth()) {
			vx = -Math.abs(vx);
		}
		if (cx < 0) {
			vx = Math.abs(vx);
		}
		if (cy > DisplayUtils.getDisplayHeight()) {
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
