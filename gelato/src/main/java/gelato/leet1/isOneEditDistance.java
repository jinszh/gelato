package gelato.leet1;

//161
public class isOneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if( Math.abs(s.length() - t.length()) > 1){
            return false;
        }
        for(int i = 0; i < s.length() && i < t.length(); i++){
            if(s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if (s.length() > t.length()) {
                    return s.substring(i + 1).equals(t.substring(i));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return s.length() != t.length();
    }
}
