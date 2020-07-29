import java.util.Arrays;

public class searchRange {
    public static void main(String[] args) {
        int[] a = {0,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,4,10,10,10,10,10,10,10,10,10,10,10,10,10,20,20,101,202,304,509,10001};
        System.out.println(Arrays.toString(searchRange(a,10)));
    }

    static int[] searchRange(int[] A, int target) {
        // write your code here
        if(A==null||A.length==0) return new int[] {-1, -1};
        int l=0, r = A.length-1;
        int [] ret = new int[2];
        //first find left bound
        boolean flag = false;
        while(l<r-1) {
            int m = l + (r-l)/2;
            if(A[m]==target&&A[m-1]<target) {
                ret[0] = m;
                flag = true;
                break;
            }
            else if(A[m]==target) r = m-1;
            else if(A[m]>target) r = m-1;
            else if(A[m]<target) l = m+1;
        }
        if(!flag) {
            if(A[l]==A[r]&&A[r]==target) ret[0] = l;
            else if(A[r]==target) ret[0] = r;
            else if(A[l]==target) ret[0] = l;
            else {
                ret[0] = ret[1] = -1;
                return ret;
            }
        }
        l = ret[0];
        r = A.length-1;
        while(l<r-1) {
            int m = l + (r-l)/2;
            if(A[m]==target&&A[m+1]>target) {
                ret[1] = m;
                return ret;
            }
            else if(A[m]==target) l=m+1;
            else if(A[m]<target) l=m+1;
            else r = m-1;
        }
        if(A[l]==A[r]&&A[r]==target) ret[1] = r;
        else ret[1] = l;
        return ret;
    }
}
