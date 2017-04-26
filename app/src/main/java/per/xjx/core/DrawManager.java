package per.xjx.core;

import java.util.List;
import java.util.Random;
import android.graphics.Color;

import per.xjx.global.Application;
import per.xjx.model.Circle;

public class DrawManager {
	private List<Circle> circles = new java.util.ArrayList<>();


	public DrawManager(int size) {
		addCircle(size);
	}

	public void drawContent(android.graphics.Canvas canvas) {
		for (int i = -1; ++i < circles.size();) {
			circles.get(i).drawSelf(canvas);
		}
	}


	public void addCircle(int size) {
		while (circles.size() < size) {
			Random r = new Random();

			float radius = r.nextFloat()
					* (Application.getInstance().getDisplayWidth() / 15) + 20;
			int[] colors = {
					Color.WHITE,
					Color.argb(r.nextInt(256), r.nextInt(256), r.nextInt(256),
							r.nextInt(256)), Color.TRANSPARENT };
			float cx = r.nextFloat() * Application.getInstance().getDisplayWidth();
			float cy = r.nextFloat() * Application.getInstance().getDisplayHeight();
			float vx = (r.nextFloat() * 5 + 5);
			vx = r.nextInt(2) == 0 ? vx : -vx;
			float vy = (r.nextFloat() * 5 + 5);
			vy = r.nextInt(2) == 0 ? vy : -vy;

			circles.add(new Circle(radius, colors, cx, cy, vx, vy));
		}
	}

	public int getSize() {
		return circles.size();
	}


	public Circle getCircle(int index) {
		return circles.get(index);
	}


	public List<Circle> getCircles() {
		return java.util.Arrays.asList(circles.toArray(new Circle[] {}));
	}
}
