package gelato.leet2;

import java.util.*;

//267
public class generatePalindromes {
    public List<String> generatePalindromes(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean has1 = false;
        for(char c : map.keySet()) {
            if (map.get(c) % 2 != 0 && has1) {
                return res;
            } else if (map.get(c) % 2 != 0) {
                has1 = true;
            }
        }
        help(0, map, new char[s.length()], res);
        return res;
    }

    private void help(int idx, HashMap<Character, Integer> charmap, char[] cur, List<String> res) {
        if ((idx + 1) * 2 >= cur.length && charmap.size() == 1) {
            char key = (char) charmap.keySet().toArray()[0];
            if ((idx + 1) * 2 > cur.length && charmap.get(key) == 1) {
                cur[idx] = key;
                res.add(new String(cur));
            } else if ((idx + 1) * 2 == cur.length && charmap.get(key) == 2) {
                cur[idx] = cur[idx + 1] = key;
                res.add(new String(cur));
            }
        } else if (idx * 2 < cur.length) {
            Set<Character> set = new HashSet<>(charmap.keySet());
            for (char c : set) {
                if (charmap.get(c) >= 2) {
                    if (charmap.get(c) == 2) {
                        charmap.remove(c);
                    } else {
                        charmap.put(c, charmap.get(c) - 2);
                    }
                    cur[idx] = cur[cur.length - 1 - idx] = c;
                    help(idx + 1, charmap, cur, res);
                    charmap.put(c, charmap.getOrDefault(c, 0) + 2);
                }
            }
        }
    }
}
