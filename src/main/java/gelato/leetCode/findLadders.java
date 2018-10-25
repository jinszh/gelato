package gelato.leetCode;
import java.util.*;

public class findLadders {
    List<List<String>> trans = new ArrayList<>();
    ArrayList<String> words;
    boolean[][] edges;
    List<Set<Integer>> pars = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        if (wordList != null && wordList.size() > 0 && wordList.contains(endWord)) {
            words = new ArrayList(wordList);
            words.add(beginWord);
            edges = new boolean[words.size()][words.size()];
            int[] layer = new int[words.size()];
            boolean [] visited = new boolean[words.size()];
            for (int i = 0; i < words.size(); i++) {
                visited[i] = false;
                pars.add(new HashSet<>());
                edges[i][i] = false;
                for (int j = i + 1; j < words.size(); j++) {
                    if (isTransable(words.get(i), words.get(j))) {
                        edges[j][i] = edges[i][j] = true;
                    } else {
                        edges[j][i] = edges[i][j] = false;
                    }
                }
            }

            int start = words.indexOf(beginWord);
            pars.get(start).add(-1);
            int end = words.indexOf(endWord);
            LinkedList<Integer> bfs = new LinkedList<>();
            bfs.offerLast(start);
            Arrays.fill(layer, Integer.MAX_VALUE);
            layer[start] = 0;

            while (!bfs.isEmpty()) {
                Integer head = bfs.peek();
                for (int i = 0; i < words.size(); i++) {
                    if (edges[i][head] && layer[i] > layer[head]) {
                        layer[i] = layer[head] + 1;
                        pars.get(i).add(head);
                        if (!visited[i] && layer[i] < layer[end]) {
                            bfs.offerLast(i);
                            visited[i] = true;
                        }
                    }
                }
                if (edges[head][end] && layer[end] > layer[head] + 1) {
                    layer[end] = layer[head] + 1;
                }
                bfs.removeFirst();
            }
            trans = formPaths(end);
        }
        return trans;
    }

    private List<List<String>> formPaths(int cur) {
        List<List<String>> allP = new ArrayList<>();
        if (pars.get(cur).size() > 0) {
            if (pars.get(cur).contains(-1)) {
                allP.add(new ArrayList<>(Arrays.asList(words.get(cur))));
            } else {
                for (Integer par : pars.get(cur)) {
                    List<List<String>> paths = formPaths(par);
                    for (List<String> p : paths) {
                        p.add(words.get(cur));
                    }
                    allP.addAll(paths);
                }
            }
        }
        return allP;
    }

    private boolean isTransable(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}