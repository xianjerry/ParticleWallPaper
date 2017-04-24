package per.xjx.paper;

import per.xjx.core.DrawCore;
import android.os.Bundle;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

/**
 * 
 * 壁纸服务类(壁纸程序的入口)
 * 
 * 
 */
public class GameWallpaperService extends WallpaperService {

	
	@Override
	public Engine onCreateEngine() {
		return new DrawGameEngine();
	}
	
	
	/**
	 * 壁纸绘制引擎
	 * 
	 * 
	 */
	public class DrawGameEngine extends Engine {

		private DrawCore task = null;

		public DrawGameEngine() {

			task = new DrawCore(getSurfaceHolder());
		}

		@Override
		public void onCreate(SurfaceHolder surfaceHolder) {
			super.onCreate(surfaceHolder);
			setTouchEventsEnabled(false);
		}

		@Override
		public void onDestroy() {
			super.onDestroy();
		}

		@Override
		public void onVisibilityChanged(boolean visible) {
			super.onVisibilityChanged(visible);
			if(visible){
				task.setPause(false);
				// 变化所有粒子
				task.changeAll();
			}else{
				task.setPause(true);
			}
		}

		@Override
		public void onTouchEvent(MotionEvent event) {
			super.onTouchEvent(event);
		}

		@Override
		public void onOffsetsChanged(float xOffset, float yOffset,
				float xOffsetStep, float yOffsetStep, int xPixelOffset,
				int yPixelOffset) {
			super.onOffsetsChanged(xOffset, yOffset, xOffsetStep, yOffsetStep,
					xPixelOffset, yPixelOffset);
		}

		@Override
		public Bundle onCommand(String action, int x, int y, int z,
				Bundle extras, boolean resultRequested) {
			return super.onCommand(action, x, y, z, extras, resultRequested);
		}

		@Override
		public void onSurfaceChanged(SurfaceHolder holder, int format,
				int width, int height) {
			super.onSurfaceChanged(holder, format, width, height);
		}

		@Override
		public void onSurfaceCreated(SurfaceHolder holder) {
			super.onSurfaceCreated(holder);
			task.start();
		}

		@Override
		public void onSurfaceDestroyed(SurfaceHolder holder) {
			super.onSurfaceDestroyed(holder);
			task.setStop(true);
		}

	}
}
