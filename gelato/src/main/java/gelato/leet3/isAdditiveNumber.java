package gelato.leet3;


//306
public class isAdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        Long m = 1L, cur = 0L;
        for (int i = num.length() - 1; i > 1; i--) {
            cur += m * (num.charAt(i) - '0');
            m *= 10;
            if (i < num.length() - 1 && num.charAt(i) == '0') continue;
            for (int j = i - 1; j > 0 && j >= i - (num.length() - i); j--) {
                if (j < i - 1 && num.charAt(j) == '0') continue;
                Long m2 = Long.parseLong(num.substring(j, i));
                if (m2 <= cur && sub(num, j, cur - m2, m2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean sub(String num, int end, long sum, long par) {
        if (!num.substring(0, end).endsWith(Long.toString(sum))) return false;
        else if (end > Long.toString(sum).length()) {
            return sub(num, end - Long.toString(sum).length(), par - sum, sum);
        } else {
            return true;
        }
    }
}
