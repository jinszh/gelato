package gelato;

import gelato.basic.FindMaxOverlap;
import gelato.basic.QSort;
import gelato.util.Util;
import org.junit.Test;

public class basicTests extends LeetTests {
    @Test
    public void testMaxOverlap(){
        FindMaxOverlap f = new FindMaxOverlap();
        int v = f.find(Util.getTwoDMatrix("[0,2],[3,7],[4,6],[7,8],[1,5]"));
        Util.print(v);
    }

    @Test
    public void testQuickSort(){
        QSort f = new QSort();
        int v = f.QSort(new int[]{4,2,6,1,7,3});
        Util.print(v);
    }

}
