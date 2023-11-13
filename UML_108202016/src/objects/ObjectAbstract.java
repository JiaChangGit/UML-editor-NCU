package objects;

import java.util.ArrayList;
import java.awt.Graphics2D;

public abstract class ObjectAbstract extends ShapeAbstract {

    public ArrayList<Port> portList = new ArrayList<>(4);
    private int x;
    private int y;
    private int xDrag;
    private int yDrag;
    private int height;
    private int width;
    private String Name = "<Default>";
    private boolean isSelected = false;

    @Override
    public boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    @Override
    public Port getNearestPort(int x, int y) {
        int minDistance = 10000;
        Port nearestPort = portList.get(0);

        for (Port port : portList) {
            int curDistance = (Math.abs(x - port.getX()) ^ 2) + (Math.abs(y - port.getY()) ^ 2);
            if (minDistance > curDistance) {
                minDistance = curDistance;
                nearestPort = port;
            }
        }
        return nearestPort;
    }

    public void createObject(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.xDrag = x;
        this.yDrag = y;
        super.depth = depth;
    }

    @Override
    public boolean isInObject(int x, int y) {
        return x > this.x && x < this.x + width && y > this.y && y < this.y + height;
    }

    @Override
    public boolean isInObject(int x1, int y1, int x2, int y2) {
        return x1 < this.getX() && y1 < this.getY() && x2 > this.getX() + this.getWidth()
                && y2 > this.getY() + this.getHeight();
    }

    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
        g2d.drawString(getName(), getTextX(), getTextY());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getXDrag() {
        return xDrag;
    }

    @Override
    public void setXDrag(int dx) {
        x = getXDrag() + dx;
    }

    @Override
    public void resetXDrag() {
        xDrag = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getYDrag() {
        return yDrag;
    }

    @Override
    public void setYDrag(int dy) {
        y = getYDrag() + dy;
    }

    @Override
    public void resetYDrag() {
        yDrag = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return Name;
    }

    @Override
    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public ArrayList<ShapeAbstract> getMember() {
        ArrayList<ShapeAbstract> shapeList = new ArrayList<>();
        shapeList.add(this);
        return shapeList;
    }
}
