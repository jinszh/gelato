package gelato.leet2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//241
public class diffWaysToCompute {
    //Simple recursive - 算各种括号的情况, 关键不要去想哪个是最先做的, 要想哪个是最后做的
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        int size = input.length();
        for (int i = 0; i < size; i++) {
            char cur = input.charAt(i);
            if (cur == '+' || cur == '-' || cur == '*') {
                // Split input string into two parts and solve them recursively
                List<Integer>  result1 = diffWaysToCompute(input.substring(0, i));
                List<Integer>  result2 = diffWaysToCompute(input.substring(i+1));
                for (Integer n1 : result1) {
                    for (Integer n2 : result2) {
                        if (cur == '+')
                            result.add(n1 + n2);
                        else if (cur == '-')
                            result.add(n1 - n2);
                        else
                            result.add(n1 * n2);
                    }
                }
            }
        }
        // if the input string contains only number
        if (result.isEmpty())
            result.add(Integer.parseInt(input));
        return result;
    }

}
