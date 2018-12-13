package gelato.leet2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSlices_tooUgly {
    public int numberOfArithmeticSlices(int[] A) {
        int n = 0;
        int len = A.length;
        boolean[][] visited = new boolean[len][len];
        int[] dupNum = new int[len]; // 0 for unmarked nodes, 1 for non-dup node, n for number duped, -1 for it is dup node
        Arrays.fill(dupNum, 0);
        for (int i = 0; i < len; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < len - 2; i++) {
            if (dupNum[i] >= 0) {
                if (dupNum[i] == 0) {
                    markDup(A, dupNum, i);
                }
                n += sameSum(dupNum[i]);
                for (int j = i + 1; j < len - 1; j++) {
                    if (dupNum[j] >= 0 && !visited[i][j]) {
                        List<int[]> dups = new ArrayList<>();
                        if(dupNum[i] > 1)dups.add(new int[]{0, dupNum[i]});
                        visited[i][j] = true;
                        long dist = (long) A[j] - (long) A[i];
                        int pos = i;
                        int nxtHop = j;
                        int hops = 0;
                        while (true) {
                            if (nxtHop > 0 && nxtHop < len) { // A series formed
                                visited[pos][nxtHop] = true;
                                if(dupNum[nxtHop] == 0) {
                                    markDup(A, dupNum, nxtHop);
                                }
                                pos = nxtHop;
                                hops++;
                                if(dupNum[nxtHop] > 1) {
                                    dups.add(new int[]{hops, dupNum[nxtHop]});
                                }
                                if ((long) A[pos] + dist > Integer.MAX_VALUE) break;
                                nxtHop = biSearchFirst(A, pos, len - 1, (int) (A[pos] + dist));
                            } else {
                                break;
                            }
                        }
                        if (hops > 1) {
                            n += getGeneralSum(hops + 1, dups);
                        }
                        dups.clear();
                    }

                }

            }
        }
        return n;
    }

    private int getGeneralSum(int nnodes, List<int[]> dups){
        int sum = 0;//This part is crazy
        int [][] dupRec = new int[dups.size() + 1][dups.size() + 1];
        for (int j = 0; j <= dups.size(); j++) {
            dupRec[0][j] = getSum((j == dups.size() ? nnodes : dups.get(j)[0])
                    - (j == 0 ? 0 : dups.get(j - 1)[0] + 1));
            sum += dupRec[0][j];
        }
        for(int i = 1; i <= dups.size(); i++) {
            for(int j = 0 ; j < dups.size(); j++){
                dupRec[i][j] = getSum(j == dups.size() - 1 ? nnodes : dups.get(j + i)[0] - (j == 0 ? 0 : dups.get(j - 1)[0]));
                for(int k = j;k <= j + i;k++) {
                    dupRec[i][j] -= dupRec[i - 1][k];
                }
                int multi = dups.get(j)[1];
                for(int k2 = 1; k2 < i; k2++){
                    multi *= dups.get(j+k2)[1];
                }
                sum+= dupRec[i][j] * multi;
                dupRec[i][j] += dupRec[i-1][j];
            }
        }
        return sum;
    }

    private int getSum(int nnode) {
        return nnode > 2 ? (nnode - 2) * (nnode - 1) / 2 : 0;
    }

    public  int biSearchFirst(int [] array, int start, int end, int key) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == key && (mid == 0 || array[mid] > array[mid - 1])) {
                return mid;
            } else {
                if (array[mid] > key || (array[mid] == key && mid > 0 && array[mid] == array[mid - 1])) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    private void markDup(int[] A, int[] dupNum, int i) {
        dupNum[i] = 1;
        for (int k = i + 1; k < A.length && A[k] == A[i]; k++) {
            dupNum[k] = -1;
            dupNum[i]++;
        }
    }

    private int sameSum(int n) {
        int sum = n >= 3 ? 1 : 0;
        int chose = 1;
        while (n - chose >= 3) {
            sum += chose(n, chose);
            chose++;
        }
        return sum;
    }

    private int chose(int c, int n) {
        int numerator = c;
        int denominator = 1;
        for (int i = 1; i < n; i++) {
            numerator *= (c - i);
            denominator *= i + 1;
        }
        return numerator / denominator;
    }
}
