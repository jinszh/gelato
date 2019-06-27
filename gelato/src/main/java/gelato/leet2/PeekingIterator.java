package gelato.leet2;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> inner;
    Integer store;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        inner = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(inner.hasNext()){
            store = inner.next();
        }
        return store;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(store != null){
            int res = store;
            store = null;
            return res;
        }else {
            return inner.next();
        }
    }

    @Override
    public boolean hasNext() {
        return store != null || inner.hasNext();
    }
}
