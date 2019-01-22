package gelato.leet2;

import java.util.Arrays;

//440
public class KthLexicoOrder {
    public int findKthNumber(int n, int k) {
        int digitN = 1;
        int ndiv = n;
        while (ndiv / 10 > 0) {
            digitN++;
            ndiv = ndiv / 10;
        }
        int[] ful = new int[digitN + 1];
        ful[0] = 1;
        for (int i = 1; i < digitN + 1; i++) {
            ful[i] = ful[i - 1] + (int) Math.pow(10, i);
        }
        int[] sum = new int[10];
        int res = 0;
        int digit = digitN - 1;
        while (k > 0 && n > 0) {
            int div = n / (int) Math.pow(10, digit);
            int rem = n % (int) Math.pow(10, digit);
            for (int i = 0; i <= 10; i++) {
                if (digit == digitN - 1 && i <= 0) continue;
                if (div > i) {
                    sum[i] = i == 0 && digit != digitN - 1 ? ful[digit] + 1 : ful[digit];
                } else if (div == i) {
                    sum[i] = (digit > 0 ? ful[digit - 1] : 0) + rem + (i > 0 ? 1 : 0);
                } else {
                    sum[i] = ful[digit - 1];
                }
                sum[i] += i > 0 ? sum[i - 1] : 0;
                if (k <= sum[i]) {
                    res = res * 10 + i;
                    if (k == sum[i]) {
                        k = 0;//result found, exit
                        if (digit > 0) {
                            if (div == i) {
                                res = res * (int) Math.pow(10, digit) +
                                        (digit > 1 && rem / 10 < Math.pow(10, digit - 1) - 1 ? (int) Math.pow(10, digit - 1) - 1 : rem);
                            } else if(div < i){
                                res = res * (int) Math.pow(10, digit - 1) + (int) Math.pow(10, digit - 1) - 1;
                            }else {
                                res = res * (int) Math.pow(10, digit) + (int) Math.pow(10, digit) - 1;

                            }
                        }
                    }
                    k -= i > 0 ? sum[i - 1] : (digit != digitN - 1 ? 1 : 0);
                    n = div > i ? (int) Math.pow(10, digit) - 1 :
                            (div == i ? (int) Math.max(rem, Math.pow(10, digit - 1) - 1) :
                                    (int) Math.pow(10, digit - 1) - 1);
                    if (div < i || (div == i && rem < Math.pow(10, digit - 1) - 1)) {
                        if(div == i && rem < Math.pow(10, digit - 1) - 1) { // skipped 0, eg, 100 --> 19
                            k--;
                        }
                        digit -= 2;
                    } else {
                        digit--;
                    }
                    break;
                }
            }
            if (k == 1) break;
        }
        return res;
    }
}
