package gelato.leet9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//923
public class threeSumMulti {
    public int threeSumMulti(int[] A, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int res = 0;
        int mod = 1000000007;
        Map.Entry<Integer, Integer>[] entries = new Map.Entry[map.size()];
        map.entrySet().toArray(entries);
        Arrays.sort(entries, Comparator.comparingInt(o -> o.getKey()));
        for (int i = 0; i < entries.length; i++) {
            for (int j = i; j < entries.length; j++) {
                int key = target - entries[i].getKey() - entries[j].getKey();
                if (key >= entries[j].getKey() && map.containsKey(key)) {
                    int toadd = 0;
                    if (key == entries[i].getKey() && key == entries[j].getKey()) {
                        toadd = (int)(((long)entries[i].getValue() * (long)(entries[i].getValue() - 1) * (long)(entries[i].getValue() - 2) / 6)%mod);
                    } else if (i == j) {
                        toadd = entries[i].getValue() * (entries[i].getValue() - 1) / 2 * map.get(key);
                    } else if(key == entries[i].getKey()){
                        toadd = entries[i].getValue() * (entries[i].getValue() - 1) / 2 * entries[j].getValue();
                    } else if(key == entries[j].getKey()){
                        toadd = entries[j].getValue() * (entries[j].getValue() - 1) / 2 * entries[i].getValue();
                    }else {
                        toadd = entries[i].getValue() * entries[j].getValue() * map.get(key);
                    }
                    res = (res + toadd % mod) % mod;
                }
            }
        }
        return res;
    }

    //优化的方法: 因为说了a的范围是101,所以直接用一个数组代替hashmap快很多
    public int threeSumMulti_you(int[] A, int target) {
        long[] c = new long[101];
        for (int a : A) c[a]++;
        long res = 0;
        for (int i = 0; i <= 100; i++)
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) continue;
                if (i == j && j == k)
                    res += c[i] * (c[i] - 1) * (c[i] - 2) / 6;
                else if (i == j && j != k)
                    res += c[i] * (c[i] - 1) / 2 * c[k];
                else if (j < k)
                    res += c[i] * c[j] * c[k];
            }
        return (int)(res % (1e9 + 7));
    }

    //另外一个方法, three pointer, 排序后一个指针遍历, 另外一个从两头往中间
    public int threeSumMulti2(int[] A, int target) {
        int MOD = 1_000_000_007;
        long ans = 0;
        Arrays.sort(A);

        for (int i = 0; i < A.length; ++i) {
            // We'll try to find the number of i < j < k
            // with A[j] + A[k] == T, where T = target - A[i].

            // The below is a "two sum with multiplicity".
            int T = target - A[i];
            int j = i+1, k = A.length - 1;

            while (j < k) {
                // These steps proceed as in a typical two-sum.
                if (A[j] + A[k] < T)
                    j++;
                else if (A[j] + A[k] > T)
                    k--;
                else if (A[j] != A[k]) {  // We have A[j] + A[k] == T.
                    // Let's count "left": the number of A[j] == A[j+1] == A[j+2] == ...
                    // And similarly for "right".
                    int left = 1, right = 1;
                    while (j+1 < k && A[j] == A[j+1]) {
                        left++;
                        j++;
                    }
                    while (k-1 > j && A[k] == A[k-1]) {
                        right++;
                        k--;
                    }

                    ans += left * right;
                    ans %= MOD;
                    j++;
                    k--;
                } else {
                    // M = k - j + 1
                    // We contributed M * (M-1) / 2 pairs.
                    ans += (k-j+1) * (k-j) / 2;
                    ans %= MOD;
                    break;
                }
            }
        }

        return (int) ans;
    }
}
