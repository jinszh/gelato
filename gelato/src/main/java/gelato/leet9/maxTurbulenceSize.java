package gelato.leet9;

public class maxTurbulenceSize {
    public int maxTurbulenceSize(int[] A) {
        int n = 0;
        int nMax = 0;
        int direction = 0;
        if(A.length == 1) {
            nMax = 1;
        }
        for(int i = 1; i < A.length; i++){
            int prevDir  = direction;
            if(A[i] > A[i - 1]){
                direction = 1;
            }else if(A[i] == A[i - 1]){
                direction = 0;
            }else {
                direction = -1;
            }
            if(direction == 0){
                n = 1;
            }else if(direction != 0 && direction == -prevDir){
                n++;
            }else{
                n = 2;
            }
            nMax = Math.max(n, nMax);
        }
        return nMax;
    }
}
