package gelato.leet4;

import java.util.*;

//454
public class fourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        HashMap<Integer, Integer> s1 = new HashMap<>();
        HashMap<Integer, Integer> s2 = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                s1.put(a + b, s1.getOrDefault(a + b, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                s2.put(c + d, s2.getOrDefault(c + d, 0) + 1);
            }
        }
        for (Integer key : s1.keySet()) {
            if (s2.containsKey(-key)) {
                res += s1.get(key) * s2.get(-key);
            }
        }
        return res;
    }

    //HashMap 优化: 一个map就够了
    public int fourSumCount_hashMapOpt(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int numA : A) {
            for (int numB : B) {
                int sumAB = numA + numB;
                hashMap.put(sumAB, hashMap.getOrDefault(sumAB, 0) + 1);
            }
        }
        for (int numC : C){
            for (int numD : D){
                int sumCD = numC + numD;
                count += hashMap.getOrDefault(-sumCD,0);
            }
        }
        return count;
    }

    //Sort version 更快
    public int fourSumCount_sort(int[] A, int[] B, int[] C, int[] D) {
        /* sorting, O(n^2*log(n)) time, O(n^2) space, no map */
        int nAB = A.length * B.length;
        int[] sumAB = new int[nAB];
        int i = 0;
        for (int a : A) {
            for (int b : B) {
                sumAB[i++] = a + b;
            }
        }
        Arrays.sort(sumAB);
        int nCD = C.length * D.length;
        int[] negSumCD = new int[nCD];
        i = 0;
        for (int c : C) {
            for (int d : D) {
                negSumCD[i++] = - (c + d);
            }
        }
        Arrays.sort(negSumCD);
        // if sumAB = negSumCD, then 4 sum = 0
        i = 0;
        int j = 0;
        int res = 0;
        while (i < nAB && j < nCD) {
            if (sumAB[i] < negSumCD[j]) i++;
            else if (sumAB[i] > negSumCD[j]) j++;
            else {
                // sumAB[i] == negSumCD[j]
                // need to count number of same consecutive values, and multiply them
                int countAB = 1, countCD = 1;
                while (++i < nAB && sumAB[i-1] == sumAB[i]) countAB += 1;
                while (++j < nCD && negSumCD[j-1] == negSumCD[j]) countCD += 1;
                res += countAB * countCD;
            }
        }
        return res;
    }
}
