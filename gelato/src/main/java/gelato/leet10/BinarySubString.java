package gelato.leet10;

import java.lang.reflect.Array;
import java.util.Arrays;

//1016
public class BinarySubString {
    public boolean queryString(String S, int N) {
        String cur = "0";
        int curV = 0;

        while (curV <= N) {
            if (!S.contains(cur)) {
                break;
            }
            int id = cur.lastIndexOf("0");
            if (id >= 0) {
                char[] charArr = cur.toCharArray();
                charArr[id] = '1';
                Arrays.fill(charArr, id + 1, charArr.length, '0');
                cur = new String(charArr);
            } else {
                char[] charArr = new char[cur.length()];
                Arrays.fill(charArr, '0');
                cur = "1" + new String(charArr);
            }
            curV++;
        }
        return curV > N;
    }
}
