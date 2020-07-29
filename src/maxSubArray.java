public class maxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 2, -3, 4, -1, 2, 1, -5, 3};
        System.out.println(maxSubArray(nums));
    }
     static int maxSubArray(int[] nums) {
        // write your code here
        if(nums.length==0) return 0;
        int sum=0, max = Integer.MIN_VALUE, minSum = 0;
        for(int i=0; i<nums.length; ++i) {
            sum+=nums[i];
            max = Math.max(max, sum-minSum);
            minSum= Math.min(sum, minSum);
        }
        return max;
    }
}
