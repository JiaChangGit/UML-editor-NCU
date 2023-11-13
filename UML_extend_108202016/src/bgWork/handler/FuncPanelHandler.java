package bgWork.handler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import Listener.HandlerActionListener;
import bgWork.InitProcess;
import mod.instance.AssociationLine;
import mod.instance.BasicClass;
import mod.instance.CompositionLine;
import mod.instance.DependencyLine;
import mod.instance.GeneralizationLine;
import mod.instance.SelectComp;
import mod.instance.UseCase;

public final class FuncPanelHandler extends PanelHandler {

    Dimension btnSize = new Dimension(50, 50);
    Vector<JButton> btnlist;
    int currIndex = 0;

    public FuncPanelHandler(JPanel Container, InitProcess process) {
        super(Container, process);
        this.btnlist = new Vector<>();
        boundDistance = 10;
        init();
        initContextPanel();
        Container.add(this.contextPanel);
    }

    void init() {
        int index = 0;
        while (this.getIcon(index) != null) {
            JButton btn = new JButton(this.getIcon(index));
            btn.setBounds(boundDistance,
                    boundDistance + (btnSize.height + boundDistance) * index,
                    btnSize.width, btnSize.height);
            btn.setVisible(true);
            btn.setBackground(Color.WHITE);
            btn.addMouseListener(new HandlerActionListener(this));
            btnlist.addElement(btn);
            index++;
        }
        setCurrentBtn(currIndex);
    }

    @Override
    void initContextPanel() {
        contextPanel = new JPanel();
        contextPanel.setBorder(new LineBorder(Color.GRAY));
        contextPanel.setLayout(null);
        contextPanel.setBounds(boundDistance, boundDistance,
                btnSize.width + boundDistance * 2,
                (btnSize.height + boundDistance) * btnlist.size()
                + boundDistance);
        contextPanel.setVisible(true);
        for (int i = 0; i < btnlist.size(); i++) {
            contextPanel.add(btnlist.elementAt(i));
        }
    }

    public void check() {
        for (int i = 0; i < btnlist.size(); i++) {
            switch (i - currIndex) {
                case 0 -> {
                    btnlist.elementAt(i).setSelected(true);
                    btnlist.elementAt(i).setBackground(Color.BLACK);
                }
                default -> {
                    btnlist.elementAt(i).setSelected(false);
                    btnlist.elementAt(i).setBackground(Color.WHITE);
                }
            }
        }
    }

    @Override
    public void ActionPerformed(MouseEvent e) {
        setCurrentBtn(btnlist.indexOf(e.getSource()));
        printCurrentFunction();
    }

    public void setCurrentBtn(int index) {
        this.currIndex = index;
        check();
    }

    public JPanel getCurrentFunc() {
        return getFunc(currIndex);
    }

    public int getCurrentFuncIndex() {
        return currIndex;
    }

    public void printCurrentFunction() {
        System.out.print("func" + getCurrentFuncIndex() + ", ");
        switch (getCurrentFuncIndex()) {
            case 0 ->
                System.out.println("Select");
            case 1 ->
                System.out.println("AssociationLine");
            case 2 ->
                System.out.println("GeneralizationLine");
            case 3 ->
                System.out.println("CompositionLine");
            case 4 ->
                System.out.println("BasicClass");
            case 5 ->
                System.out.println("UseCase");
            case 6 ->
                System.out.println("DependencyLine");
        }
    }

    ImageIcon getIcon(int index) {
        return switch (index) {
            case 0 ->
                new ImageIcon("icon/select.jpg");
            case 1 ->
                new ImageIcon("icon/association_line.jpg");
            case 2 ->
                new ImageIcon("icon/generalization_line.jpg");
            case 3 ->
                new ImageIcon("icon/composition_line.jpg");
            case 4 ->
                new ImageIcon("icon/class.jpg");
            case 5 ->
                new ImageIcon("icon/use_case.jpg");
            case 6 ->
                new ImageIcon("icon/dependency_line.png");
            default ->
                null;
        };
    }

    public JPanel getFunc(int index) {
        return switch (index) {
            case 0 ->
                new SelectComp();
            case 1 ->
                new AssociationLine(core.getCanvasPanelHandler());
            case 2 ->
                new GeneralizationLine(core.getCanvasPanelHandler());
            case 3 ->
                new CompositionLine(core.getCanvasPanelHandler());
            case 4 ->
                new BasicClass(core.getCanvasPanelHandler());
            case 5 ->
                new UseCase(core.getCanvasPanelHandler());
            case 6 ->
                new DependencyLine(core.getCanvasPanelHandler());
            default ->
                null;
        };
    }
}
