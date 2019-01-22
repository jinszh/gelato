package gelato.leetCode;

public class lengthOfLongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int v = 0;
        int i = 0, j = 0;
        if(s!= null && s.length() > 0){
            char c1 = s.charAt(0);
            int n1 = 0, n2 = 0;
            while (i < s.length() && s.charAt(i) == c1){
                n1++;
                i++;
            }
            v = n1;
            int ii1 = i;
            char cc1 = i < s.length() ? s.charAt(i) : 'd';
            while (i < s.length()) {
                j = i;
                while (j < s.length() && (s.charAt(j) == s.charAt(i) || s.charAt(j) == c1)){
                    if(s.charAt(j) != cc1){
                        ii1 = j;
                        cc1 = s.charAt(j);
                    }
                    n2++;
                    j++;
                }
                if (n1 + n2 > v) {
                    v = n1 + n2;
                }
                n1 = j - ii1;
                n2 = 0;
                c1 = cc1;
                cc1 = j < s.length() ? s.charAt(j) : 'd';
                ii1 = j;
                i = j;
            }
        }
        return v;
    }
}
