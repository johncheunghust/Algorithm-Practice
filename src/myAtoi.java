public class myAtoi {
    public static void main(String[] args) {
        String s = "-91283472332";
        System.out.println(myAtoi(s));
    }
    static int myAtoi(String str) {
        if(str==null||str.length()==0) return 0;
        char[] cs = str.toCharArray();
        int firstidx = 0;
        for(;firstidx<cs.length;++firstidx) {
            if(cs[firstidx]!=' ') break;
        }
        if(firstidx>=cs.length) return 0;
        if(cs[firstidx]!='+'&&cs[firstidx]!='-'&&cs[firstidx]<'0'&&cs[firstidx]>'9') return 0;
        int meta = cs[firstidx]=='-' ?-1:1;
        int start = 0;
        if(cs[firstidx]=='+'||cs[firstidx]=='-') start = firstidx+1;
        else start = firstidx;
        long ret = 0;
        for(int i=start;i<cs.length;i++) {
            if(cs[i]<'0'||cs[i]>'9') break;
            ret*=10;
            ret+=(cs[i]-'0');
            if(ret*meta>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if(ret*meta<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int)ret*meta;

    }
}
