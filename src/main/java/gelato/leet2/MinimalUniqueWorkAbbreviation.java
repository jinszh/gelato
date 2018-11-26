package gelato.leet2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimalUniqueWorkAbbreviation {
    int minL = Integer.MAX_VALUE;
    public String minAbbreviation(String target, String [] dict) {
        List<Integer>[] con = new List[target.length()];
        boolean[] ex = new boolean[dict.length];
        int numDict = dict.length;
        for (int k = 0; k < dict.length; k++) {
            if (dict[k].length() != target.length()) {
                numDict--;
            }
        }
        if(numDict == 0){
            return Integer.toString(target.length());
        }
        for (int i = 0; i < target.length(); i++) {
            con[i] = new ArrayList<>();
            for (int k = 0; k < dict.length; k++) {
                if (dict[k].length() != target.length()) {
                    continue;
                }
                if (target.charAt(i) != dict[k].charAt(i)) {
                    con[i].add(k);
                }
            }
        }
        return findMin(target, 0, con, "", ex, numDict, 0, 0);
    }

    private String findMin(String target, int i, List<Integer> [] noConL
            ,String partial, boolean [] noCon, int totalCon, int nBefore, int parLen) {
        int effective = noConL[i].size() == 0 ? 0 : (int)noConL[i].stream().filter(o -> noCon[o] == false).count();
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
}
