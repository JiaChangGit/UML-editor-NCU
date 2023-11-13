package drawings;

import objects.ObjectAbstract;
import objects.Class;

public class ClassDraw implements ObjectInterface {

    @Override
    public ObjectAbstract createObject(int x, int y, int depth) {
        return new Class(x, y, depth);
    }
}
