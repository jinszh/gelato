package gelato.leet5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//582
public class killProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < pid.size(); i++){
            List l = map.getOrDefault(ppid.get(i), new ArrayList<>());
            l.add(pid.get(i));
            map.put(ppid.get(i), l);
        }
        List<Integer> res = new ArrayList<>();
        kill(res, kill, map);
        return res;
    }
    private void kill(List<Integer> res, Integer i, HashMap<Integer, List<Integer>> map){
        res.add(i);
        for(Integer j : map.get(i)){
            kill(res, j, map);
        }
    }
}
