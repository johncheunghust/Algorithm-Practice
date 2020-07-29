import java.util.ArrayList;
import java.util.List;

public class permute {
    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(permute(nums).toString());
    }
    static List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<Integer> temp = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        List<List<Integer>> ret = new ArrayList<>();
        dfs(ret,temp, visit, nums);
        return ret;
    }
    static void dfs(List<List<Integer>> ret, List<Integer> temp, boolean[] visit, int[] nums) {
        if (temp.size() == nums.length) {
            ret.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;++i) {
            if(visit[i]==false) {
                temp.add(nums[i]);
                visit[i] = true;
                dfs(ret, temp, visit, nums);
                temp.remove(temp.size()-1);
                visit[i]=false;
            }
            else continue;
        }
    }
}
