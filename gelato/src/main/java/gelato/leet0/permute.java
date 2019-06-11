package gelato.leet0;

import java.util.*;
import java.util.stream.Collectors;

//46
public class permute {
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        List<List<Integer>> res = new ArrayList<>();
        help(new LinkedList<>(), res, set);
        return res;
    }

    private void help(LinkedList<Integer> cur, List<List<Integer>> res, Set<Integer> set){
        List<Integer> toAdd = new ArrayList<>(set); //每次递归都复制一次set肯定不如检查...
        for(Integer i : toAdd){
            cur.add(i);
            set.remove(i);
            if(set.isEmpty()){
                res.add(new ArrayList<>(cur));
            }else {
                help(cur, res, set);
            }
            set.add(i);
            cur.removeLast();
        }
    }

    //快很多的方法 - 不需要set
    public List<List<Integer>> permute_faster(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip - 检查一下比用set快很多的
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
