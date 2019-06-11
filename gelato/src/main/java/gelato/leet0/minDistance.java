package gelato.leet0;

//72
public class minDistance {
    public int minDistance(String word1, String word2) {
        int [][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[word1.length()][word2.length()] = 0;
        for(int i = 0; i < word1.length(); i++){
            dp[i][word2.length()] = word1.length() - i;
        }
        for(int j = 0; j < word2.length(); j++){
            dp[word1.length()][j] = word2.length() - j;
        }
        for(int i = word1.length() - 1; i >=0; i--){
            for(int j = word2.length() - 1; j >= 0; j--){
                int cur;
                if(word1.charAt(i) == word2.charAt(j)){
                    cur = dp[i + 1][j + 1];
                }else {
                    cur = Math.min(dp[i + 1][j + 1] + 1, Math.min(dp[i][j + 1], dp[i + 1][j]) + 1);
                }
                dp[i][j] = cur;
            }
        }
        return dp[0][0];
    }
}
