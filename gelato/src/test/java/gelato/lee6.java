package gelato;

import gelato.model.TreeNode;
import gelato.util.Util;
import org.junit.Test;
import gelato.leet6.*;

import java.util.Arrays;
import java.util.List;

public class lee6 extends LeetTests {
    @Test
    public void test638() {
        shoppingOffers t = new shoppingOffers();
        int n = t.shoppingOffers(Arrays.asList(2,5),Util.getTwoDList("[[3,0,5],[1,2,10]]"), Arrays.asList(3,2));
        Util.print(n);
    }

    @Test
    public void test654() {
        constructMaximumBinaryTree t = new constructMaximumBinaryTree();
        TreeNode n = t.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        Util.print(n);
    }

    @Test
    public void test658() {
        findClosestElements t = new findClosestElements();
        List n = t.findClosestElements_OLgN(new int[]{1,2,7,8,9}, 2, 6);
        Util.print(n);
    }

    @Test
    public void test692() {
        topKFrequent t = new topKFrequent();
        List n = t.topKFrequent(Util.get1dStr("[\"i\", \"love\", \"leetcode\", \"i\", \"love\", \"coding\"]"), 2);
        Util.print(n);
    }
}
