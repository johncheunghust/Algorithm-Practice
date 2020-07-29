public class minSubArrayLen {
    public static void main(String[] args) {
        int[] n = {1,1};
        System.out.println(minSubArrayLen(7, n));
    }
    static int minSubArrayLen(int s, int[] nums) {
        int l=0, r=0;
        int len = nums.length;
        if(len==0) return 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
//        int t=0;
//        for(Integer i: nums) t+=i;
//        if(t<s) return 0;
        while(l<=r&&r<len) {
            while(r<len&&sum<s) {
                sum+=nums[r];
                r++;
            }
            if(sum>=s) minLen = Math.min(r-l, minLen);
            else break;
            while(l<=r&&sum>=s) {
                sum-=nums[l];
                l++;
            }
            minLen = Math.min(r-l+1, minLen);
        }
        if(minLen==Integer.MAX_VALUE) return 0;
        return minLen;
    }
}
