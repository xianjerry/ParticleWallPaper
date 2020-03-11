package per.xjx.global;

import per.xjx.core.DrawCore;
import per.xjx.core.DrawManager;

import android.os.Bundle;
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

/**
 * 
 * 壁纸服务类(壁纸程序的入口)
 * 
 * 
 */
public class Wallpaper extends WallpaperService {

	
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
		private DrawManager draw = new DrawManager(22);

		public DrawGameEngine() {

			task = new DrawCore(getSurfaceHolder(), draw);
		}

		@Override
		public void onCreate(SurfaceHolder surfaceHolder) {
			super.onCreate(surfaceHolder);
			setTouchEventsEnabled(true);
		}

		@Override
		public void onDestroy() {
			super.onDestroy();
		}

		@Override
		public void onVisibilityChanged(boolean visible) {
			super.onVisibilityChanged(visible);

			if(visible){
				if(task != null)
					task.setStop();
				task = new DrawCore(getSurfaceHolder(), draw);
				task.start();
			}else{
				if(task != null){
					task.setStop();
					task = null;
				}
			}
		}

		@Override
		public void onTouchEvent(MotionEvent event) {
			super.onTouchEvent(event);

			if(event.getAction() == MotionEvent.ACTION_UP){
				if(task != null){
					task.changeAll();
				}
			}
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

			if(task != null) {
				task.start();
			}
		}

		@Override
		public void onSurfaceDestroyed(SurfaceHolder holder) {
			super.onSurfaceDestroyed(holder);

			if(task != null)
				task.setStop();
		}

	}
}
