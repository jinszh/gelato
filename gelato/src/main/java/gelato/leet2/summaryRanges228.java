package gelato.leet2;

import java.util.ArrayList;
import java.util.List;

//228
public class summaryRanges228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        int be = nums[0];
        int nxt = be;
        for(int i =1; i < nums.length; i++){
            nxt++;
            if(nums[i] != nxt){
                res.add(nxt - be > 1 ? String.format("%d->%d", be, nxt - 1) : Integer.toString(be));
                be = nums[i];
                nxt = be + 1;
            }else{
                nxt = nums[i];
            }
        }
        res.add(nxt - be > 1 ? String.format("%d->%d", be, nxt - 1) : Integer.toString(be));
        return res;
    }

    //不用每步都判断
    public List<String> summaryRanges_faster(int[] nums) {
        List<String> list=new ArrayList();
        if(nums.length==1){
            list.add(nums[0]+"");
            return list;
        }
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
                i++;
            }
            if(a!=nums[i]){
                list.add(a+"->"+nums[i]);
            }else{
                list.add(a+"");
            }
        }
        return list;
    }
}
