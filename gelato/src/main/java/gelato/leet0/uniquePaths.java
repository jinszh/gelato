package gelato.leet0;

//62
public class uniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[] cnt = new int[n];
        cnt[n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            int[] cnt2 = new int[n];
            cnt2[n - 1] = cnt[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                cnt2[j] = cnt[j] + cnt2[j + 1];
            }
            cnt = cnt2;
        }
        return cnt[0];
    }

    //Math way -> 一共需要m + n步达到终点, 其中m步down, n步right, 所以方式是C(m+n, m) = (m + n)!/(m! * n!)
    public int uniquePaths_m(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if(m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }

        return (int)res;
    }
}
