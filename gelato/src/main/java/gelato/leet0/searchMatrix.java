package gelato.leet0;

//74
public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int up = 0, down = matrix.length - 1, l = 0, r = matrix[0].length;
        while (up < down) {
            int mid = matrix[up][0] + (matrix[down][0] - matrix[up][0]) / 2;
            if (matrix[mid][0] > target) {
                down = mid;
            } else if (matrix[mid][0] < target) {
                up = mid;
            } else {
                up = mid;
                break;
            }
        }
        if (matrix[up][0] < target) return false;
        while (l < r) {
            int mid = matrix[up][l] + (matrix[down][r] - matrix[up][l]) / 2;
            if (matrix[up][mid] > target) {
                r = mid;
            } else if (matrix[up][mid] < target) {
                l = mid;
            } else {
                l = mid;
                break;
            }
        }
        return matrix[up][l] == target;
    }

    //好看一些,不需要两轮while
    public boolean searchMatrix_betterLooking(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int start = 0, rows = matrix.length, cols = matrix[0].length;
        int end = rows * cols - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            }
            if (matrix[mid / cols][mid % cols] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
