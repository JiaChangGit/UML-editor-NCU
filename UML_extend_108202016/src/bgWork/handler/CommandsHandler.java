package bgWork.handler;

import java.util.Vector;

import bgWork.InitProcess;

public class CommandsHandler {

    InitProcess process;
    Vector<String> cmdList;

    public CommandsHandler(InitProcess process) {
        this.cmdList = new Vector<>();
        this.process = process;
        init();
    }

    final void init() {
        cmdList.add("New Window");	// #0
        cmdList.add("Exit");		// #1
        cmdList.add("Change Object Name");// #2
        cmdList.add("Group");		// #3
        cmdList.add("Ungroup");		// #4
    }

    public int execv(String cmd) {
        switch (cmdList.indexOf(cmd)) {
            case 0 -> {
            }
            case 1 ->
                process.dispose();
            case 2 -> {
            }
            case 3 -> {
            }
            case 4 -> {
            }
            default -> {
            }
        }
        return -1;
    }
}
