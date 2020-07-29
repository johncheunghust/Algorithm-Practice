import java.util.*;

public class permuteUnique {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(permuteUnique(nums).toString());
    }
     static List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Set<List<Integer>> s = new HashSet<>();
        boolean[] vst = new boolean[nums.length];
        helper(nums, ret, temp, s, vst);
        return ret;
    }
     static void helper(int[] nums, List<List<Integer>> ret, List<Integer> temp, Set s, boolean[] vst) {
        if(temp.size()==nums.length) {
            if(!s.contains(temp)) {
                ret.add(new ArrayList<>(temp));
                s.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i=0;i<nums.length;++i) {
            if(vst[i]==false) {
                temp.add(nums[i]);
                vst[i] = true;
                helper(nums, ret, temp, s, vst);
                temp.remove(temp.size() - 1);
                vst[i] = false;
            }
        }
    }
}
