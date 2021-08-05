package gelato.leet0;

//6
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int n = numRows * 2 - 2;
        char[] cs = new char[s.length()];
        int j = 0;
        for (int r = 0; r < numRows; r++) {
            int i = r;
            while (i < s.length()) {
                cs[j++] = s.charAt(i);
                if (r != 0 && r != numRows - 1 && i + 2 * (numRows - 1 - r) < s.length()) {
                    cs[j++] = s.charAt(i + 2 * (numRows - 1 - r));
                }
                i += n;
            }
        }
        return new String(cs);
    }
}
