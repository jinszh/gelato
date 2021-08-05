package gelato.leet3;

//351 - 这道题题目好像有点问题
public class numberOfPatterns {
    int min = 0, max = 0;
    public int numberOfPatterns(int m, int n) {
        if(n <= 0) return 0;
        boolean [] selected  = new boolean[9];
        min = m;
        max = n;
        return dfs(selected, -1, 0);
    }

    private int dfs(boolean [] selected, int cur, int step) {
        int res = 0;
        for (int i = 0; i < 9; i++) {
            if (!selected[i] && ( cur < 0 || (Math.abs(cur / 3 - i / 3) <= 1 && Math.abs(cur % 3 - i % 3) <= 1)
                    || (selected[(cur / 3 + i / 3) / 2 * 3 + (cur % 3 + i % 3) / 2]))) {
                selected[i] = true;
                if (step + 1 >= min) res++;
                if (step + 1 < max) {
                    res += dfs(selected, i, step + 1);
                }
                selected[i] = false;
            }
        }
        return res;
    }
}
