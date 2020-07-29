import java.util.ArrayList;
import java.util.Arrays;

public class nextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int[] t= nextPermutation(nums);
        System.out.println(Arrays.toString(t));
    }

    static int[] nextPermutation(int[] nums) {
        // write your code here
        if(nums.length<=1) return nums;
        for(int i=nums.length-1; i>=1; --i) {
            if(nums[i]>nums[i-1]) {
                rearrange(nums, i, nums.length-1);
                int ins = nums[i-1];
                for(int j=i;j<nums.length;++j) {
                    if(nums[j]>ins) {
                        swap(nums,i-1,j);
                        break;
                    }
                }
                break;
            }
            if(i==1) rearrange(nums, 0, nums.length-1);
        }
        return nums;
    }
    static void rearrange(int[] nums, int l, int r) {
        int i=l,j=r;
        for(;i<j;++i,--j) swap(nums, i, j);
    }
    static void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}
