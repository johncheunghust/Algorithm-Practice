public class canJump {
    public static void main(String[] args) {
        int[] a = {2,1,0,2,3,2,8,5,7,10,9,9,6,6,3,4,2,9,9,0};
        System.out.println(canJump_DP(a));
    }
    static boolean canJump(int[] A) {
        // write your code here
        int len = A.length;
        int i=0;
        while(i!=A.length-1) {
            if(A[i]>=A.length-i-1) return true;
            if(A[i]==0) break;
            int ret = A[i];
            while(A[i+ret]==0) {
                ret--;
                if(ret==0) return false;
            }
            i+=ret;
        }
        return i==A.length-1?true:false;
    }
    static boolean canJump_DP(int[] A) {
        // write your code here
        boolean[] dp = new boolean[A.length];
        dp[0] = true;
        for(int i=1;i<dp.length;++i) {
            for(int j=i-1;j>=0;--j) {
                if(dp[j]==true&&A[j]>=i-j) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[A.length-1];
    }

}
