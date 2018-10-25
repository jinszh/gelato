package gelato.algos;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindContinuousSequence {
    //1的方案是自己的方案,遍历然后二分找到每个数合适的N
    public ArrayList<ArrayList<Integer>> FindContinuousSequence_1(int sum) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        for (int i = 1; i < sum; i++) {
            int l = 1, h = 2 * (int) Math.sqrt((double) sum);
            while (l <= h) {
                int m = (l + h) / 2;
                int tSum = (2 * i + m - 1) * m / 2;
                if (tSum > sum) {
                    h = m - 1;
                } else if (tSum < sum) {
                    l = m + 1;
                } else {
                    ArrayList<Integer> series = IntStream.range(i, m + i).boxed()
                            .collect(Collectors.toCollection(ArrayList::new));
                    results.add(series);
                    break;
                }
            }
        }
        return results;
    }

    //这是网友的方案, 从N的角度考虑, 因为等差数列之和 a1n + n(n-1)/2 = sum,
    // 因为a1 >= 1, 可以知道 n < sqrt(sum), 所以n在2到sqrt(sum) + 1 (因为取整的原因)之间,为每个n找到相应的a

    //看上去复杂度低多了 不过时间实测出来差别不大...
    public ArrayList<ArrayList<Integer>> FindContinuousSequence_2(int sum) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        for (int i = 2; i <= 2 * (int) Math.sqrt((double) sum); i++) {
            int l = -1, h = -1;
            if (sum % i == 0 && i % 2 == 1) {
                l = sum / i - i / 2;
                h = sum / i + i / 2;
            }
            if(sum % i != 0 && sum * 2 % i == 0 && i % 2 == 0){//因为sum/i应该是x.5
                l = sum / i - i/2 + 1;
                h = sum / i + i/2;
            }
            if( l > 0) {
                ArrayList<Integer> series = IntStream.range(l, h + 1).boxed()
                        .collect(Collectors.toCollection(ArrayList::new));
                results.add(series);
            }
        }
        return results;
    }
}
