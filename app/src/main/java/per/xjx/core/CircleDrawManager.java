package per.xjx.core;

import java.util.List;
import java.util.Random;
import android.graphics.Color;
import per.xjx.global.utils.DisplayUtils;
import per.xjx.model.Circle;
import per.xjx.utils.CircleUtils;

public class CircleDrawManager {
	private List<Circle> circles = new java.util.ArrayList<Circle>();

	/**
	 * ����ָ������������
	 * 
	 * @param size
	 *            ���ӵ�����
	 * 
	 */
	public CircleDrawManager(int size) {
		addCircle(size);
	}

	/**
	 * �����̻��Բ
	 * 
	 * @param canvas
	 */
	public void drawContent(android.graphics.Canvas canvas) {
		for (int i = -1; ++i < circles.size();) {
			circles.get(i).drawSelf(canvas);
		}
	}

	/**
	 * �������
	 * 
	 * @param size
	 *            ���ӵ�����
	 */
	public void addCircle(int size) {
		// ���30������
		while (circles.size() < size) {
			Random r = new Random();

			float radius = r.nextFloat()
					* (DisplayUtils.getDisplayWidth() / 15) + 20;
			int[] colors = {
					Color.WHITE,
					Color.argb(r.nextInt(256), r.nextInt(256), r.nextInt(256),
							r.nextInt(256)), Color.TRANSPARENT };
			float cx = r.nextFloat() * DisplayUtils.getDisplayWidth();
			float cy = r.nextFloat() * DisplayUtils.getDisplayHeight();
			float vx = (float) (r.nextFloat() * 5 + 5);
			vx = r.nextInt(2) == 0 ? vx : -vx;
			float vy = (float) (r.nextFloat() * 5 + 5);
			vy = r.nextInt(2) == 0 ? vy : -vy;

			circles.add(new Circle(radius, colors, cx, cy, vx, vy));
		}
	}

	/**
	 * ȡ����������
	 */
	public int getSize() {
		return circles.size();
	}

	/**
	 * ȡ��ָ������������
	 * 
	 * @param index
	 *            ���ӵ�����(index < ��������)
	 * 
	 * @return ָ��λ�õ�����
	 */
	public Circle getCircle(int index) {
		return circles.get(index);
	}

	/**
	 * ȡ�����Ӽ���<br/>
	 * 
	 * @return ����һ���̶���С�����ɸı��List���ϡ�
	 */
	public List<Circle> getCircles() {
		return java.util.Arrays.asList(circles.toArray(new Circle[] {}));
	}
}
