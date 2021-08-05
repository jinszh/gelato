package gelato.leet3;

//338
public class countBits {
    public int[] countBits(int num) {
        int [] res = new int[num + 1];
        res[0] = 0;
        for(int i = 0; i <= num; i++){
//            if((i & 1) > 0){
//                res[i] = res[(i >> 1)] + 1;
//            }else {
//                res[i] = res[i >> 1];
//            }
            //下面这个更简洁
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
