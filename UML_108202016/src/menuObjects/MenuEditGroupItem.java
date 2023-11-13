package menuObjects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import objects.Group;
import objects.ShapeAbstract;

public class MenuEditGroupItem extends MenuItem implements ActionListener {

    private static final long serialVersionUID = 1L;

    public MenuEditGroupItem(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        createGroup();
    }

    private void createGroup() {
        Group newGroupObject = new Group();

        for (ShapeAbstract shape : canvas.shapeList) {
            if (shape.getIsSelected()) {
                newGroupObject.add(shape);
            }
        }

        canvas.shapeList.removeAll(newGroupObject.getMember());
        canvas.shapeList.add(newGroupObject);
    }
}
