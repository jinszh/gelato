package conc;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;

public class CollectionTests {
    public void t1(){
        HashMap<Integer, Integer> hashSet = new HashMap<Integer, Integer>();
        hashSet.put(null, 1);
        hashSet.put(null, 2);
        System.out.println(hashSet.get(null));
    }
}
