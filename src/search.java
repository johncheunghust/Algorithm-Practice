public class search {
    static public void main(String[] args) {
        int [] a = {1,2,3,4,5,9};
        System.out.println(search(a,9));
    }

    static int search(int[] A, int target) {
        // write your code here
        if(A==null||A.length==0) return -1;
        if(A.length==1) return A[0]==target?0:-1;
        int maxidx = findMaxPos(A);
        //find the partition position
        if(maxidx==A.length-1) return findPos(A,0,A.length-1, target);
        else if(A[A.length-1]>=target) return findPos(A, maxidx+1, A.length-1, target);
        else return findPos(A,0, maxidx, target);
    }
    static int findPos(int[] a, int l, int r, int t) {
        int i=l, j = r;
        while(i<j) {
            int m = i+(j-i)/2;
            if(a[m]==t) return m;
            else if(a[m]>t) j=m-1;
            else i=m+1;
        }
        if(a[i]==t) return i;
        else return -1;
    }
    static int findMaxPos(int[] a) {
        int l=0, r=a.length-1;
        while(l<r-1) {
            int m = l+(r-l)/2;
            if(a[m]>a[m+1]) return m;
            else if(a[m]<a[m+1]&&a[m]>a[l]) l=m+1;
            else r = m-1;
        }
        return a[l]>a[r]?l:r;
    }

}
