package menuObjects;

public class MenuEdit extends Menu {

    private static final long serialVersionUID = 1L;

    public MenuEdit(String name) {
        super(name);
        add(new MenuEditRenameItem("Rename"));
        add(new MenuEditGroupItem("Group"));
        add(new MenuEditUngroupItem("Ungroup"));
    }
}
