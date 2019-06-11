package gelato.leet7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//737
public class areSentencesSimilarTwo {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        HashMap<String, Integer> map = new HashMap<>();
        int i = 0;
        List<Integer> roots = new ArrayList<>();
        for (List<String> l : pairs) {
            if (!map.containsKey(l.get(0))) {
                roots.add(i);
                map.put(l.get(0), i++);
            }
            if (!map.containsKey(l.get(1))) {
                roots.add(i);
                map.put(l.get(1), i++);
            }
            int r1 = findRoot(map.get(l.get(0)), roots);
            int r2 = findRoot(map.get(l.get(1)), roots);
            if (r1 != r2) {
                roots.set(r1, r2);
            }
        }
        boolean res = true;
        for (i = 0; i < words1.length; i++) {
            if ((!words1[i].equals(words2[i])) && (!map.containsKey(words1[i]) || !map.containsKey(words2[i])
                    || findRoot(map.get(words1[i]), roots) != findRoot(map.get(words2[i]), roots))) {
                res = false;
                break;
            }
        }
        return res;
    }

    private int findRoot(int x, List<Integer> roots){
        while (x != roots.get(x)){
            roots.set(x, roots.get(x));
            x = roots.get(x);
        }
        return x;
    }
}
