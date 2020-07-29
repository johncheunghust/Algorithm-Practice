import java.util.ArrayList;
import java.util.Arrays;

public class printMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1}};
        System.out.println(printMatrix(matrix));
    }
    static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        int right = matrix[0].length-1;
        int down = matrix.length-1;
        int left=0,up=0;
        while(true) {
            for(int i=left;i<=right;++i)
                ret.add(matrix[up][i]);
            up++;
            if(up>down) break;
            for(int i=up;i<=down;++i)
                ret.add(matrix[i][right]);
            right--;
            if(left>right) break;
            for(int i=right;i>=left;--i)
                ret.add(matrix[down][i]);
            down--;
            if(up>down) break;
            for(int i=down;i>=up;--i) {
                ret.add(matrix[i][left]);
            }
            left++;
            if(left>right) break;
        }

        return ret;
    }
}
