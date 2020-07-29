import java.util.ArrayList;
import java.util.List;

public class minSubArray {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(-1);
        l.add(-2);
        l.add(1);
        l.add(-4);
        System.out.println(minSubArray(l));
    }
    static int minSubArray(List<Integer> nums) {
        // write your code here
        List<Integer> newNums = new ArrayList<>();
        if(nums.size()==1) return nums.get(0);
        int sum = 0, min = nums.get(0), maxSum = 0;
        for(int i=0;i<nums.size();++i) {
            sum+=nums.get(i);
            min = Math.min(min, sum-maxSum);
            maxSum = Math.max(maxSum, sum);
        }
        return min;
    }
}
