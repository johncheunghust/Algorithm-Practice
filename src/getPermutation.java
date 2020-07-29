import java.util.ArrayList;
import java.util.List;

public class getPermutation {
    public static void main(String[] args) {
        System.out.println(getPermutation(9,1000));
    }
    static String getPermutation(int n, int k) {
        List<String> ret = new ArrayList<>();
        boolean[] is = new boolean[n+1];
        StringBuilder s = new StringBuilder();
        dfs(n, ret, s, is);
        return ret.get(k-1);
    }
    static void dfs(int n, List<String> ret, StringBuilder s, boolean[] is) {
        if(s.length()==n) {
            ret.add(s.toString());
            return;
        }
        for(int i=1; i<=n; ++i) {
            if(is[i]) continue;
            s.append(i);
            is[i]=true;
            dfs(n, ret, s, is);
            is[i] = false;
            s.delete(s.length()-1,s.length());
        }

    }
}
