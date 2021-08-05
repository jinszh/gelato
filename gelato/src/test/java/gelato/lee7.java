package gelato;

import gelato.leet7.*;
import gelato.util.Util;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        int n = t.numSubarrayProductLessThanK(Util.get1dIntArray("[10,5,2,6]"), 100);
        print(n);
    }
    @Test
    public void test714() {
        maxProfit t = new maxProfit();
        int n = t.maxProfit(Util.get1dIntArray("[1,3,2,8,4,9]"), 2);
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
        int n = t.findLength_im(Util.get1dIntArray("[1,2,3,2,1]"), Util.get1dIntArray("[3,2,1,4,7]"));
        print(n);
    }

    @Test
    public void test719() {
        smallestDistancePair t = new smallestDistancePair();
        int n = t.smallestDistancePair(Util.get1dIntArray("[1,3,1]"), 1);
        String [] inputs = Util.readFromFile("719.txt");
   //     int n = t.smallestDistancePair(Util.get1dIntArray(inputs[0]), Integer.parseInt(inputs[1]));
        print(n);
    }

    @Test
    public void test721() {
        accountsMerge t = new accountsMerge();
        List n = t.accountsMerge(Util.get2DList("[[\"John\", \"johnsmith@mail.com\", \"john00@mail.com\"], [\"John\", \"johnnybravo@mail.com\"], [\"John\", \"johnsmith@mail.com\", \"john_newyork@mail.com\"], [\"Mary\", \"mary@mail.com\"]]", String.class));
        print(n);
    }

    @Test
    public void test722() {
        removeComments t = new removeComments();
        List n = t.removeComments(Util.get1dStr("[\"a/*/b//*c\",\"blank\",\"d/*/e*//f\"]"));
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
//            print(t.book(Util.get1dIntArray(op2[i] + "]")[0], Util.get1dIntArray(op2[i] + "]")[1]));
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
        int [] n = t.dailyTemperatures(Util.get1dIntArray("[73,74,75,71,69,72,76,73]"));
        print(n);
    }

    @Test
    public void test740() {
        deleteAndEarn t = new deleteAndEarn();
        print(t.deleteAndEarn(Util.get1dIntArray("[3,4,2]")));
    }

    @Test
    public void test756() {
        pyramidTransition t = new pyramidTransition();
        print(t.pyramidTransition_bk("BDBBAA"
                , Arrays.asList(Util.get1dStr("[\"ACB\",\"ACA\",\"AAA\"" +
                        ",\"ACD\",\"BCD\",\"BAA\",\"BCB\",\"BCC\",\"BAD\",\"BAB\"" +
                        ",\"BAC\",\"CAB\",\"CCD\",\"CAA\",\"CCA\",\"CCC\",\"CAD\",\"DAD\"" +
                        ",\"DAA\",\"DAC\",\"DCD\",\"DCC\",\"DCA\",\"DDD\",\"BDD\",\"ABB\",\"ABC\"" +
                        ",\"ABD\",\"BDB\",\"BBD\",\"BBC\",\"BBA\",\"ADD\",\"ADC\",\"ADA\",\"DDC\",\"DDB\"" +
                        ",\"DDA\",\"CDA\",\"CDD\",\"CBA\",\"CDB\",\"CBD\",\"DBA\",\"DBC\",\"DBD\",\"BDA\"]"))));
        print(t.cnt);
    }

    @Test
    public void test767() {
        reorganizeString t = new reorganizeString();
        String n = t.reorganizeString2("fafafafaguguumm");
        print(n);
    }

    @Test
    public void test774() {
        minmaxGasDist t = new minmaxGasDist();
        double n = t.minmaxGasDist(Util.get1dIntArray("[1,2,3,4,5,6,7,8,9,10]"), 9);
        print(n);
    }
    @Test
    public void test785() {
        isBipartite t = new isBipartite();
        print(t.isBipartite(Util.getTwoDMatrix("[[1,2,3],[0,3,4],[0,3],[0,1,2],[1]]")));
    }
    @Test
    public void test792() {
        numMatchingSubseq t = new numMatchingSubseq();
        int n = t.numMatchingSubseq_parallel("iwdlcxpyagegrcnrcylxolxlnhhwnxyzltiscrjztiivnpnzlubzpueihinsqdfvypdteztiodbhaqhxskupwulvkzhczdyoouym"
                , new String[]{"wdmbatbcewwittubryrqwwrvfkrmniomofygybeqfzusrgeart"});
        print(n);
    }
}
