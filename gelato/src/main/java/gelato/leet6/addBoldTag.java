package gelato.leet6;

import java.util.ArrayList;
import java.util.List;

//616
public class addBoldTag {
    //My version
    public String addBoldTag(String s, String[] dict) {
        DictTreeNode root = new DictTreeNode();
        for (String ss : dict) {
            root.addWord(ss.toCharArray(), 0);
        }
        List<int[]> pairs = new ArrayList<>();
        int[] cur = null;
        for (int i = 0; i < s.length(); i++) {
            if (cur != null && i > cur[1]) {
                pairs.add(cur);
                cur = null;
            }
            int end = root.findLongestWord(s.toCharArray(), i, 0);
            if (end > 0 && cur == null) {
                cur = new int[]{i, i + end};
            } else if (cur != null && i + end > cur[1]) {
                cur[1] = i + end;
            }
        }
        if (cur != null) {
            pairs.add(cur);
        }
        if (pairs.size() > 0) {
            StringBuilder sb = new StringBuilder();
            int last = 0;
            for (int i = 0; i < pairs.size(); i++) {
                sb.append(s.substring(last, pairs.get(i)[0]));
                sb.append("<b>");
                sb.append(s.substring(pairs.get(i)[0], pairs.get(i)[1]));
                sb.append("</b>");
                last = pairs.get(i)[1];
            }
            sb.append(s.substring(pairs.get(pairs.size() - 1)[1]));
            return sb.toString();
        } else {
            return s;
        }
    }

    public class DictTreeNode{
        DictTreeNode [] children;

        public DictTreeNode(){
            children = new DictTreeNode[75];
        }

        public int findLongestWord(char [] source, int i, int j) {
            int res = -1;
            if (lastc[source[i + j] - '0']) {
                res = j + 1;
            }
            if (children[source[i + j] - '0'] != null && i + j < source.length - 1) {
                res = Math.max(res, children[source[i + j] - '0'].findLongestWord(source, i, j + 1));
            }
            return res;
        }

        public void addWord(char [] word, int i) {
            if (i == word.length - 1) {
                lastc[word[i] - '0'] = true;
                return;
            }
            if (children[word[i] - '0'] == null) {
                children[word[i] - '0'] = new DictTreeNode();
            }
            children[word[i] - '0'].addWord(word, i + 1);
        }

        boolean [] lastc = new boolean[75];
    }

    //优化版 : 并不需要字典树, 其实直接start with, 记个位子就可以了, 实际写出来这个更快

    public String addBoldTag_optimized(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (int i = 0, end = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            bold[i] = end > i;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                result.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < s.length() && bold[j]) j++;
            result.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }

        return result.toString();
    }
}
