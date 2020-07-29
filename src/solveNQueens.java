import java.util.*;

class location{
    int i;
    int j;
    location(int i, int j) {
        this.i = i;
        this.j = j;
    }
        }

public class solveNQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(6).toString());

    }
    static List<List<String>> solveNQueens(int n) {
        // write your code here
        int[][] matrix = new int[n][n];
        List<int[][]> ret = new ArrayList<>();
        List<location> l = new ArrayList<>();
        HashMap<List<Integer>, Integer> m = new HashMap<>();

        helper(n, matrix, ret, 0, l, m);

        return transfer(ret, n);
    }
    //transfer matrix to standard
    static List<List<String>> transfer(List<int[][]> input, int n) {
        List<List<String>> ret = new ArrayList<>();
        for(int[][] i:input) {
            List<String> temp = new ArrayList<>();
            for(int j=0;j<n;++j) {
                StringBuilder sb = new StringBuilder();
                for(int k=0;k<n;++k) {
                    if(i[j][k]==0) sb.append('.');
                    else sb.append('Q');
                }
                temp.add(sb.toString());
            }
            ret.add(temp);
        }
        return ret;
    }

    static void helper(int n, int[][] matrix, List<int[][]> set, int hasPutNum, List l, HashMap m) {
        if(hasPutNum==n) {
            List<Integer> tmp = new ArrayList<>();

            int[][] a= new int[n][n];
            for(int i=0;i<n;++i) {
                for(int j=0;j<n;++j) {
                    if(matrix[i][j]==1) tmp.add(j);
                    a[i][j] = matrix[i][j];
                }
            }
            if(m.containsKey(tmp)) return;
            set.add(a);
            m.put(tmp, 1);
            return;
        }
        for(int i=0;i<n;++i) {
            for(int j=0;j<n;++j) {
                if(isGood(n, l, i, j)) {
                    l.add(new location(i,j));
                    matrix[i][j]=1;
                    helper(n, matrix, set, hasPutNum+1, l, m);
                    matrix[i][j]=0;
                    l.remove(l.size()-1);
                }
            }
        }
    }

    static boolean isGood(int n, List<location> l, int i, int j) {
        for(location site: l) {
            if(site.i==i||site.j==j||(site.i+j==site.j+i)||(site.i+site.j==i+j)) return false;
        }
        return true;
    }
}
