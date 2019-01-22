package gelato.algos;
//快速幂
public class Power {
    public double Power(double base, int exponent) {
        double result = 1;
        double multiplier = base;
        int exp = Math.abs(exponent);
        while (exp > 0){
            if((exp & 1) > 0){
               result *= multiplier;
            }
            exp >>= 1;
            multiplier *= multiplier;
        }
        if(exponent < 0){
            result = 1 / result;
        }
        System.out.println(result);
        return result;
    }
}
