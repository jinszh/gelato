package gelato.leet8;

//809
public class expressiveWords {
    public int expressiveWords(String S, String[] words) {
        int cnt = 0;
        for (String w : words) {
            if (isStretchy(S, w)) cnt++;
        }
        return cnt;
    }

    private boolean isStretchy(String s, String word) {
        int i = 0, j = 0;
        while (i < s.length() && j < word.length()) {
            int nexti = i, nextj = j;
            while (nexti < s.length() && s.charAt(nexti) == s.charAt(i)) nexti++;
            while (nextj < word.length() && word.charAt(nextj) == word.charAt(j)) nextj++;
            if (s.charAt(i) == word.charAt(j) && (nexti - i == nextj - j || nexti - i >= nextj - j + 2)) {
                i = nexti;
                j = nextj;
            } else {
                break;
            }
        }
        return i == s.length();
    }

    //正确答案 题目看不懂
    public int expressiveWords2(String S, String[] words) {
        int res = 0;
        for (String W : words) if (check(S, W)) res++;
        return res;
    }
    public boolean check(String S, String W) {
        int n = S.length(), m = W.length(), j = 0;
        for (int i = 0; i < n; i++)
            if (j < m && S.charAt(i) == W.charAt(j)) j++;
            else if (i > 1 && S.charAt(i) == S.charAt(i - 1) && S.charAt(i - 1) == S.charAt(i - 2));
            else if (0 < i && i < n - 1 && S.charAt(i - 1) == S.charAt(i) && S.charAt(i) == S.charAt(i + 1));
            else return false;
        return j == m;
    }
}
