package objects;

import java.util.ArrayList;
import java.awt.Graphics2D;

public class Group extends ObjectAbstract {

    private final ArrayList<ShapeAbstract> shapeList = new ArrayList<>();

    public void add(ShapeAbstract shape) {
        shapeList.add(shape);
    }

    @Override
    public ArrayList<ShapeAbstract> getMember() {
        return shapeList;
    }

    @Override
    public boolean getIsSelected() {
        for (ShapeAbstract shape : shapeList) {
            if (shape.getIsSelected()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void setXDrag(int dx) {
        for (ShapeAbstract shape : shapeList) {
            shape.setXDrag(dx);
        }
    }

    @Override
    public void resetXDrag() {
        for (ShapeAbstract shape : shapeList) {
            shape.resetXDrag();
        }
    }

    @Override
    public void setYDrag(int dy) {
        for (ShapeAbstract shape : shapeList) {
            shape.setYDrag(dy);
        }
    }

    @Override
    public void resetYDrag() {
        for (ShapeAbstract shape : shapeList) {
            shape.resetYDrag();
        }
    }

    @Override
    public void initializePort() {
        for (ShapeAbstract shape : shapeList) {
            shape.initializePort();
        }
    }

    @Override
    public void showPorts(boolean isSelected) {
        for (ShapeAbstract shape : shapeList) {
            shape.showPorts(isSelected);
        }
    }

    @Override
    public Port getNearestPort(int x, int y) {
        ArrayList<Port> groupPortList = new ArrayList<>();
        for (ShapeAbstract shape : shapeList) {
            groupPortList.add(shape.getNearestPort(x, y));
        }

        int minDistance = 10000;
        Port nearestPort = groupPortList.get(0);

        for (Port port : groupPortList) {
            int curDistance = (Math.abs(x - port.getX()) ^ 2) + (Math.abs(y - port.getY()) ^ 2);
            if (minDistance > curDistance) {
                minDistance = curDistance;
                nearestPort = port;
            }
        }
        return nearestPort;
    }

    @Override
    public boolean isInObject(int x, int y) {
        for (ShapeAbstract shape : shapeList) {
            if (shape.isInObject(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isInObject(int x1, int y1, int x2, int y2) {
        for (ShapeAbstract shape : shapeList) {
            if (shape.isInObject(x1, y1, x2, y2)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void drawObject(Graphics2D g2d) {
        for (ShapeAbstract shape : shapeList) {
            shape.drawObject(g2d);
        }
    }

}
