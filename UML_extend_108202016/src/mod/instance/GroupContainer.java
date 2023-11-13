package mod.instance;

import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.JPanel;

import bgWork.Core;
import bgWork.InitProcess;
import mod.IFuncComponent;

public class GroupContainer extends JPanel implements IFuncComponent {

    boolean isSelect = false;
    InitProcess core;

    public GroupContainer(InitProcess process) {
        this.setVisible(true);
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setOpaque(false);
        this.core = process;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean isSelect) {
        this.isSelect = isSelect;
        for (int i = 0; i < this.getComponentCount(); i++) {
            if (core.isCore(core) == true) {
                switch (((Core) core).isFuncComponent(this.getComponent(i))) {
                    case 0 ->
                        ((BasicClass) this.getComponent(i)).setSelect(isSelect);
                    case 1 ->
                        ((UseCase) this.getComponent(i)).setSelect(isSelect);
                    case 2 ->
                        ((AssociationLine) this.getComponent(i))
                                .setSelect(isSelect);
                    case 3 ->
                        ((CompositionLine) this.getComponent(i))
                                .setSelect(isSelect);
                    case 4 ->
                        ((GeneralizationLine) this.getComponent(i))
                                .setSelect(isSelect);
                    case 5 ->
                        ((GroupContainer) this.getComponent(i))
                                .setSelect(isSelect);
                    case 6 ->
                        ((DependencyLine) this.getComponent(i))
                                .setSelect(isSelect);
                    default -> {
                    }
                }
            }
        }
    }

    public GroupContainer(LayoutManager layout) {
        super(layout);

    }

    public GroupContainer(boolean isDoubleBuffered) {
        super(isDoubleBuffered);

    }

    public GroupContainer(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);

    }

    @Override
    public void reSize() {

    }
}
