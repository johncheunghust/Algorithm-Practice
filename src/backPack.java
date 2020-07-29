public class backPack {
    public static void main(String[] args) {
        int[] a = {3,4,8,5};
        System.out.println(backPack(10,a));
    }
    static int backPack(int m, int[] A) {
        // write your code here
        int[][] dp = new int[A.length][m+1];
        for(int i=0; i<A.length;++i) dp[i][0] = 0;
        for(int i=0;i<=m;++i) dp[0][i] = A[0]>i?0:A[0];
        for(int i=1;i<A.length;++i) {
            for(int j=1;j<=m;++j) {
                dp[i][j] = dp[i-1][j];
                if(A[i]>j) continue;
                if(dp[i-1][j-A[i]]+A[i]>=dp[i][j]) dp[i][j] = dp[i-1][j-A[i]]+A[i];
            }
        }
        return dp[A.length-1][m];
    }
}
