public class isInterleave {
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        System.out.println(isInterleave(s1,s2,s3));
    }
    static boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        if(s3.equals("")) dp[0][0]=true;
        for(int i=1;i<=s1.length();++i) {
            if(s1.charAt(i-1)==s3.charAt(i-1)) dp[i][0] = true;
            else break;
        }
        for(int i=1;i<=s2.length();++i) {
            if(s2.charAt(i-1)==s3.charAt(i-1)) dp[0][i] = true;
            else break;
        }
        for(int i=1;i<=s1.length();++i) {
            for(int j=1;j<=s2.length();++j) {
                if(dp[i-1][j]==true&&s1.charAt(i-1)==s3.charAt(j+i-1)) dp[i][j]=true;
                if(dp[i][j-1]==true&&s2.charAt(j-1)==s3.charAt(i+j-1)) dp[i][j]=true;
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
