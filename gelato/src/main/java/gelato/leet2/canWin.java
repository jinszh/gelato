package gelato.leet2;

public class canWin {
    public boolean canWin(String s) {
        return win(s);
    }

    private boolean win(String s){
        int idx = s.indexOf("++");
        if(idx < 0){
            return false;
        }else {
            boolean res = false;
            char [] chars = s.toCharArray();
            while (idx >= 0 && idx < s.length()) {
                chars[idx] = chars[idx + 1] = '-';
                if(!win(new String(chars))){
                    res = true;
                    break;
                }
                chars[idx] = chars[idx + 1] = '+';
                idx = s.indexOf("++", idx + 1);
            }
            return res;
        }
    }
}
