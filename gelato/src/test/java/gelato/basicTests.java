package gelato;

import gelato.basic.FindMaxOverlap;
import gelato.basic.SortUtil;
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
        SortUtil f = new SortUtil();
        int [] arr = new int[]{1,2,2,0};
        f.QSort(arr);
        Util.print(arr);
    }

}
