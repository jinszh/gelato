package gelato.leet10;

public class baseNeg2 {
    public String baseNeg2(int N) {
        int convert = N;
        int base2 = 2;
        while (base2 > 0) {
            if ((convert & base2) > 0) {
                convert += (base2 << 1);
            }
            base2 <<= 2;
        }

        String str = convert > 0 ? "" : "0";
        while (convert > 0) {
            if ((convert & 1) > 0) {
                str = "1" + str;
            } else {
                str = "0" + str;
            }
            convert >>= 1;
        }
        return str;
    }
}
