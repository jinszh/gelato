package gelato.leet7;

//785
public class isBipartite {
    boolean isBipartitle = true;
    int n = 0;
    public boolean isBipartite(int[][] graph) {
        n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] color = new boolean[n];
        for (int i = 0; i < n && isBipartitle; i++) {
            if (visited[i]) continue;
            dfs(graph, visited, color, i, true);
        }
        return isBipartitle;
    }

    private void dfs(int [][] adj,boolean[] visited, boolean [] color, int i, boolean set) {
        if (!isBipartitle) return;
        visited[i] = true;
        color[i] = set;
        for (int j : adj[i]) {
            if (!visited[j]) {
                dfs(adj, visited, color, j, !set);
            } else if (color[j] == set) {
                isBipartitle = false;
                return;
            }
        }
    }
}
