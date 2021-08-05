package gelato.leet8;

import java.util.LinkedList;
import java.util.List;

//842
public class splitIntoFibonacci {
    public List<Integer> splitIntoFibonacci(String S) {
        LinkedList<Integer> res = new LinkedList<>();
        int m = 1, cur = 0;
        for (int i = S.length() - 1; i > 2 && i >= S.length() - 11; i--) {
            cur += m * (S.charAt(i) - '0');
            m *= 10;
            if (i < S.length() - 1 && S.charAt(i) == '0') continue;
            res.push(cur);
            for (int j = i - 1; j > 0 && j >= i - (S.length() - i); j--) {
                if (j < i - 1 && S.charAt(j) == '0') continue;
                long tmp = Long.parseLong(S.substring(j, i));
                if(tmp > Integer.MAX_VALUE - 1) continue;
                int m2 = (int)tmp;
                res.push(m2);
                if (m2 <= cur && sub(S, j, cur - m2, m2, res)) {
                    return res;
                }
                res.pop();
            }
            res.pop();
        }
        return new LinkedList<>();
    }

    private boolean sub(String num, int end, int sum, int par, LinkedList<Integer> res) {
        if (!num.substring(0, end).endsWith(Long.toString(sum))) return false;
        else {
            res.push(sum);
            if (end == Long.toString(sum).length()
                    || sub(num, end - Integer.toString(sum).length(), par - sum, sum, res)) {
                return true;
            } else {
                res.pop();
                return false;
            }
        }
    }
}
