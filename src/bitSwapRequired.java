public class bitSwapRequired {
    public  static void main(String[] args) {
        int n = -521;
        int m = 0;
        System.out.println(numTrees(0));
    }

    static int bitSwapRequired(int a, int b) {
        // write your code here
        int t = a^b;
        int cmp = Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<32;++i) {
            if((t&cmp)==cmp) ++count;
            t<<=1;
        }
        return count;
    }

    static boolean checkPowerOf2(int n) {
        // write your code here
        if(n<=0) return false;
        return (n&(n-1))==0;

//        if(n==1) return true;
//        if((n>>>31&1)==1||(n&1)==1) return false;
//        int count = 0;
//        for(int i=0;i<30;++i) {
//            if((n&2)==2) ++count;
//            n>>>=1;
//        }
//        if(count==1) return true;
//        else return false;
    }

    static long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        int count = 0;
        while(n>0) {
            count+=n/5;
            n/=5;
        }
        return count;
    }

    static int updateBits(int n, int m, int i, int j) {
        // write your code here
        int len = j-i+1;
        int a = 0;
        int c = m<<i;
        for(int z=0;z<len;++z) {
            int b = a<<1;
            a = b+1;
        }
        int tmp = a<<i;
        int t = tmp^-1;
        return (n&t)|c;
    }

    static int numTrees(int n) {
        // write your code here
        int[] count = new int[n+2];
        count[0] = 1;
        count[1] = 1;
        for(int i=2;i<n;++i) {
            for(int j=0;j<i;++j) {
                count[i]+=count[j]*count[i-j-1];
            }
        }
        return count[n];
    }

    int fastPower(int a, int b, int n) {
        // write your code here
        if(n==1) return a%b;
        else if(n==0) return 1%b;
        else {
            long product = fastPower(a,b,n/2);
            product = (product * product) %b;
            if(n%2==1) product = product *a %b;
            return (int) product;
        }
    }
}
