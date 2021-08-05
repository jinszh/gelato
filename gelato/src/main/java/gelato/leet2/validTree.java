package gelato.leet2;

import java.util.*;

//261
public class validTree {
    //如果是一棵树, 一定是一个连通量, 并且边的个数刚好为n-1
    public boolean validTree(int n, int[][] edges) {
        if(n == 0 || edges.length != n - 1) return false;
        int [] parents = new int[n];
        int [] rank = new int[n];
        for(int i = 0; i < parents.length; i++) parents[i] = i;
        for(int [] edge : edges){
            int par1 = ufind(parents, edge[0]);
            int par2 = ufind(parents, edge[1]);
            if(par1 == par2) continue;
            if(rank[par1] < rank[par2]) parents[par1] = par2;
            else {
                parents[par2] = par1;
                if(rank[par1] == rank[par2]) rank[par1]++;
            }
        }
        int par = ufind(parents, 0);
        for(int i = 0; i < n; i++){
            if(ufind(parents, i) != par) return false;
        }
        return true;
    }

    int ufind(int[] parents, int i) {
        if (parents[parents[i]] != parents[i]) { // not root
            parents[i] = ufind(parents, parents[i]);
        }
        return parents[i];
    }

    // DFS的方法 - 慢一些, 但也好写
    public boolean validTree_dfs(int n, int[][] edges) {
        if (n == 0 || edges.length != n - 1) return false;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        if (cyclic(adj, -1, 0, visited)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean cyclic(List<List<Integer>> adj, int from, int i, HashSet<Integer> visited) {
        visited.add(i);
        for (Integer a : adj.get(i)) {
            if (a != from && (visited.contains(a) || cyclic(adj, i, a, visited))) {
                return true;
            }
        }
        return false;
    }
}
