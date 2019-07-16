package gelato;

import gelato.leet4.*;
import gelato.util.Util;
import org.junit.Test;

import java.util.List;

public class lee4  extends LeetTests{
    @Test
    public void test426() {
        treeToDoublyList f = new treeToDoublyList();
        Util.print(f.treeToDoublyList(Util.getTestTree(Util.getOneDIntegerArray("[4,2,5,1,3]"))));
    }

    @Test
    public void test439() {
        parseTernary f = new parseTernary();
        Util.print(f.parseTernary("F?T?4:5:T?F?6:8:7"));
    }
    @Test
    public void test444() {
        sequenceReconstruction f = new sequenceReconstruction();
        Util.print(f.sequenceReconstruction(Util.get1dIntArray("[1]"), Util.get2DList("[[1],[1],[1]]", Integer.class)));
    }
    @Test
    public void test454() {
        fourSumCount f = new fourSumCount();
        int v = f.fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2});
        Util.print(v);
    }
    @Test
    public void test456() {
        find132pattern f = new find132pattern();
        Util.print(f.find132pattern(Util.get1dIntArray("[ 6,8,7,10,6]")));
    }
    @Test
    public void test457() {
        circularArrayLoop f = new circularArrayLoop();
        boolean v = f.circularArrayLoop(new int[]{-1,-1,-1});
        Util.print(v);
    }

    @Test
    public void test464() {
        canIWin f = new canIWin();
        boolean v = f.canIWin(10, 0);
        Util.print(v);
    }
    @Test
    public void test469() {
        String [] data = Util.readFromFile("469.txt");
        isConvex f = new isConvex();
        Util.print(f.isConvex((List<List<Integer>>)Util.get2DList("[[0,0],[1,0],[1,1],[-1,1],[-1,0]]", Integer.class)));
    }
    @Test
    public void test486() {
        PredictTheWinner f = new PredictTheWinner();
        boolean v = f.PredictTheWinner(Util.get1dIntArray("[1, 3, 1]"));
        Util.print(v);
    }
    @Test
    public void test490() {
        hasPath f = new hasPath();
        Util.print(f.hasPath(Util.getTwoDMatrix("[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]")
                , Util.get1dIntArray("[0,4]"), Util.get1dIntArray("[3,2]")));
    }
    @Test
    public void test491() {
        findSubsequences f = new findSubsequences();
        List v = f.findSubsequences(new int[]{4,6,7,7});
        Util.print(v);
    }
}
