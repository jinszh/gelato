package gelato.leet6;

//650
public class minSteps {
    int [] m;
    public int minSteps(int n) {
        if(m == null){
            m = new int[n];
            m[0] = 1;
        }
        if(m[n - 1] > 0) return m[n - 1];
        int min = n;
        for(int i = 2; i <= min; i++){
            if(n % i == 0){
                min = Math.min(min, minSteps(n / i) * i);
            }
        }
        m[n-1] = min;
        return min;
    }

    //优化版 - Greedy - 不过不知道怎么证明
    public int minSteps_you(int n) {
        int s = 0;
        for (int d = 2; d <= n; d++) {
            while (n % d == 0) {
                s += d;
                n /= d;
            }
        }
        return s;
    }
}
