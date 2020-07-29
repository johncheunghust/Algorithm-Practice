public class searchInRotated {
    public static void main(String[] args) {
        int[]a = {5,1,2,3,4};
        System.out.println(search(a, 4));
    }
    static int search(int[] nums, int target) {
        int len = nums.length;
        if(len==0) return -1;
        if(len==1) return nums[0]==target?0:-1;
        if(nums[0]<nums[len-1]) return binarySearch(nums, 0, len-1, target);
        int minidx = findMinidx(nums);
        if(target<nums[minidx]||target>nums[minidx-1]) return -1;
        if(target>nums[len-1]) return binarySearch(nums, 0, minidx-1, target);
        else return binarySearch(nums, minidx, len-1, target);
    }

    static int binarySearch(int[] nums, int l, int r, int target) {
        while(l<=r) {
            int mid = (l+r)/2;
            if(nums[mid]==target) {
                return mid;
            }
            else if(nums[mid]>target) {
                r = mid-1;
            }
            else l = mid+1;
        }
        return -1;
    }

    static int findMinidx(int[] nums) {
        int l= 0 , r = nums.length-1;
        int lmin = nums[0], rmin = nums[r];
        if(nums.length==2) return 1;
        while(l<=r) {
            int len = (l+r)/2;
            int p = nums[len];
            if(len==0) return 1;
            if(p<nums[len-1]) {
                return len;
            }
            else if(p>rmin) {
                l = len+1;
            }
            else r = len-1;
        }
        return -1;
    }
}
