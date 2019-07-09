package gelato.leet2;

//221
public class maximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;

        int [][] len = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length - k; i++) {
                for (int j = 0; j < matrix[0].length - k; j++) {
                    if (k == 0 && matrix[i][j] == '1'){
                        len[i][j] = 1;
                        max = 1;
                    }else if(k > 0 && len[i][j] == k &&  len[i + 1][j + 1] >= k
                            && matrix[i + k][j] == '1' && matrix[i][j + k] == '1'){
                        len[i][j] = k + 1;
                        max = Math.max(max, len[i][j]);
                    }
                }
            }
        }
        return max;
    }
    //优化:
    /*
    如果(a,b)->(a + k,b + k)是一个square则(a,b)->(a+k-1, b+k-1), (a + 1,b)->(a+k, b+k-1), (a,b + 1)->(a+k-1, b+k) 三个都是square
     */
    public int maximalSquare_simple(char[][] a) {
        if(a.length == 0) return 0;
        int m = a.length, n = a[0].length, result = 0;
        int[][] b = new int[m+1][n+1];
        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(a[i-1][j-1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
                    result = Math.max(b[i][j], result); // update result
                }
            }
        }
        return result*result;
    }
}
