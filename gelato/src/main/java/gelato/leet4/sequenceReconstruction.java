package gelato.leet4;

import java.util.*;

//444
public class sequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        HashMap<Integer, HashSet<Integer>> in = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> out = new HashMap<>();

        for(List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                if (!in.containsKey(seq.get(i))) {
                    in.put(seq.get(i), new HashSet<>());
                }
                if (!out.containsKey(seq.get(i))) {
                    out.put(seq.get(i), new HashSet<>());
                }
                if(i < seq.size() - 1) {
                    if (!in.containsKey(seq.get(i + 1))) {
                        in.put(seq.get(i + 1), new HashSet<>());
                    }
                    in.get(seq.get(i + 1)).add(seq.get(i));
                    out.get(seq.get(i)).add(seq.get(i + 1));
                    if (!out.containsKey(seq.get(i + 1))) {
                        out.put(seq.get(i + 1), new HashSet<>());
                    }
                }
            }
        }
        if(org.length == 1){
            return in.size() == 1 && in.get(org[0]).size() == 0;
        }

        LinkedList<Integer> q = new LinkedList<>();
        Iterator<Map.Entry<Integer, HashSet<Integer>>> ite = in.entrySet().iterator();
        while (ite.hasNext()){
            Map.Entry<Integer, HashSet<Integer>> entry = ite.next();
            if(entry.getValue().size() == 0){
                q.add(entry.getKey());
            }
        }

        int fin = 0;
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            if(q.size() > 1) return false;
            int c = q.poll();
            res.add(c);
            if(fin >= org.length || res.get(fin) != org[fin]) return false;
            for (int i : out.get(c)) {
                in.get(i).remove(c);
                if (in.get(i).size() == 0) {
                    q.add(i);
                }
            }
            fin++;
        }
        return fin == org.length;
    }

    //Another solution - 因为说了是n个数, 且是每个都有前驱后继的关系, 其实也可以不用topo sort, 直接定位
    public boolean sequenceReconstruction1(int[] org, List<List<Integer>> seqs) {
        int[] idx = new int[org.length + 1];
        for (int i = 0; i < org.length; i++) {
            idx[org[i]] = i;
        }

        boolean[] existed = new boolean[org.length + 1];
        boolean isEmpty = true;
        int count = 0;
        for (List<Integer> seq: seqs) {
            for (int i = 0; i < seq.size(); i++) {
                isEmpty = false;
                int cur = seq.get(i);
                if (cur <= 0 || cur > org.length) {
                    return false;
                }

                if (i > 0) {
                    int prev = seq.get(i - 1);
                    if (idx[cur] <= idx[prev]) {
                        return false;
                    }

                    if (idx[prev] + 1 == idx[cur]) {
                        if (!existed[prev]) {
                            count++;
                            existed[prev] = true;
                        }
                    }
                }
            }
        }

        return !isEmpty && count == org.length - 1;
    }
}
