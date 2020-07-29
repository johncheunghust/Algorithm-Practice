import java.math.BigInteger;

public class Unique_Paths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(17,18));
    }
    static int uniquePaths(int m, int n) {
        // write your code here
        if(n==1||m==1) return 1;
        else return combination(Math.min(m-1, n-1), m+n-2);
    }
    static int combination(int n, int sum) {
        BigInteger fz = new BigInteger("1");
        for(int i=sum; i>sum-n; --i) {
            fz = fz.multiply(BigInteger.valueOf(i));
        }
        BigInteger fm = new BigInteger("1");
        for(int i=n;i>0;--i) {
            fm = fm.multiply(BigInteger.valueOf(i));
        }
        return fz.divide(fm).intValue();
    }
}
