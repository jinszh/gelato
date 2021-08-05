package gelato.leet4;

import java.util.Deque;
import java.util.LinkedList;

//439
public class parseTernary {
    public String parseTernary(String expression) {
        int end = expression.length();
        LinkedList<String> stack = new LinkedList<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            if (expression.charAt(i) == ':') {
                if(end > i + 1) {
                    stack.push(expression.substring(i + 1, end));
                }
                end = i;
            } else if (expression.charAt(i) == '?') {
                char op = expression.charAt(i - 1);
                String l = i + 1 < end ? expression.substring(i + 1, end) : stack.pop();
                String r = stack.pop();
                stack.push(op == 'T' ?  l : r);
                i--;
                end = i;
            }
        }
        return stack.isEmpty() ? "" : stack.pop();
    }

    //不用判断:和?
    public String parseTernary_smart(String expression) {
        if (expression == null || expression.length() == 0) return "";
        Deque<Character> stack = new LinkedList<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {

                stack.pop(); //pop '?'
                char first = stack.pop();
                stack.pop(); //pop ':'
                char second = stack.pop();

                if (c == 'T') stack.push(first);
                else stack.push(second);
            } else {
                stack.push(c);
            }
        }

        return String.valueOf(stack.peek());
    }
}
