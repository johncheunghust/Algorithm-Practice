public class longestcommonsubstr {
    public static void main(String[] args) {
        String a = "abc";
        String b = "a";
        System.out.println(longestCommonSubstring(a, b));;
    }
    static int longestCommonSubstring(String A, String B) {
        // write your code here
        int l1 = A.length();
        int l2 = B.length();
        int[][] dp = new int[l1+1][l2+1];
        int res = 0;
        for(int i=0; i<=l1; ++i) {
            for(int j=0; j<=l2; ++j) {
                if(i==0||j==0) dp[i][j]=0;
                else if(A.charAt(i-1)==B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(dp[i][j], res);
                }
                else dp[i][j] = 0;
            }
        }
        return res;
    }
}
