package gelato.leet0;

import java.util.regex.Pattern;
public class numDecodings {
    public int numDecodings(String s) {
        //1 ~ 26
        int [] ways = new int[s.length() + 1];
        ways[s.length()] = ways[s.length() - 1] = 1;
        for(int i = s.length() - 2; i >= 0; i--){
            if(s.charAt(i) == '0')continue;
            if(Integer.parseInt(s.substring(i, i + 2)) <= 26){
                ways[i] = ways[i + 1] + ways[i + 2];
            }
        }
        return ways[0];
    }
}
