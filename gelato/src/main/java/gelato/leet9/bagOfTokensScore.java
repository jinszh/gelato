package gelato.leet9;

import java.util.Arrays;

//948
public class bagOfTokensScore {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int l = 0, r = tokens.length - 1;
        int c = 0;
        int res = 0;
        while (l < tokens.length && P > tokens[l]){
            while (l < tokens.length && P > tokens[l]){
                c++;
                P -= tokens[l++];
            }
            res = Math.max(res, c);
            if(c > 0){
                P += tokens[r--];
                c--;
            }
        }
        return res;
    }
}
