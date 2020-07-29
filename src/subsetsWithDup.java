import java.util.ArrayList;
import java.util.List;

public class subsetsWithDup {
    public static void main(String[] args) {
        int[] n ={1, 2, 2};
        System.out.println(subsetsWithDup(n));
    }
    static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        dfs(nums, temp, ret, 0);
        return ret;
    }
    static void dfs(int[] nums, List<Integer> temp, List<List<Integer>> ret, int start) {
        int len = nums.length;
        if(start==len) {
            ret.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<len; ++i) {
            int cur = nums  [i];
            if(i>start&&nums[i-1]==cur) continue;
            temp.add(cur);
            dfs(nums, temp, ret, start+1);
            temp.remove(temp.size()-1);
        }

    }
}
