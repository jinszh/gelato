package gelato;

import gelato.leet1.*;
import gelato.model.ListNode;
import gelato.model.TreeNode;
import gelato.util.Util;
import org.junit.Test;

import java.util.LinkedList;

public class lee1 extends LeetTests{
    @Test
    public void test114(){
        flatten f = new flatten();
        TreeNode root = Util.getTestTree(Util.getOneDIntegerArray("[1,2,5,3,4,null,6]"));
        f.flatten(root);
        Util.print(root.right.val);
        LinkedList<Integer> test = new LinkedList<>();
        test.add(1);
        test.add(2);
        Util.print(test.poll());
    }
    @Test
    public void test130(){
        SurroundedRegions f = new SurroundedRegions();
        char [][] in = Util.get2Dchars("[[\"X\",\"O\",\"X\",\"O\",\"O\",\"O\",\"O\"],[\"X\",\"O\",\"O\",\"O\",\"O\",\"O\",\"O\"],[\"X\",\"O\",\"O\",\"O\",\"O\",\"X\",\"O\"],[\"O\",\"O\",\"O\",\"O\",\"X\",\"O\",\"X\"],[\"O\",\"X\",\"O\",\"O\",\"O\",\"O\",\"O\"],[\"O\",\"O\",\"O\",\"O\",\"O\",\"O\",\"O\"],[\"O\",\"X\",\"O\",\"O\",\"O\",\"O\",\"O\"]]");
        f.solve(in);
        Util.print(in);
    }

    @Test
    public void test142(){
        detectCycle f = new detectCycle();
        ListNode [] listNodes  = Util.getTestListNodes(new int[]{3,2,0,-4});
        listNodes[3].next = listNodes[1];
        Util.print(f.detectCycle(listNodes[0]));
    }
    @Test
    public void test152(){
        maxProduct f = new maxProduct();
        int v = f.maxProduct(Util.getOneDArray("[-9]"));
        Util.print(v);
    }
}
