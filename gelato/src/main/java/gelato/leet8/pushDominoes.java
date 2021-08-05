package gelato.leet8;

import java.util.Arrays;

//838
public class pushDominoes {
    public String pushDominoes(String dominoes) {
        char [] res = new char[dominoes.length()];
        Integer r = null;
        int last = 0;
        for(int i = 0; i < dominoes.length(); i++){
            char c = dominoes.charAt(i);
            if(c == 'L'){
                if(r == null){
                    Arrays.fill(res, last, i + 1, 'L');
                }else {
                    Arrays.fill(res, r, r + (i - r + 1) / 2, 'R');
                    Arrays.fill(res, i + 1 - (i - r + 1) / 2, i + 1, 'L');
                    if ((i - r + 1) % 2 != 0) {
                        res[r + (i - r + 1) / 2] = '.';
                    }
                    r = null;
                }
                last = i + 1;
            } else if (c == 'R') {
                if(r != null){
                    Arrays.fill(res, r, i, 'R');
                }else {
                    Arrays.fill(res, last, i , '.');
                }
                r = i;
            }
        }
        if(r != null){
            Arrays.fill(res, r, res.length, 'R');
        }else {
            Arrays.fill(res, last, res.length, '.');
        }
        return new String(res);
    }
}
