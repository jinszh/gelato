package gelato.leet1;

import java.util.LinkedList;

//130
public class SurroundedRegions {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                LinkedList<int[]> q = new LinkedList<>();
                LinkedList<int[]> full = new LinkedList<>();
                if (board[i][j] == 'O') {
                    boolean able = true;
                    board[i][j] = 'm';
                    q.add(new int[]{i, j});
                    full.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] h = q.pollFirst();
                        int x = h[0], y = h[1];
                        if (x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1
                                || board[x - 1][y] == 'F' || board[x + 1][y] == 'F' || board[x][y - 1] == 'F' || board[x][y + 1] == 'F') {
                            able = false;
                            break;
                        }
                        if (x > 0 && board[x - 1][y] == 'O') {
                            board[x - 1][y] = 'm';
                            q.add(new int[]{x - 1, y});
                            full.add(new int[]{x - 1, y});
                        }
                        if (x < board.length - 1 && board[x + 1][y] == 'O') {
                            board[x + 1][y] = 'm';
                            q.add(new int[]{x + 1, y});
                            full.add(new int[]{x + 1, y});
                        }
                        if (y < board[0].length - 1 && board[x][y + 1] == 'O') {
                            board[x][y + 1] = 'm';
                            q.add(new int[]{x, y + 1});
                            full.add(new int[]{x, y + 1});
                        }
                        if (y > 0 && board[x][y - 1] == 'O') {
                            board[x][y - 1] = 'm';
                            q.add(new int[]{x, y - 1});
                            full.add(new int[]{x, y - 1});
                        }
                    }
                    if (able) {
                        for (int[] marked : full) {
                            board[marked[0]][marked[1]] = 'X';
                        }
                    } else {
                        for (int[] marked : full) {
                            board[marked[0]][marked[1]] = 'F';
                        }
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'F') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
