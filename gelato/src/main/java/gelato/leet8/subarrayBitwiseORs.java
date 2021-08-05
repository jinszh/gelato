package gelato.leet8;

import java.util.HashSet;
import java.util.Set;

//898 - 实际效率是O(n32) - 因为OR操作得到的结果最多只有32个, 只会增加一个1,不会减少一个1,(monotone) 所以hashset最多有32个元素, 看似n^2实则30N
public class subarrayBitwiseORs {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> ans = new HashSet();
        Set<Integer> cur = new HashSet();
        cur.add(0);
        for (int x: A) {
            Set<Integer> cur2 = new HashSet();
            for (int y: cur)
                cur2.add(x | y);
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }

        return ans.size();
    }
}
