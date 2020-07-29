public class isMatch {
    public static void main(String[] args) {
        String s = "bb";
        String p = ".ba";
//        System.out.println(s.substring(1,1));
        System.out.println(isMatchDP(s,p));
    }
    static boolean isMatch(String s, String p) {
        int l1 = s.length();
        int l2 = p.length();
        if(l1==0&&l2!=0) {
            if(l2==1) return false;
            if(p.charAt(1)=='*') return isMatch(s,p.substring(2,l2));
            else return false;
        }
        if(l1!=0&&l2==0) return false;
        if(l1==0&&l2==0) return true;
        int i=0,j=0;
            if(p.charAt(j)=='.') {
                int k=j+1;
                if(k==l2) {
                    if(i+1==l1) return true;
                    else return false;
                }
                else if(p.charAt(k)>='a'&&p.charAt(k)<='z' || p.charAt(k)=='.') {
                    return isMatch(s.substring(i+1,l1), p.substring(k,l2));
                }
                else {//followed by '*'
                    for(int a=i; a<=l1;++a) {
                        if(isMatch(s.substring(a,l1), p.substring(k+1, l2))) return true;
                    }
                    return false;
                }
            }

            else if(p.charAt(j)>='a'&&p.charAt(j)<='z') {
                int k=j+1;
                if(k==l2) {
                    if(p.charAt(j)==s.charAt(i)&&i+1==l1) return true;
                }
                else if(p.charAt(k)>='a'&&p.charAt(k)<='z' || p.charAt(k)=='.') {
                    if(p.charAt(j)==s.charAt(i)) {
                        return isMatch(s.substring(i+1,l1), p.substring(k,l2));
                    }
                    else return false;
                }
                else {//followed by '*'
                    if(p.charAt(j)!=s.charAt(i)) return isMatch(s, p.substring(k+1, l2));
                    else {
                        int l = i+1;
                        for(;l<l1;l++) if(s.charAt(l)!=s.charAt(l-1)) break;
                        for(int a=i; a<=l;++a) {
                            if(isMatch(s.substring(a,l1), p.substring(k+1, l2))) return true;
                        }
                        return false;
                    }
                }
            }
        return false;
    }

    static boolean isMatchDP(String s, String p) {
        int m = s.length(), n = p.length();
        char[] sc = s.toCharArray(), pc = p.toCharArray();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 2; i <= n; i++){
            if(pc[i - 1] == '*'){
                dp[0][i] = dp[0][i - 2]; // *可以消掉c*
            }
        }

        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j++){
                if(sc[i - 1] == pc[j - 1] || pc[j - 1] == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(pc[j - 1] == '*'){
                    if(sc[i - 1] == pc[j - 2] || pc[j - 2] == '.'){
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                        // 当*的前一位是'.'， 或者前一位的pc等于sc的话，
                        // *代表1个(dp[i][j - 1])，*代表多个(dp[i - 1][j])，或者用*消掉c*(dp[i][j - 2])
                    } else {
                        dp[i][j] = dp[i][j - 2]; // 用*消掉c*
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }
}
