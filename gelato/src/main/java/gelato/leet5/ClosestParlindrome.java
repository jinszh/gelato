package gelato.leet5;

public class ClosestParlindrome {
    public String nearestPalindromic(String n) {
        char[] arr = new char[n.length()];
        boolean isSelf = true;
        int i, j, last = 0;
        for (i = 0, j = n.length() - 1; j >= i; i++, j--) {
            if (n.charAt(i) != n.charAt(j)) {
                isSelf = false;
            }
            arr[i] = arr[j] = n.charAt(i);
            last = j;
        }
        Long v = Long.parseLong(n);
        Long vn = Long.parseLong(new String(arr));

        //Compare sub and plus
        int cur = arr[last] - '0';
        char curp = (char) ((cur == 9 ? 8 : cur + 1) + '0');
        char curs = (char) ((cur == 0 ? 1 : cur - 1) + '0');
        if (n.length() % 2 == 1) {
            arr[last] = curp;
        } else {
            arr[last - 1] = arr[last] = curp;
        }
        Long vPlus = Long.parseLong(new String(arr));
        if (n.length() % 2 == 1) {
            arr[last] = curs;
        } else {
            arr[last - 1] = arr[last] = curs;
        }
        Long vSub = Long.parseLong(new String(arr));
        if (isSelf || Math.abs(v - vn) > Math.abs(v - vSub) || Math.abs(v - vn) > Math.abs(v - vPlus)) {
            vn = Math.abs(v - vSub) <= Math.abs(v - vPlus) ? vSub : vPlus;
        }else if(Math.abs(v - vn) == Math.abs(v - vSub)){
            vn = Math.min(vn, vSub);
        }

        //Compare with "9..9" and "10...01"
        if (n.length() > 1) {
            char[] lower = new char[n.length() - 1];
            char[] higher = new char[n.length() + 1];
            higher[0] = higher[n.length()] = '1';
            for (int k = 0; k < lower.length; k++) {
                lower[k] = '9';
                higher[k + 1] = '0';
            }

            Long vl = Long.parseLong(new String(lower));
            Long vh = Long.parseLong(new String(higher));
            if (Math.abs(v - vn) < Math.abs(v - vl) && Math.abs(v - vn) < Math.abs(v - vh)) {
                return vn.toString();
            } else {
                return Math.abs(v - vh) < Math.abs(v - vl) ? new String(higher) : new String(lower);
            }
        } else {
            return vn.toString();
        }
    }
}
