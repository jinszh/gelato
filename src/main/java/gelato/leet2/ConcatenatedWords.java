package gelato.leet2;

import gelato.leet2.WordSquares;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {
    class Node {
        Node[] nodes;
        String word;

        Node() {
            this.nodes = new Node[26];
            this.word = null;
        }
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Node root = new Node();
        for(String w : words) {
            Node p = root;
            for (char c : w.toCharArray()) {
                if (p.nodes[c - 'a'] == null) {
                    p.nodes[c - 'a'] = new Node();
                }
                p = p.nodes[c - 'a'];
            }
            p.word = w;
        }

        for(String w : words){
            if(find(w, root, 0, 0)){
                res.add(w);
            }
        }
        return res;
    }

    private boolean find(String w, Node root, int i, int cnt) {
        Node p = root;
        boolean sub = false;
        for (int c = i; c < w.length(); c++) {
            p = p.nodes[w.charAt(c) - 'a'];
            if (p == null) break;
            if (p.word != null && c < w.length() - 1) {
                sub = find(w, root, c + 1, cnt + 1);
                if (sub) {
                    break;
                }
            }
        }
        if (sub || (p != null && cnt > 0 && p.word != null)) {
            return true;
        } else {
            return false;
        }
    }
}
