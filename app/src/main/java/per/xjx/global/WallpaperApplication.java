package per.xjx.global;

import per.xjx.global.utils.DisplayUtils;
import android.app.Application;

/**
 * 全局应用程序
 * 
 * @author 冼嘉贤
 *
 */
public class WallpaperApplication extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		DisplayUtils.initDisplay(this);
	}
	
	
}
