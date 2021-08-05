package gelato.leet0;

//29
public class divide {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int sign = (divisor > 0 && dividend < 0) || (divisor < 0 && dividend > 0) ? -1 : 1;
        long de = dividend < 0 ? -(long)dividend : dividend;
        long di = divisor < 0 ? -(long)divisor : divisor;
        int ans = 0;
        while (di <= de) {
            int inner = de >= di ? 1 : 0;
            while (di < de) {
                di <<= 1;
                if (di > de) break;
                inner <<= 1;
            }
            ans += inner;
            de = di > de ? de - (di >> 1) : 0;
            di = divisor < 0 ? -(long)divisor : divisor;
        }
        return sign > 0 ? ans : -ans;
    }
}