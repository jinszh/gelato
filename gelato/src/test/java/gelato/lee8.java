package gelato;

import gelato.leet8.*;
import gelato.util.Util;
import org.junit.Test;

public class lee8 extends LeetTests{
    @Test
    public void test838() {
        pushDominoes t = new pushDominoes();
        print(t.pushDominoes(".L.R...LR..L.."));
    }

    @Test
    public void test870() {
        advantageCount t = new advantageCount();
        int [] n = t.advantageCount(Util.getOneDArray("[28,47,45,8,2,10,25,35,43,37,33,30,33,20,33,42,43,36,34,3,16,23,15,10,19,42,13,47,0,21,36,38,0,5,3,28,4,20,14,5,19,22,29,17,3,16,35,0,26,0]")
                , Util.getOneDArray("[44,10,27,4,27,40,46,40,45,0,41,2,44,50,36,30,37,4,44,4,12,13,35,20,19,25,38,42,43,14,2,4,5,38,4,38,0,35,12,32,38,33,3,1,19,46,23,13,24,41]"));
        print(n);
    }

    @Test
    public void test875() {
        minEatingSpeed t = new minEatingSpeed();
        int n = t.minEatingSpeed_my(Util.getOneDArray("\n" +
                "[142126477]"), 142126479);
        print(n);
    }

    @Test
    public void test877() {
        minEatingSpeed t = new minEatingSpeed();
        int n = t.minEatingSpeed_my(Util.getOneDArray("\n" +
                "[142126477]"), 142126479);
        print(n);
    }
}
