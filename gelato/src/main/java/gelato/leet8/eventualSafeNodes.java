package gelato.leet8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//802
public class eventualSafeNodes {
    int n;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        n = graph.length;
        List<Integer> res = new ArrayList<>();
        boolean[] safe = new boolean[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(safe, true);
        for(int r =0; r < 2; r++) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited, false);
                dfs(visited, safe, i, graph, i);
                if (r == 1 && safe[i]) res.add(i);
            }
        }
        return res;
    }

    private boolean dfs(boolean[] visited, boolean[] safe, int i, int[][] graph, int root) {
        if(!safe[i]) return false;
        visited[i] = true;
        boolean res = true;
        for (int j : graph[i]) {
            if(j == root) return false;
            if (!safe[j] || (!visited[j] && !dfs(visited, safe, j, graph, root))){
                res =false;
                break;
            }
        }
        safe[i] = res;
        return res;
    }
}
