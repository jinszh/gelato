package gelato.leet9;

public class brokenCalc {
    public int brokenCalc(int X, int Y) {
        if (X > Y) {
            return X - Y;
        } else {
            double times = X > 0 ? (double) Y / (double) X : 0;
            int doubles = (int) (Math.log(times) / Math.log(2));
            if (Math.pow(2, doubles) < times) {
                doubles += 1;
            }
            int n = doubles;
            int subs = X * (int) Math.pow(2, doubles) - Y;
            while (subs > 1 && doubles > 0){
                int logRem = (int)(Math.log(subs) / Math.log(2));
                if(logRem < doubles){
                    subs -= (int) Math.pow(2, logRem);
                }else {
                    subs -= (int) Math.pow(2, doubles);
                }
                n++;
            }
            return subs + n;
        }
    }

    /*If Y <= X, we won't do Y / 2 anymore.
We will increase Y until it equals to X

So before that, while Y > X, we'll keep reducing Y, until it's smaller than X.
If Y is odd, we can do only Y = Y + 1
If Y is even, if we plus 1 to Y, then Y is odd, we need to plus another 1.
And because (Y + 1 + 1) / 2 = (Y / 2) + 1, 3 operations are more than 2.
We always choose Y / 2 if Y is even.*/
    //因为X到Y变化过程中, 出现双数,要么是double得到的,要么是double之后减两次一得到的,这样的话,就应该在乘之前减
    // 所以反推时候, 遇双则除2, 遇单则+1得到的就最优解
    public int brokenCalc_opt(int X, int Y) {
        int res = 0;
        while (Y > X) {
            Y = Y % 2 > 0 ? Y + 1 : Y / 2;
            res++;
        }
        return res + X - Y;
    }
}
