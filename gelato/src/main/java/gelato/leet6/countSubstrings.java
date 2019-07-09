package gelato.leet6;

//647
public class countSubstrings {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res++;
            for (int j = i - 1, k = i + 1; j >= 0 && k < s.length(); j--,k++ ) {
                if(s.charAt(j) == s.charAt(k)){
                    res++;
                }else {
                    break;
                }
            }
            if(i < s.length() - 1 && s.charAt(i + 1) == s.charAt(i)){
                res++;
                for (int j = i - 1, k = i + 2; j >= 0 && k < s.length(); j--,k++ ) {
                    if(s.charAt(j) == s.charAt(k)){
                        res++;
                    }else {
                        break;
                    }
                }
            }
        }
        return res;
    }

    //另外一个方法 - Manacher's Algorithm - 算回文的教科书算法 - O(N)
    /*
    https://www.hackerrank.com/topics/manachers-algorithm
    插入#是为了避免bb这种情况 前面一个b和后面b都可以作为center, 比如abba -> a#b#b#a, center就变成中间哪个#了
    (1):P table 定义 : the radius of the largest odd-length palindromic substring centered at index. P(i) = R - i
        i = 1 2 3 4 5 6 7 8 9

        T = # a # b # b # a #

        P = 0 1 0 1 4 1 0 1 0
     (2)对于某个i, 假设对于i前面的某个center的回文的right boundary超过了i
        假设对与i的mirror的位置在i', 则 i - C = C - i', i' = 2C - i. 而可以确定的是, i的回文长度至少是i'的回文长度,与i到right boundary之间距离的最小值
        L--<p'---i'---p'>------C-----<p---i---p>--R
        因为少了重复计算i到R这一段的回文, 新增加出来的boundary只会被处理一次, 所以复杂度为O(N)
     */
    public int countSubstrings_textbook(String S) {
        char[] A = new char[2 * S.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int t = 2;
        for (char c: S.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }

        int[] P = new int[A.length];
        int center = 0, right = 0;
        for (int i = 1; i < P.length - 1; ++i) {
            if (i < right)
                P[i] = Math.min(right - i, P[2 * center - i]);
            while (A[i + P[i] + 1] == A[i - P[i] - 1]) //关键就在这里
                P[i]++;
            if (i + P[i] > right) {
                center = i;
                right = i + P[i];
            }
        }
        int ans = 0;
        for (int v: P) ans += (v + 1) / 2;
        return ans;
    }
}
