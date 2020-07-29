public class InversePairs {
    public  static void main(String[] args) {
        int[] n = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(n));
    }

    static int InversePairs(int [] array) {
        if(array.length==0||array.length==1) return 0;
        return mergeSort(array, 0, array.length-1);

    }
    static int mergeSort(int[]nums, int l, int r) {
        if(l<r) {
            int mid = (l+r)/2;
            int t1 = mergeSort(nums, l, mid);
            int t2 = mergeSort(nums, mid+1, r);
            int t3 = merge(nums, l, mid, r);
            return (t1+t2+t3)%1000000007;
        }
        return 0;
    }
    static int merge(int[] nums, int l, int mid, int r) {
        int i = l,  j = mid+1;
        int[] tmp = new int[r-l+1];
        int revPair = 0;
        int k=0;
        while(i<=mid&&j<=r) {
            if(nums[i]<=nums[j]) {
                tmp[k] = nums[i++];
            }
            else {
                tmp[k] = nums[j++];
                revPair+= (mid-i+1);
            }
            k++;
        }
        while(i<=mid) tmp[k++] = nums[i++];
        while(j<=r) {
            tmp[k++] = nums[j++];
        }
        for(int a=0, b=l;a<r-l+1; ++a, ++b) {
            nums[b] = tmp[a];
        }
        return revPair;
    }
}
