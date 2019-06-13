package gelato.leet10;

//1055
public class shortestWay {
    public int shortestWay(String source, String target) {
        int n = 0;
        boolean isSub = true;
        for (int i = 0, j = 0; i < target.length(); i++) {
            int jStart = j;
            while (true) {
                int curj = j;
                if (j == source.length() - 1) {
                    n++;
                    j = 0;
                }else {
                    j++;
                }
                if(source.charAt(curj) == target.charAt(i)) {
                    break;
                }else if (j == jStart) {
                    isSub = false;
                    break;
                }
            }
            if (!isSub) {
                break;
            }
        }
        if (isSub) {
            return n;
        } else {
            return -1;
        }
    }
}
