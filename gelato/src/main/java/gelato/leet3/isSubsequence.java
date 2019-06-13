package gelato.leet3;

//392
public class isSubsequence {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            while (j < t.length() && t.charAt(j) != s.charAt(i)) j++;
            if(j == t.length())break;
            j++;
        }
        return j < t.length();
    }
}
