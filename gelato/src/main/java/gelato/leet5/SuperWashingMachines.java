package gelato.leet5;

public class SuperWashingMachines {
    //Only need to find the peak throughput
    //跟动态规划没有关系, 其实就是个应用题的峰值
    //问题可以划分为子问题, 也可以从独立反应整体! 比如找peak就是看个体的
    //Since we can operate several machines at the same time,
    //the minium number of moves is the maximum number of necessary operations on every machine.
    public int findMinMoves(int[] machines) {
        int n = machines.length, sum[] = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + machines[i - 1];
        if (sum[n] % n != 0) return -1;
        int need = sum[n] / n, ans = 0;
        for (int i = 0; i < n; i++) {
            int l = i * need - sum[i];
            int r = (n - 1 - i) * need - (sum[n] - sum[i + 1]);
            ans = Math.max(ans, l > 0 && r > 0 ? l + r : Math.max(Math.abs(l), Math.abs(r)));
        }
        return ans;
    }//Brilliant!!!
}
