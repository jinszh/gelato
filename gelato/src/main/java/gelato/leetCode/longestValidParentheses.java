package gelato.leetCode;

import java.util.Stack;

public class longestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        int id = 1;
        int count = 0;
        int maxCount = 0;
        Stack<Integer> stid = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stid.push(id);
                id++;
            } else if (s.charAt(i) == ')') {
                if (!stid.empty()) {
                    stid.pop();
                    int idPrev = !stid.empty() ? stid.peek() : 0;
                    count = (id - 1 - idPrev) * 2;
                    if (count > maxCount) {
                        maxCount = count;
                    }
                }else { // invalid till now, reset id.
                    id = 1;
                }
            }
        }
        return maxCount;
    }
}
