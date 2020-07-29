import java.util.Map;

public class findMin {
    public static void main(String[] args) {
        int[] a= {1, 2, 4, 5, 6, 7, 0 };
        System.out.println(findMin(a));

    }
    static int findMin(int[] nums) {
        // write your code here
        if(nums.length==0) return Integer.MIN_VALUE;
        int l = 0, r = nums.length-1;
        while(l<r-1) {
            int m = (l+r)/2;
            if(nums[m]>nums[r]) {
                l=m;
            }
            else if(nums[m]<nums[l]) {
                r=m;
            }
            else return nums[l];
        }
        return Math.min(nums[l],nums[r]);
    }
}
