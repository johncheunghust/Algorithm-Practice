import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
    public static void main(String[] args) {
        String a = "";
        System.out.println(letterCombinations(a));
    }
    static List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<String> ret = new ArrayList<String>();
        String cur = "";
        char[][] c = {{'a','b','c'},{'d','e','f'},{'g','h','i'},
                {'j','k','l'},{'m','n','o'},{'p','q','r','s'},
                {'t','u','v'},{'w','x','y','z'}};
        if(digits.length()==0) return ret;
        dfs(digits, 0, ret, cur, c);
        return ret;
    }
    static void dfs(String digits, int idx, List<String> ret, String cur, char[][] c) {
        if(idx==digits.length()) {
            ret.add(new String(cur));
            return;
        }
        for(int i=0;i<c[digits.charAt(idx)-'2'].length;++i) {
            char a = c[digits.charAt(idx)-'2'][i];
            if(a>'z'||a<'a') break;
            cur+= String.valueOf(a);
            dfs(digits, idx+1, ret, cur, c);
            cur = cur.substring(0,idx);
        }
    }
}
