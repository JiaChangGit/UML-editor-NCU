package drawings;

import objects.GeneralizationLine;
import objects.LineAbstract;
import objects.Port;

public class GeneralizationLineDraw implements LineInterface {

    @Override
    public LineAbstract createLine(Port port1, Port port2) {
        return new GeneralizationLine(port1, port2);
    }
}
