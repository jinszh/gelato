package gelato.leet9;

import java.util.*;

//947
public class removeStones {
    // 抄的答案, 可以通过横向纵向连起来的点,比如{(0,0), (0,1), (1,0), (1,1)}算一个union, 或者isolated island
    // 然后每个union一定可以减到最后一个节点
    // 并非教科书式的union find的写法, 思路相同, 要变通
    // 所以同样的思路下, dfs也可以, union应该更快
    Map<Integer, Integer> f = new HashMap<>();
    int islands = 0;

    public int removeStones(int[][] stones) {
        for (int i = 0; i < stones.length; ++i)
            union(stones[i][0], ~stones[i][1]);//对y坐标取非, 用于在hashmap找parent的时候区分x, y坐标来源
        return stones.length - islands;
    }

    public int find(int x) {//通过hashmap寻找自己的parent
        if (f.putIfAbsent(x, x) == null) // 把parent初始化为自己
            islands++;
        if (x != f.get(x))
            f.put(x, find(f.get(x))); // 链接到自己的parent
        return f.get(x);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f.put(x, y); //把x和y的parent也通过hashmap链接起来. 从而合成一个岛
            islands--;
        }
    }

    //dfs的版本, 简单好懂
    public int removeStones_dfs(int[][] stones) {
        Set<int[]> visited = new HashSet();
        int numOfIslands = 0;
        for (int[] s1:stones){
            if (!visited.contains(s1)){
                dfs(s1, visited, stones);
                numOfIslands++;
            }
        }
        return stones.length - numOfIslands;
    }

    private void dfs(int[] s1, Set<int[]> visited, int[][] stones){
        visited.add(s1);
        for (int[] s2: stones){
            if (!visited.contains(s2)){
                // stone with same row or column. group them into island
                if (s1[0] == s2[0] || s1[1] == s2[1])
                    dfs(s2, visited, stones);
            }
        }
    }
}
