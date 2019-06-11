package gelato.leet5;

//583
public class minDistance {
    public int minDistance(String word1, String word2) {
        int [][] steps = new int[word1.length() + 1][word2.length() + 1];
        steps[word1.length()][word2.length()] = 0;
        for(int i = 0; i < word1.length(); i++){
            steps[i][word2.length()] = word1.length() - i;
        }
        for(int j = 0; j < word2.length(); j++){
            steps[word1.length()][j] = word2.length() - j;
        }
        for(int i = word1.length() - 1; i >=0; i--){
            for(int j = word2.length() - 1; j >= 0; j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    steps[i][j] = steps[i + 1][j + 1];
                }else {
                    steps[i][j] = Math.min(steps[i + 1][j], steps[i][j+1]) + 1;
                }
            }
        }
        return steps[0][0];
    }
}
