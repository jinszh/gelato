package gelato.leet3;

//343
public class integerBreak {
    Integer[] memo;
    int max = 0;

    public int integerBreak(int n) {
        if (memo == null) {
            memo = new Integer[n + 1];
            memo[1] = 1;
        }

        if (memo[n] != null) {
            max = memo[n];
        } else {
            memo[n] = -1;
            for (int i = 1; i <= (n + 1) / 2; i++) {
                memo[n] = Math.max(memo[n], Math.max(i, integerBreak(i)) * Math.max(n - i,  integerBreak(n - i)));
            }
        }
        return max;
    }
}
