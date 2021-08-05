package gelato.leet2;

import java.util.Iterator;
import java.util.List;

//251
public class Vector2D implements Iterator<Integer> {
    int active = 0;
    Iterator<Integer> iterator;
    List<List<Integer>> vec2d;
    //improve的办法; 不需要active, 直接用外面那个list的iterator, code也简单
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        while (active < vec2d.size() && (vec2d.get(active) == null || vec2d.get(active).size() == 0)) {
            active++;
        }
        if (active < vec2d.size()) {
            iterator = vec2d.get(active).iterator();
        }
    }

    @Override
    public Integer next() {
        hasNext();
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        if (iterator.hasNext()) {
            return true;
        } else {
            active++;
            while (active < vec2d.size() && (vec2d.get(active) == null || vec2d.get(active).size() == 0)) {
                active++;
            }
            if (active < vec2d.size()) {
                iterator = vec2d.get(active).iterator();
                return true;
            } else {
                return false;
            }
        }
    }
}
