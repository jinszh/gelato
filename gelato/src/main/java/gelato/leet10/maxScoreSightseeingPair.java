package gelato.leet10;

public class maxScoreSightseeingPair {
    //Interesting - 远亲不如近邻,远亲在每一步递减1, 跟近邻的最大值比较得到max
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0, cur = 0;
        for (int a: A) {
            res = Math.max(res, cur + a);
            cur = Math.max(cur, a) - 1;
        }
        return res;
    }
}
