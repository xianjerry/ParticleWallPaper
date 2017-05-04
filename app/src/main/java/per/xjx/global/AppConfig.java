package per.xjx.global;

public class AppConfig {

    /**
     * 生成的粒子最大半径
     */
    private int maxRadius = 50;

    /**
     * 渐变粒子半径
     */
    private boolean autoChangeRadius = true;

    public int getMaxRadius() {
        return maxRadius;
    }

    public void setMaxRadius(int maxRadius) {
        this.maxRadius = maxRadius;
    }

    public boolean isAutoChangeRadius() {
        return autoChangeRadius;
    }

    public void setAutoChangeRadius(boolean autoChangeRadius) {
        this.autoChangeRadius = autoChangeRadius;
    }
}
