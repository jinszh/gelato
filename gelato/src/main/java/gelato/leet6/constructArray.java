package gelato.leet6;

//667
public class constructArray {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i + 1;
        }
        for (int i = k, j = 1; i >= 1; i--, j++) {
            res[j] = j % 2 != 0 ? res[j - 1] + k : res[j - 1] - k;
        }
        return res;
    }
}
