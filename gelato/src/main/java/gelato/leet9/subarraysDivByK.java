package gelato.leet9;

import java.util.HashMap;

public class subarraysDivByK {
    public int subarraysDivByK(int[] A, int K) {
        int[] prefix = new int[A.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        int nans = 0;
        prefix[0] = 0;
        for (int i = 0; i < A.length; i++) {
            prefix[i + 1] = prefix[i] + A[i];
            int rem = prefix[i + 1] % K;
            if (rem == 0) {
                nans += (map.getOrDefault(rem, 0) + 1);
            } else {
                nans += map.getOrDefault(rem, 0);
                nans += map.getOrDefault(rem - K, 0);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return nans;
    }

    public int subarraysDivByK_simple(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int nans = 0;
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < A.length; i++) {
            sum = (sum + A[i]) % K;
            if (sum < 0) sum += K; //小于0时转成正数, 即可少一些比较
            nans += (map.getOrDefault(sum, 0));
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return nans;
    }

    public int subarraysDivByK_faster(int[] A, int K) { //在key小的时候, 用数组替换hashmap
        int[] map = new int[K];
        map[0] = 1;
        int count = 0, sum = 0;
        for(int a : A) {
            sum = (sum + a) % K;
            if(sum < 0) sum += K;  // Because -1 % 5 = -1, but we need the positive mod 4
            count += map[sum];
            map[sum]++;
        }
        return count;
    }
}
