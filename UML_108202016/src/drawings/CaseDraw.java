package drawings;

import objects.ObjectAbstract;
import objects.Case;

public class CaseDraw implements ObjectInterface {

    @Override
    public ObjectAbstract createObject(int x, int y, int depth) {
        return new Case(x, y, depth);
    }
}
