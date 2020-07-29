public class searchinsrt {
    public static void main(String[] args) {
        int[] a = {1,3,5,6,8,9};
        System.out.println(searchInsert(a,0));
    }
    static int searchInsert(int[] A, int target) {
        // write your code here
        if(A.length==0) return 0;
        return bs(A,0,A.length-1,target);
    }
    static int bs(int[] A, int l, int r, int target) {
        if(l<r) {
            int m = (l+r)/2;
            if(A[m]==target) return m;
            else if(A[m]<target&&A[m+1]>target) return m+1;
            else if(A[m]>target) return bs(A,l,m-1,target);
            else return bs(A,m+1,r,target);
        }
        else if(A[l]>=target) return l;
        else return l+1;
    }
}
