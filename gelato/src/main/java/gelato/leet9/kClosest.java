package gelato.leet9;

import java.util.PriorityQueue;

public class kClosest {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> order = new PriorityQueue<>(K, (a, b) -> (Integer.compare(b[0] * b[0] + b[1] * b[1]
                , a[0] * a[0] + a[1] * a[1])));
        for (int [] p: points) {
            if(order.size() < K){
                order.add(p);
            }else{
                int [] head = order.peek();
                if((head[0] * head[0] + head[1] * head[1]) > (p[0] * p[0] + p[1] * p[1])){
                    order.poll();
                    order.add(p);
                }
            }
        }
        return order.toArray(new int[K][]);
    }
}
