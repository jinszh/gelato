package gelato.leet0;

import java.util.ArrayList;
import java.util.List;

//22
public class generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        help(n, 0, 0, res, "");
        return res;
    }

    private void help(int n, int nopen, int nclose, List<String> res, String s){
        if(nopen == n && nclose == n - 1){
            res.add(s + ")");
        }else {
            if(nopen < n){
                help(n, nopen + 1, nclose, res, s + "(");
            }
            if(nclose < nopen){
                help(n, nopen, nclose + 1, res, s + ")");
            }
        }
    }
}
