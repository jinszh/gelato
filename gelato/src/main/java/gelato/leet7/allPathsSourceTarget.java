package gelato.leet7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//797
public class allPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> res = new ArrayList<>();
        return dfs(graph, 0);
    }

    private List<List<Integer>> dfs(int[][] graph, int i){
        List<List<Integer>> res = new ArrayList<>();
        if(i == graph.length - 1){
            LinkedList<Integer> base = new LinkedList<>();
            base.add(i);
            res.add(base);
        }else {
            for (int nxt : graph[i]) {
                List<List<Integer>> l = dfs(graph, nxt);
                if (l.size() > 0) {
                    for (List ll : l) {
                        ((LinkedList) l).addFirst(i);
                    }
                    res.addAll(l);
                }
            }
        }
        return res;
    }
}
