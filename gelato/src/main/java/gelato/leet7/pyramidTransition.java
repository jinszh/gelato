package gelato.leet7;

import java.awt.*;
import java.util.*;
import java.util.List;

//756
public class pyramidTransition {
    public int cnt = 0;
    //自己最开始的做法, 全排列 所以最慢
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int[][] map = new int[8][8];
        for (String s : allowed) {
            map[s.charAt(0) - 'A'][s.charAt(1) - 'A'] |= (1 << (s.charAt(2) - 'A'));
        }
        List<String> form = getNextLevel(bottom, map);
        while (form.size() > 0 && form.get(0).length() > 1) {
            List<String> next = new ArrayList<>();
            for (String s : form) {
                next.addAll(getNextLevel(s, map));
            }
            form = next;
            System.out.println(next.size());
        }
        return form.size() > 0;
    }

    private List<String> getNextLevel(String s, int [][] map) {
        cnt++;
        List<String> base = new ArrayList<>();
        base.add("");
        for (int i = 0; i < s.length() - 1; i ++) {
            List<String> next = new ArrayList<>();
            int up = map[s.charAt(i) - 'A'][s.charAt(i + 1) - 'A'];
            int j = 0;
            while (up != 0){
                if((up & 1) > 0){
                    for(String b : base) {
                        next.add(b + (char)('A' + j));
                    }
                }
                up >>= 1;
                j++;
            }
            base = next;
        }
        return base;
    }

    // Map + Backtracing - Acceptable的方法 - 先遇到答案的几率大

    public boolean pyramidTransition_bk(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0,2);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s.substring(2));
        }

        return helper(bottom, map);
    }

    private boolean helper(String bottom, Map<String, List<String>> map) {
        if(bottom.length() == 1) return true;
        for (int i = 0; i<bottom.length()-1; i++) {
            if (!map.containsKey(bottom.substring(i,i+2))) return false;
        }
        List<String> ls = new ArrayList<>();
        getList(bottom, 0, new StringBuilder(), ls, map);
        for (String s : ls) {
            if (helper(s, map)) return true;
        }
        return false;
    }

    private void getList(String bottom, int idx, StringBuilder sb, List<String> ls, Map<String, List<String>> map) {
        cnt++;
        if (idx == bottom.length() - 1) {
            ls.add(sb.toString());
            return;
        }
        for (String s : map.get(bottom.substring(idx, idx+2))) {
            sb.append(s);
            getList(bottom, idx + 1, sb, ls, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
