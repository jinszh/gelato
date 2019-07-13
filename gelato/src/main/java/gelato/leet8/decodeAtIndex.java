package gelato.leet8;


//880
public class decodeAtIndex {
    //不需要用list来存, 回头计算各种边界, 太麻烦 - 直接把怎么得到N的过程回退回去
    public String decodeAtIndex(String S, int K) {
        long N = 0L;
        int i;
        char[] chs = S.toCharArray();
        for (i = 0; N < K; i++) N = chs[i] >= '0' && chs[i] <= '9' ? N*(chs[i] - '0') : N + 1;
        i--;
        while (true){
            if (chs[i] >= '0' && chs[i] <= '9') {
                N /= chs[i] - '0';
                K %= N;
            } else if (K%N == 0) return "" + chs[i];
            else N--;
            i--;
        }
    }
}
