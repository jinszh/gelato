package gelato.leet0;

//55
public class canJump {
    public boolean canJump(int[] nums) { //不需要dp... 直接走就行
        int last = nums.length - 1;
        for(int i = nums.length - 2; i >=0; i--) {
            if(i + nums[i] >= last){
                last = i;
            }
        }
        return last == 0;
    }
}
