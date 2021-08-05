package gelato;

import gelato.leet3.*;
import gelato.util.Util;
import org.junit.Test;

public class lee3 extends LeetTests{
    @Test
    public void test399() {
        calcEquation f = new calcEquation();
        Util.print(f.calcEquation(Util.get2DList("[[\"a\",\"b\"],[\"e\",\"f\"],[\"b\",\"e\"]]"
                , String.class), Util.get1dDoubleArray("[3.4,1.4,2.3]")
                , Util.get2DList("[[\"b\",\"a\"],[\"a\",\"f\"],[\"f\",\"f\"],[\"e\",\"e\"],[\"c\",\"c\"],[\"a\",\"c\"],[\"f\",\"e\"]]", String.class)));
    }
    @Test
    public void test392() {
        isSubsequence f = new isSubsequence();
        boolean v = f.isSubsequence("wdmbatbcewwittubryrqwwrvfkrmniomofygybeqfzusrgeart",
                "iwdlcxpyagegrcnrcylxolxlnhhwnxyzltiscrjztiivnpnzlubzpueihinsqdfvypdteztiodbhaqhxskupwulvkzhczdyoouym");
        Util.print(v);
    }

    @Test
    public void test375() {
        getMoneyAmount f = new getMoneyAmount();
        int v = f.getMoneyAmount(5);
        Util.print(v);
    }

    @Test
    public void test372() {
        superPow f = new superPow();
        int v = f.superPow(3714151, new int[]{4,9,1,4,4});
        Util.print(v);
    }
    @Test
    public void test365() {
        canMeasureWater f = new canMeasureWater();
        Util.print(f.canMeasureWater(2,7,5));
    }
    @Test
    public void test360() {
        sortTransformedArray f = new sortTransformedArray();
        Util.print(f.sortTransformedArray(Util.get1dIntArray("[-99,-98,-94,-93,-93,-93,-88,-83,-77,-77,-77,-74,-74,-72,-71,-70,-67,-64,-63,-62,-61,-58,-56,-54,-54,-53,-51,-51,-50,-48,-46,-45,-42,-41,-35,-31,-22,-22,-20,-20,-16,-16,-12,-11,-8,-3,-2,-1,0,1,3,4,6,9,10,11,11,11,12,13,26,27,29,31,32,34,36,42,48,49,54,56,59,62,62,65,65,69,70,72,73,74,75,82,85,86,91,92,92,97,98]"), 13,22,-16));
    }
    @Test
    public void test351() {
        numberOfPatterns f = new numberOfPatterns();
        Util.print(f.numberOfPatterns(2,2));
    }
    @Test
    public void test325() {
        maxSubArrayLen f = new maxSubArrayLen();
        int v = f.maxSubArrayLen(new int[]{},10);
        Util.print(v);
    }
    @Test
    public void test323() {
        countComponents f = new countComponents();
        Util.print(f.countComponents_my(5, Util.getTwoDMatrix("[[0,1],[1,2],[0,2],[3,4]]")));
        Util.print(f.cnter);
    }
    @Test
    public void test313() {
        nthSuperUglyNumber f = new nthSuperUglyNumber();
        int v = f.nthSuperUglyNumber(12, new int[]{2,7,13,19});
        Util.print(v);
    }

    @Test
    public void test310() {
        findMinHeightTrees f = new findMinHeightTrees();
        Util.print(f.findMinHeightTrees(6, Util.getTwoDMatrix("[[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]")));
    }
    @Test
    public void test309() {
        maxProfit f = new maxProfit();
        int v = f.maxProfit(new int[]{1,2,3,0,2});
        Util.print(v);
    }
    @Test
    public void test308() {
      //  NumMatrix_SegTree f = new NumMatrix_SegTree(Util.getTwoDMatrix("[[[[2,3],[-3,5]]]"));
        NumMatrix_BITree f = new NumMatrix_BITree(Util.getTwoDMatrix("[\n" +
                "  [3, 0, 1, 4, 2],\n" +
                "  [5, 6, 3, 2, 1],\n" +
                "  [1, 2, 0, 1, 5],\n" +
                "  [4, 1, 0, 1, 7],\n" +
                "  [1, 0, 3, 0, 5]\n" +
                "]"));
        //NumMatrix_BITree f = new NumMatrix_BITree(Util.getTwoDMatrix("[[[[2,3],[-3,5]]]"));
//        f.update(0 , 1, 3);
//        f.update(1 , 1, -3);
//        f.update(0 , 1, 1);
        int v2 = f.sumRegion(2 , 1, 4, 3);
        f.update(3,2,2);
        Util.print(f.sumRegion(2 , 1, 4, 3));
    }
    @Test
    public void test307() {
        NumArray_SegmentTree f = new NumArray_SegmentTree(Util.get1dIntArray("[9,-8]"));

//        f.update(4 , 6);
//        f.update(0 , 2);
//        f.update(0 , 9);
////        int v = f.sumRange(4 , 4);
//        f.update(3 , 8);

        int v = f.sumRange(1 , 1);
        Util.print(v);
    }

    @Test
    public void test306() {
        isAdditiveNumber f = new isAdditiveNumber();
        Util.print(f.isAdditiveNumber("12233557"));
    }
}
