package gelato.leet2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//210
public class findOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<HashSet<Integer>> premap = new ArrayList<>(numCourses);
        List<HashSet<Integer>> postmap = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++) {
            premap.add(new HashSet<>());
            postmap.add(new HashSet<>());
        }
        for(int [] pre : prerequisites){
            premap.get(pre[1]).add(pre[0]);
            postmap.get(pre[0]).add(pre[1]);
        }
        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < premap.size(); i++){
            if(premap.get(i).size() == 0){
                q.add(i);
            }
        }
        int fin = 0;
        int [] res = new int[numCourses];
        while (!q.isEmpty()) {
            int c = q.poll();
            res[fin++] = c;
            for (int i : postmap.get(c)) {
                premap.get(i).remove(c);
                if (premap.get(i).size() == 0) {
                    q.add(i);
                }
            }
        }
        return fin == numCourses ? res : new int[0];
    }
}
