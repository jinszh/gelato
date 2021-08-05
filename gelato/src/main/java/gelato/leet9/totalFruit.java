package gelato.leet9;

//904
public class totalFruit {
    public int totalFruit(int[] tree) {
        int max = 0;
        int k1 = -1, k2 = -1;
        int amt1 = 0, amt2 = 0;
        int k = 0;
        for (int i = 0; i < tree.length; i++) {
            while (tree[i] != k1 && tree[i] != k2) {
                if (k2 >= 0 && tree[k] == k1) {
                    amt1--;
                    k++;
                } else if (k1 >= 0 && tree[k] == k2) {
                    amt2--;
                    k++;
                }
                if (amt1 == 0) k1 = tree[i];
                else if (amt2 == 0) k2 = tree[i];
            }
            if (tree[i] == k1) {
                amt1++;
            } else {
                amt2++;
            }
            max = Math.max(max, i - k + 1);
        }
        return max;
    }

    //简短的 且不需要中间那个while - 因为并不在乎里面 - 里面count_b标注的是连续的b的个数, 新的c出现的时候 只需要关注这个数即可
    public int totalFruit2(int[] tree) {
        int res = 0, cur = 0, count_b = 0, a = 0, b = 0;
        for (int c :  tree) {
            cur = c == a || c == b ? cur + 1 : count_b + 1;
            count_b = c == b ? count_b + 1 : 1;
            if (b != c) {a = b; b = c;}
            res = Math.max(res, cur);
        }
        return res;
    }
}
