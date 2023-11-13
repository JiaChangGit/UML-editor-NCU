package mod;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import Pack.DragPack;

public interface ILinePainter {

    void paintArrow(Graphics g, Point point);

    public void setConnect(DragPack dPack);

    void paintSelect(Graphics gra);

    public boolean isSelect();

    public void setSelect(boolean isSelect);

    public JPanel getFrom();

    public int getFromSide();

    public JPanel getTo();

    public int getToSide();
}
