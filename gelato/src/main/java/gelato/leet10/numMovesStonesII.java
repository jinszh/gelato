package gelato.leet10;

import java.util.Arrays;

//1040

/**
 * This idea led the solution with sliding windows.
 *
 * Slide a window of size N, and find how many stones are already in this window.
 * We want moves other stones into this window.
 * For each missing stone, we need at least one move.
 *
 * Generally, the number of missing stones and the moves we need are the same.
 * Only one corner case in this problem, we need to move the endpoint to no endpoint.
 *
 * For case 1,2,4,5,10,
 * 1 move needed from 10 to 3.
 *
 * For case 1,2,3,4,10,
 * 2 move needed from 1 to 6, then from 10 to 5.
 *
 *
 * Upper Bound
 * We try to move all stones to leftmost or rightmost.
 * For example of to rightmost.
 * We move the A[0] to A[1] + 1.
 * Then each time, we pick the stone of left endpoint, move it to the next empty position.
 * During this process, the position of leftmost stones increment 1 by 1 each time.
 * Until the leftmost is at A[n - 1] - n + 1.
 *
 *
 * Complexity
 * Time of quick sorting O(NlogN)
 * Time of sliding window O(N)
 * Space O(1)
 */
public class numMovesStonesII {
    public int[] numMovesStonesII(int[] A) {
        Arrays.sort(A);
        int i = 0, n = A.length, low = n;
        int high = Math.max(A[n - 1] - n + 2 - A[1], A[n - 2] - A[0] - n + 2);
        for (int j = 0; j < n; ++j) {
            while (A[j] - A[i] >= n) ++i;
            if (j - i + 1 == n - 1 && A[j] - A[i] == n - 2) //前面的数已经排好了 就差最后一个数, 这是特殊情况, 需要搬两次, 而不是n - 覆盖的个数
                low = Math.min(low, 2);
            else
                low = Math.min(low, n - (j - i + 1));
        }
        return new int[] {low, high};
    }

}
