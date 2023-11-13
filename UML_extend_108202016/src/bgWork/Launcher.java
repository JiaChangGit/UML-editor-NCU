package bgWork;

public class Launcher {

    public static void main(String[] args) {
        CoreMgr cmgr = new CoreMgr();
        cmgr.addProcess(new Core(cmgr));
    }
}
