package gelato.leet10;

import java.util.LinkedList;

public class isValid {
    public boolean isValid(String S) {
        LinkedList<Integer> stack = new LinkedList<>();
        boolean isValid = true;
        for (char c : S.toCharArray()) {
            switch (c) {
                case 'a':
                    stack.add(1);
                    break;
                case 'b':
                    stack.add(2);
                    break;
                case 'c':
                    for (int j = 2; j >= 1; j--) {
                        if (stack.isEmpty() || stack.peekLast() != j) {
                            isValid = false;
                            break;
                        }
                        stack.pollLast();
                    }
            }
        }
        return isValid && stack.isEmpty();
    }
}
