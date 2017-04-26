package per.xjx.global;

import android.util.DisplayMetrics;

public class Application extends android.app.Application {

    private int displayHeight = 0;

    private int displayWidth = 0;

    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        init();
    }

    public static Application getInstance() {
        return instance;
    }

    public void init() {
        DisplayMetrics dm = this.getResources().getDisplayMetrics();
        this.displayHeight = dm.heightPixels;
        this.displayWidth = dm.widthPixels;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }

    public int getDisplayWidth() {
        return displayWidth;
    }

}
