package gelato.leet9;

public class strWithout3a3b {
    public String strWithout3a3b(int A, int B) {
        //subs are only aab bba ab ba
        String res = null;
        StringBuilder sb = new StringBuilder();
        int useda = 0, usedb = 0;
        for (int i = 0; i < Math.min(A, B) - (Math.max(A, B) - Math.min(A, B)); i++, useda++, usedb++) {
            sb.append("ab");
        }
        if (A > B) {
            for (int i = 0; i < (Math.max(A, B) - Math.min(A, B)) && useda + 2 <= A && usedb + 1 <= B; i++, useda += 2, usedb++) {
                sb.append("aab");
            }
        } else if (A < B) {
            for (int i = 0; i < (Math.max(A, B) - Math.min(A, B)) && useda + 1 <= A && usedb + 2 <= B; i++, useda++, usedb += 2) {
                sb.append("abb");
            }
        }
        res = sb.toString();
        if (A - useda > 0) {
            res += A - useda > 1 ? "aa" : "a";
        }
        if (B - usedb > 0) {
            res = (B - usedb > 1 ? "bb" : "b") + res;
        }
        return res;
    }

    public String strWithout3a3b_simpleGreedy(int A, int B) {
        StringBuilder res = new StringBuilder(A + B);
        char a = 'a', b = 'b';
        int i = A, j = B;
        if (B > A) { a = 'b'; b = 'a'; i = B; j = A; }
        while (i-- > 0) {
            res.append(a);
            if (i > j) { res.append(a); --i; }
            if (j-- > 0) res.append(b);
        }
        return res.toString();
    }
}
