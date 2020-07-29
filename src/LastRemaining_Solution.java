public class LastRemaining_Solution {
    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5,3));
    }
    static int LastRemaining_Solution(int n, int m) {
        int[] a = new int[n];
        int start = 0;
        for(int i=0;i<n-1;++i) {
            int j=0;
            while(true) {
                if(a[start]==0) {
                    j++;
                    start = (start+1)%n;
                }
                else start = (start+1)%n;
                if(j==m) {
                    a[(start-1+n)%n] = 1;

                    break;
                }
            }
        }
        for(int i=0; i<n; ++i) {
            if(a[i]==0) return i;
        }
        return -1;
    }
}
