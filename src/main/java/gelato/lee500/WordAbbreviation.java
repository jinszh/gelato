package gelato.lee500;

import java.util.*;

public class WordAbbreviation {
    class  Trie {
        Trie[] nodes = new Trie[26];
        int[] cnt = new int[26];
        HashMap<Integer, Integer>[] dups = new HashMap[26];
    }

    public List<String> wordsAbbreviation(List<String> dict) {
        Trie root = new Trie();
        List<String> res = new ArrayList<>();
        for (String s : dict) {
            Trie p = root;
            char end = s.charAt(s.length() - 1);
            for (char c : s.toCharArray()) {
                if (p.nodes[c - 'a'] == null) {
                    p.nodes[c - 'a'] = new Trie();
                    Arrays.fill(p.nodes[c - 'a'].cnt, 0);
                }
                p = p.nodes[c - 'a'];
                p.cnt[end - 'a']++;
                if (p.dups[end - 'a'] == null) {
                    p.dups[end - 'a'] = new HashMap<>();
                }
                p.dups[end - 'a'].put(s.length(),
                        p.dups[end - 'a'].containsKey(s.length()) ? p.dups[end - 'a'].get(s.length()) + 1 : 1);

            }
        }
        for (String s : dict) {
            Trie p = root;
            int i = 0;
            char end = s.charAt(s.length() - 1);
            for (; i < s.length() - 3; i++) {
                p = p.nodes[s.charAt(i) - 'a'];
                if (p.cnt[end - 'a'] == 1 || p.dups[end - 'a'].get(s.length()) == 1) {
                    break;
                }
            }
            res.add(i == s.length() - 3 || s.length() <= 3 ? s : s.substring(0, i + 1) + (s.length() - i - 2) + end);
        }
        return res;
    }
}
