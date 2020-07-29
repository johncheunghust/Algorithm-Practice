public class multiply {
    public static void main(String[] args) {
        String num1 = "999", num2 = "999";
        System.out.println(multiply(num1, num2));
    }
    static String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length() ;
        if(num1.equals("0")||num2.equals("0")) return "0";
        char[] ret = new char[l1+l2];
        for(int i=0;i<l1+l2;++i) ret[i]='0';
        for(int i=l1-1; i>=0; --i) {
            for(int j=l2-1; j>=0; --j) {
                int multi = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int pos1 = i+j+1, pos2 = i+j;
                int o1 = ret[pos1]-'0', o2 = ret[pos2]-'0';
                int n1 = o1 + multi%10;
                ret[pos1] = (char)(n1%10+'0');
                ret[pos2] = (char)( o2 + multi/10 + n1/10 + '0');
            }
        }
        String r = String.valueOf(ret);
        if(r.charAt(0)=='0'&&r.length()!=1) r = r.substring(1,r.length());
        return r;
    }
}
