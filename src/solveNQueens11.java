import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solveNQueens11 {
    public static void main(String[] args) {
        System.out.println(solveNQueens(8).toString());
    }
    static List<List<String>> solveNQueens(int n) {
        List<Integer> rows = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        helper(n, rows, ret);
        return draw(ret, n);
    }

    static List<List<String>> draw(List<List<Integer>> ret, int n) {
        List<List<String>> last = new ArrayList<>();
        for(List<Integer> l: ret) {
            List<String> lsb = new ArrayList<>();
            for(int i: l) {
                char[] c = new char[n];
                Arrays.fill(c,'.');
                c[i] = 'Q';
                lsb.add(String.valueOf(c));
            }
            last.add(lsb);
        }
        return last;
    }

    static void helper(int n, List<Integer> rows, List<List<Integer>> ret) {
        if(rows.size()==n) {
            ret.add(new ArrayList<>(rows));
            return;
        }
        for(int i=0;i<n;++i) {
            if(isGood(n, rows, i)) {
                rows.add(i);
                helper(n, rows, ret);
                rows.remove(rows.size()-1);
            }
        }
    }
    static boolean isGood(int n, List<Integer> rows, int j) {
        int r = rows.size();
        for(int a=0;a<rows.size(); ++a) {
            int i = rows.get(a);
            if(i==j||a+j==r+i||r+j==a+i) return false;
        }
        return true;
    }
}
