package gelato.leet4;

//469 - 感觉是道几何题目

import java.util.List;

/*
The Key is
The key observation for convexity is that vector pi+1-pi always turns to the same direction to pi+2-pi formed by any 3 sequentially adjacent vertices
, i.e., cross product (pi+1-pi) x (pi+2-pi) does not change sign when traversing sequentially along polygon vertices.
 (右手原则)
 Cross product的计算方法:
 */
public class isConvex {
    public boolean isConvex(List<List<Integer>> points) {
        int sign = 0;
        int [] vec1 = new int[]{points.get(1).get(0) - points.get(0).get(0)
                , points.get(1).get(1) - points.get(0).get(1) };
        for(int i = 1; i <= points.size(); i++){
            int curId = i == points.size() ? 0 : i;
            int nextId = (curId < points.size() - 1 ? curId + 1 : 0);
            int [] vec2 = new int[]{points.get(nextId).get(0) - points.get(curId).get(0)
                    , points.get(nextId).get(1) - points.get(curId).get(1) };
            int cross = crossproduct(vec1, vec2);
            if(cross != 0) System.out.println(cross + ":" + points.get(curId).get(0) + "," + points.get(curId).get(1) );
            if(cross == 0) continue;
            if(sign == 0) {
                sign = cross > 0 ? 1 : -1;
            }else {
                if(sign * (cross > 0 ? 1 : -1) < 0){
                    return false;
                }
            }
            vec1 = vec2;
        }
        return true;
    }

    private int crossproduct(int [] vec1, int [] vec2) {
        return vec1[0] * vec2[1] - vec2[0] * vec1[1];
    }
}
