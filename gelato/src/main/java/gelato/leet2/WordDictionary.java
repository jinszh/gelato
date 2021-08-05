package gelato.leet2;

import gelato.util.Trie;

import java.util.HashMap;
import java.util.Map;

//211
public class WordDictionary {

    Map<Integer,TrieNode> trieMap = new HashMap<Integer,TrieNode>();
    public WordDictionary() {
    }


    public void addWord(String word) {
        if(!trieMap.containsKey(word.length())){
            trieMap.put(word.length(), new TrieNode());
        }
        TrieNode root = trieMap.get(word.length());
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int j = i;
            if(root.children[c - '.'] == null){
                root.children[c - '.'] = new TrieNode();
            }
            root = root.children[c - '.'];
            for(; j < word.length() && word.charAt(j) == word.charAt(i); j++);
            if(j == word.length()) {
                root.len = j - i;
                break;
            }
        }
    }

    public boolean search(String word) {
        if (!trieMap.containsKey(word.length())) return false;
        TrieNode root = trieMap.get(word.length());
        return root != null && search(root, 0, word.toCharArray());
    }

    private boolean search(TrieNode root, int beg, char [] cs) {
        for (int i = beg; i < cs.length; i++) {
            if (cs[i] != '.' && root.children[cs[i] - '.'] == null) {
                return false;
            } else if (cs[i] == '.') {
                if (i == cs.length - 1) return true;
                for (TrieNode t : root.children) {
                    if (t != null && search(t, i + 1, cs)) {
                        return true;
                    }
                }
                return false;
            }
            root = root.children[cs[i] - '.'];
            int j = i;
            for (; j < cs.length && cs[j] == cs[i]; j++) ;
            if (j == cs.length) {
               return root.len ==  j - i;
            }
        }
        return true;
    }

    class TrieNode{
        TrieNode children[];
        int len = 0;  //record the number of character that is continuously duplicated
        public TrieNode(){
            children = new TrieNode[512];
        }
    }
}
