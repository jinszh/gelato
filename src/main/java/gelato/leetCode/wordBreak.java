package gelato.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class wordBreak {
    HashMap<Integer, List<String>> memo;
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> words = new ArrayList<>();
        if(s != null && wordDict.size() > 0) {
            //build a dict tree?
            memo = new HashMap<>();
            words = findSeq(s, wordDict, 0);
        }
        return words;
    }

    private List<String> findSeq(String s, List<String> wordDict, Integer pos){
        List<String> l = new ArrayList<>();
        for(String w : wordDict){
            if(s.length() > w.length() && s.startsWith(w)){
                if(!memo.containsKey(pos + w.length())) {
                    findSeq(s.substring(w.length()), wordDict, pos + w.length());
                }
                List<String> sub = memo.get(pos + w.length());
                if(sub != null && sub.size() > 0) {
                    l.addAll(sub.stream().map(x -> w + " " + x).collect(Collectors.toList()));
                }
            }else if(s.equals(w)){
                l.add(w);
            }
        }
        memo.put(pos, l);
        return l;
    }
}
