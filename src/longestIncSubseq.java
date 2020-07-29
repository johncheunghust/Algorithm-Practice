import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class longestIncSubseq {
    public static void main(String[] args) {
        int[] nums = {4,2,4,5,3,7};
        System.out.println(longestIncreasingSubsequence(nums));
    }
    static int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        //O(n^2) solution
        if(nums.length==0) return 0;
        List<Integer> piles = new ArrayList<>();
        piles.add(nums[0]);
        int len = 1;
        for(int i=1;i<nums.length;++i) {
            int cur = nums[i];
            int idx = Collections.binarySearch(piles, cur);
            if(idx<0) idx = ~idx;
            if(idx==len) {
                piles.add(cur);
                len++;
            }
            else piles.set(idx, cur);
        }
        return len;
    }
}