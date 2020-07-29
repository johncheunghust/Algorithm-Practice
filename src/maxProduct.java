public class maxProduct {
    public static void main(String[] args) {
        int[] a = {-1, 99};
        System.out.println(maxProduct(a));

    }
    static int maxProduct(int[] nums) {
        // write your code here
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        int mx;
        mx = dp1[0]=dp2[0]=nums[0];

        for(int i=1;i<nums.length;++i) {
            dp1[i] = dp2[i] = nums[i];
            if(nums[i]>0) {
                dp1[i] = Math.max(dp1[i], dp1[i-1] *nums[i]);
                dp2[i] = Math.min(dp2[i], dp2[i-1] * nums[i]);
            }
            else if(nums[i]<0) {
                dp1[i] = Math.max(dp1[i], dp2[i-1]*nums[i]);
                dp2[i] = Math.min(dp2[i], dp1[i-1]*nums[i]);
            }
            mx = Math.max(mx, dp1[i]);
        }
        return mx;
    }
}
