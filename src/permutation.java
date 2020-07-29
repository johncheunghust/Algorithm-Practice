import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class permutation {
    public static void main(String[] args) {
        solu s = new solu();
        String ss = new String("aab");
        System.out.println(s.Permutation(ss));
    }
}

class solu {
    public ArrayList<String> Permutation(String str) {
        int len = str.length();
        ArrayList<String> ret = new ArrayList<>();
        String sb = new String();
        char[] cs = str.toCharArray();
        boolean[] chosen = new boolean[52];
        Set<String> s = new HashSet<>();
        if(str.length()==0||str==null) return ret;
        backtracking(cs, len, chosen, ret, sb, s);
        return ret;
    }
    static void backtracking(char[] cs, int len, boolean[] chosen, ArrayList<String> ret, String sb, Set<String> s) {
        if(sb.length()==len) {
            if(s.contains(sb)) return;
            ret.add(sb);
            s.add(sb);
            return;
        }

        for(int i=0;i<cs.length; ++i) {
            if(chosen[i]==true) continue;
            chosen[i] = true;
            sb +=Character.toString(cs[i]);
            backtracking(cs, len, chosen, ret, sb, s);
            chosen[i] = false;
            sb = sb.substring(0, sb.length()-1);
        }
    }
}