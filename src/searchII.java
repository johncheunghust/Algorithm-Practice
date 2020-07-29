public class searchII {
    public static void main(String[] args) {
        int[] a = {1,3,1,1,1};
        System.out.println(search(a, 3));
    }
    static boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l<=r) {
            int mid = (l+r)/2;
            int t = nums[mid];
            if(t==target) return true;
            if(t>nums[l]||t>nums[r]) {
                if(t>target&&nums[l]<=target) {
                    r = mid-1;
                }
                else l = mid+1;
            }
            else if(t<nums[l]||t<nums[r]) {
                if(t<target&&nums[r]>=target) l = mid+1;
                else r = mid-1;
            }
            else l++;
        }
        return false;
    }
}
