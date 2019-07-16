package gelato.leet8;

import java.util.ArrayList;
import java.util.List;

//816
public class ambiguousCoordinates {
    //Two dimensional
    public List<String> ambiguousCoordinates(String S) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        dfs(S.substring(1, S.length() - 1), 0, res, sb, false, true);
        return res;
    }

    private void dfs(String S, int cur, List<String> res, StringBuilder sb, boolean is2d, boolean lead) {
        if (cur == S.length() - 1) {
            if (!is2d) return;
            sb.append(S.charAt(cur) + ")");
            res.add(sb.toString());
            sb.delete(sb.length() - 2, sb.length()); // check how to use this
        } else {
            sb.append(S.charAt(cur));
            if (!is2d) {
                sb.append(", ");
                dfs(S, cur + 1, res, sb, true, true);
                sb.delete(sb.length() - 2, sb.length());
            }

            sb.append(".");
            for (int i = cur + 1; i < S.length(); i++) {
                sb.append(S.charAt(i));
                if (S.charAt(i) != '0') {
                    if (i == S.length() - 1) {
                        if (is2d) {
                            sb.append(")");
                            res.add(sb.toString());
                            sb.delete(sb.length() - 1, sb.length());
                        }
                    } else if (!is2d) {
                        sb.append(", ");
                        dfs(S, i + 1, res, sb, true, true);
                        sb.delete(sb.length() - 2, sb.length());
                    }
                }
            }
            sb.delete(sb.length() - (S.length() - cur), sb.length());
            if (S.charAt(cur) != '0' || !lead) {
                dfs(S, cur + 1, res, sb, is2d, false);
            }
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
