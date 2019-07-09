package gelato;

import gelato.model.TreeNode;
import gelato.util.Util;
import org.junit.Test;
import gelato.leet6.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lee6 extends LeetTests {
    @Test
    public void test616() {
        addBoldTag t = new addBoldTag();
        Util.print(t.addBoldTag("abcdef", Util.get1dStr("[\"ab\",\"bc\",\"cd\",\"de\",\"ef\",\"fg\",\"gh\"]")));
    }

    @Test
    public void test621() {
        leastInterval t = new leastInterval();
        Util.print(t.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }
    @Test
    public void test638() {
        shoppingOffers t = new shoppingOffers();
        String [] inputs = Util.readFromFile("638.txt");
        //int n = t.shoppingOffers(Arrays.asList(2,5),Util.getTwoDList("[[3,0,5],[1,2,10]]"), Arrays.asList(3,2));
        int n = t.shoppingOffers_2(Arrays.stream(Util.getOneDArray(inputs[0])).boxed().collect(Collectors.toList())
                , Util.get2DList(inputs[1], Integer.class)
                , Arrays.stream(Util.getOneDArray(inputs[2])).boxed().collect(Collectors.toList()));
        Util.print(n);
    }
    @Test
    public void test640() {
        solveEquation t = new solveEquation();
        Util.print(t.solveEquation("1+1=x"));
    }

    @Test
    public void test647() {
        countSubstrings t = new countSubstrings();
        Util.print(t.countSubstrings_textbook("abba"));
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
    public void test666() {
        pathSum t = new pathSum();
        Util.print(t.pathSum(Util.getOneDArray("[111,217,221,315,415]")));
    }
    @Test
    public void test670() {
        maximumSwap t = new maximumSwap();
        Util.print(t.maximumSwap(98368));
    }
    @Test
    public void test678() {
        checkValidString t = new checkValidString();
        Util.print(t.checkValidString_dp("(((((((((((((***********))))"));
    }

    @Test
    public void test685() {
        RedundantConnectionII t = new RedundantConnectionII();
        int [] n = t.findRedundantDirectedConnection(Util.getTwoDMatrix("[[2,1],[3,1],[4,2],[1,4]]"));
       // int [] n = t.findRedundantDirectedConnection(Util.getTwoDMatrix("[[1,2], [2,3], [3,4], [4,1], [1,5]]"));
        Util.print(n);
    }

    @Test
    public void test692() {
        topKFrequent t = new topKFrequent();
        List n = t.topKFrequent(Util.get1dStr("[\"i\", \"love\", \"leetcode\", \"i\", \"love\", \"coding\"]"), 2);
        Util.print(n);
    }
}
