package buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import drawings.AssociationLineDraw;
import gui.Panel;

public class AssociationLineButton extends ButtonAbstract implements ActionListener {

    private static final long serialVersionUID = 1L;

    public AssociationLineButton(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        canvas.lineDraw = new AssociationLineDraw();
        canvas.objectDraw = null;
        Panel.resetButtonColor();
        setBackground(Color.GRAY);
    }
}
