public class binarySearch {
    public static void main(String[] args) {
        int[] n = { 1, 2, 3, 3, 4, 5, 10};
        System.out.println(binarySearch(n,6));
    }
    static int binarySearch(int[] nums, int target) {
        // write your code here
        if(nums.length==0) return -1;
        int l = 0, r = nums.length-1;
        while(l<r-1) {
            int m = (l+r)/2;
            if(nums[m]==target) r = m;
            else if(nums[m]>target) r=m-1;
            else l=m+1;
        }
        if(nums[l]==target) return l;
        else if(nums[r] == target)return r;
        else return -1;
    }

}
