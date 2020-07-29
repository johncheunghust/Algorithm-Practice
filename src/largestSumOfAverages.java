public class largestSumOfAverages {
    public static void main(String[] args) {
        int[] a = {9,1,2,3,9};
        int k = 3;
        System.out.println(largestSumOfAverages(a,k));
    }

    static double largestSumOfAverages(int[] A, int K) {
        int len = A.length;
        double[][] dp = new double[len+1][K+1];
        int[] sum = new int[len+1];
        for(int i=1; i<=len; ++i) {
            sum[i] = sum[i-1] + A[i-1];
            dp[i][1]= sum[i]/i;
        }
        for(int j=2;j<=K;++j) {
            for(int i=j; i<=len; ++i) {
                for(int k=j-1; k<i; ++k) {
                    dp[i][j] = Math.max(dp[i][j], dp[k][j-1] + (sum[i]-sum[k])/(i-k) );
                }
            }
        }
        double ret =dp[len][1];
        for(int i=2; i<=K; ++i) ret = Math.max(ret, dp[len][i]);
        return ret;
    }
}
