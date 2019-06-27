package gelato.leet1;

//151
public class reverseWords {
    public String reverseWords(String s) {
        if(s == null || s == "") return "";
        s = s.trim();
        String [] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--){
            sb.append(words[i] + " ");
        }
        return sb.toString().trim();
    }
}
