package gelato.leet5;

public class NonNegativeIntNoConsecutiveOnes {
    public static int findIntegers(int num) {

        if (num < 3)
            return num + 1;

        int n = 32 - Integer.numberOfLeadingZeros(num);

        int[] b1 = new int[n]; //1结尾得数
        int[] a0 = new int[n]; //0结尾的数
        a0[0] = b1[0] = 1;
        for (int i = 1; i < n; i++) {
            a0[i] = a0[i - 1] + b1[i - 1];
            b1[i] = a0[i - 1];
        }

        int r = a0[n - 1] + b1[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int ithbit = 1 << i;
            int i1thbit = 1 << (i + 1);
            if ((num & ithbit) == ithbit && (num & i1thbit) == i1thbit)//如果有连续的两个1,那么剩余位数的所有数比当前剩下的数小,break
                break;
            if ((num & ithbit) == 0 && (num & i1thbit) == 0)//
                r -= b1[i]; //相当于减掉所有1打头的长度为i的数, 不足的前面补零,比如i为1, 剩下的长度为2, 那就是10.
        }
        return r;
    }
}
