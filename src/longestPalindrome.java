public class longestPalindrome {
    public static void main(String[] args) {
        String a = "babad";
        System.out.println(longestPalindrome(a));
    }
    static String longestPalindrome(String s) {
        if(s.length()==0||s.length()==1) return s;
        String ret = s.substring(0,1);
        for(int i=1;i<s.length();++i) {
            String t = roundScanI(s, i);
            if(t.length()>ret.length()) ret = t;
        }
        for(int i=0;i<s.length()-1;++i) {
            if(s.charAt(i)==s.charAt(i+1)) {
                String t = roundScanII(s, i);
                if(t.length()>ret.length()) ret = t;
            }
        }
        return ret;
    }
    static String roundScanI(String s, int idx) {
        int l=idx-1,r = idx+1;
        while(l>=0&&r<s.length()) {
            if(s.charAt(l)==s.charAt(r)) {
                l--;
                r++;
            }
            else break;
        }
        return s.substring(++l, r);
    }
    static String roundScanII(String s, int idx) {
        int l = idx-1, r = idx+2;
        while(l>=0&&r<s.length()) {
            if(s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            else break;
        }
        return s.substring(++l, r);
    }

}
