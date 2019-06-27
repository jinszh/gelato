package gelato.leet6;

import java.util.LinkedList;
import java.util.Stack;

//678
public class checkValidString {
    public boolean checkValidString_dp(String s) {
        int curmin = 0, curmax = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                curmin++;
                curmax++;
            } else if (c == ')') {
                curmin = curmin > 0 ? curmin - 1: (curmax > 0 ? curmin : -1);
                curmax--;
            } else {
                curmin = curmin > 0 ? curmin - 1 : 0;
                curmax++;
            }
            if(curmin < 0 && curmax < 0){
                break;
            }
        }
        return curmin == 0;
    }
    ///Recur
    public boolean checkValidString(String s) {
        return check(s, 0, 0);
    }

    private boolean check(String s, int start, int stack) {
        boolean res = false;
        if (stack >= 0) {
            int i = start;
            for (; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack++;
                } else if (c == ')') {
                    if (stack > 0) {
                        stack--;
                    } else {
                        break;
                    }
                } else {
                    res = check(s, i + 1, stack)
                            || check(s, i + 1, stack + 1)
                            || check(s, i + 1, stack - 1);
                    break;
                }
            }
            res = i == s.length() ? stack == 0 : res;
        }
        return res;
    }
}
