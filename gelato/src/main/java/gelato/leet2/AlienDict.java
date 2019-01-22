package gelato.leet2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlienDict {
    final static int CHAR_NUM = 26;
    public String alienOrder(String[] words) {
        boolean [][] edges = new boolean[CHAR_NUM][];
        Boolean [] nodes = new Boolean[CHAR_NUM];
        Integer [] din = new Integer[CHAR_NUM];
        Arrays.fill(din, 0);
        Arrays.fill(nodes, false);
        for(int i = 0 ; i < CHAR_NUM; i++) {
            edges[i] = new boolean[CHAR_NUM];
            Arrays.fill(edges[i], false);
        }

        String a = "";
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                nodes[words[i].charAt(j) - 'a'] = true;
            }
            for (int j = 0; j < words[i].length(); j++) {
                if (j < a.length()){
                    if(a.charAt(j) != words[i].charAt(j)) {
                        edges[a.charAt(j) - 'a'][words[i].charAt(j) - 'a'] = true;
                        break;
                    }
                }else {
                    break;
                }
            }
            a = words[i];
        }
        StringBuilder seq = new StringBuilder();
        for(int i = 0; i < edges.length; i++){
            for(int j = 0; j < edges.length; j++)
               if(edges[i][j]){
                    din[j]++;
               }
        }
        boolean f = true;
        while (f) {
            f = false;
            for (int i = 0; i < CHAR_NUM; i++) {
                if (din[i] == 0 && nodes[i]) {
                    seq.append((char) (i + 'a'));
                    nodes[i] = false;
                    f = true;
                    for (int j = 0; j < edges.length; j++) {
                        if (edges[i][j]) din[j]--;
                    }
                }
            }
        }
        return Arrays.stream(nodes).anyMatch(o -> o)? "" : seq.toString();
    }
}
