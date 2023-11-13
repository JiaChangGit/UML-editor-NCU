package objects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class CompositionLine extends LineAbstract {

    public CompositionLine(Port port1, Port port2) {
        super.createLine(port1, port2);
    }

    @Override
    public void drawLine(Graphics g, Port portStart, Port portEnd) {
        Graphics2D g2d = (Graphics2D) g.create();

        double dx = portEnd.getX() - portStart.getX(), dy = portEnd.getY() - portStart.getY();
        double angle = Math.atan2(dy, dx);
        int len = (int) Math.sqrt(dx * dx + dy * dy);
        AffineTransform at = AffineTransform.getTranslateInstance(portStart.getX(), portStart.getY());
        at.concatenate(AffineTransform.getRotateInstance(angle));
        g2d.transform(at);

        // Draw horizontal arrow starting in (0, 0)
        g2d.drawLine(0, 0, len - 2 * 10, 0);
        g2d.drawPolygon(new int[]{len, len - 10, len - 2 * 10, len - 10}, new int[]{0, -10, 0, 10}, 4);
    }
}
