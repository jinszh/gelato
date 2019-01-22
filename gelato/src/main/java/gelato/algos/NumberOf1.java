package gelato.algos;
//求2进制中1个数，不论正负
public class NumberOf1 {
    //原码:true code, 反码:complement code, 补码:one's complement code（+1补码）2's complement code同理+2补码.
    public int NumberOf1(int n) {
        int flag = 1;
        int count = 0;
        while(flag != 0){
            if((flag & n) != 0){ // 注意4&5=4
                count++;
            }
            flag <<= 1;
        }
        System.out.println(count);
        return count;
    }
}
