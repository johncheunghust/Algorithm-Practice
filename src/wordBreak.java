import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak {
    public static void main(String[] args) {
        String s = "a";
        Set<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("lint");
        dict.add("code");
        System.out.println(wordBreak(s,dict));
    }
    static boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if(s.length()==0||s.length()==1&&dict.contains(s)) return true;
        Set<Boolean> st = new HashSet<>();
        backtracking(s,dict,st);
        return st.contains(true)?true:false;
    }
    static void backtracking(String s, Set<String> dict, Set<Boolean> st) {
        if(dict.contains(s)||s.equals("")) {
            st.add(true);
        }
        for(int i=1;i<=s.length();++i) {
            if(dict.contains(s.substring(0, i))) {
                backtracking(s.substring(i, s.length()), dict, st);
            }
        }
    }
}
