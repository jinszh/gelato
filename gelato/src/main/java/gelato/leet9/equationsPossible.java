package gelato.leet9;

import javax.swing.text.StyledEditorKit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class equationsPossible {
    public boolean equationsPossible(String[] equations){
        Set [] sets = new Set[26];
        for(int i = 0 ; i < sets.length; i++){
            sets[i] = new HashSet();
            sets[i].add(i);
        }
        boolean res = true;
        for(int j = 0; j < 2; j++) {
            for (String e : equations) {
                int c1 = e.charAt(0) - 'a';
                int c2 = e.charAt(3) - 'a';
                boolean eqe = e.charAt(1) == '=';
                if (eqe && j == 0) {
                    sets[c1].addAll(sets[c2]);
                    sets[c2] = sets[c1];//注意 set[c2].addAll(set[c1])不对,c1和c2和, c2和c3合的时候, c1的就漏了,没进c3
                } else if(!eqe && j == 1) {
                    if (sets[c1].contains(c2)) {
                        res = false;
                        break;
                    }
                }
            }
        }
        return res;
    }

    //Union find method, 就是用数组指向目标位子, 递归地找.
    int[] uf = new int[26];
    public boolean equationsPossible_uf(String[] equations) {
        for (int i = 0; i < 26; ++i) uf[i] = i;
        for (String e : equations)
            if (e.charAt(1) == '=')
                uf[find(e.charAt(0) - 'a')] = find(e.charAt(3) - 'a');
        for (String e : equations)
            if (e.charAt(1) == '!' && find(e.charAt(0) - 'a') == find(e.charAt(3) - 'a'))
                return false;
        return true;
    }

    public int find(int x) {
        if (x != uf[x]) uf[x] = find(uf[x]);
        return uf[x];
    }
}
