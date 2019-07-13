package gelato.leet5;

import java.util.ArrayList;
import java.util.List;

//544
public class findContestMatch {
    public String findContestMatch(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n / 2; i++) {
            res.add(String.format("(%d,%d)", i, n - i + 1));
        }
        while (res.size() > 1) {
            List<String> nxt = new ArrayList<>();
            int l = 0, r = res.size() - 1;
            while (l < r) {
                nxt.add(String.format("(%s,%s)", res.get(l), res.get(r)));
                l++;
                r--;
            }
            res = nxt;
        }
        return res.get(0);
    }

    //用string array且不用创建新的用来赋值的话快很多
    public String findContestMatch_(int n) {
        String[] m = new String[n];
        for (int i = 0; i < n; i++) {
            m[i] = String.valueOf(i + 1);
        }

        while (n > 1) {
            for (int i = 0; i < n / 2; i++) {
                m[i] = "(" + m[i] + "," + m[n - 1 - i] + ")";
            }
            n /= 2;
        }

        return m[0];
    }
}
