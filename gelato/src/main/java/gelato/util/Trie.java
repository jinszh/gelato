package gelato.util;

import java.util.HashMap;

public class Trie {
    HashMap<Character, Trie> children;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        children = new HashMap<>();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie p = root;
        for (char c : word.toCharArray()) {
            if (!p.children.containsKey(c)) {
                p.children.put(c, new Trie());
            }
            p = p.children.get(c);
        }
        p.children.put(end, null);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie p = root;
        for (char c : word.toCharArray()) {
            if (!p.children.containsKey(c)) {
                return false;
            }
            p = p.children.get(c);
        }
        return p.children.containsKey(end);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie p = root;
        boolean match = true;
        for (char c : prefix.toCharArray()) {
            Trie pp = p.children.get(c);
            if (pp == null) {
                match = false;
                break;
            }
            p = pp;
        }
        return match;
    }

    private static Trie root = new Trie();
    static char end = '-';
}
