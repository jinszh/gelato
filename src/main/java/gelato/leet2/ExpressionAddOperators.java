package gelato.leet2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ExpressionAddOperators {
    HashSet<String>[][][] prodss;
    Long[][][] prods;

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num.length() > 0) {
            prods = new Long[num.length()][num.length()][];
            prodss = new HashSet[num.length()][num.length()][];
            int step = 0;
            while (step < num.length()) {
                for (int i = 0; i < num.length() - step; i++) {
                    HashMap<Long, HashSet<String>> prodsMap = new HashMap<>();
                    if (step == 0 || num.charAt(i) != '0') {
                        Long fullval = Long.parseLong(num.substring(i, i + step + 1));
                        prodsMap.put(fullval, new HashSet<>());
                        prodsMap.get(fullval).add(num.substring(i, i + step + 1));
                    }
                    for (int j = i; j < i + step; j++) {
                        Long sub1[] = prods[i][j];
                        Long sub2[] = prods[j + 1][i + step];
                        for (int k1 = 0; k1 < sub1.length; k1++) {
                            for (int k2 = 0; k2 < sub2.length; k2++) {
                                if (!prodsMap.containsKey(sub1[k1] * sub2[k2])) {
                                    prodsMap.put(sub1[k1] * sub2[k2], new HashSet<>());
                                }
                                for (String s1 : prodss[i][j][k1]) {
                                    for (String s2 : prodss[j + 1][i + step][k2]) {
                                        prodsMap.get(sub1[k1] * sub2[k2]).add(s1 + "*" + s2);
                                    }
                                }
                            }
                        }
                    }
                    prods[i][i + step] = new Long[prodsMap.size()];
                    prodss[i][i + step] = new HashSet[prodsMap.size()];
                    int count = 0;
                    for (Long key : prodsMap.keySet()) {
                        prods[i][i + step][count] = key;
                        prodss[i][i + step][count++] = prodsMap.get(key);
                    }
                }
                step++;
            }
            res = div((long) target, num, num.length());
        }
        return res;
    }

    private List<String> div(Long target, String ss, int end) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < prods[0][end - 1].length; i++) {
            if (prods[0][end - 1][i].equals(target)) {
                prodss[0][end - 1][i].forEach(o -> res.add(o));
            }
        }
        for (int i = 1; i < end; i++) {
            Long[] aa = prods[i][end - 1];
            for (int j = 0; j < aa.length; j++) {
                List<String> subs_add = div(target - aa[j], ss.substring(0, i), i);
                for (String s : subs_add) {
                    HashSet<String> sss = prodss[i][end - 1][j];
                    for (String si : sss) {
                        res.add(s + "+" + si);
                    }
                }
                List<String> subs_sub = div(target + aa[j], ss.substring(0, i), i);
                for (String s : subs_sub) {
                    HashSet<String> sss = prodss[i][end - 1][j];
                    for (String si : sss) {
                        res.add(s + "-" + si);
                    }
                }
            }
        }
        HashSet<String> remDup = new HashSet<>();
        remDup.addAll(res);
        return new ArrayList<>(remDup);
    }
}
