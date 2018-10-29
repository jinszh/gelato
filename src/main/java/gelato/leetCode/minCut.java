package gelato.leetCode;

public class minCut {

    Integer [][] memo;

    public int minCut(String s) {
        if (s != null && s.length() > 0) {
            memo = new Integer[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                getParlindrome(i, i, s);
                if (i - 1 >= 0 && s.charAt(i - 1) == s.charAt(i)) {
                    getParlindrome(i - 1, i, s);
                }
                if (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i)) {
                    getParlindrome(i, i + 1, s);
                }
            }
            if (memo[0][s.length() - 1] == null) {
                findMin(s, 0, s.length() - 1);
            }
        }
        return memo[0][s.length() - 1] - 1;
    }

    private void getParlindrome(int i, int j, String s) {
        memo[i][j] = 1;
        int c = 1;
        while (i - c >= 0 && j + c < s.length() && s.charAt(i - c) == s.charAt(j + c) && memo[i - c][j + c] == null) {
            memo[i - c][j + c] = 1;
            c++;
        }
    }

    private int findMin(String s, int i, int j){
        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k ++){
            int ik = memo[i][k] != null ? memo[i][k] : findMin(s, i, k);
            int kj = memo[k+1][j] != null ? memo[k+1][j] : findMin(s, k+1, j);
            if(ik + kj < min){
                min = ik + kj;
            }
            if(min == 2){
                break;
            }
        }
        memo[i][j] = min;
        return  min;
    }
}
