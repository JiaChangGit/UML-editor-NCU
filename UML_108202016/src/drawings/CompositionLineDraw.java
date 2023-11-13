package drawings;

import objects.CompositionLine;
import objects.LineAbstract;
import objects.Port;

public class CompositionLineDraw implements LineInterface {

    @Override
    public LineAbstract createLine(Port port1, Port port2) {
        return new CompositionLine(port1, port2);
    }
}
