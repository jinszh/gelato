package gelato.leet6;

//684
public class findRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int [] roots = new int[n + 1];
        int [] res = null;
        for(int i = 0; i <= n; i++){
            roots[i] = i;
        }
        for (int [] e : edges){
            int r1 = findroot(e[0], roots);
            int r2 = findroot(e[1], roots);
            if(r1 != r2){
                roots[r1] = r2;
            }else{
                res = e;
                break;
            }
        }
        return res;
    }

    private int findroot(int i, int [] roots){
        while (i != roots[i]){
            roots[i] = roots[roots[i]];
            i = roots[i];
        }
        return i;
    }
}
