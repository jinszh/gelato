package gelato;

import gelato.leet2.*;
import gelato.leet2.shortestPalindrome;
import gelato.leet2.ConcatenatedWords;
import gelato.util.Trie;
import gelato.util.Util;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class lee2 extends LeetTests {
    @Test
    public void testTrie(){
        Trie trie = new Trie();
        boolean v = trie.startsWith("a");
        Util.print(v);
    }

    @Test
    public void testshortestPalindrome(){
        shortestPalindrome trie = new shortestPalindrome();
        String v = trie.shortestPalindrome("baabcd");
        Util.print(v);
    }

    @Test
    public void testSkyline() {
        getSkyline f = new getSkyline();
        List<int[]> v = f.getSkyline(Util.getTwoDMatrix("[[2,7,10],[3,6,15],[4,7,12]]"));
        Util.print(v);
    }

    @Test
    public void testKthLexicoOrder() {
        KthLexicoOrder f = new KthLexicoOrder();
        int v = f.findKthNumber(10, 3);
        Util.print(v);
    }

    @Test
    public void testArithmeticSlices() {
        ArithmeticSlices f = new ArithmeticSlices();
        int v = f.numberOfArithmeticSlices(Util.getOneDArray("[1,3,3,5,7,9]"));
        Util.print(v);
    }

    @Test
    public void testCountTheRepetitions() {
        CountTheRepetitions f = new CountTheRepetitions();
        int v = f.getMaxRepetitions("aaa", 10, "aaaaa", 2);
        Util.print(v);
    }

    @Test
    public void testEncodeWithShortestLen() {
        EncodeWithShortestLen f = new EncodeWithShortestLen();
        String v = f.encode("aaaaaa");
        Util.print(v);
    }

    @Test
    public void testConcatenatedWords() {
        ConcatenatedWords f = new ConcatenatedWords();
        List<String> v = f.findAllConcatenatedWordsInADict(Util.get1dStr("[\"cat\",\"cats\",\"catsdogcats\",\"dog\",\"dogcatsdog\",\"hippopotamuses\",\"rat\",\"ratcatdogcat\"]"));
        Util.print(v);
    }

    @Test
    public void testSmallestGoodBase() {
        SmallestGoodBase f = new SmallestGoodBase();
        String v = f.smallestGoodBase("13");
        Util.print(v);
    }

    @Test
    public void testSlidingWindowMedian() {
        SlidingWindowMedian f = new SlidingWindowMedian();
        double [] v = f.medianSlidingWindow(new int[]{1,1,1,1}, 2);
        //double [] v = f.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        Util.print(v);
    }

    @Test
    public void testAllOne() {
        AllOne c = new AllOne();
        String [] data = Util.readFromFile("AllOne.txt");
        String [] op = Util.get1dStr(data[0]);
        String [] dt = Util.get1dStr(data[1]);
        int binc = 0 , bdec = 0;
        for(int i = 0 ; i < op.length; i++){
            if(op[i].equals("inc")){
                if(dt[i].equals("b"))binc++;
                c.inc(dt[i]);
            }else if (op[i].equals("dec")) {
                if(dt[i].equals("b"))bdec++;
                c.dec(dt[i]);
            }
        }

        Util.print(c.getMaxKey());
        Util.print(c.getMinKey());
    }

    @Test
    public void testCalculate() {
        calculate c = new calculate();
        int v = c.calculate("(1+(4+5+2)-3)+(6+8)");
        Util.print(v);
    }

    @Test
    public void teststrobogrammaticInRange() {
        strobogrammaticInRange c = new strobogrammaticInRange();
     //   strobe2 c = new strobe2();
        int v = c.strobogrammaticInRange("0", "100000000000000");
       // int v = c.strobogrammaticInRange("50", "100");
        Util.print(v);
    }

    @Test
    public void testPaintHouse2() {
        PaintHouse2 c = new PaintHouse2();
        //   strobe2 c = new strobe2();
        int v = c.minCostII(Util.getTwoDMatrix("[[16,9,20,8],[8,18,8,12]" +
                ",[1,16,2,5],[3,4,16,3],[3,16,9,8],[6,14,18,13],[13,2,4,19]" +
                ",[15,12,13,7],[5,5,2,14],[9,17,12,6]" +
                ",[17,14,6,17],[14,3,19,11],[6,19,12,1],[7,2,12,12],[9,4,1,11]]"));
        // int v = c.strobogrammaticInRange("50", "100");
        Util.print(v);
    }

    @Test
    public void testAlienDict() {
        AlienDict c = new AlienDict();
        String v = c.alienOrder(Util.get1dStr("[\n" +
                "  \"wrt\",\n" +
                "  \"wrf\",\n" +
                "  \"er\",\n" +
                "  \"ett\",\n" +
                "  \"rftt\"\n" +
                "]"));
        Util.print(v);
    }

    @Test
    public void testClosetK() {
        ClosetBST closetBST = new ClosetBST();
        List<Integer> l = closetBST.closestKValues(Util.getTestTree(new Integer[]{41,37,44,24,39,42,48,1,35,38,40
                ,null,43,46,49,0,2,30,36,null,null,null,null,null,null
                ,45,47,null,null,null,null,null,4,29,32,null,null,null
                ,null,null,null,3,9,26,null,31,34,null,null,7,11,25,27
                ,null,null,33,null,6,8,10,16,null,null,null,28,null,null
                ,5,null,null,null,null,null,15,19,null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23}), 5.142, 45);
        Util.print(l);
    }

    @Test
    public void testnumberToWords() {
        numberToWords f = new numberToWords();
        String s = f.numberToWords(101);
        Util.print(s);
    }

    @Test
    public void testExpressionAddOperators() {
        ExpressionAddOperators f = new ExpressionAddOperators();
        List<String> m2 = f.addOperators("123456789", 45);
        Util.print(m2);
    }

    @Test
    public void testWordPatternII() {
        WordPatternII f = new WordPatternII();
        boolean b = f.wordPatternMatch("aaaa", "asdasdasdasd");
        Util.print(b);
    }

    @Test
    public void testBestMeetingPoint() {
        BestMeetingPoint f = new BestMeetingPoint();
        int b = f.minTotalDistance(Util.getTwoDMatrix("[[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]"));
        Util.print(b);
    }

    @Test
    public void testNumberOfIslands() {
        NumberOfIslands f = new NumberOfIslands();
        List<Integer> l = f.numIslands2(3,3, Util.getTwoDMatrix("[[0,1],[1,2],[2,1],[1,0],[0,2],[0,0],[1,1]]"));
        Util.print(l);
    }

    @Test
    public void testRemoveDupLetters() {
        RemoveDupLetters f = new RemoveDupLetters();
        String s = f.removeDuplicateLetters("bcab");
        Util.print(s);
    }

    @Test
    public void testMinDistanceWithObstacles() {
        shortestDistanceWithObstacles f = new shortestDistanceWithObstacles();
        int s = f.shortestDistance(Util.getTwoDMatrix("[[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]"));
        Util.print(s);
    }

    @Test
    public void testMaxNumFrom2Array() {
        MaxNumFrom2Array f = new MaxNumFrom2Array();
        int [] s = f.maxNumber(Util.getOneDArray("[8,3,9]"), Util.getOneDArray("[8,3,6,9]"), 4);
        Util.print(s);
    }

    @Test
    public void testCountRangeSum() {
        countRangeSum f = new countRangeSum();
        int s = f.countRangeSum2(new int[]{-2, 5, -1}, 4, 4);
        Util.print(s);
    }

    @Test
    public void testLongestIncreasingPath() {
        LongestIncreasingPath f = new LongestIncreasingPath();
        int s = f.longestIncreasingPath(Util.getTwoDMatrix("[\n" +
                "  []] "));
        Util.print(s);
    }

    @Test
    public void testPatchingArray() {
        PatchingArray f = new PatchingArray();
        int s = f.minPatches(new int[]{1, 2}, 5);
        Util.print(s);
    }

    @Test
    public void testLongestSubStringWithKChar() {
        LongestSubStringWithKChar f = new LongestSubStringWithKChar();
        int s = f.lengthOfLongestSubstringKDistinct("aaabc", 3);
        Util.print(s);
    }

    @Test
    public void testSearch2DMatrixII() {
        Search2DMatrixII f = new Search2DMatrixII();
        boolean s = f.searchMatrix(Util.getTwoDMatrix("[\n" +
                "  [1]\n" +
                "]"), 1);
        Util.print(s);
    }

    @Test
    public void testSelfCrossing() {
        SelfCrossing f = new SelfCrossing();
        boolean s = f.isSelfCrossing(new int[]{1,1,1,1});
        Util.print(s);
    }

    @Test
    public void testRussianDoll() {
        RussianDoll f = new RussianDoll();
        int s = f.maxEnvelopes(Util.getTwoDMatrix("[[4,5],[4,6],[6,7],[2,3],[1,1]]"));
        Util.print(s);
    }

    @Test
    public void testRearrangeStringKDis() {
        RearrangeStringKDis f = new RearrangeStringKDis();
        String s = f.rearrangeString2(Util.readFromFile("rearr.txt")[0],26);
        Util.print(s);
    }

    @Test
    public void testMaxSumOfRectangle() {
        MaxSumOfRectangle f = new MaxSumOfRectangle();
        int s = f.maxSumSubmatrix(Util.getTwoDMatrix("[[2,2,-1,3]]"),3);
        Util.print(s);
    }

    @Test
    public void testPerfectRectangle() {
        PerfectRectangle f = new PerfectRectangle();
        boolean s = f.isRectangleCover(Util.getTwoDMatrix("[[0,0,4,1],[7,0,8,2],[6,2,8,3],[5,1,6,3],[4,0,5,1],[6,0,7,2],[4,2,5,3],[2,1,4,3],[0,1,2,2],[0,2,2,3],[4,1,5,2],[5,0,6,1]]"));
        Util.print(s);
    }

    @Test
    public void testFrogJump() {
        FrogJump f = new FrogJump();
        boolean s = f.canCross(Util.getOneDArray("[0,1,2,3,4,8,9,11]"));
        Util.print(s);
    }

    @Test
    public void testTrappingRainWater3D() {
        TrappingRainWater3D f = new TrappingRainWater3D();
        int s = f.trapRainWater(Util.getTwoDMatrix("[\n" +
                "  [3,3,3,3,3,3],\n" +
                "  [3,3,3,3,2,3],\n" +
                "  [3,3,3,3,1,3]\n" +
                "]"));
        Util.print(s);
    }

    @Test
    public void testSplitArrayLargestSum() {
        SplitArrayLargestSum f = new SplitArrayLargestSum();
        int s = f.splitArray(Util.getOneDArray("[7,2,5,10,8]"), 3);
        Util.print(s);
    }

    @Test
    public void testMinimalUniqueWorkAbbreviation() {
        MinimalUniqueWorkAbbreviation f = new MinimalUniqueWorkAbbreviation();
        String s = f.minAbbreviation2("apple", Util.get1dStr("[\"blade\",\"plain\",\"amber\"]"));
        Util.print(s);
    }

    @Test
    public void testStrongPasswordChecker() {
        StrongPasswordChecker f = new StrongPasswordChecker();
        int s = f.strongPasswordChecker("aaaabbaaabbaaa123456A");
        Util.print(s);
    }

    @Test
    public void testWordSquares() {
        WordSquares f = new WordSquares();
        List<List<String>> res = f.wordSquares(Util.get1dStr("[\"abat\",\"baba\",\"atan\",\"atal\"]"));
        Util.print(res);
    }

    @Test
    public void testMazeIII() {
        MazeIII f = new MazeIII();
        String res = f.findShortestWay(Util.getTwoDMatrix("[[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]]")
                ,Util.getOneDArray("[4,3]")
                ,Util.getOneDArray("[0,1]"));
        Util.print(res);
    }

    @Test
    public void testZumaGame() {
        ZumaGame f = new ZumaGame();
        int res = f.findMinStep("WRRBBW","RB");
        Util.print(res);
    }

    @Test
    public void testReversePairs() {
        ReversePairs f = new ReversePairs();
        int res = f.reversePairs(new int[]{2147483647,-2147483647,-2147483647,-2147483647});
        Util.print(res);
    }

    @Test
    public void testSummaryRanges() {
        SummaryRanges f = new SummaryRanges();
        f.addNum(1);
        f.addNum(3);
        f.addNum(7);
        Util.print(f.getIntervals());
        f.addNum(2);
        f.addNum(6);
        Util.print(f.getIntervals());
    }

    @Test
    public void testlongestValidParentheses() {
        findWords f = new findWords();
        Character[][] board =  Util.<Character>getTwoDMatrix("[[\"a\",\"a\",\"a\",\"a\"],[\"a\",\"a\",\"a\",\"a\"],[\"a\",\"a\",\"a\",\"a\"],[\"a\",\"a\",\"a\",\"a\"],[\"b\",\"c\",\"d\",\"e\"],[\"f\",\"g\",\"h\",\"i\"],[\"j\",\"k\",\"l\",\"m\"],[\"n\",\"o\",\"p\",\"q\"],[\"r\",\"s\",\"t\",\"u\"],[\"v\",\"w\",\"x\",\"y\"],[\"z\",\"z\",\"z\",\"z\"]]"
                , Character.class);
        char[][] b = new char[board.length][board[0].length];
        for(int i = 0 ; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                b[i][j] = board[i][j].charValue();
            }
        }
        List<String> res = f.findWords(b
                ,Util.get1dStr("[\"aaaaaaaaaaaaaaaa\",\"aaaaaaaaaaaaaaab\",\"aaaaaaaaaaaaaaac\",\"aaaaaaaaaaaaaaad\",\"aaaaaaaaaaaaaaae\",\"aaaaaaaaaaaaaaaf\",\"aaaaaaaaaaaaaaag\",\"aaaaaaaaaaaaaaah\",\"aaaaaaaaaaaaaaai\",\"aaaaaaaaaaaaaaaj\",\"aaaaaaaaaaaaaaak\",\"aaaaaaaaaaaaaaal\",\"aaaaaaaaaaaaaaam\",\"aaaaaaaaaaaaaaan\",\"aaaaaaaaaaaaaaao\",\"aaaaaaaaaaaaaaap\",\"aaaaaaaaaaaaaaaq\",\"aaaaaaaaaaaaaaar\",\"aaaaaaaaaaaaaaas\",\"aaaaaaaaaaaaaaat\",\"aaaaaaaaaaaaaaau\",\"aaaaaaaaaaaaaaav\",\"aaaaaaaaaaaaaaaw\",\"aaaaaaaaaaaaaaax\",\"aaaaaaaaaaaaaaay\",\"aaaaaaaaaaaaaaaz\",\"aaaaaaaaaaaaaaaa\",\"aaaaaaaaaaaaaaab\",\"aaaaaaaaaaaaaaac\",\"aaaaaaaaaaaaaaad\",\"aaaaaaaaaaaaaaae\",\"aaaaaaaaaaaaaaaf\",\"aaaaaaaaaaaaaaag\",\"aaaaaaaaaaaaaaah\",\"aaaaaaaaaaaaaaai\",\"aaaaaaaaaaaaaaaj\",\"aaaaaaaaaaaaaaak\",\"aaaaaaaaaaaaaaal\",\"aaaaaaaaaaaaaaam\",\"aaaaaaaaaaaaaaan\",\"aaaaaaaaaaaaaaao\",\"aaaaaaaaaaaaaaap\",\"aaaaaaaaaaaaaaaq\",\"aaaaaaaaaaaaaaar\",\"aaaaaaaaaaaaaaas\",\"aaaaaaaaaaaaaaat\",\"aaaaaaaaaaaaaaau\",\"aaaaaaaaaaaaaaav\",\"aaaaaaaaaaaaaaaw\",\"aaaaaaaaaaaaaaax\",\"aaaaaaaaaaaaaaay\",\"aaaaaaaaaaaaaaaz\",\"aaaaaaaaaaaaaaba\",\"aaaaaaaaaaaaaabb\",\"aaaaaaaaaaaaaabc\",\"aaaaaaaaaaaaaabd\",\"aaaaaaaaaaaaaabe\",\"aaaaaaaaaaaaaabf\",\"aaaaaaaaaaaaaabg\",\"aaaaaaaaaaaaaabh\",\"aaaaaaaaaaaaaabi\",\"aaaaaaaaaaaaaabj\",\"aaaaaaaaaaaaaabk\",\"aaaaaaaaaaaaaabl\",\"aaaaaaaaaaaaaabm\",\"aaaaaaaaaaaaaabn\",\"aaaaaaaaaaaaaabo\",\"aaaaaaaaaaaaaabp\",\"aaaaaaaaaaaaaabq\",\"aaaaaaaaaaaaaabr\",\"aaaaaaaaaaaaaabs\",\"aaaaaaaaaaaaaabt\",\"aaaaaaaaaaaaaabu\",\"aaaaaaaaaaaaaabv\",\"aaaaaaaaaaaaaabw\",\"aaaaaaaaaaaaaabx\",\"aaaaaaaaaaaaaaby\",\"aaaaaaaaaaaaaabz\",\"aaaaaaaaaaaaaaca\",\"aaaaaaaaaaaaaacb\",\"aaaaaaaaaaaaaacc\",\"aaaaaaaaaaaaaacd\",\"aaaaaaaaaaaaaace\",\"aaaaaaaaaaaaaacf\",\"aaaaaaaaaaaaaacg\",\"aaaaaaaaaaaaaach\",\"aaaaaaaaaaaaaaci\",\"aaaaaaaaaaaaaacj\",\"aaaaaaaaaaaaaack\",\"aaaaaaaaaaaaaacl\",\"aaaaaaaaaaaaaacm\",\"aaaaaaaaaaaaaacn\",\"aaaaaaaaaaaaaaco\",\"aaaaaaaaaaaaaacp\",\"aaaaaaaaaaaaaacq\",\"aaaaaaaaaaaaaacr\",\"aaaaaaaaaaaaaacs\",\"aaaaaaaaaaaaaact\",\"aaaaaaaaaaaaaacu\",\"aaaaaaaaaaaaaacv\",\"aaaaaaaaaaaaaacw\",\"aaaaaaaaaaaaaacx\",\"aaaaaaaaaaaaaacy\",\"aaaaaaaaaaaaaacz\",\"aaaaaaaaaaaaaada\",\"aaaaaaaaaaaaaadb\",\"aaaaaaaaaaaaaadc\",\"aaaaaaaaaaaaaadd\",\"aaaaaaaaaaaaaade\",\"aaaaaaaaaaaaaadf\",\"aaaaaaaaaaaaaadg\",\"aaaaaaaaaaaaaadh\",\"aaaaaaaaaaaaaadi\",\"aaaaaaaaaaaaaadj\",\"aaaaaaaaaaaaaadk\",\"aaaaaaaaaaaaaadl\",\"aaaaaaaaaaaaaadm\",\"aaaaaaaaaaaaaadn\",\"aaaaaaaaaaaaaado\",\"aaaaaaaaaaaaaadp\",\"aaaaaaaaaaaaaadq\",\"aaaaaaaaaaaaaadr\",\"aaaaaaaaaaaaaads\",\"aaaaaaaaaaaaaadt\",\"aaaaaaaaaaaaaadu\",\"aaaaaaaaaaaaaadv\",\"aaaaaaaaaaaaaadw\",\"aaaaaaaaaaaaaadx\",\"aaaaaaaaaaaaaady\",\"aaaaaaaaaaaaaadz\",\"aaaaaaaaaaaaaaea\",\"aaaaaaaaaaaaaaeb\",\"aaaaaaaaaaaaaaec\",\"aaaaaaaaaaaaaaed\",\"aaaaaaaaaaaaaaee\",\"aaaaaaaaaaaaaaef\",\"aaaaaaaaaaaaaaeg\",\"aaaaaaaaaaaaaaeh\",\"aaaaaaaaaaaaaaei\",\"aaaaaaaaaaaaaaej\",\"aaaaaaaaaaaaaaek\",\"aaaaaaaaaaaaaael\",\"aaaaaaaaaaaaaaem\",\"aaaaaaaaaaaaaaen\",\"aaaaaaaaaaaaaaeo\",\"aaaaaaaaaaaaaaep\",\"aaaaaaaaaaaaaaeq\",\"aaaaaaaaaaaaaaer\",\"aaaaaaaaaaaaaaes\",\"aaaaaaaaaaaaaaet\",\"aaaaaaaaaaaaaaeu\",\"aaaaaaaaaaaaaaev\",\"aaaaaaaaaaaaaaew\",\"aaaaaaaaaaaaaaex\",\"aaaaaaaaaaaaaaey\",\"aaaaaaaaaaaaaaez\",\"aaaaaaaaaaaaaafa\",\"aaaaaaaaaaaaaafb\",\"aaaaaaaaaaaaaafc\",\"aaaaaaaaaaaaaafd\",\"aaaaaaaaaaaaaafe\",\"aaaaaaaaaaaaaaff\",\"aaaaaaaaaaaaaafg\",\"aaaaaaaaaaaaaafh\",\"aaaaaaaaaaaaaafi\",\"aaaaaaaaaaaaaafj\",\"aaaaaaaaaaaaaafk\",\"aaaaaaaaaaaaaafl\",\"aaaaaaaaaaaaaafm\",\"aaaaaaaaaaaaaafn\",\"aaaaaaaaaaaaaafo\",\"aaaaaaaaaaaaaafp\",\"aaaaaaaaaaaaaafq\",\"aaaaaaaaaaaaaafr\",\"aaaaaaaaaaaaaafs\",\"aaaaaaaaaaaaaaft\",\"aaaaaaaaaaaaaafu\",\"aaaaaaaaaaaaaafv\",\"aaaaaaaaaaaaaafw\",\"aaaaaaaaaaaaaafx\",\"aaaaaaaaaaaaaafy\",\"aaaaaaaaaaaaaafz\",\"aaaaaaaaaaaaaaga\",\"aaaaaaaaaaaaaagb\",\"aaaaaaaaaaaaaagc\",\"aaaaaaaaaaaaaagd\",\"aaaaaaaaaaaaaage\",\"aaaaaaaaaaaaaagf\",\"aaaaaaaaaaaaaagg\",\"aaaaaaaaaaaaaagh\",\"aaaaaaaaaaaaaagi\",\"aaaaaaaaaaaaaagj\",\"aaaaaaaaaaaaaagk\",\"aaaaaaaaaaaaaagl\",\"aaaaaaaaaaaaaagm\",\"aaaaaaaaaaaaaagn\",\"aaaaaaaaaaaaaago\",\"aaaaaaaaaaaaaagp\",\"aaaaaaaaaaaaaagq\",\"aaaaaaaaaaaaaagr\",\"aaaaaaaaaaaaaags\",\"aaaaaaaaaaaaaagt\",\"aaaaaaaaaaaaaagu\",\"aaaaaaaaaaaaaagv\",\"aaaaaaaaaaaaaagw\",\"aaaaaaaaaaaaaagx\",\"aaaaaaaaaaaaaagy\",\"aaaaaaaaaaaaaagz\",\"aaaaaaaaaaaaaaha\",\"aaaaaaaaaaaaaahb\",\"aaaaaaaaaaaaaahc\",\"aaaaaaaaaaaaaahd\",\"aaaaaaaaaaaaaahe\",\"aaaaaaaaaaaaaahf\",\"aaaaaaaaaaaaaahg\",\"aaaaaaaaaaaaaahh\",\"aaaaaaaaaaaaaahi\",\"aaaaaaaaaaaaaahj\",\"aaaaaaaaaaaaaahk\",\"aaaaaaaaaaaaaahl\",\"aaaaaaaaaaaaaahm\",\"aaaaaaaaaaaaaahn\",\"aaaaaaaaaaaaaaho\",\"aaaaaaaaaaaaaahp\",\"aaaaaaaaaaaaaahq\",\"aaaaaaaaaaaaaahr\",\"aaaaaaaaaaaaaahs\",\"aaaaaaaaaaaaaaht\",\"aaaaaaaaaaaaaahu\",\"aaaaaaaaaaaaaahv\",\"aaaaaaaaaaaaaahw\",\"aaaaaaaaaaaaaahx\",\"aaaaaaaaaaaaaahy\",\"aaaaaaaaaaaaaahz\",\"aaaaaaaaaaaaaaia\",\"aaaaaaaaaaaaaaib\",\"aaaaaaaaaaaaaaic\",\"aaaaaaaaaaaaaaid\",\"aaaaaaaaaaaaaaie\",\"aaaaaaaaaaaaaaif\",\"aaaaaaaaaaaaaaig\",\"aaaaaaaaaaaaaaih\",\"aaaaaaaaaaaaaaii\",\"aaaaaaaaaaaaaaij\",\"aaaaaaaaaaaaaaik\",\"aaaaaaaaaaaaaail\",\"aaaaaaaaaaaaaaim\",\"aaaaaaaaaaaaaain\",\"aaaaaaaaaaaaaaio\",\"aaaaaaaaaaaaaaip\",\"aaaaaaaaaaaaaaiq\",\"aaaaaaaaaaaaaair\",\"aaaaaaaaaaaaaais\",\"aaaaaaaaaaaaaait\",\"aaaaaaaaaaaaaaiu\",\"aaaaaaaaaaaaaaiv\",\"aaaaaaaaaaaaaaiw\",\"aaaaaaaaaaaaaaix\",\"aaaaaaaaaaaaaaiy\",\"aaaaaaaaaaaaaaiz\",\"aaaaaaaaaaaaaaja\",\"aaaaaaaaaaaaaajb\",\"aaaaaaaaaaaaaajc\",\"aaaaaaaaaaaaaajd\",\"aaaaaaaaaaaaaaje\",\"aaaaaaaaaaaaaajf\",\"aaaaaaaaaaaaaajg\",\"aaaaaaaaaaaaaajh\",\"aaaaaaaaaaaaaaji\",\"aaaaaaaaaaaaaajj\",\"aaaaaaaaaaaaaajk\",\"aaaaaaaaaaaaaajl\",\"aaaaaaaaaaaaaajm\",\"aaaaaaaaaaaaaajn\",\"aaaaaaaaaaaaaajo\",\"aaaaaaaaaaaaaajp\",\"aaaaaaaaaaaaaajq\",\"aaaaaaaaaaaaaajr\",\"aaaaaaaaaaaaaajs\",\"aaaaaaaaaaaaaajt\",\"aaaaaaaaaaaaaaju\",\"aaaaaaaaaaaaaajv\",\"aaaaaaaaaaaaaajw\",\"aaaaaaaaaaaaaajx\",\"aaaaaaaaaaaaaajy\",\"aaaaaaaaaaaaaajz\",\"aaaaaaaaaaaaaaka\",\"aaaaaaaaaaaaaakb\",\"aaaaaaaaaaaaaakc\",\"aaaaaaaaaaaaaakd\",\"aaaaaaaaaaaaaake\",\"aaaaaaaaaaaaaakf\",\"aaaaaaaaaaaaaakg\",\"aaaaaaaaaaaaaakh\",\"aaaaaaaaaaaaaaki\",\"aaaaaaaaaaaaaakj\",\"aaaaaaaaaaaaaakk\",\"aaaaaaaaaaaaaakl\",\"aaaaaaaaaaaaaakm\",\"aaaaaaaaaaaaaakn\",\"aaaaaaaaaaaaaako\",\"aaaaaaaaaaaaaakp\",\"aaaaaaaaaaaaaakq\",\"aaaaaaaaaaaaaakr\",\"aaaaaaaaaaaaaaks\",\"aaaaaaaaaaaaaakt\",\"aaaaaaaaaaaaaaku\",\"aaaaaaaaaaaaaakv\",\"aaaaaaaaaaaaaakw\",\"aaaaaaaaaaaaaakx\",\"aaaaaaaaaaaaaaky\",\"aaaaaaaaaaaaaakz\",\"aaaaaaaaaaaaaala\",\"aaaaaaaaaaaaaalb\",\"aaaaaaaaaaaaaalc\",\"aaaaaaaaaaaaaald\",\"aaaaaaaaaaaaaale\",\"aaaaaaaaaaaaaalf\",\"aaaaaaaaaaaaaalg\",\"aaaaaaaaaaaaaalh\",\"aaaaaaaaaaaaaali\",\"aaaaaaaaaaaaaalj\",\"aaaaaaaaaaaaaalk\",\"aaaaaaaaaaaaaall\",\"aaaaaaaaaaaaaalm\",\"aaaaaaaaaaaaaaln\",\"aaaaaaaaaaaaaalo\",\"aaaaaaaaaaaaaalp\",\"aaaaaaaaaaaaaalq\",\"aaaaaaaaaaaaaalr\",\"aaaaaaaaaaaaaals\",\"aaaaaaaaaaaaaalt\",\"aaaaaaaaaaaaaalu\",\"aaaaaaaaaaaaaalv\",\"aaaaaaaaaaaaaalw\",\"aaaaaaaaaaaaaalx\",\"aaaaaaaaaaaaaaly\",\"aaaaaaaaaaaaaalz\",\"aaaaaaaaaaaaaama\",\"aaaaaaaaaaaaaamb\",\"aaaaaaaaaaaaaamc\",\"aaaaaaaaaaaaaamd\",\"aaaaaaaaaaaaaame\",\"aaaaaaaaaaaaaamf\",\"aaaaaaaaaaaaaamg\",\"aaaaaaaaaaaaaamh\",\"aaaaaaaaaaaaaami\",\"aaaaaaaaaaaaaamj\",\"aaaaaaaaaaaaaamk\",\"aaaaaaaaaaaaaaml\",\"aaaaaaaaaaaaaamm\",\"aaaaaaaaaaaaaamn\",\"aaaaaaaaaaaaaamo\",\"aaaaaaaaaaaaaamp\",\"aaaaaaaaaaaaaamq\",\"aaaaaaaaaaaaaamr\",\"aaaaaaaaaaaaaams\",\"aaaaaaaaaaaaaamt\",\"aaaaaaaaaaaaaamu\",\"aaaaaaaaaaaaaamv\",\"aaaaaaaaaaaaaamw\",\"aaaaaaaaaaaaaamx\",\"aaaaaaaaaaaaaamy\",\"aaaaaaaaaaaaaamz\",\"aaaaaaaaaaaaaana\",\"aaaaaaaaaaaaaanb\",\"aaaaaaaaaaaaaanc\",\"aaaaaaaaaaaaaand\",\"aaaaaaaaaaaaaane\",\"aaaaaaaaaaaaaanf\",\"aaaaaaaaaaaaaang\",\"aaaaaaaaaaaaaanh\",\"aaaaaaaaaaaaaani\",\"aaaaaaaaaaaaaanj\",\"aaaaaaaaaaaaaank\",\"aaaaaaaaaaaaaanl\",\"aaaaaaaaaaaaaanm\",\"aaaaaaaaaaaaaann\",\"aaaaaaaaaaaaaano\",\"aaaaaaaaaaaaaanp\",\"aaaaaaaaaaaaaanq\",\"aaaaaaaaaaaaaanr\",\"aaaaaaaaaaaaaans\",\"aaaaaaaaaaaaaant\",\"aaaaaaaaaaaaaanu\",\"aaaaaaaaaaaaaanv\",\"aaaaaaaaaaaaaanw\",\"aaaaaaaaaaaaaanx\",\"aaaaaaaaaaaaaany\",\"aaaaaaaaaaaaaanz\",\"aaaaaaaaaaaaaaoa\",\"aaaaaaaaaaaaaaob\",\"aaaaaaaaaaaaaaoc\",\"aaaaaaaaaaaaaaod\",\"aaaaaaaaaaaaaaoe\",\"aaaaaaaaaaaaaaof\",\"aaaaaaaaaaaaaaog\",\"aaaaaaaaaaaaaaoh\",\"aaaaaaaaaaaaaaoi\",\"aaaaaaaaaaaaaaoj\",\"aaaaaaaaaaaaaaok\",\"aaaaaaaaaaaaaaol\",\"aaaaaaaaaaaaaaom\",\"aaaaaaaaaaaaaaon\",\"aaaaaaaaaaaaaaoo\",\"aaaaaaaaaaaaaaop\",\"aaaaaaaaaaaaaaoq\",\"aaaaaaaaaaaaaaor\",\"aaaaaaaaaaaaaaos\",\"aaaaaaaaaaaaaaot\",\"aaaaaaaaaaaaaaou\",\"aaaaaaaaaaaaaaov\",\"aaaaaaaaaaaaaaow\",\"aaaaaaaaaaaaaaox\",\"aaaaaaaaaaaaaaoy\",\"aaaaaaaaaaaaaaoz\",\"aaaaaaaaaaaaaapa\",\"aaaaaaaaaaaaaapb\",\"aaaaaaaaaaaaaapc\",\"aaaaaaaaaaaaaapd\",\"aaaaaaaaaaaaaape\",\"aaaaaaaaaaaaaapf\",\"aaaaaaaaaaaaaapg\",\"aaaaaaaaaaaaaaph\",\"aaaaaaaaaaaaaapi\",\"aaaaaaaaaaaaaapj\",\"aaaaaaaaaaaaaapk\",\"aaaaaaaaaaaaaapl\",\"aaaaaaaaaaaaaapm\",\"aaaaaaaaaaaaaapn\",\"aaaaaaaaaaaaaapo\",\"aaaaaaaaaaaaaapp\",\"aaaaaaaaaaaaaapq\",\"aaaaaaaaaaaaaapr\",\"aaaaaaaaaaaaaaps\",\"aaaaaaaaaaaaaapt\",\"aaaaaaaaaaaaaapu\",\"aaaaaaaaaaaaaapv\",\"aaaaaaaaaaaaaapw\",\"aaaaaaaaaaaaaapx\",\"aaaaaaaaaaaaaapy\",\"aaaaaaaaaaaaaapz\",\"aaaaaaaaaaaaaaqa\",\"aaaaaaaaaaaaaaqb\",\"aaaaaaaaaaaaaaqc\",\"aaaaaaaaaaaaaaqd\",\"aaaaaaaaaaaaaaqe\",\"aaaaaaaaaaaaaaqf\",\"aaaaaaaaaaaaaaqg\",\"aaaaaaaaaaaaaaqh\",\"aaaaaaaaaaaaaaqi\",\"aaaaaaaaaaaaaaqj\",\"aaaaaaaaaaaaaaqk\",\"aaaaaaaaaaaaaaql\",\"aaaaaaaaaaaaaaqm\",\"aaaaaaaaaaaaaaqn\",\"aaaaaaaaaaaaaaqo\",\"aaaaaaaaaaaaaaqp\",\"aaaaaaaaaaaaaaqq\",\"aaaaaaaaaaaaaaqr\",\"aaaaaaaaaaaaaaqs\",\"aaaaaaaaaaaaaaqt\",\"aaaaaaaaaaaaaaqu\",\"aaaaaaaaaaaaaaqv\",\"aaaaaaaaaaaaaaqw\",\"aaaaaaaaaaaaaaqx\",\"aaaaaaaaaaaaaaqy\",\"aaaaaaaaaaaaaaqz\",\"aaaaaaaaaaaaaara\",\"aaaaaaaaaaaaaarb\",\"aaaaaaaaaaaaaarc\",\"aaaaaaaaaaaaaard\",\"aaaaaaaaaaaaaare\",\"aaaaaaaaaaaaaarf\",\"aaaaaaaaaaaaaarg\",\"aaaaaaaaaaaaaarh\",\"aaaaaaaaaaaaaari\",\"aaaaaaaaaaaaaarj\",\"aaaaaaaaaaaaaark\",\"aaaaaaaaaaaaaarl\",\"aaaaaaaaaaaaaarm\",\"aaaaaaaaaaaaaarn\",\"aaaaaaaaaaaaaaro\",\"aaaaaaaaaaaaaarp\",\"aaaaaaaaaaaaaarq\",\"aaaaaaaaaaaaaarr\",\"aaaaaaaaaaaaaars\",\"aaaaaaaaaaaaaart\",\"aaaaaaaaaaaaaaru\",\"aaaaaaaaaaaaaarv\",\"aaaaaaaaaaaaaarw\",\"aaaaaaaaaaaaaarx\",\"aaaaaaaaaaaaaary\",\"aaaaaaaaaaaaaarz\",\"aaaaaaaaaaaaaasa\",\"aaaaaaaaaaaaaasb\",\"aaaaaaaaaaaaaasc\",\"aaaaaaaaaaaaaasd\",\"aaaaaaaaaaaaaase\",\"aaaaaaaaaaaaaasf\",\"aaaaaaaaaaaaaasg\",\"aaaaaaaaaaaaaash\",\"aaaaaaaaaaaaaasi\",\"aaaaaaaaaaaaaasj\",\"aaaaaaaaaaaaaask\",\"aaaaaaaaaaaaaasl\",\"aaaaaaaaaaaaaasm\",\"aaaaaaaaaaaaaasn\",\"aaaaaaaaaaaaaaso\",\"aaaaaaaaaaaaaasp\",\"aaaaaaaaaaaaaasq\",\"aaaaaaaaaaaaaasr\",\"aaaaaaaaaaaaaass\",\"aaaaaaaaaaaaaast\",\"aaaaaaaaaaaaaasu\",\"aaaaaaaaaaaaaasv\",\"aaaaaaaaaaaaaasw\",\"aaaaaaaaaaaaaasx\",\"aaaaaaaaaaaaaasy\",\"aaaaaaaaaaaaaasz\",\"aaaaaaaaaaaaaata\",\"aaaaaaaaaaaaaatb\",\"aaaaaaaaaaaaaatc\",\"aaaaaaaaaaaaaatd\",\"aaaaaaaaaaaaaate\",\"aaaaaaaaaaaaaatf\",\"aaaaaaaaaaaaaatg\",\"aaaaaaaaaaaaaath\",\"aaaaaaaaaaaaaati\",\"aaaaaaaaaaaaaatj\",\"aaaaaaaaaaaaaatk\",\"aaaaaaaaaaaaaatl\",\"aaaaaaaaaaaaaatm\",\"aaaaaaaaaaaaaatn\",\"aaaaaaaaaaaaaato\",\"aaaaaaaaaaaaaatp\",\"aaaaaaaaaaaaaatq\",\"aaaaaaaaaaaaaatr\",\"aaaaaaaaaaaaaats\",\"aaaaaaaaaaaaaatt\",\"aaaaaaaaaaaaaatu\",\"aaaaaaaaaaaaaatv\",\"aaaaaaaaaaaaaatw\",\"aaaaaaaaaaaaaatx\",\"aaaaaaaaaaaaaaty\",\"aaaaaaaaaaaaaatz\",\"aaaaaaaaaaaaaaua\",\"aaaaaaaaaaaaaaub\",\"aaaaaaaaaaaaaauc\",\"aaaaaaaaaaaaaaud\",\"aaaaaaaaaaaaaaue\",\"aaaaaaaaaaaaaauf\",\"aaaaaaaaaaaaaaug\",\"aaaaaaaaaaaaaauh\",\"aaaaaaaaaaaaaaui\",\"aaaaaaaaaaaaaauj\",\"aaaaaaaaaaaaaauk\",\"aaaaaaaaaaaaaaul\",\"aaaaaaaaaaaaaaum\",\"aaaaaaaaaaaaaaun\",\"aaaaaaaaaaaaaauo\",\"aaaaaaaaaaaaaaup\",\"aaaaaaaaaaaaaauq\",\"aaaaaaaaaaaaaaur\",\"aaaaaaaaaaaaaaus\",\"aaaaaaaaaaaaaaut\",\"aaaaaaaaaaaaaauu\",\"aaaaaaaaaaaaaauv\",\"aaaaaaaaaaaaaauw\",\"aaaaaaaaaaaaaaux\",\"aaaaaaaaaaaaaauy\",\"aaaaaaaaaaaaaauz\",\"aaaaaaaaaaaaaava\",\"aaaaaaaaaaaaaavb\",\"aaaaaaaaaaaaaavc\",\"aaaaaaaaaaaaaavd\",\"aaaaaaaaaaaaaave\",\"aaaaaaaaaaaaaavf\",\"aaaaaaaaaaaaaavg\",\"aaaaaaaaaaaaaavh\",\"aaaaaaaaaaaaaavi\",\"aaaaaaaaaaaaaavj\",\"aaaaaaaaaaaaaavk\",\"aaaaaaaaaaaaaavl\",\"aaaaaaaaaaaaaavm\",\"aaaaaaaaaaaaaavn\",\"aaaaaaaaaaaaaavo\",\"aaaaaaaaaaaaaavp\",\"aaaaaaaaaaaaaavq\",\"aaaaaaaaaaaaaavr\",\"aaaaaaaaaaaaaavs\",\"aaaaaaaaaaaaaavt\",\"aaaaaaaaaaaaaavu\",\"aaaaaaaaaaaaaavv\",\"aaaaaaaaaaaaaavw\",\"aaaaaaaaaaaaaavx\",\"aaaaaaaaaaaaaavy\",\"aaaaaaaaaaaaaavz\",\"aaaaaaaaaaaaaawa\",\"aaaaaaaaaaaaaawb\",\"aaaaaaaaaaaaaawc\",\"aaaaaaaaaaaaaawd\",\"aaaaaaaaaaaaaawe\",\"aaaaaaaaaaaaaawf\",\"aaaaaaaaaaaaaawg\",\"aaaaaaaaaaaaaawh\",\"aaaaaaaaaaaaaawi\",\"aaaaaaaaaaaaaawj\",\"aaaaaaaaaaaaaawk\",\"aaaaaaaaaaaaaawl\",\"aaaaaaaaaaaaaawm\",\"aaaaaaaaaaaaaawn\",\"aaaaaaaaaaaaaawo\",\"aaaaaaaaaaaaaawp\",\"aaaaaaaaaaaaaawq\",\"aaaaaaaaaaaaaawr\",\"aaaaaaaaaaaaaaws\",\"aaaaaaaaaaaaaawt\",\"aaaaaaaaaaaaaawu\",\"aaaaaaaaaaaaaawv\",\"aaaaaaaaaaaaaaww\",\"aaaaaaaaaaaaaawx\",\"aaaaaaaaaaaaaawy\",\"aaaaaaaaaaaaaawz\",\"aaaaaaaaaaaaaaxa\",\"aaaaaaaaaaaaaaxb\",\"aaaaaaaaaaaaaaxc\",\"aaaaaaaaaaaaaaxd\",\"aaaaaaaaaaaaaaxe\",\"aaaaaaaaaaaaaaxf\",\"aaaaaaaaaaaaaaxg\",\"aaaaaaaaaaaaaaxh\",\"aaaaaaaaaaaaaaxi\",\"aaaaaaaaaaaaaaxj\",\"aaaaaaaaaaaaaaxk\",\"aaaaaaaaaaaaaaxl\",\"aaaaaaaaaaaaaaxm\",\"aaaaaaaaaaaaaaxn\",\"aaaaaaaaaaaaaaxo\",\"aaaaaaaaaaaaaaxp\",\"aaaaaaaaaaaaaaxq\",\"aaaaaaaaaaaaaaxr\",\"aaaaaaaaaaaaaaxs\",\"aaaaaaaaaaaaaaxt\",\"aaaaaaaaaaaaaaxu\",\"aaaaaaaaaaaaaaxv\",\"aaaaaaaaaaaaaaxw\",\"aaaaaaaaaaaaaaxx\",\"aaaaaaaaaaaaaaxy\",\"aaaaaaaaaaaaaaxz\",\"aaaaaaaaaaaaaaya\",\"aaaaaaaaaaaaaayb\",\"aaaaaaaaaaaaaayc\",\"aaaaaaaaaaaaaayd\",\"aaaaaaaaaaaaaaye\",\"aaaaaaaaaaaaaayf\",\"aaaaaaaaaaaaaayg\",\"aaaaaaaaaaaaaayh\",\"aaaaaaaaaaaaaayi\",\"aaaaaaaaaaaaaayj\",\"aaaaaaaaaaaaaayk\",\"aaaaaaaaaaaaaayl\",\"aaaaaaaaaaaaaaym\",\"aaaaaaaaaaaaaayn\",\"aaaaaaaaaaaaaayo\",\"aaaaaaaaaaaaaayp\",\"aaaaaaaaaaaaaayq\",\"aaaaaaaaaaaaaayr\",\"aaaaaaaaaaaaaays\",\"aaaaaaaaaaaaaayt\",\"aaaaaaaaaaaaaayu\",\"aaaaaaaaaaaaaayv\",\"aaaaaaaaaaaaaayw\",\"aaaaaaaaaaaaaayx\",\"aaaaaaaaaaaaaayy\",\"aaaaaaaaaaaaaayz\",\"aaaaaaaaaaaaaaza\",\"aaaaaaaaaaaaaazb\",\"aaaaaaaaaaaaaazc\",\"aaaaaaaaaaaaaazd\",\"aaaaaaaaaaaaaaze\",\"aaaaaaaaaaaaaazf\",\"aaaaaaaaaaaaaazg\",\"aaaaaaaaaaaaaazh\",\"aaaaaaaaaaaaaazi\",\"aaaaaaaaaaaaaazj\",\"aaaaaaaaaaaaaazk\",\"aaaaaaaaaaaaaazl\",\"aaaaaaaaaaaaaazm\",\"aaaaaaaaaaaaaazn\",\"aaaaaaaaaaaaaazo\",\"aaaaaaaaaaaaaazp\",\"aaaaaaaaaaaaaazq\",\"aaaaaaaaaaaaaazr\",\"aaaaaaaaaaaaaazs\",\"aaaaaaaaaaaaaazt\",\"aaaaaaaaaaaaaazu\",\"aaaaaaaaaaaaaazv\",\"aaaaaaaaaaaaaazw\",\"aaaaaaaaaaaaaazx\",\"aaaaaaaaaaaaaazy\",\"aaaaaaaaaaaaaazz\",\"aaaaaaaaaaaaaaaa\",\"aaaaaaaaaaaaaaab\",\"aaaaaaaaaaaaaaac\",\"aaaaaaaaaaaaaaad\",\"aaaaaaaaaaaaaaae\",\"aaaaaaaaaaaaaaaf\",\"aaaaaaaaaaaaaaag\",\"aaaaaaaaaaaaaaah\",\"aaaaaaaaaaaaaaai\",\"aaaaaaaaaaaaaaaj\",\"aaaaaaaaaaaaaaak\",\"aaaaaaaaaaaaaaal\",\"aaaaaaaaaaaaaaam\",\"aaaaaaaaaaaaaaan\",\"aaaaaaaaaaaaaaao\",\"aaaaaaaaaaaaaaap\",\"aaaaaaaaaaaaaaaq\",\"aaaaaaaaaaaaaaar\",\"aaaaaaaaaaaaaaas\",\"aaaaaaaaaaaaaaat\",\"aaaaaaaaaaaaaaau\",\"aaaaaaaaaaaaaaav\",\"aaaaaaaaaaaaaaaw\",\"aaaaaaaaaaaaaaax\",\"aaaaaaaaaaaaaaay\",\"aaaaaaaaaaaaaaaz\",\"aaaaaaaaaaaaaaba\",\"aaaaaaaaaaaaaabb\",\"aaaaaaaaaaaaaabc\",\"aaaaaaaaaaaaaabd\",\"aaaaaaaaaaaaaabe\",\"aaaaaaaaaaaaaabf\",\"aaaaaaaaaaaaaabg\",\"aaaaaaaaaaaaaabh\",\"aaaaaaaaaaaaaabi\",\"aaaaaaaaaaaaaabj\",\"aaaaaaaaaaaaaabk\",\"aaaaaaaaaaaaaabl\",\"aaaaaaaaaaaaaabm\",\"aaaaaaaaaaaaaabn\",\"aaaaaaaaaaaaaabo\",\"aaaaaaaaaaaaaabp\",\"aaaaaaaaaaaaaabq\",\"aaaaaaaaaaaaaabr\",\"aaaaaaaaaaaaaabs\",\"aaaaaaaaaaaaaabt\",\"aaaaaaaaaaaaaabu\",\"aaaaaaaaaaaaaabv\",\"aaaaaaaaaaaaaabw\",\"aaaaaaaaaaaaaabx\",\"aaaaaaaaaaaaaaby\",\"aaaaaaaaaaaaaabz\",\"aaaaaaaaaaaaaaca\",\"aaaaaaaaaaaaaacb\",\"aaaaaaaaaaaaaacc\",\"aaaaaaaaaaaaaacd\",\"aaaaaaaaaaaaaace\",\"aaaaaaaaaaaaaacf\",\"aaaaaaaaaaaaaacg\",\"aaaaaaaaaaaaaach\",\"aaaaaaaaaaaaaaci\",\"aaaaaaaaaaaaaacj\",\"aaaaaaaaaaaaaack\",\"aaaaaaaaaaaaaacl\",\"aaaaaaaaaaaaaacm\",\"aaaaaaaaaaaaaacn\",\"aaaaaaaaaaaaaaco\",\"aaaaaaaaaaaaaacp\",\"aaaaaaaaaaaaaacq\",\"aaaaaaaaaaaaaacr\",\"aaaaaaaaaaaaaacs\",\"aaaaaaaaaaaaaact\",\"aaaaaaaaaaaaaacu\",\"aaaaaaaaaaaaaacv\",\"aaaaaaaaaaaaaacw\",\"aaaaaaaaaaaaaacx\",\"aaaaaaaaaaaaaacy\",\"aaaaaaaaaaaaaacz\",\"aaaaaaaaaaaaaada\",\"aaaaaaaaaaaaaadb\",\"aaaaaaaaaaaaaadc\",\"aaaaaaaaaaaaaadd\",\"aaaaaaaaaaaaaade\",\"aaaaaaaaaaaaaadf\",\"aaaaaaaaaaaaaadg\",\"aaaaaaaaaaaaaadh\",\"aaaaaaaaaaaaaadi\",\"aaaaaaaaaaaaaadj\",\"aaaaaaaaaaaaaadk\",\"aaaaaaaaaaaaaadl\",\"aaaaaaaaaaaaaadm\",\"aaaaaaaaaaaaaadn\",\"aaaaaaaaaaaaaado\",\"aaaaaaaaaaaaaadp\",\"aaaaaaaaaaaaaadq\",\"aaaaaaaaaaaaaadr\",\"aaaaaaaaaaaaaads\",\"aaaaaaaaaaaaaadt\",\"aaaaaaaaaaaaaadu\",\"aaaaaaaaaaaaaadv\",\"aaaaaaaaaaaaaadw\",\"aaaaaaaaaaaaaadx\",\"aaaaaaaaaaaaaady\",\"aaaaaaaaaaaaaadz\",\"aaaaaaaaaaaaaaea\",\"aaaaaaaaaaaaaaeb\",\"aaaaaaaaaaaaaaec\",\"aaaaaaaaaaaaaaed\",\"aaaaaaaaaaaaaaee\",\"aaaaaaaaaaaaaaef\",\"aaaaaaaaaaaaaaeg\",\"aaaaaaaaaaaaaaeh\",\"aaaaaaaaaaaaaaei\",\"aaaaaaaaaaaaaaej\",\"aaaaaaaaaaaaaaek\",\"aaaaaaaaaaaaaael\",\"aaaaaaaaaaaaaaem\",\"aaaaaaaaaaaaaaen\",\"aaaaaaaaaaaaaaeo\",\"aaaaaaaaaaaaaaep\",\"aaaaaaaaaaaaaaeq\",\"aaaaaaaaaaaaaaer\",\"aaaaaaaaaaaaaaes\",\"aaaaaaaaaaaaaaet\",\"aaaaaaaaaaaaaaeu\",\"aaaaaaaaaaaaaaev\",\"aaaaaaaaaaaaaaew\",\"aaaaaaaaaaaaaaex\",\"aaaaaaaaaaaaaaey\",\"aaaaaaaaaaaaaaez\",\"aaaaaaaaaaaaaafa\",\"aaaaaaaaaaaaaafb\",\"aaaaaaaaaaaaaafc\",\"aaaaaaaaaaaaaafd\",\"aaaaaaaaaaaaaafe\",\"aaaaaaaaaaaaaaff\",\"aaaaaaaaaaaaaafg\",\"aaaaaaaaaaaaaafh\",\"aaaaaaaaaaaaaafi\",\"aaaaaaaaaaaaaafj\",\"aaaaaaaaaaaaaafk\",\"aaaaaaaaaaaaaafl\",\"aaaaaaaaaaaaaafm\",\"aaaaaaaaaaaaaafn\",\"aaaaaaaaaaaaaafo\",\"aaaaaaaaaaaaaafp\",\"aaaaaaaaaaaaaafq\",\"aaaaaaaaaaaaaafr\",\"aaaaaaaaaaaaaafs\",\"aaaaaaaaaaaaaaft\",\"aaaaaaaaaaaaaafu\",\"aaaaaaaaaaaaaafv\",\"aaaaaaaaaaaaaafw\",\"aaaaaaaaaaaaaafx\",\"aaaaaaaaaaaaaafy\",\"aaaaaaaaaaaaaafz\",\"aaaaaaaaaaaaaaga\",\"aaaaaaaaaaaaaagb\",\"aaaaaaaaaaaaaagc\",\"aaaaaaaaaaaaaagd\",\"aaaaaaaaaaaaaage\",\"aaaaaaaaaaaaaagf\",\"aaaaaaaaaaaaaagg\",\"aaaaaaaaaaaaaagh\",\"aaaaaaaaaaaaaagi\",\"aaaaaaaaaaaaaagj\",\"aaaaaaaaaaaaaagk\",\"aaaaaaaaaaaaaagl\",\"aaaaaaaaaaaaaagm\",\"aaaaaaaaaaaaaagn\",\"aaaaaaaaaaaaaago\",\"aaaaaaaaaaaaaagp\",\"aaaaaaaaaaaaaagq\",\"aaaaaaaaaaaaaagr\",\"aaaaaaaaaaaaaags\",\"aaaaaaaaaaaaaagt\",\"aaaaaaaaaaaaaagu\",\"aaaaaaaaaaaaaagv\",\"aaaaaaaaaaaaaagw\",\"aaaaaaaaaaaaaagx\",\"aaaaaaaaaaaaaagy\",\"aaaaaaaaaaaaaagz\",\"aaaaaaaaaaaaaaha\",\"aaaaaaaaaaaaaahb\",\"aaaaaaaaaaaaaahc\",\"aaaaaaaaaaaaaahd\",\"aaaaaaaaaaaaaahe\",\"aaaaaaaaaaaaaahf\",\"aaaaaaaaaaaaaahg\",\"aaaaaaaaaaaaaahh\",\"aaaaaaaaaaaaaahi\",\"aaaaaaaaaaaaaahj\",\"aaaaaaaaaaaaaahk\",\"aaaaaaaaaaaaaahl\",\"aaaaaaaaaaaaaahm\",\"aaaaaaaaaaaaaahn\",\"aaaaaaaaaaaaaaho\",\"aaaaaaaaaaaaaahp\",\"aaaaaaaaaaaaaahq\",\"aaaaaaaaaaaaaahr\",\"aaaaaaaaaaaaaahs\",\"aaaaaaaaaaaaaaht\",\"aaaaaaaaaaaaaahu\",\"aaaaaaaaaaaaaahv\",\"aaaaaaaaaaaaaahw\",\"aaaaaaaaaaaaaahx\",\"aaaaaaaaaaaaaahy\",\"aaaaaaaaaaaaaahz\",\"aaaaaaaaaaaaaaia\",\"aaaaaaaaaaaaaaib\",\"aaaaaaaaaaaaaaic\",\"aaaaaaaaaaaaaaid\",\"aaaaaaaaaaaaaaie\",\"aaaaaaaaaaaaaaif\",\"aaaaaaaaaaaaaaig\",\"aaaaaaaaaaaaaaih\",\"aaaaaaaaaaaaaaii\",\"aaaaaaaaaaaaaaij\",\"aaaaaaaaaaaaaaik\",\"aaaaaaaaaaaaaail\",\"aaaaaaaaaaaaaaim\",\"aaaaaaaaaaaaaain\",\"aaaaaaaaaaaaaaio\",\"aaaaaaaaaaaaaaip\",\"aaaaaaaaaaaaaaiq\",\"aaaaaaaaaaaaaair\",\"aaaaaaaaaaaaaais\",\"aaaaaaaaaaaaaait\",\"aaaaaaaaaaaaaaiu\",\"aaaaaaaaaaaaaaiv\",\"aaaaaaaaaaaaaaiw\",\"aaaaaaaaaaaaaaix\",\"aaaaaaaaaaaaaaiy\",\"aaaaaaaaaaaaaaiz\",\"aaaaaaaaaaaaaaja\",\"aaaaaaaaaaaaaajb\",\"aaaaaaaaaaaaaajc\",\"aaaaaaaaaaaaaajd\",\"aaaaaaaaaaaaaaje\",\"aaaaaaaaaaaaaajf\",\"aaaaaaaaaaaaaajg\",\"aaaaaaaaaaaaaajh\",\"aaaaaaaaaaaaaaji\",\"aaaaaaaaaaaaaajj\",\"aaaaaaaaaaaaaajk\",\"aaaaaaaaaaaaaajl\",\"aaaaaaaaaaaaaajm\",\"aaaaaaaaaaaaaajn\",\"aaaaaaaaaaaaaajo\",\"aaaaaaaaaaaaaajp\",\"aaaaaaaaaaaaaajq\",\"aaaaaaaaaaaaaajr\",\"aaaaaaaaaaaaaajs\",\"aaaaaaaaaaaaaajt\",\"aaaaaaaaaaaaaaju\",\"aaaaaaaaaaaaaajv\",\"aaaaaaaaaaaaaajw\",\"aaaaaaaaaaaaaajx\",\"aaaaaaaaaaaaaajy\",\"aaaaaaaaaaaaaajz\",\"aaaaaaaaaaaaaaka\",\"aaaaaaaaaaaaaakb\",\"aaaaaaaaaaaaaakc\",\"aaaaaaaaaaaaaakd\",\"aaaaaaaaaaaaaake\",\"aaaaaaaaaaaaaakf\",\"aaaaaaaaaaaaaakg\",\"aaaaaaaaaaaaaakh\",\"aaaaaaaaaaaaaaki\",\"aaaaaaaaaaaaaakj\",\"aaaaaaaaaaaaaakk\",\"aaaaaaaaaaaaaakl\",\"aaaaaaaaaaaaaakm\",\"aaaaaaaaaaaaaakn\",\"aaaaaaaaaaaaaako\",\"aaaaaaaaaaaaaakp\",\"aaaaaaaaaaaaaakq\",\"aaaaaaaaaaaaaakr\",\"aaaaaaaaaaaaaaks\",\"aaaaaaaaaaaaaakt\",\"aaaaaaaaaaaaaaku\",\"aaaaaaaaaaaaaakv\",\"aaaaaaaaaaaaaakw\",\"aaaaaaaaaaaaaakx\",\"aaaaaaaaaaaaaaky\",\"aaaaaaaaaaaaaakz\",\"aaaaaaaaaaaaaala\",\"aaaaaaaaaaaaaalb\",\"aaaaaaaaaaaaaalc\",\"aaaaaaaaaaaaaald\",\"aaaaaaaaaaaaaale\",\"aaaaaaaaaaaaaalf\",\"aaaaaaaaaaaaaalg\",\"aaaaaaaaaaaaaalh\",\"aaaaaaaaaaaaaali\",\"aaaaaaaaaaaaaalj\",\"aaaaaaaaaaaaaalk\",\"aaaaaaaaaaaaaall\"]" +
                        ""));
        Util.print(res);
    }
}
