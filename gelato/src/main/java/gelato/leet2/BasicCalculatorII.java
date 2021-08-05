package gelato.leet2;

import java.util.LinkedList;

//227
public class BasicCalculatorII {
    public int calculate(String s) {
        s = s.trim();
        int cur = 0;
        char ope = '@';
        LinkedList<Character> ops = new LinkedList<>();
        LinkedList<Integer> opr = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ')continue;
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                cur = cur * 10 + s.charAt(i) - '0';
            }
            if (i == s.length() - 1 || !(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                if (ope == '*') {
                    int nxt = opr.pop() * cur;
                    opr.push(nxt);
                } else if (ope == '/') {
                    int nxt = opr.pop() / cur;
                    opr.push(nxt);
                } else {
                    if (ope != '@') ops.push(ope);
                    opr.push(cur);
                }
                ope = s.charAt(i);
                cur = 0;
            }
        }
        while (!ops.isEmpty()) {
            char op = ops.pollLast();
            int fst = op == '+' ? opr.pollLast() + opr.pollLast() : opr.pollLast() - opr.pollLast();
            opr.add(fst);
        }
        return opr.peek();
    }

    //优化一下, 并不需要栈, res是已经求得的部分, preValue是正在求得部分, 到下面一个操作符得前面的
    public int calculate2(String s) {
        if (s == null) return 0;
        s = s.trim().replaceAll(" +", "");
        int length = s.length();

        int res = 0;
        long preVal = 0; // initial preVal is 0
        char sign = '+'; // initial sign is +
        int i = 0;
        while (i < length) {
            long curVal = 0;
            while (i < length && (int)s.charAt(i) <= 57 && (int)s.charAt(i) >= 48) { // int
                curVal = curVal*10 + (s.charAt(i) - '0');
                i++;
            }
            if (sign == '+') {
                res += preVal;  // update res
                preVal = curVal;
            } else if (sign == '-') {
                res += preVal;  // update res
                preVal = -curVal;
            } else if (sign == '*') {
                preVal = preVal * curVal; // not update res, combine preVal & curVal and keep loop
            } else if (sign == '/') {
                preVal = preVal / curVal; // not update res, combine preVal & curVal and keep loop
            }
            if (i < length) { // getting new sign
                sign = s.charAt(i);
                i++;
            }
        }
        res += preVal;
        return res;
    }
}
