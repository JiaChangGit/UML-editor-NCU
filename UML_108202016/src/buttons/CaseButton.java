package buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import drawings.CaseDraw;
import gui.Panel;

public class CaseButton extends ButtonAbstract implements ActionListener {

    private static final long serialVersionUID = 1L;

    public CaseButton(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        canvas.lineDraw = null;
        canvas.objectDraw = new CaseDraw();
        Panel.resetButtonColor();
        setBackground(Color.GRAY);
    }
}
