package menuObjects;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import objects.ShapeAbstract;

public class MenuEditRenameItem extends MenuItem implements ActionListener {

    private static final long serialVersionUID = 1L;

    public MenuEditRenameItem(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        showRenameDialog();
    }

    private void showRenameDialog() {
        JTextField renameField = new JTextField(20);
        JPanel renamePanel = new JPanel();
        renamePanel.add(renameField);

        int result = JOptionPane.showConfirmDialog(renamePanel, renamePanel, "Enter a name",
                JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            for (ShapeAbstract shape : canvas.shapeList) {
                if (shape.getIsSelected()) {
                    shape.setName(renameField.getText());
                }
            }
            canvas.repaint();
        }
    }
}
