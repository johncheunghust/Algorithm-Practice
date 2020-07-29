import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    public static  void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    static List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        String s = "";
        if(n==0) return l;
        dfs(n*2, 0, 0, 0, l, s);
        return l;

    }
    static void dfs(int len, int nl, int nr, int idx, List<String> l, String s) {
        if(idx==len) {
            l.add(new String(s));
            return ;
        }
        if(nl<len/2) {
            s+="(";
            dfs(len, nl+1, nr, idx+1, l, s);
            s= s.substring(0, idx);

        }
        if(nl>nr) {
            s+=")";
            dfs(len, nl, nr+1, idx+1, l, s);
            s= s.substring(0, idx);
        }
    }
}
