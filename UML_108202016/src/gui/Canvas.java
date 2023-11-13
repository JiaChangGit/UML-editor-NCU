package gui;

import objects.Port;
import objects.ShapeAbstract;
import objects.LineAbstract;
import objects.ObjectAbstract;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import drawings.LineInterface;
import drawings.ObjectInterface;

public class Canvas extends JPanel implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;
    private static Canvas instance;
    public LineInterface lineDraw;
    public ObjectInterface objectDraw;
    public ArrayList<ShapeAbstract> shapeList;
    private static ArrayList<LineAbstract> lineList;
    private static int depth = 0;
    private int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

    private Canvas() {
        this.shapeList = new ArrayList<>();
        lineList = new ArrayList<>();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public static Canvas getInstance() {
        synchronized (Canvas.class) {
            if (instance == null) {
                instance = new Canvas();
            }
        }
        return instance;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, getWidth(), getHeight());
        Graphics2D g2d = (Graphics2D) g;
        for (ShapeAbstract shape : shapeList) {
            shape.drawObject(g2d);
        }

        for (LineAbstract lo : lineList) {
            lo.drawLine(g, lo.getPortStart(), lo.getPortEnd());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        selectShape(x1, y1);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        checkCursorInObject(x1, y1);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        for (ShapeAbstract shape : shapeList) {
            shape.resetXDrag();
            shape.resetYDrag();
        }
        addObject(x2, y2);
        addLine(x1, y1, x2, y2);

        if (x1 != x2 && y1 != y2) {
            selectShapes(x1, y1, x2, y2);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        dragObject(x1, y1, x2, y2);
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void dragObject(int x1, int y1, int x2, int y2) {
        if (!isSelectMode()) {
            return;
        }

        int dx = x2 - x1;
        int dy = y2 - y1;

        for (ShapeAbstract shape : shapeList) {
            if (shape.getIsSelected()) {
                shape.setXDrag(dx);
                shape.setYDrag(dy);
                shape.initializePort();
            }
        }
        repaint();
    }

    private void addObject(int x, int y) {
        if (objectDraw == null) {
            return;
        }

        ObjectAbstract newObject = objectDraw.createObject(x, y, depth);
        depth++;
        shapeList.add(newObject);
        repaint();
    }

    private void addLine(int x1, int y1, int x2, int y2) {
        if (lineDraw == null) {
            return;
        }

        boolean isVaildLineStart = false;
        boolean isVaildLineEnd = false;
        ShapeAbstract boStart = null;
        ShapeAbstract boEnd = null;
        Port portStart = null;
        Port portEnd = null;

        for (ShapeAbstract shape : shapeList) {
            if (shape.isInObject(x1, y1)) {
                isVaildLineStart = true;
                portStart = shape.getNearestPort(x1, y1);
                boStart = shape;
                break;
            }
        }

        for (ShapeAbstract shape : shapeList) {
            if (shape.isInObject(x2, y2)) {
                isVaildLineEnd = true;
                portEnd = shape.getNearestPort(x2, y2);
                boEnd = shape;
                break;
            }
        }

        if (boStart == null || boEnd == null) {
            return;
        }

        if (boStart.equals(boEnd) || !(isVaildLineStart && isVaildLineEnd)) {
            return;
        }

        LineAbstract newLine = lineDraw.createLine(portStart, portEnd);
        lineList.add(newLine);
        repaint();
    }

    private void checkCursorInObject(int x, int y) {
        for (ShapeAbstract shape : shapeList) {
            if (shape.isInObject(x, y) && shape.getIsSelected()) {
                return;
            }
        }

        for (ShapeAbstract shape : shapeList) {
            shape.showPorts(false);
        }
    }

    private void selectShape(int x, int y) {
        if (!isSelectMode()) {
            return;
        }

        boolean alreadySelect = false;

        for (int i = shapeList.size() - 1; i >= 0; i--) {
            ShapeAbstract shape = shapeList.get(i);
            if (shape.isInObject(x, y) && !alreadySelect) {
                shape.showPorts(true);
                alreadySelect = true;
            } else {
                shape.showPorts(false);
            }
        }

        repaint();
    }

    private void selectShapes(int x1, int y1, int x2, int y2) {
        if (!isSelectMode()) {
            return;
        }

        if (x1 > x2) {
            int tmp = x1;
            x1 = x2;
            x2 = tmp;
        }

        if (y1 > y2) {
            int tmp = y1;
            y1 = y2;
            y2 = tmp;
        }

        for (int i = shapeList.size() - 1; i >= 0; i--) {
            ShapeAbstract bo = shapeList.get(i);
            if (bo.isInObject(x1, y1, x2, y2)) {
                bo.showPorts(true);
            } else {
                bo.showPorts(false);
            }
        }
        repaint();
    }

    private boolean isSelectMode() {
        return objectDraw == null && lineDraw == null;
    }

}
