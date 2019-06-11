package gelato.leet0;

import java.util.ArrayList;
import java.util.List;

//17
public class letterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        help(0, digits.length() - 1, digits, "", res);
        return res;
    }

    private void help(int i, int n, String digits, String cur, List<String> res) {
        char c;
        int k = 3;
        if (digits.charAt(i) >= '2' && digits.charAt(i) <= '6') {
            c = (char) ((digits.charAt(i) - '2') * 3 + 'a');
        } else if (digits.charAt(i) == '7') {
            c = 'p';
            k = 4;
        } else if (digits.charAt(i) == '9') {
            c = 'w';
            k = 4;
        } else {
            c = 't';
        }
        for (int j = 0; j < k; j++) {
            if (i == n) {
                res.add(cur + (char) (c + j));
            } else {
                help(i + 1, n, digits, cur + (char) (c + j), res);
            }
        }
    }
}
