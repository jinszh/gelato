package gelato.leet0;

//79
public class WordSearch {
    public int cnt = 0;

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int idx, int i, int j) {
        cnt++;
        if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
            return false;
        }
        boolean res = false;
        if (board[i][j] == word.charAt(idx)) {
            if (idx == word.length() - 1) {
                res = true;
            } else {
                board[i][j] ^= 256; //相当于二进制八位前面加1
//                if (i > 0) res |= backtrack(board, word, idx + 1, i - 1, j);
//                if (i < board.length - 1) res |= backtrack(board, word, idx + 1, i + 1, j);
//                if (j > 0) res |= backtrack(board, word, idx + 1, i, j - 1);
//                if (j < board[0].length - 1) res |= backtrack(board, word, idx + 1, i, j + 1);
                board[i][j] ^= 256; //不要用一个个的 |= 直接用 || 这样子遇到true就会结束
                res = backtrack(board, word, idx + 1, i - 1, j)
                        || backtrack(board, word, idx + 1, i + 1, j)
                        || backtrack(board, word, idx + 1, i, j - 1)
                        || backtrack(board, word, idx + 1, i, j + 1);
                board[i][j] ^= 256;
            }
        }
        return res;
    }

    //Others
    public boolean exist2(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        char[] chs = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, chs, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int idx, int x, int y) {
        cnt++;
        if (idx == words.length) {
            return true;
        }
        if (x < 0 || x == board.length || y < 0 || y == board[0].length) {
            return false;
        }
        if (board[x][y] != words[idx]) {
            return false;
        }
        board[x][y] ^= 256;
        boolean exist = dfs(board, words, idx + 1, x, y + 1) ||
                dfs(board, words, idx + 1, x, y - 1)
                || dfs(board, words, idx + 1, x + 1, y) ||
                dfs(board, words, idx + 1, x - 1, y);
        board[x][y] ^= 256;
        return exist;
    }
}
