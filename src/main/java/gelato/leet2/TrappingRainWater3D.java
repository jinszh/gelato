package gelato.leet2;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class TrappingRainWater3D {
    public int trapRainWater(int[][] heightMap) {
        int v = 0;
        int h = heightMap.length, w = heightMap[0].length;
        int [][] water = new int[h][w];
        boolean [][] visited = new boolean[h][w];

        //Height queue
        PriorityQueue<int[]> hq = new PriorityQueue<>((o1, o2) -> (Integer.compare(o1[2],o2[2])));

        for(int i = 0; i < heightMap.length; i++){
            for(int j = 0; j < heightMap[0].length; j++){
                hq.offer(new int[]{i, j, heightMap[i][j]});
            }
        }
        int minL;
        while (!hq.isEmpty()) {
            ArrayDeque<int[]> bfs = new ArrayDeque<>();
            int[] m = hq.poll();
            if(visited[m[0]][m[1]]){
                continue;
            }
            minL = m[2];
            if (m[0] == 0 || m[0] == h - 1 || m[1] == 0 || m[1] == w - 1) {
                water[m[0]][m[1]] = 0;
                visited[m[0]][m[1]] = true;
            } else {
                int hu = heightMap[m[0] - 1][m[1]];
                int hd = heightMap[m[0] + 1][m[1]];
                int hl = heightMap[m[0]][m[1] - 1];
                int hr = heightMap[m[0]][m[1] + 1];
                int minNeighbor = Math.min(heightMap[m[0] - 1][m[1]], heightMap[m[0] + 1][m[1]]);
            }
        }

        return v;
    }
}
