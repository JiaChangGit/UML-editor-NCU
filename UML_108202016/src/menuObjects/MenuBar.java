package menuObjects;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {

    private static final long serialVersionUID = 1L;
    private static MenuBar instance;
    
    private MenuBar() {
        add(new MenuFile("File"));
        add(new MenuEdit("Edit"));
    }

    public static MenuBar getInstance() {
        synchronized (MenuBar.class) {
            if (instance == null) {
                instance = new MenuBar();
            }
        }
        return instance;
    }
}
