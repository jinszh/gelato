package gelato.leet10;

public class smallestRepunitDivByK {
    public int smallestRepunitDivByK(int K) {
        int res = 1;
        while (K % 2 != 0 && res < 100000) {
            if (res % K == 0) break;
            res = (res * 10) + 1;
        }
        return res % K == 0 ? res : -1;
    }
}
