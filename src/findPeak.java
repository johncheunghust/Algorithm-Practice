public class findPeak {
    static public void main(String[ ] args) {
        int[] a = {1,2,3,4,1};
        long l=1,r=Integer.MAX_VALUE;
        int m= (int)((l+r)/2);
        System.out.println(m);
    }
    static int findPeak(int[] A) {
        // write your code here
        if(A.length==3) return 1;
        int l = 0, r = A.length-1;
        while(l<r-1) {
            int m = (l+r)/2;
            if(A[m]>A[m-1]&&A[m]>A[m+1]) return m;
            else if(A[m]<A[m-1]) r=m;
            else l=m;
        }
        return -1;
    }
}
