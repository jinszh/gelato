package gelato.leet5;

import java.util.List;

//524
public class findLongestWord {
    public String findLongestWord(String s, List<String> d) {
        int max = 0;
        String res = "";
        for (String ds : d) {
            if ((ds.length() > max || (ds.length() == max && res.compareTo(ds) > 0)) && isSubs(s, ds)) {
                max = ds.length();
                res = ds;
            }
        }
        return res;
    }

    private boolean isSubs(String s, String d) {
        int i = 0, j = 0;
        boolean res = true;
        for (; i < d.length(); i++) {
            while (j < s.length() && s.charAt(j) != d.charAt(i)) j++;
            if (j == s.length()) {
                res = false;
                break;
            }
            j++;
        }
        return res;
    }
}
