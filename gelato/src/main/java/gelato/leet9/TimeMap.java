package gelato.leet9;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    Map<String, TreeMap<Integer, String>> mapMap;
    public TimeMap() {
        mapMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!mapMap.containsKey(key)){
            mapMap.put(key, new TreeMap<>());
        }
        mapMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        Integer timeKey = mapMap.getOrDefault(key, new TreeMap<>()).floorKey(timestamp);
        if(timeKey != null){
            return mapMap.get(key).get(timeKey);
        }
        return null;
    }
}
