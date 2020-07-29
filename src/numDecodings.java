public class numDecodings {
    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
    }
    static int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        if(s.charAt(0)=='0') return 0;
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=s.length(); ++i) {
            if(s.charAt(i-1)=='0') {
                if(s.charAt(i-2)=='0'||s.charAt(i-2)>='3') {
                    return 0;
                }
                dp[i] = dp[i-2];
            }
            else if(s.charAt(i-1)>='7'&&s.charAt(i-2)>='2') dp[i] = dp[i-1];
            else {
                if(s.charAt(i-2)=='0'||s.charAt(i-2)>='3') dp[i] = dp[i-1];
                else dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
