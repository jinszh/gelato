package gelato.leetCode;

import java.util.*;

public class findSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (s == null || words == null || words.length == 0 || s.length() < words[0].length() * words.length) return res;
        Map<String, Integer> map = new HashMap();
        Map<String, Integer> cur = new HashMap();
        for (String word: words) {
            if (!map.containsKey(word)) map.put(word, 0);
            map.put(word, map.get(word) + 1);
        }
        int m = words[0].length(), n = s.length(), num = words.length;
        for (int i = 0; i < m; i++) {
            int left = i, right = i, cnt = 0;
            cur = new HashMap();
            for (; right + m <= n; right += m) {
                String sub = s.substring(right, right + m);
                if (!map.containsKey(sub)){
                    cur = new HashMap();
                    cnt = 0;
                    left = right + m;
                }
                else {
                    if (!cur.containsKey(sub)) {
                        cur.put(sub, 0);
                    }
                    cur.put(sub, cur.get(sub) + 1);
                    cnt++;
                    while (cur.get(sub) > map.get(sub)) {
                        String leftSub = s.substring(left, left + m);
                        cur.put(leftSub, cur.get(leftSub) - 1);
                        cnt--;
                        left += m;
                    }
                    if (cnt == num) res.add(left);
                }
            }
        }
        return res;
    }
}
