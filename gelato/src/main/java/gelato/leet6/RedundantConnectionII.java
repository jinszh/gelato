package gelato.leet6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//685
public class RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        checkValid(edges, -1);
        HashMap<Integer, Integer> mapId = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            mapId.put(edges[i][0] * edges.length + edges[i][1], i);
        }
        int maxId = -1;
        for (int[] error : err) {
            int idx = mapId.get(error[0] * edges.length + error[1]);
            boolean valid = checkValid(edges, idx);
            if (valid) {
                maxId = Math.max(maxId, idx);
            }
        }
        return edges[maxId];
    }

    boolean checkValid(int[][] edges, int skip) {
        int n = edges.length + 1;
        int[] roots = new int[n];
        int[] par = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
            par[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            if (i == skip) continue;
            if (par[edges[i][1]] != edges[i][1]) {
                if (skip < 0) {
                    err.add(edges[i]);
                    err.add(new int[]{par[edges[i][1]], edges[i][1]});
                }
                return false;
            } else{
                int r1 = findroot(edges[i][0], roots);
                if (r1 == edges[i][1]) {//cycle found
                    if (skip < 0) {
                        err.add(edges[i]);
                        int v = edges[i][0];
                        while (v != edges[i][1]) {
                            err.add(new int[]{par[v], v});
                            v = par[v];
                        }
                    }
                    return false;
                } else {
                    roots[edges[i][1]] = r1;
                    par[edges[i][1]] = edges[i][0];
                }
            }
        }
        return true;
    }

    private int findroot(int i, int[] roots) {
        while (i != roots[i]) {
            roots[i] = roots[roots[i]];
            i = roots[i];
        }
        return i;
    }

    List<int[]> err = new ArrayList<>();
}
