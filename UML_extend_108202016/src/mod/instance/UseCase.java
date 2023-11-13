package mod.instance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Vector;

import javax.swing.JPanel;

import bgWork.handler.CanvasPanelHandler;
import mod.IClassPainter;
import mod.IFuncComponent;

public final class UseCase extends JPanel implements IFuncComponent, IClassPainter {

    Vector<String> texts;
    Dimension defSize = new Dimension(150, 40);
    int maxLength = 20;
    boolean isSelect = false;
    int selectBoxSize = 5;

    public UseCase(CanvasPanelHandler cph) {
        this.texts = new Vector<>();
        texts.add("New Use Case");
        reSize();
        this.setVisible(true);
        this.setLocation(0, 0);
        this.setOpaque(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        reSize();
        for (int i = 0; i < texts.size(); i++) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, defSize.width, defSize.height);
            g.setColor(Color.BLACK);
            g.drawOval(0, 0, defSize.width - 1, defSize.height - 1);
            if (texts.elementAt(i).length() > maxLength) {
                g.drawString(texts.elementAt(i).substring(0, maxLength) + "...",
                        3, (int) (0 + (i + 0.8) * defSize.getHeight()));
            } else {
                g.drawString(texts.elementAt(i), (int) (defSize.width * 0.2),
                        (int) (defSize.getHeight()) / 2);
            }
        }
        if (isSelect == true) {
            paintSelect(g);
        }
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }

    @Override
    public void reSize() {
        switch (texts.size()) {
            case 0 ->
                this.setSize(defSize);
            default ->
                this.setSize(defSize.width, defSize.height);
        }
    }

    @Override
    public void setText(String text) {
        texts.clear();
        texts.add(text);
        this.repaint();
    }

    @Override
    public void paintSelect(Graphics gra) {

        gra.setColor(Color.BLACK);
        gra.fillRect(this.getWidth() / 2 - selectBoxSize, 0, selectBoxSize * 2,
                selectBoxSize);
        gra.fillRect(this.getWidth() / 2 - selectBoxSize,
                this.getHeight() - selectBoxSize, selectBoxSize * 2,
                selectBoxSize);
        gra.fillRect(0, this.getHeight() / 2 - selectBoxSize, selectBoxSize,
                selectBoxSize * 2);
        gra.fillRect(this.getWidth() - selectBoxSize,
                this.getHeight() / 2 - selectBoxSize, selectBoxSize,
                selectBoxSize * 2);
    }

    @Override

    public int inWhichPort(Point point) {

        int width = this.getWidth();
        int height = this.getHeight();
        Point[] apexs = {new Point(width, 0), new Point(0, 0), new Point(0, height), new Point(width, height)};
        Point center = new Point(width / 2, height / 2);

        for (int i = 0; i < apexs.length; i++) {
            Polygon t = new Polygon();
            int secondIndex = ((i + 1) % 4);
            t.addPoint(apexs[i].x, apexs[i].y);
            t.addPoint(apexs[secondIndex].x, apexs[secondIndex].y);
            t.addPoint(center.x, center.y);

            if (t.contains(point)) {
                return ports[i];
            }
        }
        return -1;
    }
}
