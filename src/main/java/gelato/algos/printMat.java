package gelato.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class printMat {
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null || matrix[0] == null){return null;}
        int left = 0, top=0, bottom = matrix.length-1, right=matrix[0].length -1;
        int direction = 0;
        while(left <= right && top <= bottom){
            switch(direction){
                case 0:
                    for(int i = left; i <= right; i++){
                        print(matrix[top][i]);
                    }
                    top++;
                    direction = 1;
                    break;
                case 1:
                    for(int i = top; i <= bottom; i++){
                        print(matrix[i][right]);
                    }
                    right--;
                    direction = 2;
                    break;
                case 2:
                    for(int i = right; i >= left; i--){
                        print(matrix[bottom][i]);
                    }
                    bottom--;
                    direction = 3;
                    break;
                case 3:
                    for(int i = bottom; i >= top; i--){
                        print(matrix[i][left]);
                    }
                    left++;
                    direction = 0;
                    break;
                default:
                    break;
            }
        }

        return list;
    }

    private void print(int i){
        list.add(i);
    }
}



