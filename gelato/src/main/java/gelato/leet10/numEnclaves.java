package gelato.leet10;

import java.util.LinkedList;

public class numEnclaves {
    public int numEnclaves(int[][] A) {
        int n = 0;
        if (A.length == 0 || A[0].length == 0) return 0;
        boolean[][] visited = new boolean[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            if (i == 0 || i == A.length - 1) {
                for (int j = 0; j < A[0].length; j++) {
                    DFS(A, visited, i, j);
                }
            } else {
                DFS(A, visited, i, 0);
                DFS(A, visited, i, A[0].length - 1);
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (!visited[i][j] && A[i][j] != 0) n++;

            }
        }
        return n;
    }

    private void DFS(int[][] A, boolean[][] visited, int i, int j) {
        if (visited[i][j] || A[i][j] == 0) return;
        visited[i][j] = true;
        LinkedList<int[]> stack = new LinkedList<>();
        stack.push(new int[]{i, j});
        while (!stack.isEmpty()) {
            int[] h = stack.pollLast();
            if (h[0] > 0 && A[h[0] - 1][h[1]] > 0 && !visited[h[0] - 1][h[1]]) {
                visited[h[0] - 1][h[1]] = true;
                stack.push(new int[]{h[0] - 1, h[1]});
            }
            if (h[0] < A.length - 1 && A[h[0] + 1][h[1]] > 0 && !visited[h[0] + 1][h[1]]) {
                visited[h[0] + 1][h[1]] = true;
                stack.push(new int[]{h[0] + 1, h[1]});
            }
            if (h[1] > 0 && A[h[0]][h[1] - 1] > 0 && !visited[h[0]][h[1] - 1]) {
                visited[h[0]][h[1] - 1] = true;
                stack.push(new int[]{h[0], h[1] - 1});
            }
            if (h[1] < A[0].length - 1 && A[h[0]][h[1] + 1] > 0 && !visited[h[0]][h[1] + 1]) {
                visited[h[0]][h[1] + 1] = true;
                stack.push(new int[]{h[0], h[1] + 1});
            }
        }
    }
}
