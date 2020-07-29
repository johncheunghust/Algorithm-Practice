public class minimumTotal {
    public static void main(String[] args) {
        int[][] ret = {{2},
                      {3,4},
                     {6,5,7},
                    {4,1,8,3}};
        System.out.println(minimumTotal(ret));
    }
    static int minimumTotal(int[][] triangle) {
        // write your code here
        if(triangle.length==1) return triangle[0][0];
        int[] sum = new int[triangle.length];
        for(int i=0;i<triangle.length;++i) sum[i]=triangle[triangle.length-1][i];
        for(int i = triangle.length-2;i>=0;i--) {
            for(int j=0;j<=i;++j) {
                sum[j] = Math.min(sum[j]+triangle[i][j], sum[j+1]+triangle[i][j]);
            }
        }
        return sum[0];
    }
}
