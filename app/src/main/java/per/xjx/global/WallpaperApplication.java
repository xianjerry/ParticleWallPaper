package per.xjx.global;

import per.xjx.global.utils.DisplayUtils;
import android.app.Application;

/**
 * ȫ��Ӧ�ó���
 * 
 * @author ������
 *
 */
public class WallpaperApplication extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		DisplayUtils.initDisplay(this);
	}
	
	
}
