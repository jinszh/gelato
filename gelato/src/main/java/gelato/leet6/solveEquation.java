package gelato.leet6;

//640
public class solveEquation {
    public String solveEquation(String equation) {
        int co = 0, cons = 0, v = 0, sign = 1, rsign = 1;
        char[] cs = (equation + "$").replace(" ", "").toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= '0' && cs[i] <= '9') {
                v = v * 10 + cs[i] - '0';
            } else {
                int nxtSign = 1;
                if (cs[i] == 'x') {
                    if (v == 0) {
                        if (!(i > 0 && cs[i - 1] == '0')) v = 1;
                    }
                    co += v * sign * rsign;
                    v = 0;
                } else {
                    cons += v * sign * rsign;
                    if (cs[i] == '=') {
                        rsign = -1;
                    } else if (cs[i] == '-') {
                        nxtSign = -1;
                    }
                    v = 0;
                }
                sign = nxtSign;
            }
        }
        return co == 0 && cons == 0 ? "Infinite solutions"
                : (co * cons == 0 ? "No solution" : "x=" + Integer.toString(-cons / co));
    }
}
