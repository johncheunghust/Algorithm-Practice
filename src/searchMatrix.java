public class searchMatrix {
    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(m,0));
    }
    static boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        int row = findrow(matrix, target, 0, m-1);
        return findv(matrix[row], target,0,n-1);
    }
    static boolean findv(int[] row, int target, int l, int r) {
        if(l<r) {
            int m = (l+r)/2;
            if(row[m]==target) return true;
            else if(row[m]>target) return findv(row, target,0,m-1);
            else return findv(row, target,m+1,r);
        }
        if(row[l]==target) return true;
        else return false;

    }

    static int findrow(int[][] mat, int t, int top, int bottom) {
        if(top<bottom) {
            int m = (top+bottom)/2;
            if(mat[m][0]<=t&&mat[m+1][0]>t||mat[m][0]<=t&&m==bottom) return m;
            else if(mat[m][0]<t) return findrow(mat, t, m+1,bottom);
            else return findrow(mat,t,top,m-1);
        }
        return top;
    }
}
