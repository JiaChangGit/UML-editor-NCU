package drawings;

import objects.LineAbstract;
import objects.Port;

public interface LineInterface {
    public LineAbstract createLine(Port port1, Port port2);
}
