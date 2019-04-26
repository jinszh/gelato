package gelato.leet10;

public class mergeStones {
    public int mergeStones(int[] stones, int K) {
        int [][] dp = new int[stones.length][K + 1];
        mergeStones(stones, 0, stones.length - 1, K);
        return 0;
    }

    private void merge(int [] stones, int b, int e, int K){

    }
}
