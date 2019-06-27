package gelato.leet2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//247
public class findStrobogrammatic {
    public List<String> findStrobogrammatic(int n) {
        List<String> r = new ArrayList<>();
        r.add("");
        if(n > 0){
            List<String> r1 = new ArrayList<>();
            r1.add("0");
            r1.add("1");
            r1.add("8");
            for(int i = 2; i <= n; i++){
                List<String> r2 = new ArrayList<>();
                for(String w : r){
                    r2.add("0" + w + "0");
                    r2.add("1" + w + "1");
                    r2.add("6" + w + "9");
                    r2.add("8" + w + "8");
                    r2.add("9" + w + "6");
                }
                r = r1;
                r1 = r2;
            }
            r = n > 1 ? (r1.stream().filter(o -> !o.startsWith("0")).collect(Collectors.toList())) : r1;
        }
        return r;
    }

    //One improvement - 递归的时候只需要-2即可, 另外不是最后一轮都要两侧加0, 这样子避免最后找一轮去掉0... 这样子就快很多
    public List<String> findStrobogrammatic_1(int n) {
        return helper(n, n);
    }

    List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));

        List<String> list = helper(n - 2, m);

        List<String> res = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);

            if (n != m) res.add("0" + s + "0");

            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }

        return res;
    }
}
