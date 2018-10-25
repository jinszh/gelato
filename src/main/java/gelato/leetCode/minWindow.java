package gelato.leetCode;

import java.util.HashMap;
import java.util.HashSet;

public class minWindow {
    public String minWindow(String s, String t) {
        String m = "";
        HashMap<Character, Integer> set = new HashMap<>();
        HashMap<Character, Integer> n = new HashMap<>();
        for (Character c : t.toCharArray()) {
            int count = set.getOrDefault(c, 0);
            set.put(c, count + 1);
        }
        int required = set.size();
        int formed = 0;
        int len = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < s.length();) {
            if (formed != required && j < s.length()&& set.containsKey(s.charAt(i))) {
                if(set.containsKey(s.charAt(j))) {
                    int count = n.getOrDefault(s.charAt(j), 0);
                    n.put(s.charAt(j), count + 1);
                    if (set.get(s.charAt(j)) == n.getOrDefault(s.charAt(j), 0)) {
                        formed++;
                    }
                }
                j++;
            } else {
                if (set.containsKey(s.charAt(i))) {
                    int cnt = n.get(s.charAt(i));
                    if (cnt == 1) {
                        n.remove(s.charAt(i));
                    } else {
                        n.put(s.charAt(i), cnt - 1);
                    }
                    if(n.getOrDefault(s.charAt(i), 0) < set.getOrDefault(s.charAt(i), 0)) {
                        formed--;
                    }
                    if (j < i) {
                        j = i;
                    }
                }
                i++;
            }
            if (formed == required && j - i < len) {
                len = j - i;
                m = s.substring(i, j);
            }

        }
        return m;
    }
}
