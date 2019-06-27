package gelato.leet6;

import java.util.*;

public class LogSystem {
    TreeMap<Long, List<Integer>> logs;
    public LogSystem() {
        logs = new TreeMap<>();
    }

    public void put(int id, String timestamp) {
        Long key = convertKey(timestamp);
        List l = logs.getOrDefault(key, new ArrayList<>());
        l.add(id);
        logs.put(key, l);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new ArrayList<>();
        switch (gra) {
            case "Year":
                s = s.substring(0, 4) + ":00:00:00:00:00";
                e = e.substring(0, 4) + ":12:31:23:59:59";
                break;
            case "Month":
                s = s.substring(0, 7) + ":00:00:00:00";
                e = e.substring(0, 7) + ":31:23:59:59";
                break;
            case "Day":
                s = s.substring(0, 10) + ":00:00:00";
                e = e.substring(0, 10) + ":23:59:59";
                break;
            case "Hour":
                s = s.substring(0, 13) + ":00:00";
                e = e.substring(0, 13) + ":59:59";
                break;
            case "Minute":
                s = s.substring(0, 16) + ":00";
                e = e.substring(0, 16) + ":59";
                break;
            default:
        }
        Long keys = logs.ceilingKey(convertKey(s));
        Long keye = logs.floorKey(convertKey(e));
        if(keys != null && keye != null && keye >= keys) {
            Map<Long, List<Integer>> map = logs.subMap(keys, true, keye, true);
            for (Long k : map.keySet()) {
                res.addAll(map.get(k));
            }
        }
        return res;
    }

    private Long convertKey(String timestamp){
        return Long.parseLong(timestamp.replace(":", "").trim());
    }
}
