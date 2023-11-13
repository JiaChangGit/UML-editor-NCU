package Define;

import java.awt.Dimension;
import java.awt.Point;

public class AreaDefine {

    int xMask = 0x01;
    int yMask = 0x02;
    public static final int OUT_SIDE = -1;
    public static final int TOP = 3;
    public static final int RIGHT = 2;
    public static final int LEFT = 1;
    public static final int BOTTOM = 0;

    public int getArea(Point rectLocat, Dimension rectSize, Point click) {
        if (click.x < rectLocat.x || click.y < rectLocat.y) {
            return OUT_SIDE;
        }
        if (click.x > rectLocat.x + rectSize.width
                || click.y > rectLocat.y + rectSize.height) {
            return OUT_SIDE;
        }
        Dimension vx = new Dimension(rectSize.width, -rectSize.height);
        Dimension vy = new Dimension(rectSize.width, rectSize.height);
        Point center = new Point(rectLocat.x + rectSize.width / 2,
                rectLocat.y + rectSize.height / 2);
        Dimension vc = new Dimension(click.x - center.x, click.y - center.y);
        double x = vc.width * vx.height - vc.height * vx.width;
        double y = vc.width * vy.height - vc.height * vy.width;
        int result = 0;
        if (x >= 0.0) {
            result |= xMask;
        }
        if (y >= 0.0) {
            result |= yMask;
        }
        return switch (result) {
            case TOP -> TOP;
            case RIGHT -> RIGHT;
            case LEFT -> LEFT;
            case BOTTOM -> BOTTOM;
            default -> OUT_SIDE;
        };
    }
}
