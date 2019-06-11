package gelato.leet7;

import java.util.*;

//721
public class accountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> emailMap = new HashMap<>();
        HashMap<Integer, String> acctMap = new HashMap<>();

        ArrayList<Integer> roots = new ArrayList<>();
        int i = 0;
        for(List<String> s : accounts){
            Integer root = null;
            for(int j = 1; j < s.size(); j++){
                if(!emailMap.containsKey(s.get(j))) {
                    if(root == null) {
                        root = i;
                        acctMap.put(i, s.get(0));
                    }
                    emailMap.put(s.get(j), i++);
                    roots.add(root);
                }else {
                    int newroot = findRoot(emailMap.get(s.get(j)), roots);
                    if(root == null){
                        root = newroot;
                    }else if(root != newroot) {
                        roots.set(root, newroot);
                        root = newroot;
                    }
                }
            }
        }
        HashMap<Integer, List<String>> res = new HashMap<>();
        for(Map.Entry<String, Integer> entry : emailMap.entrySet()){
            int root = findRoot(entry.getValue(), roots);
            if(!res.containsKey(root)){
                res.put(root, new ArrayList<>());
            }
            res.get(root).add(entry.getKey());
        }
        List<List<String>> resarr = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry : res.entrySet()){
            ArrayList<String> sa = new ArrayList<>();
            sa.add(acctMap.get(entry.getKey()));
            entry.getValue().sort(String::compareTo);
            sa.addAll(entry.getValue());
            resarr.add(sa);
        }
        return resarr;
    }

    private int findRoot(int i, List<Integer> roots){
        while (i != roots.get(i)){
            roots.set(i, roots.get(i));
            i = roots.get(i);
        }
        return i;
    }

    //Other's union find ---
    public List<List<String>> accountsMerge_(List<List<String>> acts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();//直接用hashmap来存parent对于string换array可能更快
        Map<String, TreeSet<String>> unions = new HashMap<>(); //用treeset来存放sorted的email
        for (List<String> a : acts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        for (List<String> a : acts) {
            String p = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++)
                parents.put(find(a.get(i), parents), p);
        }
        for(List<String> a : acts) {
            String p = find(a.get(1), parents);
            if (!unions.containsKey(p)) unions.put(p, new TreeSet<>());
            for (int i = 1; i < a.size(); i++)
                unions.get(p).add(a.get(i));
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }

    private String find(String s, Map<String, String> p) {
        return p.get(s) == s ? s : find(p.get(s), p);
    }
}
