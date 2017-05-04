package per.xjx.core;

import android.util.Log;
import android.widget.Toast;

import per.xjx.global.Application;
import per.xjx.utils.CircleUtils;

public class DrawCore extends Thread {

	private boolean stop = false;
	
	private android.view.SurfaceHolder holder;
	private float rotate = 0;
	
	private DrawManager circleManager;

	public DrawCore(android.view.SurfaceHolder holder, DrawManager drawManager) {
		this.holder = holder;
		circleManager = drawManager;
	}

	@Override
	public void run() {
		android.graphics.Canvas canvas = null;

		while (true) {
			if (stop == true) {
				break;
			}

			try {
				canvas = holder.lockCanvas(null);

				// 旋转画布
				canvas.rotate(rotate, Application.getInstance().getDisplayWidth() / 2,
						Application.getInstance().getDisplayHeight() / 2);
				rotate += 0.5;

				// 绘制的关键步骤
				canvas.drawARGB((int) (0.05 * 256), 0, 0, 0); // 绘制有透明度的黑色背景
				circleManager.drawContent(canvas); // 绘制粒子

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (canvas != null) {
					this.holder.unlockCanvasAndPost(canvas);
				}
			}

		}

		holder = null;
		circleManager = null;
	}

	public void setStop() {
		this.stop = true;
	}
	
	public void changeAll(){
		changeColor();
		changeRadius();
		changeDirection();
	}

	public void changeColor() {
		CircleUtils.changeColor(circleManager.getCircles());
	}

	public void changeRadius() {
		CircleUtils.changeRadius(circleManager.getCircles());
	}

	public void changeDirection() {
		CircleUtils.changeDirection(circleManager.getCircles());
	}
}
