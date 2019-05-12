package gelato.leet9;

public class uniquePathsIII {
    boolean[][] visited;
    int[][] grid;
    int nsqr = 0;

    public int uniquePathsIII(int[][] grid) {
        int npath = 0;
        this.grid = grid;
        this.visited = new boolean[grid.length][grid[0].length];
        int[] entry = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    entry = new int[]{i, j};
                } else if (grid[i][j] >= 0) {
                    nsqr++;
                }
            }
        }
        npath = dfs(entry[0], entry[1], 0);
        return npath;
    }

    public int dfs(int i, int j, int nvisited) {
        if (grid[i][j] == 2 && nvisited == nsqr) {
            return 1;
        } else {
            visited[i][j] = true;
            int npath = 0;
            if (i > 0 && !visited[i - 1][j] && grid[i - 1][j] >= 0) {
                npath += dfs(i - 1, j, nvisited + 1);
            }
            if (j > 0 && !visited[i][j - 1] && grid[i][j - 1] >= 0) {
                npath += dfs(i, j - 1, nvisited + 1);
            }
            if (i < grid.length - 1 && !visited[i + 1][j] && grid[i + 1][j] >= 0) {
                npath += dfs(i + 1, j, nvisited + 1);
            }
            if (j < grid[0].length - 1 && !visited[i][j + 1] && grid[i][j + 1] >= 0) {
                npath += dfs(i, j + 1, nvisited + 1);
            }
            visited[i][j] = false;
            return npath;
        }
    }
}
