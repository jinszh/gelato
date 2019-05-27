package gelato.leet7;

import java.util.TreeMap;

public class MyCalendar {
    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        Integer floors = map.floorKey(start);
        Integer floore = map.floorKey(end - 1);
        if((floors == null || map.get(floors) <= start)
            && (floore == null || map.get(floore) <= start)){
            map.put(start, end);
            return true;
        }else {
            return false;
        }
    }

    TreeMap<Integer, Integer> map = new TreeMap<>();
}
