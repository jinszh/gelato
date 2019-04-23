package gelato.leet10;

public class clumsy {
    public int clumsy(int N) {
        int nfac = N / 4;
        int nred = N % 4;
        int res = 0;
        for (int i = nfac; i > 0; i--) {
            int s = nred + i * 4;
            if(res == 0) {
                res += s * (s - 1) / (s - 2) + (s - 3);
            }else {
                res -= s * (s - 1) / (s - 2) - (s - 3);
            }
        }
        if(nfac > 0) {
            res -= (nred < 3 ? nred : 6);
        }else {
            res += (nred < 3 ? nred : 6);
        }
        return res;
    }
}
