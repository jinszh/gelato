package gelato.leet10;

public class minDominoRotations {
    public int minDominoRotations(int[] A, int[] B) {
        int[] n = new int[6];
        int[] nswap2a = new int[6];
        int[] nswap2b = new int[6];
        for (int j = 0; j < A.length; j++) {
            for (int i = 0; i < 6; i++) {
                int faceVal = i + 1;
                if (A[j] == faceVal || B[j] == faceVal) {
                    n[i]++;
                    if (A[j] != faceVal) {
                        nswap2a[i]++;
                    }
                    if(B[j] != faceVal){
                        nswap2b[i]++;
                    }
                }
            }
        }
        int mi = -1;
        for (int i = 0; i < 6; i++) {
            if (n[i] == A.length && (nswap2a[i] < mi  || nswap2b[i] < mi || mi < 0)) {
                mi = Math.min(nswap2a[i], nswap2b[i]);
            }
        }
        return mi;
    }
}
