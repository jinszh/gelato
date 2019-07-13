package gelato.leet2;


//208
public class Trie {
    Trie [] children;
    boolean isWord;
    /**
     * Initialize your data structure here.
     */
    public Trie() {
        children = new Trie[26];
        isWord = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie p = this;
        for(char c: word.toCharArray()){
            if(p.children[c - 'a'] == null){
                p.children[c - 'a'] = new Trie();
            }
            p = p.children[c - 'a'];
        }
        p.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie p = this;
        for (char c : word.toCharArray()) {
            if(p.children[c - 'a'] == null) return false;
            p = p.children[c - 'a'];
        }
        return p.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie p = this;
        for (char c : prefix.toCharArray()) {
            if(p.children[c - 'a'] == null) return false;
            p = p.children[c - 'a'];
        }
        return true;
    }
}
