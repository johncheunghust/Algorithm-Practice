import java.util.ArrayList;
import java.util.List;

public class restoreIpAddresses {
    public static void main(String[] args) {
        String s = "010010";
        System.out.println(restoreIpAddresses(s));
    }
    static List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        String t = "";
        dfs(s, ret, t, 0);
        List<String> n = new ArrayList<>();
        for(String ss: ret) n.add(ss.substring(1, ss.length()));
        return n;
    }
    static void dfs(String s, List<String> ret, String t, int count) {
        int len = s.length();
        if(len==0&&count==4) {
            ret.add(new String(t));
            return ;
        }
        else if(len==0||count==4) return;
        for(int i=1;i<4;++i) {
            if(i>len) break;
            String ss = s.substring(0,i);
            if(ss.charAt(0)=='0'&&ss.length()>1) break;
            int curV = Integer.parseInt(s.substring(0,i));
            if(curV>=0&&curV<=255) {
                String last = t;
                t+= "."+s.substring(0,i);
                dfs(s.substring(i, s.length()), ret, t, count+1);
                t = last;
            }
        }
    }
}
