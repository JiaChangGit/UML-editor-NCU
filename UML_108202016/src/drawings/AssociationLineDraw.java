package drawings;

import objects.AssociationLine;
import objects.LineAbstract;
import objects.Port;

public class AssociationLineDraw implements LineInterface {

    @Override
    public LineAbstract createLine(Port port1, Port port2) {
        return new AssociationLine(port1, port2);
    }
}
