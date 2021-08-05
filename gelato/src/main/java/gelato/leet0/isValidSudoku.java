package gelato.leet0;

//36
public class isValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[board.length];
        int[] col = new int[board[0].length];
        int[] box = new int[board.length];
        int i = 0;
        boolean res = true;
        for (; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;
                int v = 1 << (board[i][j] - '0');
                if ((v & row[i]) > 0 || (v & col[j]) > 0 || (v & box[i / 3 * 3 + j / 3]) > 0) {
                    res = false;
                    break;
                }
                row[i] |= v;
                col[j] |= v;
                box[i / 3 * 3 + j / 3] |= v;
            }
            if (!res) break;
        }
        return res && check(row) && check(col) && check(box);
    }
    private boolean check(int [] arr){
        for(int x : arr){
            if(x != 1023) {
                return false;
            }
        }
        return true;
    }
}
