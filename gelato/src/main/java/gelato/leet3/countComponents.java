package gelato.leet3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//323
public class countComponents {
    public int cnter = 0;
    //优化版本,
    // (1)最后并不需要用hashset来数有多少个parent,只需要在每次union的时候相减即可
    // (2)parent指向自己即可.
    // (3)path compression
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for(int i = 0; i < n; i++) roots[i] = i;

        for(int[] e : edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            if(root1 != root2) {
                roots[root1] = root2;  // union
                n--;
            }
        }
        return n;
    }

    public int find(int[] roots, int id) {
        while(roots[id] != id) {
            cnter++;
            roots[id] = roots[roots[id]];  // Path compression: 优化
            id = roots[id];
        }
        return id;
    }
    //----------------------------------------
    public int countComponents_my(int n, int[][] edges) {
        int [] parents = new int[n];
        for(int i =0 ; i< n; i++){
            parents[i] = i;
        }
        for(int [] edge : edges){
            int par1 = findParent(parents, edge[0]);
            int par2 = findParent(parents, edge[1]);
            if(par1 != par2) {
                parents[par1] = par2;
                n--;
            }
        }
        return n;
    }

    private int findParent(int [] parents, int x){
        while(parents[x] != x){
            cnter++;
            x = parents[x];
        }
        return x;
    }
}
