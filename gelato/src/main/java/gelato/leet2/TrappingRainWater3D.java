package gelato.leet2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class TrappingRainWater3D {
    public int trapRainWater(int[][] heightMap) {
        int v = 0;
        if(heightMap.length > 0 && heightMap[0].length > 0) {
            int h = heightMap.length, w = heightMap[0].length;
            int[][] water = new int[h][w];
            boolean[][] visited = new boolean[h][w];

            //Height queue
            PriorityQueue<int[]> hq = new PriorityQueue<>((o1, o2) -> (Integer.compare(o1[2], o2[2])));
            for (int i = 1; i < h - 1; i++) {//only internal position trap water
                for (int j = 1; j < w - 1; j++) {
                    hq.offer(new int[]{i, j, heightMap[i][j]});
                }
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < h; i++) {//only internal position trap water
                for (int j = 0; j < w; j++) {
                    max = Math.max(max, heightMap[i][j]);
                }
            }

            while (!hq.isEmpty()) {
                int[] hd = hq.poll();
                if (hd[2] != heightMap[hd[0]][hd[1]] || heightMap[hd[0]][hd[1]] >= max) {
                    continue;
                }
                ArrayDeque<int[]> bfs = new ArrayDeque<>();
                ArrayDeque<int[]> border = new ArrayDeque<>();
                bfs.offerLast(hd);
                ArrayList<int[]> flat = new ArrayList<>();
                int minNeighbor = Integer.MAX_VALUE;
                int maxNeighbor = Integer.MIN_VALUE;
                int minL = hd[2];
                boolean edge = false;
                while (!bfs.isEmpty()) {
                    int[] m = bfs.pollFirst();
                    flat.add(m);

                    if (m[0] == 0 || m[0] == h - 1 || m[1] == 0 || m[1] == w - 1) {
                        continue;
                    }
                    int[][] nbs = new int[4][2];//neighbors
                    nbs[0][0] = m[0] - 1;
                    nbs[0][1] = m[1];
                    nbs[1][0] = m[0] + 1;
                    nbs[1][1] = m[1];
                    nbs[2][0] = m[0];
                    nbs[2][1] = m[1] - 1;
                    nbs[3][0] = m[0];
                    nbs[3][1] = m[1] + 1;
                    for (int[] nb : nbs) {
                        if (!visited[nb[0]][nb[1]]) {
                            if (heightMap[nb[0]][nb[1]] <= minL) {
                                if (inEdge(nb[0], nb[1], h, w)) {
                                    edge = true;
                                } else {
                                    bfs.add(new int[]{nb[0], nb[1], heightMap[nb[0]][nb[1]]});
                                }
                            } else {
                                minNeighbor = Math.min(minNeighbor, heightMap[nb[0]][nb[1]]);
                                maxNeighbor = Math.max(maxNeighbor, heightMap[nb[0]][nb[1]]);
                                border.add(new int[]{nb[0], nb[1], heightMap[nb[0]][nb[1]]});
                            }
                        }
                    }
                    visited[m[0]][m[1]] = true;
                }

                if (!edge && minNeighbor > minL) {
                    for (int[] item : flat) {
                        int delta = minNeighbor - heightMap[item[0]][item[1]];
                        water[item[0]][item[1]] += delta;
                        v += delta;
                        heightMap[item[0]][item[1]] = minNeighbor;
                        hq.offer(new int[]{item[0], item[1], heightMap[item[0]][item[1]]});
                        visited[item[0]][item[1]] = false;
                    }
                }
            }
        }
        return v;
    }

    private boolean inEdge(int i, int j, int h, int w) {
        return i == 0 || i == h - 1 || j == 0 || j == w - 1;
    }
}
