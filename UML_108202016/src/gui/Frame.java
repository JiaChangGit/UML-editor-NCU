package gui;

import javax.swing.*;
import java.awt.*;
import menuObjects.MenuBar;

public class Frame extends JFrame {

    private static final long serialVersionUID = 1L;
    private static Frame instance;
    private final Panel toolPanel;
    private final Canvas canvas;
    private final MenuBar menuBar;

    private Frame() {
        super("UML Editor");
        instance = this;
        toolPanel = Panel.getInstance();
        canvas = Canvas.getInstance();
        menuBar = MenuBar.getInstance();

        setLayout(new BorderLayout());
        setJMenuBar(menuBar);
        add(toolPanel, BorderLayout.WEST);
        add(canvas, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1200, 700);
        setResizable(true);
        setVisible(true);
    }

    public static Frame getInstance() {
        synchronized (Frame.class) {
            if (instance == null) {
                instance = new Frame();
            }
        }
        return instance;
    }
}
