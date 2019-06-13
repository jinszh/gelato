package gelato.leet5;

//526
public class countArrangement {
    int nres = 0;
    int N;
    public int countArrangement(int N) {
        boolean [] used = new boolean[N + 1];
        this.N = N;
        backtrace(used, N);
        return nres;
    }

    private void backtrace(boolean [] used, int idx){
        if(idx == 0) nres++;
        for(int i = 1; i <= N; i++) {
            if (!used[i] && (idx % i == 0 || i % idx == 0)) { //因为1所有位置都适用, 所以反着backtrack快很多,分支应该是少了
                used[i] = true;
                backtrace(used, idx - 1);
                used[i] = false;
            }
        }
    }
}
