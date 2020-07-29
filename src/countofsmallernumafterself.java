import java.util.ArrayList;
import java.util.List;
//return the last
public class countofsmallernumafterself {
    private int[] count;
    public List<Integer> countSmaller(int[] nums) {
        int[] count = new int[nums.length];
        int[] ht_pos = new int[nums.length];//initial pos hash to modified pos
        for(int i=0;i<nums.length;++i) {
            ht_pos[i] = i;
        }
        count = new int[nums.length-1];
        mymergesort(nums, 0, nums.length-1, ht_pos);
        List<Integer> l1= new ArrayList<Integer>();
        for(int i:ht_pos) {
            l1.add(i);
        }
        return l1;
    }
    private void mymergesort(int[]nums, int l, int r, int[] ht_pos) {
        if(l<r) {
            int mid = (l+r)/2;
            mymergesort(nums,l,mid, ht_pos);
            mymergesort(nums,mid+1, r, ht_pos);
            merge(nums,l, mid, r, ht_pos);
        }
    }
    private void merge(int[] nums, int l, int mid, int r, int[] ht_pos) {
        int n1 = mid-l+1;
        int n2 = r-mid;
        int i=l, j=mid+1;
        int[] sorted_ht_pos = new int[r-l+1];
        int k=0;
        int right_count=0;
        while(i<=mid&&j<=r) {
            if(nums[ht_pos[i]]>nums[ht_pos[j]]) {
                ++right_count;
                sorted_ht_pos[k++] = ht_pos[j++];
            }
            else {
                count[ht_pos[i]]+=right_count;
                sorted_ht_pos[k++] = ht_pos[i++];
            }
        }
        while(i<=mid) {
            count[ht_pos[i]]+=right_count;
            sorted_ht_pos[k++] = ht_pos[i++];
        }
        while(j<=r) {
            sorted_ht_pos[k++] = ht_pos[i++];
        }
        for(int m = l, n = 0;m<=r;++n,++m) {
            ht_pos[m]=sorted_ht_pos[n];
        }
    }


}
