package gelato.leet0;

import java.util.HashMap;
import java.util.HashSet;

//3
public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        for(int i = 0, j = 0; i < s.length(); i++){
            while (set.contains(s.charAt(i))){
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));
            max = Math.max(max, i - j);
        }
        return max;
    }
}
