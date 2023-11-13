package buttons;

import javax.swing.JButton;
import java.awt.Color;
import gui.Canvas;
import gui.Panel;

public abstract class ButtonAbstract extends JButton {

    private static final long serialVersionUID = 1L;
    protected Canvas canvas;
    protected Panel panel;

    public ButtonAbstract(String name) {
        super(name);
        canvas = Canvas.getInstance();
        setBackground(Color.YELLOW);
    }
}
