package objects;

import javax.swing.ImageIcon;

public final class Case extends ObjectAbstract {

    public Case(int x, int y, int depth) {
        super.createObject(x, y, depth);
        initialize();
    }

    protected void initialize() {
        super.setHeight(100);
        super.setWidth(150);
        initializePort();
        super.icon = new ImageIcon(getClass().getResource("images/case.png"));
        super.image = super.icon.getImage();
    }

    @Override
    public void initializePort() {
        if (portList.isEmpty()) {
            portList.add(new Port(getX(), getY() + getHeight() / 2));
            portList.add(new Port(getX() + getWidth() / 2, getY()));
            portList.add(new Port(getX() + getWidth(), getY() + getHeight() / 2));
            portList.add(new Port(getX() + getWidth() / 2, getY() + getHeight()));
        } else {
            portList.get(0).setPos(getX(), getY() + getHeight() / 2);
            portList.get(1).setPos(getX() + getWidth() / 2, getY());
            portList.get(2).setPos(getX() + getWidth(), getY() + getHeight() / 2);
            portList.get(3).setPos(getX() + getWidth() / 2, getY() + getHeight());
        }
    }

    @Override
    public void showPorts(boolean isSelected) {
        if (isSelected) {
            super.setImage(new ImageIcon(getClass().getResource("images/case_selected.png")).getImage());
        } else {
            super.setImage(new ImageIcon(getClass().getResource("images/case.png")).getImage());
        }

        super.setIsSelected(isSelected);
    }

    @Override
    public int getTextX() {
        return super.getX() + super.getWidth() / 4;
    }

    @Override
    public int getTextY() {
        return super.getY() + super.getHeight() / 2;
    }
}
