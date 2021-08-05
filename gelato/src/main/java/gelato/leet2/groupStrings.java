package gelato.leet2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//249
public class groupStrings {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            int shift = s.length() > 0 ? s.charAt(0) - 'a' : 0;
            char[] cs = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                cs[i] += cs[i] - 'a' > shift ? -shift : 26 - shift;
            }
            String key = new String(cs);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
