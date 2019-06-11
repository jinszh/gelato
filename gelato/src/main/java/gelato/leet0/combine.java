package gelato.leet0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//77
public class combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        help(1, 0, n, k, new LinkedList<>(), res);
        return res;
    }

    private void help(int idx, int cnt, int n, int k, LinkedList<Integer> cur, List<List<Integer>> res){
        for(int i = idx; i <= n; i++){
          cur.add(i);
          if(cur.size() == k){
              res.add(new ArrayList<>(cur));
          }else{
              help(i + 1, cnt + 1, n, k, cur, res);
          }
          cur.removeLast();
        }
    }
}
