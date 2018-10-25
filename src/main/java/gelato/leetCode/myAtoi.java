package gelato.leetCode;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class myAtoi {
    public int myAtoi(String str) {
        Long v = 0L;
        Matcher matcher = (Pattern.compile("[\\+-]?[0-9]+(\\s|.)")).matcher(str.trim() + " ");
        String numStr = matcher.find() ? (matcher.start() == 0 ? matcher.group(0) : "0") : "0";
        try {
            v = Long.valueOf(numStr.substring(0, numStr.length() - 1));
        } catch (NumberFormatException e) {
            if(numStr.length() > String.valueOf(Integer.MIN_VALUE).length()){
                v = (long)(numStr.startsWith("-") ? Integer.MIN_VALUE : Integer.MAX_VALUE);
            }
        }
        return v > Integer.MAX_VALUE ? Integer.MAX_VALUE : (v < Integer.MIN_VALUE ? Integer.MIN_VALUE : v.intValue());
    }
}
