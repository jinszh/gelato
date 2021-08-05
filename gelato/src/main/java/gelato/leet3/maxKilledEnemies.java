package gelato.leet3;

//361
public class maxKilledEnemies {
    int max = 0;
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0) return 0;
        int [][] kill = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int left = 0, right = 0;
            for (int j = 0; j < grid[0].length; j++) {
                left = process(grid, i, j, left, kill);
            }
            for (int j = grid[0].length - 1; j >= 0; j--) {
                right = process(grid, i, j, right, kill);
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            int down = 0, up = 0;
            for (int j = 0; j < grid.length; j++) {
                down = process(grid, j, i, down, kill);
            }
            for (int j = grid.length - 1; j >= 0; j--) {
                up = process(grid, j, i, up, kill);
            }
        }
        return max;
    }

    private int process(char [][] grid, int i, int j, int input, int [][] kill) {
        int res = input;
        if (grid[i][j] == 'E') {
            res++;
        } else if (grid[i][j] == 'W') {
            res = 0;
        } else {
            kill[i][j] += res;
            max = Math.max(max, kill[i][j]);
        }
        return res;
    }
}
