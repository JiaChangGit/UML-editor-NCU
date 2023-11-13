package objects;

import java.util.ArrayList;

public class Port extends ShapeAbstract {

    private int x;
    private int y;
    private int xDrag;
    private int yDrag;
    private final ArrayList<LineAbstract> LineStartList;
    private final ArrayList<LineAbstract> LineEndList;

    public Port(int x, int y) {
        this.LineStartList = new ArrayList<>();
        this.LineEndList = new ArrayList<>();
        this.x = x;
        this.y = y;
        this.xDrag = x;
        this.yDrag = y;
    }

    public void updatePos(int dx, int dy) {
        setX(this.getXDrag() + dx);
        setY(this.getYDrag() + dy);
    }

    public void setPos(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getXDrag() {
        return xDrag;
    }

    @Override
    public void setXDrag(int xDrag) {
        this.xDrag = xDrag;
    }

    public int getYDrag() {
        return yDrag;
    }

    @Override
    public void setYDrag(int yDrag) {
        this.yDrag = yDrag;
    }

    public void addStartLine(LineAbstract startLine) {
        LineStartList.add(startLine);
    }

    public void addEndLine(LineAbstract endLine) {
        LineEndList.add(endLine);
    }
}
