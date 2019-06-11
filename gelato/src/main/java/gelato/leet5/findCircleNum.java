package gelato.leet5;

//547
public class findCircleNum {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int [] root = new int[n];
        for(int i = 0; i < n; i++){
            root[i] = i;
        }
        for(int i = 0 ; i < root.length; i++){
            for(int j = i + 1; j < root.length; j++){
                if(M[i][j] == 1){
                    int r1 = find(root, i);
                    int r2 = find(root, j);
                    if(r1 != r2){
                        root[r1] = r2;
                        n--;
                    }
                }
            }
        }
        return n;
    }

    private int find(int [] root, int i){
        while (root[i] != i){
            root[i] = root[root[i]];
            i = root[i];
        }
        return i;
    }
}
