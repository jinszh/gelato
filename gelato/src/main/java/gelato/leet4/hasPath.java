package gelato.leet4;

import java.util.HashSet;

//490
public class hasPath {
    int m, n;
    boolean hasPath = false; // 一旦找到结果, 用于提前结束dfs其他的分支
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        boolean [][] visited = new boolean[m][n];
        dfs(maze, start, destination, visited);
        return hasPath;
    }
    //用二维数组替换hashmap会快很多
    private void dfs(int[][] maze, int[] start, int [] destination, boolean [][] visited) {
        if(hasPath) return;
        if(visited[start[0]][start[1]]) return;
        if(start[0] == destination[0] && start[1] == destination[1]){
            hasPath = true;
            return;
        }
        visited[start[0]][start[1]] = true;
        int[][] d4 = new int[4][2];
        for(int i = 0; i < d4.length; i++){
            d4[i] = new int[]{start[0], start[1]};
        }
        for (; d4[0][0] > 0 && maze[d4[0][0] - 1][start[1]] == 0; d4[0][0]--) ; //up
        dfs(maze, d4[0], destination, visited);

        for (; d4[1][0] < maze.length - 1 && maze[d4[1][0] + 1][start[1]] == 0; d4[1][0]++) ;//down
        dfs(maze, d4[1], destination, visited);

        for (; d4[2][1] > 0 && maze[start[0]][d4[2][1] - 1] == 0; d4[2][1]--) ; //left
        dfs(maze, d4[2], destination, visited);

        for (; d4[3][1] < maze[0].length - 1 && maze[start[0]][d4[3][1] + 1] == 0; d4[3][1]++) ; //right
        dfs(maze, d4[3], destination, visited);
    }
}
