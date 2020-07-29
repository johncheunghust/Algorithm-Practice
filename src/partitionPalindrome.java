import java.util.ArrayList;
import java.util.List;

public class partitionPalindrome {
    public static void main(String[] args) {
        String s = "";
        partition(s);
    }
    static List<List<String>> partition(String s) {
        List<String> l = new ArrayList<>();
        List<List<String>> ret = new ArrayList<>();
        if(s.length()==0) return ret;
        dfs(s, 0, l, ret);
        return ret;
    }
    static void dfs(String s, int start, List<String> l, List<List<String>> ret) {
        if(start==s.length()) {
            ret.add(new ArrayList<>(l));
            return;
        }
        for(int i=start+1; i<=s.length(); ++i) {
            String t = s.substring(start, i);
            if(judge(t)) {
                l.add(t);
                dfs(s, i, l, ret);
                l.remove(l.size()-1);
            }
        }
    }

    static boolean judge(String s) {
        int i =0, j = s.length()-1;
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}
