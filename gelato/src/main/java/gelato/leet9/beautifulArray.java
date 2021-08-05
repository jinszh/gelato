package gelato.leet9;

import java.util.ArrayList;

//932
public class beautifulArray {
    /**
     * Another way is to divide into odds part and evens part.
     * (1)So there is no k with A[k] * 2 = odd + even
     * (2)如果A为beautiful array,则A.map(o - > 2*o)也是beautiful array,
     *    很好证明, 如果A[k] * 2 = A[i] + A[j] => A[k] * 4 = A[i] * 2 + A[j] * 2
     *    同理, A.map(o - > 2*o + 1) 也是beautiful array. 于是可以拼出新的beautiful array
     * A = [2, 1, 4, 5, 3]
     * A1 = [3, 1, 7, 9, 5]
     * A2 = [4, 2, 8, 10, 6]
     * B = A1 + A2 = [3, 1, 7, 9, 5, 4, 2, 8, 10, 6]
     */
    public int[] beautifulArray(int N) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < N) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i : res) if (i * 2 - 1 <= N) tmp.add(i * 2 - 1);
            for (int i : res) if (i * 2 <= N) tmp.add(i * 2);
            res = tmp;
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
