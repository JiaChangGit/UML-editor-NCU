package objects;

import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Image;

public abstract class ShapeAbstract {

    public int depth = 0;
    protected ImageIcon icon;
    protected Image image;

    public void setName(String name) {
        ////System.out.println("Shape.setName(String name)");
    }

    public boolean getIsSelected() {
        ////System.out.println("Shape.getIsSelected()");
        return false;
    }

    public void setXDrag(int dx) {
        ////System.out.println("Shape.setXDrag()");
    }

    public void resetXDrag() {
        ////System.out.println("Shape.resetXDrag()");
    }

    public int getTextX() {
        ////System.out.println("Shape.getTextX()");
        return -1;
    }

    public void setYDrag(int dy) {
        //System.out.println("Shape.setYDrag()");
    }

    public void resetYDrag() {
        //System.out.println("Shape.resetYDrag()");
    }

    public int getTextY() {
        //System.out.println("Shape.getTextY()");
        return -1;
    }

    public boolean isInObject(int x, int y) {
        //System.out.println("Shape.isInObject(int x, int y)");
        return false;
    }

    public boolean isInObject(int x1, int y1, int x2, int y2) {
        //System.out.println("Shape.isInObject(int x1, int y1, int x2, int y2)");
        return false;
    }

    public void showPorts(boolean isSelected) {
        //System.out.println("Shape.showPorts(boolean isSelected)");

    }

    public void initializePort() {
        //System.out.println("Shape.initializePort()");
    }

    public void drawObject(Graphics2D g2d) {
        //System.out.println("Shape.drawObject(Graphics2D g2d)");
    }

    public Port getNearestPort(int x, int y) {
        //System.out.println("Shape.getNearestPort(int x, int y)");
        return new Port(-1, -1);
    }

    public ArrayList<ShapeAbstract> getMember() {
        //System.out.println("Shape.getMember()");
        return new ArrayList<>();
    }

    public void setImage(Image image) {
        //System.out.println("Shape.setImage(Image image)");
        this.image = image;
    }
}
