public class longestCommonSubsequence {
    public static void main(String[] args) {
        String a = "ABCD";
        String b = "EACB";
        System.out.println(longestCommonSubsequence(a,b));
    }
    static int longestCommonSubsequence(String a, String b) {
        // write your code here
        int l1 = a.length();
        int l2 = b.length();
        int[][] dp = new int[l1+1][l2+1];
        for(int i=0;i<=l1;++i) dp[i][0] = 0;
        for(int i=0;i<=l2;++i) dp[0][i] = 0;
        for(int i=1;i<=l1;++i) {
            for(int j=1;j<=l2;++j) {
                if(a.charAt(i-1)==b.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[l1][l2];
    }
}
