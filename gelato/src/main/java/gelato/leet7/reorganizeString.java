package gelato.leet7;

import jdk.internal.util.xml.impl.Pair;

import java.util.*;

//767
public class reorganizeString {
    public String reorganizeString2(String S) {
        if (S == null || S.length() <= 2) return S;
        int len = S.length();
        int[] counts = new int[26];
        for (char c : S.toCharArray())
            counts[c - 'a']++;

        ArrayList<AbstractMap.SimpleEntry<Integer, Character>> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (counts[i] > (len + 1) / 2)
                return "";
            list.add(new AbstractMap.SimpleEntry<>(counts[i], (char)(i + 'a')));
        }
        Collections.sort(list, (a, b) -> (b.getKey() - a.getKey()));
        StringBuilder sb = new StringBuilder();
        for (AbstractMap.SimpleEntry<Integer, Character> pair : list) {
            int cnt = pair.getKey();
            char c = pair.getValue();
            for (int i = 0; i < cnt; i++) {
                sb.append(c);
            }
        }
        StringBuilder res = new StringBuilder();
        int i = 0, j = (len + 1) / 2;
        while (i < (len + 1) / 2) { // 用后半段来插入前半段, 不要一个一个字母插, 有bug, 比如ffffaaaauuuggmm
            res.append(sb.charAt(i++));
            if (j < len)
                res.append(sb.charAt(j++));
        }
        return res.toString();
    }

    //不sort也可以, 记一个max即可
    public String reorganizeString3(String S) {
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        }
        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        if (max > (S.length() + 1) / 2) {
            return "";
        }
        char[] res = new char[S.length()];
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }
}
