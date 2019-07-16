package gelato.leet3;

import java.util.List;
import java.util.Stack;

public class MiniParser {
    public NestedInteger deserialize(String s) {
        if (s.isEmpty())
            return null;
        if (s.charAt(0) != '[') // ERROR: special case
            return new NestedInteger(Integer.valueOf(s));

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;
        int l = 0; // l shall point to the start of a number substring;
        // r shall point to the end+1 of a number substring
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (ch == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
                l = r+1;
            } else if (ch == ']') {
                String num = s.substring(l, r);
                if (!num.isEmpty())
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(curr);
                    curr = pop;
                }
                l = r+1;
            } else if (ch == ',') {
                if (s.charAt(r-1) != ']') {
                    String num = s.substring(l, r);
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
                l = r+1;
            }
        }

        return curr;
    }


  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  public interface NestedInteger_ {


      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // Set this NestedInteger to hold a single integer.
      public void setInteger(int value);

      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      public void add(NestedInteger_ ni);

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger_> getList();
  }

  class NestedInteger implements NestedInteger_{
      // Constructor initializes a single integer.
      public NestedInteger(int value){};

      public NestedInteger() {
          super();
      }

      @Override
      public boolean isInteger() {
          return false;
      }

      @Override
      public Integer getInteger() {
          return null;
      }

      @Override
      public void setInteger(int value) {

      }

      @Override
      public void add(NestedInteger_ ni) {

      }

      @Override
      public List<NestedInteger_> getList() {
          return null;
      }
  }

}