package gelato.leet3;

import java.util.*;

//399
//Union find
public class calcEquation {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Integer> keys = new HashMap<>();

        int id = 0;
        for (int i = 0; i < equations.size(); i++) {
            for (String s : equations.get(i)) {
                if (!keys.containsKey(s)) {
                    keys.put(s, id++);
                }
            }
        }

        int[] parent = new int[keys.size()];
        int[] rank = new int[keys.size()];
        double[] times = new double[keys.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            times[i] = 1;
        }

        for (int i = 0; i < equations.size(); i++) {
            double v = values[i];
            int para1 = keys.get(equations.get(i).get(0));
            int para2 = keys.get(equations.get(i).get(1));
            int par1 = ufind(parent, times, para1);
            int par2 = ufind(parent, times, para2);

            if (par1 == par2) continue;
            if (rank[par1] > rank[par2]) {
                parent[par2] = par1;
                times[par2] = v * times[para1] / times[para2];
            } else {
                parent[par1] = par2;
                times[par1] = times[para2] / v * times[para1];
                if (rank[par1] == rank[par2])
                    rank[par2]++;
            }
        }

        double[] res = new double[queries.size()];
        int i = 0;
        for (List<String> q : queries) {
            Integer para1 = keys.get(q.get(0));
            Integer para2 = keys.get(q.get(1));
            if(para1 == null || para2 == null) {
                res[i] = -1;
            }else {
                int par1 = ufind(parent, times, para1);
                int par2 = ufind(parent, times, para2);
                if (par1 != par2) {
                    res[i] = -1;
                } else {
                    res[i] = times[para2] / times[para1];
                }
            }
            i++;
        }
        return res;
    }

    private int ufind(int [] parent, double [] times, int i) {
        if (parent[i] != i) {
            int oldParent = parent[i];
            parent[i] = ufind(parent, times, parent[i]);
            if (oldParent != parent[i]) times[i] *= times[oldParent];
        }
        return parent[i];
    }


    //另外一个dfs的版本, 没有union find快 - 程序写起来比较简单
    public double[] calcEquation_dfs(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> edgemap = new HashMap<>();

        for (int i = 0; i < values.length; i ++) {
            List<String> equation = equations.get(i);
            if (!edgemap.containsKey(equation.get(0))) {
                edgemap.put(equation.get(0), new HashMap<>());
            }

            if (!edgemap.containsKey(equation.get(1))) {
                edgemap.put(equation.get(1), new HashMap<>());
            }

            edgemap.get(equation.get(0)).put(equation.get(1), values[i]);
            edgemap.get(equation.get(1)).put(equation.get(0), 1/values[i]);
        }

        double[] res = new double[queries.size()];

        for (int j = 0; j < queries.size(); j ++) {
            List<String> query = queries.get(j);
            String from = query.get(0);
            String to = query.get(1);

            res[j] = search(edgemap, 1, from, to, new HashSet<String>());
        }

        return res;
    }

    // dfs
    private double search(Map<String, HashMap<String, Double>> map,
                          double val, String cur, String to, Set<String> visited) {
        if (visited.contains(cur) || !map.containsKey(cur)) {
            return -1;
        }

        if (cur.equals(to)) {
            return val;
        }

        visited.add(cur);

        HashMap<String, Double> adj = map.get(cur);
        double res = -1;
        for (Map.Entry<String, Double> pair : adj.entrySet()) {
            res = search(map, val * pair.getValue(), pair.getKey(), to, visited);
            if (res != -1) {
                break;
            }
        }

        return res;
    }
}
