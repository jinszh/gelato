package gelato.leet2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//245
public class shortestWordDistance {
    HashMap<String, List<Integer>> map;
    public int shortestWordDistance(String[] words, String word1, String word2) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
                map.get(words[i]).add(Integer.MAX_VALUE);
            } else {
                int dist = i - map.get(words[i]).get(map.get(words[i]).size() - 1);
                if (map.get(words[i]).get(0) > dist) {
                    map.get(words[i]).set(0, dist);
                }
            }
            map.get(words[i]).add(i);
        }
        if (word1.equals(word2)) {
            return map.get(word1).get(0);
        } else {
            List<Integer> l1 = map.get(word1);
            List<Integer> l2 = map.get(word2);
            int i = 1, j = 1;
            int dist = Integer.MAX_VALUE;
            while (i < l1.size() && j < l2.size()) {
                if (l1.get(i) >= l2.get(j)) {
                    dist = Math.min(l1.get(i) - l2.get(j), dist);
                    j++;
                } else {
                    dist = Math.min(l2.get(j) - l1.get(i), dist);
                    i++;
                }
            }
            return dist;
        }
    }

    //因为只call一遍, 所以其实并不需要hashmap
    public int shortestWordDistance_fast(String[] words, String word1, String word2) {
        long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
        boolean same = word1.equals(word2);
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) {
                if (same) {
                    i1 = i2;
                    i2 = i;
                } else {
                    i1 = i;
                }
            } else if (words[i].equals(word2)) {
                i2 = i;
            }
            dist = Math.min(dist, Math.abs(i1 - i2));
        }
        return (int) dist;
    }
}
