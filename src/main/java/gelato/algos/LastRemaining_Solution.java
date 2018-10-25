package gelato.algos;

public class LastRemaining_Solution {
    //n个小朋友报数, 每次报到m的退出,求最后剩下的小朋友的坐标
    //就是典型的Josephus problem

    public int LastRemaining_Solution(int n, int m) {
        int k = 0;
        for (int i = 2; i <= n; i++) {
            k = (k + m) % i;
        }
        return k;
    }
}
