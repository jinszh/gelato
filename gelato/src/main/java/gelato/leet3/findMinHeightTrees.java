package gelato.leet3;

import java.util.*;

//310
public class findMinHeightTrees {
    //Minial height tree的root最多有两个, 去掉最外面一层叶子之后, 里面的节点最小深度+1
    // 如果还剩三个点, 则至少还能去掉两个叶子, 剩下的那个节点的最小深度加1, 成为根节点
    // 当只有两个点时, 因为这两个点肯定相连, 则最小深度相同
    // 所有去掉的节点都不能成为根, 因为如果他是根,他的最小深度 >= 该店到达根的路径 + 根的最小深度
    // 可以想象成两个最远的path往中间走,相遇的地方即root
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        //Get adj edges  - 这里不需要用map, 直接下标就行
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
