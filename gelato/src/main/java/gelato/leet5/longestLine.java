package gelato.leet5;

//562
public class longestLine {
    public int longestLine(int[][] M) {
        int max = 0;
        if(M.length == 0)return max;
        int [] rows = new int[M.length];
        int [] cols = new int[M[0].length];
        int [] diag = new int[M.length + M[0].length];
        int [] antidiag = new int[M.length + M[0].length];
        for(int i = 0 ; i < M.length; i++){
            for(int j = 0; j < M[0].length; j++){
                if(M[i][j] > 0){
                    rows[i] = rows[i] + 1;
                    cols[j] = cols[j] + 1;
                    diag[i - j + M[0].length] = diag[i - j + M[0].length] + 1;
                    // System.out.println(diag[i - j + M[0].length]);
                    antidiag[j + i] = antidiag[j + i] + 1;
                    max = Math.max(max, Math.max(Math.max(rows[i], cols[j])
                            , Math.max(diag[i - j + M[0].length], antidiag[j + i])));
                }else {
                    rows[i] = cols[j] = diag[i - j + M[0].length] = antidiag[j + i] = 0;
                }
            }
        }
        return max;
    }
}
