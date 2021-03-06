package gelato;

import gelato.leet9.*;
import gelato.util.Util;
import org.junit.Test;

import java.util.List;

public class lee9 extends LeetTests {
    @Test
    public void test996() {
        numSquarefulPerms f = new numSquarefulPerms();
        int n = f.numSquarefulPerms_opt(new int[]{2,2,2,2,2,2,2,2,2,2,2,2});
        Util.print(n);
    }

    @Test
    public void test995() {
        minKBitFlips f = new minKBitFlips();
        int n = f.minKBitFlips(new int[]{0,0,0,1,0,1,1,0}, 3);
        Util.print(n);
    }

    @Test
    public void test992() {
        subarraysWithKDistinct f = new subarraysWithKDistinct();
        String [] inputs = Util.readFromFile("subarraysWithKDistinct.txt");
       // int n = f.subarraysWithKDistinct(Util.get1dIntArray(inputs[0]), 1000);
        int n = f.subarraysWithKDistinct(new int[]{2,1,2,1,1}, 3);
        Util.print(n);
    }

    @Test
    public void test991() {
        brokenCalc f = new brokenCalc();
        int n = f.brokenCalc_opt(5, 1025);
        Util.print(n);
    }

    @Test
    public void test990() {
        equationsPossible f = new equationsPossible();
        boolean n = f.equationsPossible_uf(new String[]{"f==a","a==b","f!=e","a==c","b==e","c==f"});
        Util.print(n);
    }

    @Test
    public void test987() {
        verticalTraversal f = new verticalTraversal();
        List<List<Integer>> n = f.verticalTraversal(Util.getTestTreeByArray(Util.getOneDIntegerArray("\n" +
                "[0,7,1,null,10,2,null,11,null,3,14,13,null,null,4,null,null,null,null,12,5,null,null,6,9,8]")));
        Util.print(n);
    }

    @Test
    public void test986() {
        intervalIntersection f = new intervalIntersection();
        int [][] n = f.intervalIntersection(Util.getTwoDMatrix("[[8,15]]")
                , Util.getTwoDMatrix("[[2,6],[8,10],[12,20]]"));
        Util.print(n);
    }

    @Test
    public void test984() {
        strWithout3a3b f = new strWithout3a3b();
        String n = f.strWithout3a3b(7, 8);
        Util.print(n);
    }

    @Test
    public void test983() {
        mincostTickets f = new mincostTickets();
        int n = f.mincostTickets(Util.get1dIntArray("[1,2,3,4,5,6,7,8,9,10,30,31]"), Util.get1dIntArray("[2,7,15]"));
        Util.print(n);
    }

    @Test
    public void test982() {
        countTriplets f = new countTriplets();
        int n = f.countTriplets_v2(Util.get1dIntArray("[0,1,3]"));
        Util.print(n);
    }

    @Test
    public void test981() {
        TimeMap f = new TimeMap();
        f.set("a", "a1" , 1);
        f.set("a", "a2" , 2);
        String n = f.get("b", 3);
        Util.print(n);
    }

    @Test
    public void test980() {
        uniquePathsIII f = new uniquePathsIII();
        int n = f.uniquePathsIII(Util.getTwoDMatrix("[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]"));
        Util.print(n);
    }

    @Test
    public void test979() {
        distributeCoins f = new distributeCoins();
        int n = f.distributeCoins(Util.getTestTree(new Integer[]{0,3,0}));
        Util.print(n);
    }

    @Test
    public void test978() {
        maxTurbulenceSize f = new maxTurbulenceSize();
        int n = f.maxTurbulenceSize(Util.get1dIntArray("[9,4,2,10,7,8,8,1,9]"));
        Util.print(n);
    }

    @Test
    public void test975() {
        oddEvenJumps f = new oddEvenJumps();
        int n = f.oddEvenJumps_stackMethod(Util.get1dIntArray("[5,1,3,4,2]"));
        Util.print(n);
    }

    @Test
    public void test974() {
        subarraysDivByK f = new subarraysDivByK();
        int n = f.subarraysDivByK(Util.get1dIntArray("[-1,2,9]"), 2);
       // int n = f.subarraysDivByK(Util.get1dIntArray("[4,5,0,-2,-3,1]"), 5);
        String [] inputs = Util.readFromFile("subarraysDivByK.txt");
        //int n = f.subarraysDivByK(Util.get1dIntArray(inputs[0]), Integer.parseInt(inputs[1]));
        Util.print(n);
    }

    @Test
    public void test973() {
        kClosest f = new kClosest();
        int [][] n = f.kClosest(Util.getTwoDMatrix("[[1,3],[-2,2]]"), 1);
        Util.print(n);
    }

    @Test
    public void test972() {
        isRationalEqual f = new isRationalEqual();
        boolean n = f.isRationalEqual_w1("0.05(25)", "0.0(52)");
        Util.print(n);
    }

    @Test
    public void test971() {
        flipMatchVoyage f = new flipMatchVoyage();
        Util.print(f.flipMatchVoyage(Util.getTestTree(new Integer[]{1,2,3,4,5}), new int[]{1,2,5,4,3}));
    }

    @Test
    public void test954() {
        canReorderDoubled f = new canReorderDoubled();
        Util.print(f.canReorderDoubled(Util.get1dIntArray("[-2,-2,1,-2,-1,2]")));
    }

    @Test
    public void test947() {
        removeStones f = new removeStones();
        Util.print(f.removeStones(Util.getTwoDMatrix("[[5,9],[9,0],[0,0],[7,0],[4,3],[8,5],[5,8],[1,1],[0,6],[7,5],[1,6],[1,9],[9,4],[2,8],[1,3],[4,2],[2,5],[4,1],[0,2],[6,5]]")));
    }

    @Test
    public void test932() {
        beautifulArray f = new beautifulArray();
        Util.print(f.beautifulArray(10));
    }

    @Test
    public void test923() {
        threeSumMulti f = new threeSumMulti();
        Util.print(f.threeSumMulti(Util.get1dIntArray("[1,1,2,2,3,3,4,4,5,5]"), 8 ));
    }

    @Test
    public void test904() {
        totalFruit f = new totalFruit();
        Util.print(f.totalFruit(Util.get1dIntArray("[1,2,3,2,2]")));
    }
}
