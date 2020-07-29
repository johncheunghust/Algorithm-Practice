public class kmp {
    public static void main(String[] args) {
        String a = "source";
        String b = "target";
        Solution s1 = new Solution();
        System.out.println(s1.strStr(a,b));
    }
    static int KMP(String a, String b) {
        int i=0,j=0;
        char[] t = a.toCharArray();
        char[] p = b.toCharArray();
        int[] next = new int[b.length()+1];
        getNext(b,next);
        while(i<a.length()&&j<b.length()) {
            if(j==-1||t[i]==p[j]) {
                ++i;
                ++j;
            }
            else j = next[j];
        }
        if(j==b.length()) return i-j;
        else return -1;
    }
    static void getNext(String b, int[] next) {
        next[0]=-1;
        int i=0,j=-1;
        char[] p = b.toCharArray();
        while(i<p.length) {
            if(j==-1||p[i]==p[j]) {
                ++i;
                ++j;
                next[i] = j;
            }
            else j=next[j];
        }
    }
}
 class Solution {
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here
        return KMP(source, target);
    }
    int KMP(String source, String target) {
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        
        int i=0,j=0;
        int[] next = new int[t.length+1];
        getNext(target, next);
        while(i<s.length&&j<t.length) {
            if(j==-1||s[i]==t[j]) {
                ++i;
                ++j;
            }
            else j=next[j];
        }
        if(j==t.length) return i-j;
        else return -1;
    }
    void getNext(String target, int[] next) {
        char[] t = target.toCharArray();
        next[0] = -1;
        int i = 0, j = -1;
        while(i<t.length) {
            if(j==-1||t[i]==t[j]) {
                ++i;++j;
                next[i]=j;
            }
            else j=next[j];
        }
    }
}