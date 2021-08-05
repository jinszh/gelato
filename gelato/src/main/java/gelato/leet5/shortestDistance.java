package gelato.leet5;

import java.util.*;

//505
public class shortestDistance {
    //--- Solution 1 : 自己写的Dijkstra, 也可用PriorityQueue ------------------------------------------------
    int m, n = 0;
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        boolean[][] computed = new boolean[m][n];
        LinkedHashMap<Integer, Integer> distMap = new LinkedHashMap<>();
        distMap.put(start[0] * n + start[1], 0);


        while (!distMap.isEmpty()) {
            int min = Integer.MAX_VALUE;
            Integer point = -1;
            for(Integer key : distMap.keySet()){
                if(distMap.get(key) < min){
                    min = distMap.get(key);
                    point = key;
                }
            }

            distMap.remove(point);

            int[] h = new int[]{point / n, point % n};
            computed[h[0]][h[1]] = true;
            if (h[0] == destination[0] && h[1] == destination[1]) {
                return min;
            }

            int u = h[0], d = h[0];
            while (u > 0 && maze[u - 1][h[1]] == 0) u--;
            visit(computed, distMap, h[0] - u + min, u, h[1]);

            while (d < maze.length - 1 && maze[d + 1][h[1]] == 0) d++;
            visit(computed, distMap, d - h[0] + min, d, h[1]);

            int l = h[1], r = h[1];
            while (l > 0 && maze[h[0]][l - 1] == 0) l--;
            visit(computed, distMap, h[1] - l + min, h[0], l);

            while (r < maze[0].length - 1 && maze[h[0]][r + 1] == 0) r++;
            visit(computed, distMap, r - h[1] + min, h[0], r);

        }
        return -1;
    }

    private void visit(boolean[][] visited, Map<Integer, Integer> distMap, int dis, int i, int j) {
        if (!visited[i][j]) {
            distMap.put(i * n + j, Math.min(distMap.getOrDefault(i * n + j, Integer.MAX_VALUE), dis));
        }
    }

    // Solution 2: 别人写的 BFS 挺快的, 可能是因为HashMap本身的开销比较大----------------------------------------
    public static final int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //上右下左

    public int shortestDistance_dfs(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0 || maze[0].length == 0) {
            return -1;
        }

        int m = maze.length;
        int n = maze[0].length;
        int[][] dp = new int[m][n];
        Queue<Pair> que = new LinkedList<>();

        que.offer(new Pair(start[0], start[1], 0));
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        while(!que.isEmpty()) {
            Pair cur = que.poll();
            for(int[] dir : dirs) { //四个方向能到达的分别入队列
                int nextX = cur.x;
                int nextY = cur.y;
                int len = cur.len;
                while(nextX < m && nextX >= 0 && nextY < n && nextY >= 0 && maze[nextX][nextY] == 0) {
                    nextX += dir[0];
                    nextY += dir[1];
                    len++;

                }
                nextX -= dir[0];
                nextY -= dir[1];
                len--;

                // avoid going through unneccessary cases.
                if(len > dp[destination[0]][destination[1]]) {
                    continue;
                }

                if(len < dp[nextX][nextY]) { //每个点在第一次达到, 或者发现更短路径的时候才入队列. 如果发现更短路径, 其后继节点也会相继更新
                    dp[nextX][nextY] = len;
                    que.offer(new Pair(nextX, nextY, len));
                }
            }
        }

        return dp[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dp[destination[0]][destination[1]];
    }

    class Pair {
        int x;
        int y;
        int len;
        public Pair(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }

    //Solution 3
}
