package gelato.leet0;

public class intToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int th = num / 1000;
        for(int i = 0; i < th; i++) sb.append("M");

        int h = (num % 1000) / 100;
        process(sb, h, 'C', 'D', 'M');

        int t = (num % 100) / 10;
        process(sb, t, 'X', 'L', 'C');

        int o = num % 10;
        process(sb, o, 'I', 'V','X');
        return sb.toString();
    }

    private void process(StringBuilder sb, int cnt,  char u, char fi, char nxt){
        if(cnt <= 3){
            for(int i = 0; i < cnt; i++) sb.append(u);
        }else if(cnt == 4){
            sb.append(u);
            sb.append(fi);
        }else if(cnt <= 8){
            sb.append(fi);
            for(int i = 6; i <= cnt; i++){
                sb.append(u);
            }
        }else {
            sb.append(u);
            sb.append(nxt);
        }
    }
}
