package gelato.leet5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//567
public class checkInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        if (s1.length() == s2.length() && s1.length() == 0) return true;

        HashMap<Character, Integer> s1perm = new HashMap<>();
        HashMap<Character, Integer> s2perm = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1perm.put(s1.charAt(i), s1perm.getOrDefault(s1.charAt(i), 0) + 1);
            s2perm.put(s2.charAt(i), s2perm.getOrDefault(s2.charAt(i), 0) + 1);
        }
        Set<Character> keysNotMatch = new HashSet<>();
        for (Character c : s1perm.keySet()) {
            if (!s1perm.get(c).equals(s2perm.get(c))) {
                keysNotMatch.add(c);
            }
        }

        int k = s1.length();
        while (keysNotMatch.size() != 0 && k < s2.length()) {
            check(s2.charAt(k), 1, s1perm, s2perm, keysNotMatch);
            check(s2.charAt(k - s1.length()), -1, s1perm, s2perm, keysNotMatch);
            if (keysNotMatch.size() == 0) {
                // System.out.println(k);
                break;
            }
            k++;
        }
        return keysNotMatch.size() == 0;
    }

    private void check(char c, int delta, HashMap<Character, Integer> s1, HashMap<Character, Integer> s2, Set<Character> keysNotMatch){
        if(s1.containsKey(c)) {
            s2.put(c, s2.getOrDefault(c, 0) + delta);
            if (s2.get(c).equals(s1.get(c))) {
                keysNotMatch.remove(c);
            } else if (!keysNotMatch.contains(c)) {
                keysNotMatch.add(c);
            }
        }
    }

    //简洁版
    public boolean checkInclusion2(String s1, String s2) {
        int[] count = new int[128];
        for(int i = 0; i < s1.length(); i++) count[s1.charAt(i)]--;
        for(int l = 0, r = 0; r < s2.length(); r++) {
            if (++count[s2.charAt(r)] > 0){
                while(--count[s2.charAt(l++)] != 0) { /* do nothing */}
            }
            else if ((r - l + 1) == s1.length()) return true;
        }
        return s1.length() == 0;
    }
}
