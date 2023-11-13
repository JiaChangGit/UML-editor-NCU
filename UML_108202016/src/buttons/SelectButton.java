package buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.Panel;

public class SelectButton extends ButtonAbstract implements ActionListener {

    private static final long serialVersionUID = 1L;

    public SelectButton(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        canvas.lineDraw = null;
        canvas.objectDraw = null;
        Panel.resetButtonColor();
        setBackground(Color.GRAY);
    }
}
