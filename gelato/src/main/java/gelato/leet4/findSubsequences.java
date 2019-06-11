package gelato.leet4;

import java.util.*;
import java.util.stream.Collectors;

//491
public class findSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>>[] res = new ArrayList[nums.length];
        Set<String> codes = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            res[i] = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    String code1 = nums[j] + " " + nums[i] + " ";
                    if(!codes.contains(code1)){
                        res[i].add(Arrays.asList(nums[j], nums[i]));
                        codes.add(code1);
                    }
                    if (res[j] != null && res[j].size() > 0) {
                        for(List<Integer> l : res[j]) {
                            List<Integer> lc = l.stream().collect(Collectors.toList());
                            lc.add(nums[i]);
                            String code = lc.stream().map(e -> (e.toString()+" ")).collect(Collectors.joining());
                            if(!codes.contains(code)){
                                res[i].add(lc);
                                codes.add(code);
                            }
                        }
                    }
                }
            }
        }
        return Arrays.asList(res).stream().flatMap(List::stream).collect(Collectors.toList());
    }

    //Optimization - 直接用dfs, 用hashCode记一下就可以了 更快
    public List<List<Integer>> findSubsequences_op(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(new LinkedList<Integer>(), 0, nums, res);
        return res;
    }
    private void helper(LinkedList<Integer> list, int index, int[] nums, List<List<Integer>> res){
        if(list.size()>1) res.add(new LinkedList<Integer>(list));
        Set<Integer> used = new HashSet<>();
        for(int i = index; i<nums.length; i++){
            if(used.contains(nums[i])) continue;
            if(list.size()==0 || nums[i]>=list.peekLast()){
                used.add(nums[i]);
                list.add(nums[i]);
                helper(list, i+1, nums, res);
                list.remove(list.size()-1);
            }
        }
    }
}
