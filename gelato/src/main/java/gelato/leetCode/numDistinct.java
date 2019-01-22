package gelato.leetCode;

public class numDistinct {
    Integer memo[][];

    public int numDistinct(String s, String t) {
        memo = new Integer[t.length()][s.length()];
        return findNumDistinct(0, 0, t, s);
    }

    private Integer findNumDistinct(int i, int j, String s, String t) {
        Integer result = 0;
        if (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                if (i < s.length() - 1 && j < t.length() - 1) {
                    result += memo[i + 1][j + 1] != null ? memo[i + 1][j + 1] : findNumDistinct(i + 1, j + 1, s, t);
                } else if (i == s.length() - 1) {
                    result = 1;
                }
            }
            if (j < t.length() - 1) {
                result += memo[i][j + 1] != null ? memo[i][j + 1] : findNumDistinct(i, j + 1, s, t);
            }
            memo[i][j] = result;
        }
        return result;
    }
}