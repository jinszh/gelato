package gelato.leet2;

//264
public class nthUglyNumber {
    public int nthUglyNumber(int n) {
        int i2 = 1, i3 = 1, i5 = 1;
        int [] res = new int[n + 1];
        res[1] = 1;
        int cur = 2;
        while (cur <= n) {
            if (res[i2] * 2 < res[i3] * 3 && res[i2] * 2 < res[i5] * 5) {
                res[cur++] = res[i2] * 2;
                i2++;
            } else if (res[i3] * 3 < res[i2] * 2 && res[i3] * 3 < res[i5] * 5) {
                res[cur++] = res[i3] * 3;
                i3++;
            } else if (res[i5] * 5 < res[i2] * 2 && res[i5] * 5 < res[i3] * 3) {
                res[cur++] = res[i5] * 5;
                i5++;
            } else if (res[i2] * 2 == res[i3] * 3 || res[i2] * 2 == res[i5] * 5) {
                i2++;
            } else if (res[i3] * 3 == res[i5] * 5) {
                i3++;
            }
        }
        return res[n];
    }

    //下面是简单优化,就是少一些if就快很多
    public int nthUglyNumber_simple(int n) {
        int i2 = 1, i3 = 1, i5 = 1;
        int [] res = new int[n + 1];
        int cur = 1;
        int factor2 = 1,factor3 = 1,factor5 = 1;
        while (cur <= n) {
            int min = Math.min(Math.min(factor2,factor3),factor5);
            res[cur++] = min;
            if(factor2 == min)
                factor2 = 2*res[i2++];
            if(factor3 == min)
                factor3 = 3*res[i3++];
            if(factor5 == min)
                factor5 = 5*res[i5++];
        }
        return res[n];
    }
}
