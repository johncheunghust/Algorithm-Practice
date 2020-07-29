public class generateMatrix {
    public static void main(String[] args) {
        generateMatrix(1);
    }
    static int[][] generateMatrix(int n) {
        int t = 0, b = n-1, l = 0, r = n-1;
        int[][] ret = new int[n][n];
        if(n==0) return ret;
        int count=1;
        while(t<=b&&l<=r&&count<=n*n) {
            for(int i=l; i<=r; ++i) {
                ret[t][i] = count++;
            }
            if(++t>b) break;
            for(int i=t; i<=b;++i) {
                ret[i][r] = count++;
            }
            if(--r<l) break;
            for(int i=r;i>=l;--i) {
                ret[b][i] = count++;
            }
            if(--b<t) break;
            for(int i=b;i>=t;--i) {
                ret[i][l] = count++;
            }
            if(++l>r) break;
        }
        return ret;
    }
}
