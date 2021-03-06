package gelato;

import gelato.leet1.*;
import gelato.model.ListNode;
import gelato.model.TreeNode;
import gelato.util.Util;
import org.junit.Test;

import java.util.LinkedList;

public class lee1 extends LeetTests{
    @Test
    public void test106(){
        buildTree f = new buildTree();
        Util.print(f.buildTree(Util.get1dIntArray("[1,2,3,4]"), Util.get1dIntArray("[4,3,2,1]")));
    }
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
    public void test148() {
        sortList f = new sortList();
        ListNode[] listNodes = Util.getTestListNodes(new int[]{4,5,7,-1,4,2,2,8,9,10,3,-2, 2});
        for (int i = 0; i < listNodes.length - 1; i++) {
            listNodes[i].next = listNodes[i + 1];
        }
        Util.print(f.sortList(listNodes[0]));
    }

    @Test
    public void test152(){
        maxProduct f = new maxProduct();
        int v = f.maxProduct(Util.get1dIntArray("[-9]"));
        Util.print(v);
    }

    @Test
    public void test156(){
        upsideDownBinaryTree f = new upsideDownBinaryTree();
        Util.print(f.upsideDownBinaryTree(Util.getTestTree(new Integer[]{1,2,3,4,5})));
    }
}
