package gelato.leet2;

public class shortestPalindrome {
    public String shortestPalindrome(String s) {
        String f = s;
        if (s != null && s.length() > 1) {
            String rev = new StringBuilder(s).reverse().toString();
            char [] cob = ( s + "#" + rev).toCharArray();
            int lps [] = new int[cob.length];
            lps[0] = 0;
            for(int i = 1; i < cob.length; i++){
                int t = lps[i-1];
                while (cob[i] != cob[t] && t > 0){
                    t = lps[t-1];
                }
                if(cob[i] == cob[t]){
                    t++;
                }
                lps[i] = t;
            }
            f = rev.substring(0, rev.length() - lps[cob.length - 1]) + s;
        }
        return f;
    }

    public String shortestPalindrome2(String s) {
        String f = s;
        if (s != null && s.length() > 1) {
            String rev = new StringBuilder(s).reverse().toString();
            int i;
            for (i = s.length() / 2; i >= 1; i--) {
                if ((s.substring(i + 1).startsWith(rev.substring(s.length() - i)))) {
                    f = rev.substring(0, s.length() - i - 1) + s.substring(i);
                    break;
                }
                if (s.charAt(i) == s.charAt(i - 1)) {
                    if ((s.substring(i + 1).startsWith(rev.substring(s.length() - i + 1)))) {
                        f = rev.substring(0, s.length() - i - 1) + s.substring(i - 1);
                        break;
                    }
                }
            }
            if(i == 0) f = rev.substring(0, s.length() - 1) + s;
        }
        return f;
    }
}
