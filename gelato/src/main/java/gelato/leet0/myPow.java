package gelato.leet0;

import java.util.PriorityQueue;

//50
public class myPow {
    public double myPow(double x, int n) {
        double res = pow(x, Math.abs(n));
        return n < 0 ? (1 / res) : res;
    }

    private double pow(double x, int n){
        if(n <= 10) {
            int i = 0;
            double res = 1;
            while (i < n) {
                res *= x;
                i++;
            }
            return res;
        }else {
            double res = pow(x, n / 10);
            res = pow(res, 10);
            res = res * pow(x, n % 10);
            return res;
        }
    }
}
