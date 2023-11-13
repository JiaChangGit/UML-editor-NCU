package bgWork;

import java.util.Vector;

public final class CoreMgr implements Runnable {

    Vector<InitProcess> procList;

    public CoreMgr() {
        this.procList = new Vector<>();

    }

    public CoreMgr(InitProcess proc) {
        this.procList = new Vector<>();
        this.addProcess(proc);
        run();
    }

    public void addProcess(InitProcess proc) {

        switch (procList.indexOf(proc)) {
            case -1 ->
                procList.addElement(proc);
            default -> {
            }
        }
    }

    void removeProcess(InitProcess proc) {

        switch (procList.indexOf(proc)) {
            case -1 -> {
                System.err.println("CoreMgr: " + this);
                System.err.println("Caller: " + proc);
                for (int i = 0; i < procList.size(); i++) {
                    System.err.println(
                            "List[" + i + "]: " + procList.elementAt(i));
                }
            }
            default ->
                procList.remove(proc);
        }
    }

    @Override
    public void run() {
        while (true) {

            switch (procList.size()) {
                case 0 ->
                    System.exit(0);
                default -> {
                }
            }
        }
    }
}
