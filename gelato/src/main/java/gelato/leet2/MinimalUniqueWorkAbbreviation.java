package gelato.leet2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimalUniqueWorkAbbreviation {
    //Original version
    public String minAbbreviation(String target, String [] dict) {
        List<Integer>[] con = new List[target.length()];
        int numDict = dict.length;
        for (int k = 0; k < dict.length; k++) {
            if (dict[k].length() != target.length()) {
                numDict--;
                continue;
            }
            for (int i = 0; i < target.length(); i++) {
                if (target.charAt(i) != dict[k].charAt(i)) {
                    if (con[i] == null) con[i] = new ArrayList<>();
                    con[i].add(k);
                }
            }
        }
        return numDict == 0 ? Integer.toString(target.length()) : findMin(target, 0, con, "", new boolean[dict.length], numDict, 0, 0);
    }

    private String findMin(String target, int i, List<Integer> [] noConL
            ,String partial, boolean [] noCon, int totalCon, int nBefore, int parLen) {
        int effective = noConL[i] == null ? 0 : (int)noConL[i].stream().filter(o -> noCon[o] == false).count();
        if (effective == totalCon) {
            String s2 = null;
            if (nBefore > 0 && i < target.length() - 1) {
                s2 = findMin(target, i + 1, noConL, partial, noCon, totalCon, nBefore + 1, parLen);
            }
            String s1 = partial + (nBefore > 0 ? Integer.toString(nBefore) : "")
                    + target.charAt(i)
                    + (target.length() - i - 1 > 0 ? Integer.toString(target.length() - i - 1) : "");
            if (parLen + (nBefore > 0 ? 1 : 0) + (i == target.length() - 1 ? 1 : 2) < minL) {
                minL = parLen + (nBefore > 0 ? 1 : 0) + (i == target.length() - 1 ? 1 : 2);
                return s1;
            } else {
                return s2;
            }
        }else {
            if(i == target.length() - 1){
                return null;
            }else if (effective == 0) {
                return findMin(target, i + 1, noConL, partial, noCon, totalCon, nBefore + 1, parLen);
            } else {
                //keep i
                int newTotal = totalCon;
                boolean[] tmp = Arrays.copyOf(noCon, noCon.length);
                for (Integer id : noConL[i]) {
                    if (!noCon[id]) {
                        tmp[id] = true;
                        newTotal--;
                    }
                }
                String partial1 = partial + (nBefore > 0 ? Integer.toString(nBefore) : "") + target.charAt(i);
                String s1 = parLen + (nBefore > 0 ? 1 : 0) + 2 >= minL ? null : findMin(target, i + 1, noConL, partial1, tmp, newTotal, 0, parLen + (nBefore > 0 ? 1 : 0) + 1);
                //mask i
                String s2 = parLen + 1 >= minL ? null : findMin(target, i + 1, noConL, partial, noCon, totalCon, nBefore + 1, parLen);
                if (s1 != null && s2 != null) {
                    return s1.length() > s2.length() ? s2 : s1;
                } else {
                    return s1 != null ? s1 : s2;
                }
            }
        }
    }

    //version 2, using bit mask
    public String minAbbreviation2(String target, String [] dict) {
        List<Integer> masks = new ArrayList<>();
        int numDict = dict.length, full = 0;
        targetLen = target.length();
        for (int k = 0; k < dict.length; k++) {
            if (dict[k].length() != target.length()) {
                numDict--;
                continue;
            }
            int mask = 0;
            for (int i = target.length() - 1, bit = 1; i >= 0; i--, bit <<= 1) {
                if (target.charAt(i) != dict[k].charAt(i)) {
                    mask += bit;
                }
            }
            full |= mask;
            masks.add(mask);
        }
        if (numDict == 0) {
            return Integer.toString(target.length());
        }
        minV = full; minL = getLen(full);
        solve(full, target.length() - 1, masks);
        StringBuilder res = new StringBuilder();
        int nMasked = 0;
        for (int i = 0; i < target.length(); i++) {
            if ((minV & (1 << (target.length() - 1 - i))) > 0) {
                if (nMasked > 0) {
                    res.append(nMasked);
                    nMasked = 0;
                }
                res.append(target.charAt(i));
            } else {
                nMasked++;
            }
        }
        if(nMasked > 0){
            res.append(nMasked);
        }
        return res.toString();
    }

    private void solve(int val, int id, List<Integer> dict) {
        for (int i = id; i >= 0; i--) {
            if ((val & (1 << i)) > 0) {
                int vHid = val ^ (1 << i);
                if (dict.stream().allMatch(o -> (o & vHid) > 0)) {
                    int l = getLen(vHid);
                    if (l < minL) {
                        minL = l;
                        minV = vHid;
                    }
                    if (i > 0) {
                        solve(vHid, i - 1, dict);
                    }
                }
            }
        }
    }

    private int getLen(int v) {
        if (v < 0) {
            return Integer.MAX_VALUE;
        }
        int end = 1;
        int len = 0;
        int step = 0;
        while (step < targetLen) {
            if ((v & 1) == 1 || (v & 1) != end) {
                len++;
                end = (v & 1);
            }
            v >>= 1;
            step++;
        }
        return len;
    }
    int minL = Integer.MAX_VALUE;
    int minV = -1;
    int targetLen = 0;
}
