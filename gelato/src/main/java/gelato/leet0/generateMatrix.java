package gelato.leet0;

//59
public class generateMatrix {
    public int[][] generateMatrix(int n) {
        int [][] res = new int[n][n];
        fill(1, 0, n, res);
        return res;
    }

    private void fill(int v, int s, int n,  int [][] res){
        for(int i = s; i < s + n; i++){
            res[s][i] = v++;
        }
        for(int i = s + 1; i < s + n; i++) {
            res[i][s + n - 1] = v++;
        }
        for(int i = s + n - 2; i >= s; i--) {
            res[s + n - 1][i] = v++;
        }
        for(int i = s + n - 2; i > s; i--) {
            res[i][s] = v++;
        }
        if(n > 2){
            fill(v, s + 1, n - 2, res);
        }
    }
}
