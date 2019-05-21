package gelato;

import gelato.leet7.*;
import gelato.util.Util;
import org.junit.Test;

import java.util.stream.IntStream;

public class lee7 extends LeetTests{
    @Test
    public void test713() {
        numSubarrayProductLessThanK t = new numSubarrayProductLessThanK();
        int n = t.numSubarrayProductLessThanK(Util.getOneDArray("[10,5,2,6]"), 100);
        print(n);
    }

    @Test
    public void test718() {
        findLength t = new findLength();
        int n = t.findLength_im(Util.getOneDArray("[1,2,3,2,1]"), Util.getOneDArray("[3,2,1,4,7]"));
        print(n);
    }

    @Test
    public void test719() {
        smallestDistancePair t = new smallestDistancePair();
        int n = t.smallestDistancePair(Util.getOneDArray("[1,3,1]"), 1);
        String [] inputs = Util.readFromFile("719.txt");
   //     int n = t.smallestDistancePair(Util.getOneDArray(inputs[0]), Integer.parseInt(inputs[1]));
        print(n);
    }

    @Test
    public void test739() {
        dailyTemperatures t = new dailyTemperatures();
        int [] n = t.dailyTemperatures(Util.getOneDArray("[73,74,75,71,69,72,76,73]"));
        print(n);
    }

    @Test
    public void test774() {
        minmaxGasDist t = new minmaxGasDist();
        double n = t.minmaxGasDist(Util.getOneDArray("[1,2,3,4,5,6,7,8,9,10]"), 9);
        print(n);
    }
}
