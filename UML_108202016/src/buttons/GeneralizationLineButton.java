package buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import drawings.GeneralizationLineDraw;
import gui.Panel;

public class GeneralizationLineButton extends ButtonAbstract implements ActionListener {

    private static final long serialVersionUID = 1L;

    public GeneralizationLineButton(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        canvas.lineDraw = new GeneralizationLineDraw();
        canvas.objectDraw = null;
        Panel.resetButtonColor();
        setBackground(Color.GRAY);
    }
}
