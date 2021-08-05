package gelato.leet5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//531
public class findLonelyPixel {
    public int findLonelyPixel(char[][] picture) {
        if(picture == null || picture.length == 0 || picture[0].length == 0) return 0;
        HashMap<Integer, Integer> rows = new HashMap();
        HashMap<Integer, Integer> cols = new HashMap();
        for(int i = 0; i < picture.length; i++){
            for(int j = 0; j < picture[0].length; j++){
                if(picture[i][j] == 'B'){
                    rows.put(i, rows.getOrDefault(i, 0) + 1);
                    cols.put(j, cols.getOrDefault(j, 0) + 1);
                }
            }
        }
        int cnt = 0;
        for(Map.Entry<Integer, Integer> r : rows.entrySet()){
            if(r.getValue() == 1){
                for(Map.Entry<Integer, Integer> c : cols.entrySet()){
                    if(c.getValue() == 1){
                        if(picture[r.getKey()][c.getKey()] == 'B'){
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    //更好的办法: 读到第二个B的时候 把之前加过的减掉
    public int findLonelyPixel_better(char[][] picture) {
        int m= picture.length, n=picture[0].length, rowLP= 0, colLP= 0;
        int[] colCnt= new int[n];
        for (int i=0; i<m; i++){
            int rowCnt=0;
            for (int j=0; j<n; j++){
                if (picture[i][j]=='B'){
                    rowCnt++;
                    colCnt[j]++;
                    if (rowCnt==1) rowLP++;
                    if (rowCnt==2) rowLP--; //再出现第三个时候就无视了
                    if (colCnt[j]==1) colLP++;
                    if (colCnt[j]==2) colLP--;
                }
            }
        }
        return Math.min(rowLP, colLP);
    }
}
