public class climbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }
    static int climbStairs(int n) {
        // write your code here
        if(n==0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;++i) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
