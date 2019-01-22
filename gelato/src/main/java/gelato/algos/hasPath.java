package gelato.algos;

import java.util.Arrays;

/**请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。**/

//解法 DFS
public class hasPath {
    boolean [] visited;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(rows == 0 || cols == 0 || str == null){
            return false;
        }
        boolean result = false;
        visited = new boolean[matrix.length];
        Arrays.fill(visited, false);
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i] == str[0]){
                result = DFS(matrix, rows, cols, str, i, 0);
            }
            if(result){
                break;
            }
        }
        return result;
    }

    private boolean DFS(char[] matrix, int rows, int cols, char[] str, int iMat, int iStr){
        visited[iMat] = true;
        boolean result = false;
        if(iStr == str.length - 1){
            return true;
        }else{
            int rowNo = iMat / cols;
            int colNo = iMat % cols;
            int left = rowNo * cols + colNo - 1;
            int right = rowNo * cols + colNo + 1;
            int up = (rowNo - 1) * cols + colNo;
            int down = (rowNo + 1) * cols + colNo;
            if(colNo > 0 && !visited[left] && matrix[left] == str[iStr + 1]){
                result = result || DFS(matrix, rows, cols, str, left, iStr + 1);
            }
            if(!result && colNo < cols - 1 && !visited[right] && matrix[right] == str[iStr + 1]){
                result = result || DFS(matrix, rows, cols, str, right, iStr + 1);
            }
            if(!result && rowNo > 0 && !visited[up] && matrix[up] == str[iStr + 1]){
                result = result || DFS(matrix, rows, cols, str, up, iStr + 1);
            }
            if(!result && rowNo < rows - 1 && !visited[down] && matrix[down] == str[iStr + 1]){
                result = result || DFS(matrix, rows, cols, str, down, iStr + 1);
            }
        }
        visited[iMat] = false;
        return result;
    }
}
