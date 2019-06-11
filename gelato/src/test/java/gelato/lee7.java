package gelato;

import gelato.leet7.*;
import gelato.util.Util;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

public class lee7 extends LeetTests{
    @Test
    public void test712() {
        minimumDeleteSum t = new minimumDeleteSum();
        int n = t.minimumDeleteSum("sea", "eat");
        print(n);
    }
    @Test
    public void test713() {
        numSubarrayProductLessThanK t = new numSubarrayProductLessThanK();
        int n = t.numSubarrayProductLessThanK(Util.getOneDArray("[10,5,2,6]"), 100);
        print(n);
    }

    @Test
    public void test715() {
        RangeModule t = new RangeModule();
        t.addRange(6, 8);
        t.removeRange(7, 8);
        t.removeRange(8, 9);
        t.addRange(8, 9);
        t.removeRange(1, 3);
        t.addRange(1, 8);
        print(t.queryRange(2, 9));
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
    public void test721() {
        accountsMerge t = new accountsMerge();
        List n = t.accountsMerge(Util.get2DList("[[\"John\", \"johnsmith@mail.com\", \"john00@mail.com\"], [\"John\", \"johnnybravo@mail.com\"], [\"John\", \"johnsmith@mail.com\", \"john_newyork@mail.com\"], [\"Mary\", \"mary@mail.com\"]]", String.class));
        print(n);
    }

    @Test
    public void test732() {
        MyCalendarThree t = new MyCalendarThree();
//        String [] input = Util.readFromFile("732.txt");
//        String [] op1 = input[0].replace("[", "")
//                .replace("]", "").replace("\"", "").split(",");
//        String [] op2 = input[1].substring(1, input[1].length() - 2).split("],");
//        for(int i = 1; i <op2.length; i++){
//            print(t.book(Util.getOneDArray(op2[i] + "]")[0], Util.getOneDArray(op2[i] + "]")[1]));
//        }
        print(t.book_seg(21, 39));
        print(t.book_seg(37, 48));
        print(t.book_seg(22, 39));
        print(t.book_seg(31, 44));
        print(t.book_seg(20, 27));
        print(t.book_seg(15, 23));
    }

    @Test
    public void test737() {
        areSentencesSimilarTwo t = new areSentencesSimilarTwo();
        boolean n = t.areSentencesSimilarTwo(Util.get1dStr("[\"great\",\"acting\",\"skills\"]")
        ,Util.get1dStr("[\"fine\",\"drama\",\"talent\"]")
        ,Util.get2DList("[[\"great\",\"good\"],[\"fine\",\"good\"],[\"drama\",\"acting\"],[\"skills\",\"talent\"]]", String.class));
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
