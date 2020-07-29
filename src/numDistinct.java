public class numDistinct {
    public static void main(String[] args) {
        String a = "rabbbit";
        String b = "rabbit";
        System.out.println(numDistinct(a,b));
    }
    static int numDistinct(String S, String T) {
        // write your code here
        if(T.length()==0||T==null) return 1;
        if(S.length()==0||S==null) return 0;
        int l1 = S.length();
        int l2 = T.length();
        int[][] dp = new int[l1+1][l2+1];
        for(int i=0;i<=l2;++i) dp[0][i] = 0;
        for(int i=0;i<=l1;++i) dp[i][0] = 1;
        for(int i=1;i<=l1;++i) {
            for(int j=1;j<=l2;++j) {
                if(S.charAt(i-1)==T.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[l1][l2];
    }
}
