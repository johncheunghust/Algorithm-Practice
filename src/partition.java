import java.util.Arrays;

public class partition {
    public static void main(String[] args) {
        int[] n = {9,9,9,8,9,8,7,9,8,8,8,9,8,9,8,8,6,9};
        System.out.println(partitionArray(n,9));
        System.out.println(Arrays.toString(n));
    }
    static int partitionArray(int[] nums, int k) {
        // write your code here
        if(nums.length==0) return 0;
        int min = 0x7fffffff;
        int idx = 0;
        int ii;
        boolean flag = false;
        for(ii=0; ii<nums.length; ++ii) {
            if(nums[ii]-k>=0&&nums[ii]-k<min) {
                idx = ii;
                min = nums[ii]-k;
                flag = true;
            }
        }
        if(!flag) return nums.length;
//        System.out.println(idx);
//        System.out.println(nums[idx]);
        swap(nums, idx, nums.length-1);
        int p = nums[nums.length-1];
        int i = -1;
        for(int j=0; j< nums.length; ++j) {
            if(nums[j]<p) {
                swap(nums,j,++i);
            }
        }
        swap(nums,++i, nums.length-1);
        return i;
    }
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
