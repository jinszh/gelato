package gelato.leet0;

import java.util.Arrays;

//63
public class uniquePathsWithObstacles {
    int [][] memo;
     int count = 0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0) return 0;
        memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int [] m : memo){
            Arrays.fill(m, -1);
        }
        int res = visit(obstacleGrid, 0, 0);
         System.out.println(count);
        return res;
    }

    private int visit(int[][] grid, int i, int j) {
       // if(memo[i][j] >= 0) return memo[i][j];
         count++;
        int res = 0;
        if(grid[i][j] == 0) {
            if (i == grid.length - 1 && j == grid[0].length - 1){
                res = 1;
            }
            if (i < grid.length - 1) {
                res += visit(grid, i + 1, j);
            }
            if (j < grid[0].length - 1) {
                res += visit(grid, i, j + 1);
            }
        }
        memo[i][j] = res;
        return res;
    }
}
