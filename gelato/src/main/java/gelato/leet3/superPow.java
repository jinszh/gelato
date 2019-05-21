package gelato.leet3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//372
public class superPow {
    // ( a * b ) % k = (a%k * b%k)%k
    int globalRem = 0;

    public int superPow(int a, int[] b) {
        globalRem = a % 1337;
        LinkedList<Integer> full = new LinkedList<>();
        full.addAll(Arrays.stream(b).boxed().collect(Collectors.toList()));
        return get(full);
    }


    private int get(List<Integer> b) {
        if (b.size() == 1 && b.get(0) == 1) {
            return globalRem;
        } else {
            LinkedList<Integer> res = new LinkedList<>();
            int rem = 0;
            for (Integer i : b) {
                res.add((rem * 10 + i) / 2);
                rem = i % 2;
            }
            if (res.get(0) == 0) {
                res.removeFirst();
            }
            int half = get(res);
            return (((half * half) % 1337) * (rem != 0 ? globalRem : 1)) % 1337; //三个1337相乘就越届
        }
    }

    //another way: a^1234567 % k = (a^1234560 % k) * (a^7 % k) % k = (a^123456 % k)^10 % k * (a^7 % k) % k
    int MOD = 1337;

    public int superPow_another(int a, int[] b) {
        if (b.length == 1) {
            return pow(a, b[0]);
        }

        return PowArray(a, b, b.length - 1);
    }

    public int PowArray(int a, int[] b, int endindex) {
        if (endindex < 0) return 1;

        return (pow(PowArray(a, b, endindex - 1), 10) * pow(a, b[endindex])) % MOD;
    }

    public int pow(int a, int k) {
        int res = 1;
        a %= MOD;
        for (int i = 0; i < k; i++) {
            res *= a;
            res %= MOD;
        }
        return res;
    }
}
