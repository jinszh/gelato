package gelato.leet1;

import java.util.Arrays;
import java.util.List;

//120
public class minimumTotal {
    //space O(n)
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int i = 1;
        List<Integer> prev = triangle.get(0);
        int[] prevlen = prev.stream().mapToInt(Integer::intValue).toArray();
        int res = Arrays.stream(prevlen).min().getAsInt();
        while (i < triangle.size()) {
            List<Integer> cur = triangle.get(i);
            int min = Integer.MAX_VALUE;
            int[] len = new int[cur.size()];
            for (int j = 0; j < len.length; j++) {
                len[j] = Math.min((j < prevlen.length ? prevlen[j] : prevlen[j - 1]) + cur.get(j)
                        , (j > 0 ? prevlen[j - 1] : prevlen[0]) + cur.get(j));
                min = Math.min(min, len[j]);
            }
            res = min;
            prevlen = len;
            i++;
        }
        return res;
    }

    //优化 - Bottom-up的方法避免了if else的判断...
    public int minimumTotal_im(List<List<Integer>> triangle) {
        if(triangle.size() == 0)
            return 0;

        for (int i=triangle.size() - 2; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                List<Integer> nextRow = triangle.get(i+1);
                int sum = Math.min(nextRow.get(j), nextRow.get(j+1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, sum);
            }
        }
        return triangle.get(0).get(0);
    }
}
