package gelato.leet2;

public class gameOfLife {
    public void gameOfLife(int[][] board) {
        //0, dead, -1(now dead, will live)
        //1, live, 2(now live, will die)
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int n = 0;
                if (i > 0 && board[i - 1][j] > 0) n++;
                if (i > 0 && j > 0 && board[i - 1][j - 1] > 0) n++;
                if (i > 0 && j < board[0].length - 1 && board[i - 1][j + 1] > 0) n++;
                if (j > 0 && board[i][j - 1] > 0) n++;
                if (j < board[0].length - 1 && board[i][j + 1] > 0) n++;
                if (i < board.length - 1 && j < board[0].length - 1 && board[i + 1][j + 1] > 0) n++;
                if (i < board.length - 1 && j > 0 && board[i + 1][j - 1] > 0) n++;
                if (i < board.length - 1 && board[i + 1][j] > 0) n++;
                if (n < 2) {
                    if (board[i][j] == 1) board[i][j] = 2;
                } else if (n <= 3) {
                    if (n == 3 && board[i][j] == 0) board[i][j] = -1;
                } else {
                    if (board[i][j] == 1) board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) board[i][j] = 0;
                if (board[i][j] == -1) board[i][j] = 1;
            }
        }
    }
}
