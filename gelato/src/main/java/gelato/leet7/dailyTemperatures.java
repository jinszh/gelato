package gelato.leet7;

import java.util.LinkedList;

//739
public class dailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int [] res = new int[T.length];
        LinkedList<int[]> stack = new LinkedList<>();
        for(int i = 0; i < T.length; i++){
            while (!stack.isEmpty() && stack.peek()[0] < T[i]){
                int [] head = stack.poll();
                res[head[1]] = (i - head[1]);
            }
            stack.push(new int[]{T[i], i});
        }
        return res;
    }
}
