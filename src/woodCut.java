public class woodCut {
    public static void main(String[] args) {
        int[] l = {232,124,456
        };
        System.out.println(woodCut(l,7));
    }
    static int woodCut(int[] L, int k) {
        // write your code here
        long sum=0, max=0;
        sum = calsum(L);
        max = calmax(L);
        System.out.println(piecing(L,2));
        System.out.println(piecing(L,1));
        for(int i:L) {
            sum+=i;
            if(i>max) max = i;
        }
        if(sum<k) return 0;
        long l = 1, r = max;
        while(l<r-1) {
            long m = l+(r-l)/2;
            long p = piecing(L,m);
            if(p>=k&&piecing(L,m+1)<k) return (int)m;
            else if(p>=k) l = m+1;
            else if(p<k) r=m-1;
        }
        long lv = piecing(L,l);
        long rv = piecing(L,r);
        if(rv>=k) return (int)r;
        else  return (int)l;
    }
    static int calsum(int[] l ) {
        int sum=0;
        for(int i:l) sum+=i;
        return sum;
    }
    static int calmax(int[] l) {
        int max=0;
        for(int i:l) if(i>max) max =i;
        return max;
    }

    static long piecing(int[] l, long m) {
        int sum = 0;
        for(int i:l) sum += i/m;
        return sum;
    }
}
