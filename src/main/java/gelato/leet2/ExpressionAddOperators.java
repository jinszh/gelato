package gelato.leet2;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    String [][][] prodss;
    Integer [][][] prods;
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();

        return res;
    }

    private  List<String> div(int target, String ss, int end){
        List<String> res = new ArrayList<>();
        if(Integer.parseInt(ss) == target){
            res.add(ss);
        }
        for(int i = 1; i < end ; i++){
            Integer [] aa =  prods[i][end];
            for(int j = 0; j < aa.length; j++) {
                List<String> subs_add = div(target - aa[j], ss.substring(0, i), i);
            }
        }
    }
}
