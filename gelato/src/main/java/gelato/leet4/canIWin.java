package gelato.leet4;

import java.util.HashMap;

public class canIWin {
    //DP 记录时, 有时候hashmap比数组省空间
   // HashMap<Integer, HashMap<Integer, Boolean>> winMap = new HashMap<>();//used的bits相同,则total肯定相同!!不需要双重map
    HashMap<Integer, Boolean> winMap = new HashMap<>();
//    HashMap<Integer, HashMap<Integer, Boolean>> loseMap = new HashMap<>(); //lost即非win, 所以不需要lostmap
//    boolean[] used; used数组并不需要, 只需要在拿牌的时候按位操作即可
//    public long calls = 0;
    public int maxn = 0;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        this.maxn = maxChoosableInteger;
        if(maxChoosableInteger * (maxChoosableInteger + 1) / 2 >= desiredTotal) {
            return win(0, desiredTotal, maxChoosableInteger);
        }else {
            return false;
        }
    }

    //同理, Endode并不需要, 只需要在拿牌的时候按位操作即可
//    private int encode(boolean[] v) {
//        int res = 0;
//        for (int i = 0; i < v.length; i++) {
//            if (v[i]) {
//                res |= 1;
//            } else {
//                res |= 0;
//            }
//            res <<= 1;
//        }
//        return res >> 1;
//    }

    private boolean win(int used, int total, int ncards) {
//        calls++;
        if (winMap.containsKey(used)) {
            return winMap.get(used);
        }
        boolean res = false;
        int bitmask = 1;
        for (int i = 0; i < maxn; i++, bitmask <<= 1) {
            if ((~used & bitmask) != 0) {
                if ((i + 1) >= total) {
                    res = true;
                } else if (ncards > 1) {
                    res |= (!win(used | bitmask, total - (i + 1), ncards - 1));
                }
                if (res) {
                    break;
                }
            }
        }
        winMap.put(used, res);
        return res;
    }
}
