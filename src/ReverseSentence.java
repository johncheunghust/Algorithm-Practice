public class ReverseSentence {
    public static void main(String[] args) {
        String str = "I am a student.";
        System.out.println(ReverseSentence(str));
    }
    static String ReverseSentence(String str) {
        char[] cs = new StringBuffer(str).reverse().toString().toCharArray();
        int len = cs.length;
        int last = 0;
        for(int i=0; i<len; ++i) {
            if(cs[i]==' ') {
                reverse(cs, last, i-1);
                last = i+1;
            }
        }
        reverse(cs, last, len-1);
        return String.valueOf(cs);
    }
    static void reverse(char[] cs, int l, int r) {
        while(l<r) {
            char t = cs[l];
            cs[l] = cs[r];
            cs[r] = t;
            l++;
            r--;
        }
    }
}

