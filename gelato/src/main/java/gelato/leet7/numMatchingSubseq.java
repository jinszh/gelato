package gelato.leet7;

import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

//792
public class numMatchingSubseq {
    public int numMatchingSubseq(String S, String[] words) {
        int n = 0;
        for (String word : words) {
            int i = 0, j = 0;
            for (; j < S.length() && i < word.length(); i++, j++) {
                while (j < S.length() && S.charAt(j) != word.charAt(i)) j++;
            }
            if (i == word.length() && j <= S.length()) n++;
        }
        return n;
    }

    //平行处理 - 更快 - 因为相对来说, word应该更短
    public int numMatchingSubseq_parallel(String S, String[] words) {
        List<StringCharacterIterator>[] waiting = new List[128];
        for (int c = 0; c <= 'z'; c++)
            waiting[c] = new ArrayList();
        for (String w : words)
            waiting[w.charAt(0)].add(new StringCharacterIterator(w));
        for (char c : S.toCharArray()) {
            List<StringCharacterIterator> advance = waiting[c];
            waiting[c] = new ArrayList();
            for (StringCharacterIterator it : advance)
                waiting[it.next() % it.DONE].add(it);//it.DONE 是 iterator结束的标志
        }
        return waiting[0].size();
    }
}
