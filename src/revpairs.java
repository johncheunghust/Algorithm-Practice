import java.util.ArrayList;
import java.util.List;

public class revpairs {
    public static void main(String[] args) {
//        int[] test1 = new int[] {4,3,2,1};
//        System.out.println(reversePairs(test1));
    }


    static long reversePairs(int[] A) {
        // write your code here
        return calrp(A, 0, A.length-1);
    }

    static long calrp(int[] a, int l, int r) {
        if(l<r) {
            int mid = (r+l)/2;
            long num1 = calrp(a, l, mid);
            long num2 = calrp(a, mid+1, r);
            long num3 = calmergerp(a, l, mid, r);
            return num1+num2+num3;
        }
        else return 0;
    }

    static long calmergerp(int[] a,int l, int mid, int r) {
        int n1 = mid-l+1;
        int n2 = r-mid;
        long num=0;
        for(int i=0;i<n1;++i) {
            for(int j=0;j<n2;++j) {
                if(a[l+i]>a[mid+j+1]) ++num;
            }
        }
        return num;
    }
}
