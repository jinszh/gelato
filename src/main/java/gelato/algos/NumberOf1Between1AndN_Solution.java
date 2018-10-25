package gelato.algos;

public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
    /*
      我们从低位到高位求每位1出现的次数，累加求和即可
      比如个位出现1的个数为 n/10 + ( n % 10 > 1 ? 1 : 0)
      十位为 n /100 * 10 + ( n % 100 / 10 > 1 ? 10 : n % 10)
      百位为 n / 1000 * 100 + (n % 1000 / 100 > 1 ? 100 : n % 100)
    */
        int sum = 0;
        int exp = 1;
        while (n / exp > 0) {
            sum += n / (exp * 10) * exp;
            if (n % (exp * 10) / exp > 1) {
                sum += exp;
            } else if (n % (exp * 10) / exp == 1) {
                sum += n % exp + 1;
            }
            exp *= 10;
        }
        return sum;
    }
}
