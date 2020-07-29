public class GetNumberOfK {
    public static void main(String[] args) {
        int[] a = {1,2,3,3,3,3,4,5};
        System.out.println(GetNumberOfK(a, 5));
    }

    static int GetNumberOfK(int [] array , int k) {
        if(array.length==0) return 0;
        int idx1=-1;
        int i=0;
        int l=0, r = array.length-1;
        while(l<=r) {
            int mid = (l+r)/2;
            int cur = array[mid];
            if(cur<k) {
                l=mid+1;
            }
            else if(cur>k) {
                r=mid-1;
            }
            else {
                if(mid==0||array[mid-1]<k) {
                    idx1 = mid;
                    break;
                }
                else r=mid;
            }
        }
        if(idx1==-1) return 0;
        l=0;
        r=array.length-1;
        int idx2= 0;
        while(l<=r) {
            int mid = (l+r)/2;
            int cur = array[mid];
            if(cur<k) {
                l=mid+1;
            }
            else if(cur>k) {
                r=mid-1;
            }
            else {
                if(mid==array.length-1||array[mid+1]>k) {
                    idx2 = mid;
                    break;
                }
                else l=mid;
            }
        }
        return idx2-idx1+1;

    }
}
