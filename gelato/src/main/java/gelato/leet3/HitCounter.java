package gelato.leet3;

import java.util.LinkedList;

//362
public class HitCounter {
    LinkedList<Integer> hist = new LinkedList<>();
    /** Initialize your data structure here. */
    public HitCounter() {

    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        hist.add(timestamp);
        while (hist.peekFirst() < timestamp - 300){
            hist.pollFirst();
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!hist.isEmpty() && hist.peekFirst() < timestamp - 300){
            hist.pollFirst();
        }
        return hist.size();
    }
}
