package gelato.leet6;

import java.util.LinkedList;

public class maxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max, 1 + visit(i, j, grid));
                }
            }
        }
        return max;
    }

    private int visit(int i, int j, int[][] grid){
        grid[i][j] = -1;
        int res = 0;
        if(i > 0 && grid[i - 1][j] == 1) res += (1 + visit(i - 1, j, grid));
        if(i < grid.length - 1 && grid[i + 1][j] == 1) res += (1 + visit(i + 1, j, grid));
        if(j > 0 && grid[i][j - 1] == 1) res += (1 + visit(i, j - 1, grid));
        if(j < grid[0].length - 1 && grid[i][j + 1] == 1) res += (1 + visit(i, j + 1, grid));
        return res;
    }
}
