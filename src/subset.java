import java.util.*;

public class subset {
    public  static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsets(nums).toString());

    }
    static List<List<Integer>> subsets(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        Set<List<Integer>> s= new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        helper(nums, ret, temp, 0,  s);
        return  ret;
    }
    static void helper(int[] nums, List<List<Integer>> ret, List<Integer> temp, int start, Set<List<Integer>> s) {
        if(start==nums.length) {
            if(!s.contains(temp)) {
                ret.add(new ArrayList<>(temp));
                s.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(nums[start]);
        helper(nums, ret, temp, start+1, s);
        temp.remove(temp.size()-1);
        helper(nums, ret, temp, start+1, s);
    }

}
