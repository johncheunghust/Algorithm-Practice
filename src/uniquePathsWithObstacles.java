public class uniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] og = {{0,0}, {0,0}, {0,0}, {1, 0}, {0,0}};
        System.out.println(uniquePathsWithObstacles(og));
    }
    static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if(obstacleGrid.length==0) return 0;
        int a = obstacleGrid[0].length;
        int b = obstacleGrid.length;
        int[][] dp = new int[b][a];
        int ob1;
        for( ob1=0;ob1<a;++ob1) {
            if(obstacleGrid[0][ob1]==1) break;
        }
        for(int i=0;i<Math.min(ob1, a);++i) dp[0][i]=1;
        int ob2;
        for(ob2=0;ob2<b;++ob2) {
            if(obstacleGrid[ob2][0]==1) break;
        }
        for(int i=0;i<Math.min(ob2,b);++i) dp[i][0]=1;
        for(int i=1;i<a;++i) {
            for(int j=1;j<b;++j) {
                if(obstacleGrid[j][i]==1) dp[j][i]=0;
                else dp[j][i] = dp[j-1][i] + dp[j][i-1];
            }
        }
        return dp[b-1][a-1];
    }
}
