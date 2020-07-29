public class DeleteDigits {
    public static void main(String[] args) {
        String a = "191817161514";
        int k = 9;
        System.out.println(DeleteDigits(a,k));
    }

    static String DeleteDigits(String A, int k) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        for(int i=0;i<k;++i) {
            int j = 0;
            for(;j<sb.length()-1&&(sb.charAt(j)<=sb.charAt(j+1)||sb.charAt(j)=='0');++j) {}
            sb.delete(j,j+1);
        }
        for(int i=0;i<sb.length()&&sb.charAt(i)=='0';) sb.delete(0,1);
        return sb.toString();
    }
}
