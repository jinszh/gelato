package gelato.leet6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//648
public class replaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        Trie root = new Trie();
        for(String s : dict){
            addRoot(s, root);
        }
        String [] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++) {
            Trie p = root;
            int j = 0;
            for (; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                p = p.children[c - 'a'];
                if (p == null) break;
                if (p.isRoot) break;
            }
            if (p != null && j < words[i].length()) words[i] = words[i].substring(0, j + 1);
        }
        return Arrays.stream(words).collect(Collectors.joining(" "));
    }

    private void addRoot(String w, Trie root) {
        Trie p = root;
        for (char c : w.toCharArray()) {
            if (p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new Trie();
            }
            p = p.children[c - 'a'];
        }
        p.isRoot = true;
    }

    class Trie{
        Trie [] children = new Trie[26];
        boolean isRoot = false;
    }
}
