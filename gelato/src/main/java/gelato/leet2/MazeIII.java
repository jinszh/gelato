package gelato.leet2;

import java.util.Arrays;
import java.util.LinkedList;

public class MazeIII {
    int [] hole;
    int[][] len;
    LinkedList<int[]> bfs;
    String[][] path;
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        this.hole = hole;
        path = new String[maze.length][maze[0].length];
        len = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) Arrays.fill(len[i], Integer.MAX_VALUE);
        bfs = new LinkedList<>();
        bfs.offerLast(ball);
        path[ball[0]][ball[1]] = "";
        len[ball[0]][ball[1]] = 0;
        while (!bfs.isEmpty()) {
            int[] head = bfs.pollFirst();
            int j;
            //down
            for (j = head[0]; j < maze.length - 1 && maze[j + 1][head[1]] == 0 && !(hole[0] == j && hole[1] == head[1]); j++)
                ;
            mark(head, j, head[1], "d");
            //left
            for (j = head[1]; j > 0 && maze[head[0]][j - 1] == 0 && !(hole[0] == head[0] && hole[1] == j); j--) ;
            mark(head, head[0], j, "l");
            //right
            for (j = head[1]; j < maze[0].length - 1 && maze[head[0]][j + 1] == 0 && !(hole[0] == head[0] && hole[1] == j); j++)
                ;
            mark(head, head[0], j, "r");
            //up
            for (j = head[0]; j > 0 && maze[j - 1][head[1]] == 0 && !(hole[0] == j && hole[1] == head[1]); j--) ;
            mark(head, j, head[1], "u");
        }
        return path[hole[0]][hole[1]] == null ? "impossible" : path[hole[0]][hole[1]];
    }

    private void mark(int [] head, int i, int j, String direction) {
        if (i == head[0] && j == head[1]) return;
        int delta = Math.abs(i - head[0]) + Math.abs(j - head[1]);
        if (len[head[0]][head[1]] + delta < len[i][j] || (len[head[0]][head[1]] + delta == len[i][j]
                && (path[head[0]][head[1]] + direction).compareTo(path[i][j]) < 0)) {
            path[i][j] = path[head[0]][head[1]] + direction;
            len[i][j] = len[head[0]][head[1]] + delta;
            if (i != hole[0] || j != hole[1]) {
                bfs.offerLast(new int[]{i, j});
            }
        }
    }
}
