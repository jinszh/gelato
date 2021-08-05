package gelato.leet0;

import java.util.*;

//49
public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] code = new char[26];
            for (char c : s.toCharArray()) {
                code[c - 'a']++;
            }
            String key = new String(code);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
