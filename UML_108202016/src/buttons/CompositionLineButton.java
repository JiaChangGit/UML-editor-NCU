package buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import drawings.CompositionLineDraw;
import gui.Panel;

public class CompositionLineButton extends ButtonAbstract implements ActionListener {

    private static final long serialVersionUID = 1L;

    public CompositionLineButton(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        canvas.lineDraw = new CompositionLineDraw();
        canvas.objectDraw = null;
        Panel.resetButtonColor();
        setBackground(Color.GRAY);
    }
}
