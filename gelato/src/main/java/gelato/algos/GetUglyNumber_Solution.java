package gelato.algos;

/***
 下一个丑数必定由有数组中的某一个丑数A * 2， B * 3， C * 5 的中的最小值得来。其中A,B,C都是已经生成的丑数.
 因为2*A < 3*A < 5*A, 同时如果A<B则2A<2B. 于是可以想象成维护了3个队列,其中一个是2与已有丑数相乘的队列,还有3和5的队列
 即 min = min(2 * A2, 3 * A3, 5 * A5),其中A2是上次(min == A2*2)即从队列2里面出最小值时候的丑数index,3,5同理
 ***/

public class GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        return 0;
    }
}
