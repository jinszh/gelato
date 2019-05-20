package gelato.leet7;

//718
public class findLength {
    public int findLength(int[] A, int[] B) {
        int max = 0;
        int [][] len = new int[A.length + 1][B.length + 1];
        for(int i = A.length - 1; i >=0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    len[i][j] = len[i + 1][j + 1] + 1;
                    max = Math.max(len[i][j], max);
                }
            }
        }
        return max;
    }

    //Improved version - with O(1) extra space
    //相当于 固定B, A开始滑动,判断有多少位重合. 再固定A, 滑动B看有多少位重合 - 左右滑动的过程中, 总有一个时刻, 相同的substring会重合
    public int findLength_im(int [] A, int [] B){
        int maxLen = 0;


        for (int j = 0; j < B.length; j++) {
            int maxLenEnding = 0;
            for (int i = 0, k = j; i < A.length && k < B.length; i++, k++) {
                if (A[i] != B[k]) maxLenEnding = 0;
                else {
                    maxLenEnding++;
                    maxLen = Math.max(maxLen, maxLenEnding);
                }
            }
        }

        for (int i =1; i < A.length; i++) {
            int maxLenEnding = 0;
            for (int j = 0, k = i; k < A.length && j < B.length; j++, k++) {
                if (A[k] != B[j]) maxLenEnding = 0;
                else {
                    maxLenEnding++;
                    maxLen = Math.max(maxLen, maxLenEnding);
                }
            }
        }

        return maxLen;
    }
}
