package gelato.leet2;

import java.util.*;

public class NumberOfIslands {
    /****
     * 使用HashTable的方法, --> 复杂度是O(L^2 + m*n), 跟标准答案类似,不过没有rank, 所以在找根parent这步上可能最差会O(L), 所以会变成O(L^2)
     * @param m
     * @param n
     * @param positions
     * @return
     */
    public List<Integer> numIslands2_hash(int m, int n, int[][] positions) {
        List<Integer> s = new ArrayList<>();
        int[][] mat = new int[m][n];
        for (int[] a : mat) {
            Arrays.fill(a, -1);
        }

        int count = 0;
        int dup = 0;
        HashMap<Integer, Integer> merged = new HashMap<>();
        merged.put(-1, -1);
        for (int[] pos : positions) {
            int il = pos[0] > 0 ? revGet(merged, mat[pos[0] - 1][pos[1]]) : -1;
            int ir = pos[0] < m - 1 ? revGet(merged, mat[pos[0] + 1][pos[1]]) : -1;
            int iu = pos[1] > 0 ? revGet(merged, mat[pos[0]][pos[1] - 1]) : -1;
            int id = pos[1] < n - 1 ? revGet(merged, mat[pos[0]][pos[1] + 1]) : -1;
            List<Integer> l = Arrays.asList(il, ir, iu, id);
            Collections.sort(l);
            if (l.get(l.size() - 1) < 0) {
                mat[pos[0]][pos[1]] = ++count;
                merged.put(count, count);
            } else {
                mat[pos[0]][pos[1]] = l.get(l.size() - 1);
                for (int k = 0; k < l.size(); k++) {
                    int num = l.get(k);
                    if (num > 0 && (k == 0 || num != l.get(k - 1)) && num < mat[pos[0]][pos[1]]) {
                        merged.put(num, mat[pos[0]][pos[1]]);
                        dup++;
                    }
                }
            }
            s.add(count - dup);
        }
        return s;
    }

    private int revGet(HashMap<Integer, Integer> map, int start) {
        while (map.get(start).intValue() != start) {
            start = map.get(start);
        }
        return start;
    }

    /****
     * 使用 Disjoint Union的方法, --> 复杂度是O(L + mn), L是position的个数, mn是matrix的边长
     * 因为有了rank所以unionfind这部操作实际复杂度是O(1)
     * * @param m
     * @param n
     * @param positions
     * @return
     */
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new LinkedList<>();
        UnionFind uf = new UnionFind(m, n);
        for (int[] pos : positions) {
            int i = pos[0];
            int j = pos[1];
            uf.add(i, j);
            int[][] ns = new int[][]{
                    { i - 1, j }, { i + 1, j }, { i, j - 1 }, { i, j + 1 }
            };
            for (int[] neighbor : ns) {
                int ni = neighbor[0];
                int nj = neighbor[1];
                uf.union(i, j, ni, nj);
            }
            result.add(uf.count);
        }
        return result;
    }

    private class UnionFind {
        public int[] rank;
        public int[] parent;
        public int m;
        public int n;
        public int count;
        public UnionFind(int m, int n) {
            this.m = m;
            this.n = n;
            this.rank = new int[m * n + 1];
            this.parent = new int[m * n + 1];
            this.count = 0;
        }
        public int index(int i, int j) {
            return i * n + j + 1;
        }
        public void add(int i, int j) {
            int index = index(i, j);
            if (parent[index] == 0) {
                parent[index] = index;
                rank[index] = 1;
            }
            count++;
        }
        public void union(int i, int j, int ni, int nj) {
            if (!valid(i, j) || !valid(ni, nj)) return;
            int parent1 = find(index(i, j));
            int parent2 = find(index(ni, nj));
            if (parent1 == 0 || parent2 == 0 || parent1 == parent2) return;
            if (rank[parent1] > rank[parent2]) {
                parent[parent2] = parent1;
                rank[parent1] += rank[parent2];
            } else {
                parent[parent1] = parent2;
                rank[parent2] += rank[parent1];
            }
            count--;
        }
        private boolean valid(int i, int j) {
            return i >= 0 && i < m && j >= 0 && j < n;
        }
        private int find(int index) {
            if (parent[index] == 0) return 0;
            while (parent[index] != index) {
                index = parent[parent[index]];
            }
            return index;
        }
    }

}
