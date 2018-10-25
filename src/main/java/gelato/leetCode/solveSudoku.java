package gelato.leetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class solveSudoku {
    int [] col = new int[9];
    int [] row = new int[9];
    int [] mat = new int[9];
    public void solveSudoku(char[][] board) {
        Arrays.fill(col, 0);
        Arrays.fill(row, 0);
        Arrays.fill(mat, 0);
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    col[j] ^= (1 << charToInt(board[i][j]));
                    row[i] ^= (1 << charToInt(board[i][j]));
                    mat[j / 3 + i / 3 * 3] ^= (1 << charToInt(board[i][j]));
                }
            }
        }
        recur(0, 0, board);
    }

    private boolean recur(int i, int j, char[][] board) {
        if (board[i][j] == '.') {
            boolean res = false;
            ArrayList<Integer> possibleI = new ArrayList<>();
            for (int k = 1; k <= 9; k++) {
                if ((col[j] & (1 << k)) == 0 && (row[i] & (1 << k)) == 0 && (mat[j / 3 + i / 3 * 3] & (1 << k)) == 0) {
                    possibleI.add(k);
                }
            }
            if (possibleI.size() == 0) {
                return false;
            } else {
                for (Integer k : possibleI) {
                    board[i][j] = (char) (k + 48);
                    col[j] ^= (1 << k);
                    row[i] ^= (1 << k);
                    mat[j / 3 + i / 3 * 3] ^= (1 << k);
                    res = recur(i, j, board);
                    if (res) {
                        break;
                    } else {
                        col[j] ^= (1 << k);
                        row[i] ^= (1 << k);
                        mat[j / 3 + i / 3 * 3] ^= (1 << k);
                    }
                }
                if(!res){
                    board[i][j] = '.';
                }
                return res;
            }
        } else {
            if (j < 8) {
                return recur(i, j + 1, board);
            } else if (i < 8) {
                return recur(i + 1, 0, board);
            } else {
                return true;
            }
        }
    }

    private int charToInt(char c){
        return c - 48;//48 is (int)'0'
    }
}
