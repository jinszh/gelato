package gelato.leet2;


import java.util.HashMap;

public class LongestSubStringWithKChar {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = 0;
        int b = 0;
        int e = 0;
        int c = 0;
        while (e < s.length() && k > 0) {
            if (!map.containsKey(s.charAt(e)) || map.get(s.charAt(e)) == 0) {
                map.put(s.charAt(e), 0);
                c++;
            }
            while (c > k) {
                map.put(s.charAt(b), map.get(s.charAt(b)) - 1);
                if (map.get(s.charAt(b)) == 0) {
                    c--;
                }
                b++;
            }

            map.put(s.charAt(e), map.get(s.charAt(e)) + 1);
            e++;
            if (e - b > len) {
                len = e - b;
            }
        }
        return len;
    }
}
