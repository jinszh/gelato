package gelato;

import gelato.leet10.*;
import gelato.model.TreeNode;
import gelato.util.Trie;
import gelato.util.Util;
import org.junit.Test;

public class lee10 extends LeetTests {
    @Test
    public void test1020() {
        numEnclaves t = new numEnclaves();
        int n = t.numEnclaves(Util.getTwoDMatrix("[[0,0,0,1,1,1,0,1,0,0],[1,1,0,0,0,1,0,1,1,1],[0,0,0,1,1,1,0,1,0,0],[0,1,1,0,0,0,1,0,1,0],[0,1,1,1,1,1,0,0,1,0],[0,0,1,0,1,1,1,1,0,1],[0,1,1,0,0,0,1,1,1,1],[0,0,1,0,0,1,0,1,0,1],[1,0,1,0,1,1,0,0,0,0],[0,0,0,0,1,1,0,0,0,1]]"));
        print(n);
    }

    @Test
    public void test1019() {
        NxtLargerNode t = new NxtLargerNode();
        int [] n = t.nextLargerNodes(Util.getTestListNode(new int[]{1,7,5,1,9,2,5,1}));
        print(n);
    }

    @Test
    public void test1017() {
        baseNeg2 t = new baseNeg2();
        String n = t.baseNeg2(0);
        print(n);
    }

    @Test
    public void test1016() {
        BinarySubString t = new BinarySubString();
        boolean n = t.queryString("10010111100001110010",10);
        print(n);
    }

    @Test
    public void test1015() {
        smallestRepunitDivByK t = new smallestRepunitDivByK();
        int n = t.smallestRepunitDivByK(3);
        print(n);
    }

    @Test
    public void test1014() {
        maxScoreSightseeingPair t = new maxScoreSightseeingPair();
        int n = t.maxScoreSightseeingPair(Util.getOneDArray("[8,0,7,0,0,10]"));
        print(n);
    }

    @Test
    public void test1012() {
        numDupDigitsAtMostN t = new numDupDigitsAtMostN();
        int n = t.numDupDigitsAtMostN(1);
        print(n);
    }

    @Test
    public void test1011() {
        shipWithinDays t = new shipWithinDays();
        int n = t.shipWithinDays(Util.getOneDArray("[1,2,3,4,5,6,7,8,9,10]"), 5);
        print(n);
    }

    @Test
    public void test1008() {
        bstFromPreorder t = new bstFromPreorder();
        TreeNode n = t.bstFromPreorder(Util.getOneDArray("[8,5,1,7,10,12]"));
        print(n);
    }

    @Test
    public void test1007() {
        minDominoRotations t = new minDominoRotations();
        int n = t.minDominoRotations(Util.getOneDArray("[2,1,2,4,2,2]")
                                    ,Util.getOneDArray("[5,2,6,2,3,2]"));
        print(n);
    }

    @Test
    public void test1006() {
        clumsy t = new clumsy();
        int n = t.clumsy(10);
        print(n);
    }

    @Test
    public void test1004() {
        longestOnes t = new longestOnes();
        int n = t.longestOnes(new int[]{0,0,0,0,0,1,1,0,1}, 3);
        print(n);
    }

    @Test
    public void test1003() {
        isValid t = new isValid();
        boolean n = t.isValid("aabcbc");
        print(n);
    }

    @Test
    public void test1001() {
        gridIllumination t = new gridIllumination();
        String [] inputs = Util.readFromFile("gridIllumination.txt");
        int [] n = t.gridIllumination(Integer.parseInt(inputs[0]), Util.getTwoDMatrix(inputs[1])
                , Util.getTwoDMatrix(inputs[2]));
        print(n);
    }
}
