import java.util.Arrays;
import java.util.Map;

public class threesumclosest {
    public static void main(String[] args) {
        int[] n = new int[] {-1,2,1,-4};
        System.out.println(threeSumClosest(n,1));
    }
    static int threeSumClosest(int[] nums, int target) {
        // write your code here
        Arrays.sort(nums);
        if(nums.length<=2) return Integer.MIN_VALUE;
        int minDis = Integer.MAX_VALUE;
        int ret = nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++) {
            int j=1+i, k=nums.length-1;
            while(j<k) {
                int sum = nums[i] +nums[j]+nums[k];
                if(sum==target) return sum;
                else if(sum<target) {
                    if(minDis>target-sum) {
                        minDis = target-sum;
                        ret = sum;
                    }
                    j++;
                }
                else {
                    if(minDis>sum-target) {
                        minDis = sum-target;
                        ret = sum;
                    }
                    k--;
                }
            }
        }
        return ret;
    }
}
