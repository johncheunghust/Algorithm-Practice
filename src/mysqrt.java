public class mysqrt {
    public static void main(String[] args) {
        System.out.println( mySqrt(2147395599));
    }
    static int mySqrt(int x) {
        if(x==0) return 0;
        if(x<3) return 1;
        int up=x;
        int down=0;
        while(up>down) {
            long t = (up+down)>>1;
            if(t*t==x) return (int)t;
            else if(t*t<x&&(t+1)*(t+1)>x) return(int) t;
            else if(t*t<x) down=(int)t;
            else up=(int) t;
        }
        return down;
    }
}
