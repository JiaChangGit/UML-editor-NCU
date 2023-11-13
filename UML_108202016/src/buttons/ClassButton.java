package buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import drawings.ClassDraw;
import gui.Panel;

public class ClassButton extends ButtonAbstract implements ActionListener {

    private static final long serialVersionUID = 1L;

    public ClassButton(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        canvas.lineDraw = null;
        canvas.objectDraw = new ClassDraw();
        Panel.resetButtonColor();
        setBackground(Color.GRAY);
    }
}
