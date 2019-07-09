package gelato.leet3;

public class countNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 1){
            return 10;
        }
        int res = 9;
        int fac = 9;
        for(int i = 1; i < n; i++){
            res *= fac;
        }
        return res;
    }
}
