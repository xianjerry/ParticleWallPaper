package per.xjx.core;

import per.xjx.global.Application;
import per.xjx.utils.CircleUtils;

public class DrawCore extends Thread {
	
	private boolean pause = false;
	private boolean stop = false;
	
	private android.view.SurfaceHolder holder;
	private float d = 0;
	
	private DrawManager circleManager;

	public DrawCore(android.view.SurfaceHolder holder) {
		this.holder = holder;
		
		circleManager = new DrawManager(30);
	}

	@Override
	public void run() {
		android.graphics.Canvas canvas = null;

		while (true) {
			if (stop == true) {
				break;
			}
			if (pause == false) {
				try {
					canvas = holder.lockCanvas(null);
					
					// 旋转画布
					canvas.rotate(d, Application.getInstance().getDisplayWidth() / 2,
							Application.getInstance().getDisplayHeight() / 2);
					d += 0.5;
					
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
			} else {
				try {
					sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	public void changeAll(){
		changeColor();
		changeRadius();
		changeV();
	}

	public void changeColor() {
		CircleUtils.changeColor(circleManager.getCircles());
	}

	public void changeRadius() {
		CircleUtils.changeRadius(circleManager.getCircles());
	}

	public void changeV() {
		CircleUtils.changeV(circleManager.getCircles());
	}
}
