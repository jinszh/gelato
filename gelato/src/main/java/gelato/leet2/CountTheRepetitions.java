package gelato.leet2;

import gelato.util.Util;

public class CountTheRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int[] len = new int[s1.length()];
        for (int i = 0; i < s1.length(); i++) {
            int ilen = 0;
            int j = i;
            boolean noMatch = false;
            for (char c : s2.toCharArray()) {
                int cPos = j;
                while (s1.charAt(j) != c && (j + 1) % s1.length() != cPos) {
                    j = (j + 1) % s1.length();
                    ilen++;
                }
                if (s1.charAt(j) != c) {
                    noMatch = true;
                    break;
                }
                j = (j + 1) % s1.length();
                ilen++;
            }
            if (noMatch) {
                len[i] = -1;
                break;//no need to check the following
            } else {
                len[i] = ilen;
            }
        }
        if (len[0] < 0) {
            return 0;
        }
        int len1 = 0, in2 = 0;
        int nxt = 0;
        while (len1 + len[nxt] <= n1 * s1.length()) {
            len1 += len[nxt];
            in2++;
            nxt = (nxt + len[nxt]) % s1.length();
            if(nxt == 0) break;
//            if ((nxt + len[nxt]) % s1.length() == len[0] % s1.length()) { //looped
//                break;
//            }
        }

        int in1 = len1 % s1.length() == 0 ? len1 / s1.length() : len1 / s1.length() + 1;
        if (in2 == 0) { // cannot cover n2 * s2
            return 0;
        } else {
            int par1 = (n1 / in1) * in2;
            if (n1 % in1 != 0) {
                len1 = len[0];
                nxt = 0;
                while (len1 <= (n1 % in1) * s1.length()) {
                    par1++;
                    nxt = len[nxt] % s1.length();
                    len1 += len[nxt];
                }
            }
            return par1 / n2;
        }
    }
}
