package gelato.leet2;

import java.util.Iterator;
import java.util.List;

//281
public class ZigzagIterator {
    Iterator active;
    Iterator inactive;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        active = v1.iterator();
        inactive = v2.iterator();
    }

    public int next() {
        int res = 0;
        if(hasNext()) {
            res = (Integer) active.next();
        }
        if(inactive.hasNext()){
            Iterator swap = active;
            active = inactive;
            inactive = swap;
        }
        return res;
    }

    public boolean hasNext() {
        if(!active.hasNext()) {
            active = inactive;
        }
        return active.hasNext();
    }
}
