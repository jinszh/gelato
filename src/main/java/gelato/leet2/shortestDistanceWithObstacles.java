package gelato.leet2;

import java.util.ArrayDeque;
import java.util.Arrays;

public class shortestDistanceWithObstacles {
    public int shortestDistance(int[][] grid) {
        int l = -1;
        if(grid.length > 0) {
            int[][] len = new int[grid.length][grid[0].length];
            int[][] houses = new int[grid.length][grid[0].length];
            int totalHouse = 0;
            for(int i = 0; i < grid.length; i++) {
                Arrays.fill(len[i], 0);
                Arrays.fill(houses[i], 0);
            }
            for(int i = 0; i < grid.length; i++){
                for(int j = 0 ; j < grid[0].length; j++){
                    if(grid[i][j] > 0) {
                        if (grid[i][j] == 1) {
                            totalHouse++;
                            BFS(i, j, grid, len, houses, grid.length, grid[0].length);
                        }
                        continue;
                    }
                }
            }
            int minLen = Integer.MAX_VALUE;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0 ; j < grid[0].length; j++){
                    if(houses[i][j] == totalHouse && len[i][j] < minLen){
                        minLen = len[i][j];
                    }
                }
            }
            l = minLen == Integer.MAX_VALUE ? -1 : minLen;
        }
        return l;
    }

    private void BFS(int i, int j, int[][] grid, int[][] len, int[][] houses, int height, int width) {
        boolean [][] visited = new boolean[height][width];
        for(boolean [] v : visited){
            Arrays.fill(v, false);
        }
        ArrayDeque<Integer> pos = new ArrayDeque<>();
        pos.add(i * width + j);
        int cur = 1, polled = 0, p1 = 1, p2 = 0;
        while (!pos.isEmpty()) {
            Integer h = pos.pollFirst();
            polled++;
            int[][] neighbors = new int[4][2];
            neighbors[0][0] = h / width - 1;
            neighbors[1][0] = h / width + 1;
            neighbors[1][1] = neighbors[0][1] = h % width;
            neighbors[3][0] = neighbors[2][0] = h / width;
            neighbors[2][1] = h % width - 1;
            neighbors[3][1] = h % width + 1;
            for (int[] n : neighbors) {
                if (n[0] >= 0 && n[0] < height && n[1] >= 0 && n[1] < width
                        && grid[n[0]][n[1]] == 0 && !visited[n[0]][n[1]]) {
                    visited[n[0]][n[1]] = true;
                    houses[n[0]][n[1]]++;
                    len[n[0]][n[1]] += cur;
                    p2++;
                    pos.offerLast(n[0] * width + n[1]);
                }
            }
            if (polled == p1) {
                cur++;
                p1 = p2;
                polled = p2 = 0;
            }
        }
    }
}
