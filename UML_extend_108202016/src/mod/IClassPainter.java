package mod;

import java.awt.Graphics;
import java.awt.Point;

public interface IClassPainter {

    public void setText(String text);

    public void paintSelect(Graphics gra);

    public static final int N = 0;
    public static final int W = 1;
    public static final int S = 2;
    public static final int E = 3;
    public static final int[] ports = new int[]{N, W, S, E};

    public int inWhichPort(Point point);

}
