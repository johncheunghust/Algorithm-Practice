public class uniquePathsIII {
    public static void main(String[] args) {
        uniquePathsIII_impl a = new uniquePathsIII_impl();
        int[][] t= {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        System.out.println(a.uniquePathsIII(t));
    }
}

class uniquePathsIII_impl{
    int[] loopx = {0, 1, 0, -1};
    int[] loopy = {1, 0, -1 ,0};
     int sum;
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int x=0, y=0;
        int todo=0;
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                if(grid[i][j]==1) {x=i;y=j;}
                else if(grid[i][j]==0) todo++;
            }
        }
        dfs(grid, x, y, todo);
        return sum;
    }
    void dfs(int[][] grid, int i, int j, int todo) {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length) return;
        if(todo==0&&grid[i][j]==2) sum++;
        if(grid[i][j]==-1) return;
        for(int k=0; k<4; ++k) {
            int x=i+loopx[k];
            int y=j+loopy[k];
            int t = grid[i][j];
            grid[i][j]=-1;
            if(t!=1) {
                todo--;
                dfs(grid, x, y, todo);
                grid[i][j]=t;
                todo++;
            }
            else {
                dfs(grid, x, y, todo);
                grid[i][j]=t;
            }
        }
    }
}
