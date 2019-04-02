package conc;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CollectionTests {
    public void t1() {
        HashMap<Integer, Integer> hashSet = new HashMap<Integer, Integer>();
        hashSet.put(null, 1);
        hashSet.put(null, 2);
        System.out.println(hashSet.get(null));
    }

    public void bl() {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>();


        new Thread(() -> {
            try {
                blockingQueue.put(10);
            } catch (InterruptedException e) {
                ;
            }
        }).start();

    }
}