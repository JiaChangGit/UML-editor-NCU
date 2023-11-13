package gui;

import buttons.CompositionLineButton;
import buttons.AssociationLineButton;
import buttons.SelectButton;
import buttons.GeneralizationLineButton;
import buttons.ClassButton;
import buttons.CaseButton;
import buttons.ButtonAbstract;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.GridLayout;

public class Panel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static Panel instance;
    private static ArrayList<ButtonAbstract> buttonList;

    private Panel() {
        buttonList = new ArrayList<>();
        initializeButton();
        setLayout(new GridLayout(6, 1, 0, 0));
    }

    public static Panel getInstance() {
        synchronized (Panel.class) {
            if (instance == null) {
                instance = new Panel();
            }
        }
        return instance;
    }

    public static void resetButtonColor() {
        for (ButtonAbstract button : buttonList) {
            button.setBackground(Color.WHITE);
        }
    }

    private void initializeButton() {
        ButtonAbstract selectbutton = new SelectButton("Select Mode");
        ButtonAbstract associationLineButton = new AssociationLineButton("Association Line");
        ButtonAbstract generalizationLineButton = new GeneralizationLineButton("Generalization Line");
        ButtonAbstract compositionLineButton = new CompositionLineButton("Composition Line");
        ButtonAbstract classButton = new ClassButton("Class");
        ButtonAbstract usecaseButton = new CaseButton("Use Case");

        add(selectbutton);
        add(associationLineButton);
        add(generalizationLineButton);
        add(compositionLineButton);
        add(classButton);
        add(usecaseButton);

        buttonList.add(selectbutton);
        buttonList.add(associationLineButton);
        buttonList.add(generalizationLineButton);
        buttonList.add(compositionLineButton);
        buttonList.add(classButton);
        buttonList.add(usecaseButton);
    }
}
