public class myPow {
    public static void main(String[] args) {
        System.out.println(myPow(2.0, -2147483648));
    }
    static double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        if(n>0) {
            return myPowPos(x,(long) n);
        }

        else {
            double t = myPowPos(x,(long) n*(-1));
            return 1/t;
        }
    }
    static private double myPowPos(double x, long n) {
        int i=1;
        boolean[] b = new boolean[33];
        for(int j=1; j<33;++j) {
            if((i & n) !=0) b[j]=true;
            i<<=1;
        }
        double base = 1;
        double ret=1;
        for(i=0;i<33;++i) {
            if(b[i]) ret*=base;
            if(i==0) base*=x;
            else base*=base;
        }
        return ret;
    }
}
