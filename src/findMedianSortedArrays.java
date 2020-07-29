public class findMedianSortedArrays {
    public static void main(String[] args) {
        int[] n1 = {1,3,4,9};
        int[] n2 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(findMedianSortedArrays(n1,n2));
    }
    static double findMedianSortedArrays(int[] a, int[] b) {
        int l1 = a.length;
        int l2 = b.length;
        if(l1>l2) {// make a.length always not bigger than b
            int[] temp  = a;
            a = b;
            b = temp;
            l1 = a.length;
            l2 = b.length;
        }
        if((l1+l2)%2==1) {
            return (double) (findKthSortedArrays(a,b,(l1+l2+1)/2));
        }
        else {
            int ret1 = findKthSortedArrays(a, b, (l1+l2)/2);
            int ret2 = findKthSortedArrays(a, b, (l1+l2)/2 +1);
            return (ret1+ret2)/2.0;
        }
    }
    static int findKthSortedArrays(int[] a, int[] b, int k) {
        if(a.length==0) return b[k-1];
        if(b.length==0) return a[k-1];
        int cut = k/2;
        if(k==1) return Math.min(a[0], b[0]);
        if(cut>=a.length) {
            if(a[a.length-1]<=b[a.length-1]){
                int[] aa = new int[0];
                return findKthSortedArrays(aa, b, k-a.length);
            }
            else {
                int[] bb = new int[b.length-a.length];
                for(int i=0;i<b.length-a.length;++i) bb[i] = b[i+a.length];
                if(bb.length>=a.length) return findKthSortedArrays(a,bb, k-a.length);
                else return findKthSortedArrays(bb,a,k-a.length);
            }
        }
        if(a[cut-1]<=b[cut-1]) {
            int[] aa = new int[a.length-cut];
            for(int i=0;i<a.length-cut;++i) aa[i] = a[i+cut];
            return findKthSortedArrays(aa, b, k-cut);
        }
        else  {
            int[] bb = new int[b.length-cut];
            for(int i=0;i<b.length-cut;++i) bb[i] = b[i+cut];
            if(bb.length>=a.length) return findKthSortedArrays(a,bb, k-cut);
            else return findKthSortedArrays(bb,a,k-cut);
        }
    }
}
