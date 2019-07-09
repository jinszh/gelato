package gelato.leet9;

//926
public class minFlipsMonoIncr {
    public int minFlipsMonoIncr(String S) {
        int res = 0;
        int[] cnt1 = new int[S.length() + 1];
        cnt1[0] = 0;
        for (int i = 0; i < S.length(); i++) {
            cnt1[i + 1] = S.charAt(i) == '1' ? cnt1[i] + 1 : cnt1[i];
        }
        int min = S.length();
        for (int i = 0; i < S.length(); i++) {
            int tmp = (cnt1[i + 1] - cnt1[0])
                    + (S.length() - 1 - i - (cnt1[S.length()] - cnt1[i + 1]));
            min = Math.min(tmp, min);
        }
        return min;
    }

    //下面这个不需要额外空间, 类似与greedy, 效率也更高, 只需要走一遍
    //遇到第一个1开始统计0与1的个数, 如果0比1多了就选择放弃1. 下次遇到1开始重新计数
    public int minFlipsMonoIncr_better(String S) {
        if(S == null || S.length() <= 0 )
            return 0;

        char[] sChars = S.toCharArray();
        int flipCount = 0;
        int onesCount = 0;

        for(int i=0; i<sChars.length; i++){
            if(sChars[i] == '0'){
                if(onesCount == 0) continue;
                else flipCount++;
            }else{
                onesCount++;
            }
            if(flipCount > onesCount){
                flipCount = onesCount;
            }
        }
        return flipCount;
    }
}
