import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class combinationSum {
    public static void main(String[] args) {
        int[] can = {8,7,4,3};
        System.out.println(combinationSum(can,11).toString());
    }
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        HashMap<List<Integer>, Integer> hm = new HashMap();
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        int sz = candidates.length;
        if(sz==0) return ret;
        Arrays.sort(candidates);
        helper(candidates, target, ret, solution, 0, 0, hm);
        return ret;
    }
    static void helper(int[] candidates, int target, List<List<Integer>> ret, List<Integer> solution, int start, int sum,
                       HashMap hm) {
        if(sum==target) {
            if(!hm.containsKey(solution)) {
                ret.add(new ArrayList<>(solution));
                hm.put(solution,1);
            }
            return;
        }
        if(sum>target) return;
        for(int i=start; i<candidates.length; ++i) {
            solution.add(candidates[i]);
            helper(candidates, target, ret, solution, i, sum+candidates[i], hm);
            solution.remove(solution.size()-1);
        }
    }
}
