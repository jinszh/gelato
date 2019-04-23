package gelato.leet10;

import java.util.ArrayList;

public class numDupDigitsAtMostN {
    //比如题目找的是至少一个重复的,其实就是找完全没有重复的
    public int numDupDigitsAtMostN(int N) {
        int allcnt = N;
        ArrayList<Integer> digits = new ArrayList<>();
        while (N > 0) {
            digits.add(N % 10);
            N = N / 10;
        }
        int nodups = 0;
        boolean selfDup = false;
        boolean[] used = new boolean[10];
        for (int i = digits.size() - 1, j = 0; i >= 0; i--, j++) {
            selfDup = used[digits.get(i)];
            int usedCnt = 0;
            for (int k = 0; k < digits.get(i); k++) {
                usedCnt += used[k] ? 1 : 0;
            }
            nodups += (i == digits.size() - 1 ? digits.get(i) - 1 - usedCnt : digits.get(i) - usedCnt)
                    * (factorial(9 - j, i, false));
            used[digits.get(i)] = true;
            if(selfDup)break;
        }
        nodups += (selfDup ? 0 : 1);
        for (int i = 1; i < digits.size(); i++) {
            nodups += factorial(9, i, true);
        }
        return allcnt - nodups;
    }

    int factorial(int n, int len, boolean fromStart) { //If from start, the first digit can not be zero but the second can
        int res = len >= 1 ? n : 1;
        for (int i = 1; i < len; i++) {
            res *= (n - i + (fromStart ? 1 : 0));
        }
        return res;
    }
}
