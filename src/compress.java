public class compress {
    public static void main(String[] args) {
        char[] t= {'a','a','a','b','b','a','a'};
        System.out.println(compress(t));
    }

    static int compress(char[] chars) {
        int len = chars.length;
        int i=0, j=0;

        while(j<len) {
            char t = chars[j];
            int r = j;
            while(j<len&&chars[j]==t) j++;

            if(j-r>1) {
                chars[i++] = t;
                i = addNum(chars, i, j-r);
            }
            else {
                chars[i++] = t;
            }
        }
        return i;
    }
    static int addNum(char[] chars, int start, int dif) {
        int base=1;
        int len=0;
        while(dif/base!=0) {
            base*=10;
            len++;
        }
        char[] cur = new char[len];
        for(int i=len-1; i>=0; i--) {
            int t = dif%10;
            cur[i] = (char) (t+'0');
            dif/=10;
        }
        for(int i=start; i<start+len; ++i) {
            chars[i] = cur[i-start];
        }
        return start+len;
    }
}
