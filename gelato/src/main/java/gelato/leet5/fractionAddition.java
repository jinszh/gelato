package gelato.leet5;

//592
public class fractionAddition {
    public String fractionAddition(String expression) {
        char[] cs = (expression + "@").trim().replace(" ", "").toCharArray();
        int v = 0, n = 0, pren = 0, d = 1, sign = 1;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= '0' && cs[i] <= '9') {
                v = v * 10 + cs[i] - '0';
            } else if (cs[i] == '/') {
                n = sign * v;
                v = 0;
                sign = 1;
            } else {
                if(v != 0){
                    int lcm = lcm(v, d);
                    pren *= lcm / d;
                    n *= lcm / v;
                    pren += n * sign;
                    d = lcm;
                }
                if (cs[i] == '+') {
                    sign = 1;
                } else {
                    sign = -1;
                }
                v = 0;
            }
        }
        return pren / gcd(Math.abs(pren), d) + "/" + d / gcd(Math.abs(pren), d);
    }

    private int gcd(int a, int b) {
        while (a % b != 0) {
            int swap = a;
            a = b;
            b = swap % b;
        }
        return b;
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
