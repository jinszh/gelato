package gelato.leet1;

//186
public class reverseWords2 {
    //need in place change
    public void reverseWords(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r){
           char swap = s[l];
           s[l] = s[r];
           s[r] = swap;
           l++;
           r--;
        }
        for(int i = 0; i <= s.length; i++){
            l = r = i;
            while (s[r] != ' ' && r < s.length)r++;
            i = r;
            while (l < r - 1){
                char swap = s[l];
                s[l] = s[r - 1];
                s[r - 1] = swap;
                l++;
                r--;
            }
        }
    }
}
