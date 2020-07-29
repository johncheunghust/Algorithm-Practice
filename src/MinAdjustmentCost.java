import java.util.ArrayList;
import java.util.List;

public class MinAdjustmentCost {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(4);
        l.add(2);
        l.add(3);
        System.out.println(MinAdjustmentCost(l, 1));

    }
    static int MinAdjustmentCost(List<Integer> A, int target) {
        // write your code here
        int mx = 0;
        for(Integer a: A) mx=Math.max(mx, a);
        int[][] dp = new int[A.size()][mx+1];//the min cost when ith element turns to j
        for(int i=1;i<=mx;i++) dp[0][i] = Math.abs(A.get(0)-i);
        for(int i=1;i<A.size();++i) {
            for(int j=1;j<=mx;++j) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=Math.max(1, j-target); k<=Math.min(mx, j+target);k++) {
                    dp[i][j] = Math.min(dp[i-1][k] + Math.abs(A.get(i) - j), dp[i][j]);
                }
            }
        }
        int ret = Integer.MAX_VALUE;
        for(int i=1;i<=mx;++i) ret = Math.min(ret, dp[A.size()-1][i]);
        return ret;
    }
}
