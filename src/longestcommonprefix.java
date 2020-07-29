import java.util.Map;

public class longestcommonprefix {
    public static void main(String[] args) {
        String []s1 = new String[] {};
        System.out.println(longestCommonPrefix(s1));
    }
    static String longestCommonPrefix(String[] strs) {
        // write your code here
        int len = strs.length;
        if(len==0) return new String("");
        int prelen = dc(strs, 0, len-1);
        return strs[0].substring(0,prelen);
    }

    static int dc(String[] strs, int l, int r) {
        if(l==r) return strs[l].length();
        else if(l==r-1) return cmpstrpre(strs[l],strs[r]);
        else {
            int r1 = dc(strs, l, (l+r)/2);
            int r2 = dc(strs, (l+r)/2, r);
            return Math.min(r1, r2);
        }
    }

    static int cmpstrpre(String a, String b) {
        int i=0;
        for(i=0;i<Math.min(a.length(), b.length());++i) {
            if(a.charAt(i)==b.charAt(i)) continue;
            else return i;
        }
        return i;
    }
}
