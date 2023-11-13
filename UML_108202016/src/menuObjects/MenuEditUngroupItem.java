package menuObjects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import objects.ShapeAbstract;

public class MenuEditUngroupItem extends MenuItem implements ActionListener {

    private static final long serialVersionUID = 1L;

    public MenuEditUngroupItem(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        unGroup();
    }

    private void unGroup() {
        ArrayList<ShapeAbstract> toAddList = new ArrayList<>();
        ArrayList<ShapeAbstract> toDeleteList = new ArrayList<>();

        for (ShapeAbstract shape : canvas.shapeList) {
            if (shape.getIsSelected()) {
                toDeleteList.add(shape);
                toAddList.addAll(shape.getMember());
            }
        }
        canvas.shapeList.removeAll(toDeleteList);
        canvas.shapeList.addAll(toAddList);
    }
}
