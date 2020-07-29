import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class simplifyPath {
    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        System.out.println(simplifyPath(path));
    }
    static String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for(int i=1; i<path.length(); ++i) {
            if(path.charAt(i)=='/'&&path.charAt(i-1)=='/') continue;
            sb.append(path.charAt(i));
        }
        if(sb.charAt(sb.length()-1)=='/') sb.delete(sb.length()-1, sb.length());
        //delete the form redundancy
        List<String> l = new ArrayList<>();
        int i=0, j=1;
        while(i<sb.length()&&j<sb.length()) {
            if(sb.charAt(i)=='/') {
                j=i+1;
                while(j<sb.length()) {
                    if(sb.charAt(j)!='/') j++;
                    else break;
                }
               l.add(sb.substring(i+1, j));
            }
            i=j;
        }

        Iterator<String> iter = l.iterator();
        while(iter.hasNext()) {
            String t = iter.next();
            if(t.equals(".")) iter.remove();
        }
        boolean[] delete = new boolean[l.size()];
        int count=0;
        for(int a=l.size()-1; a>=0; --a) {
            if(l.get(a).equals("..")) {
                delete[a]=true;
                count++;
            }
            else if(count>0) {
                delete[a] = true;
                count--;
            }
        }
        List<String> ret = new ArrayList<>();
        for(i=0; i<l.size(); ++i) {
            if(!delete[i]) ret.add(l.get(i));
        }
        StringBuilder r = new StringBuilder();
        r.append('/');
        if(ret.size()==0) return r.toString();
        for(i=0; i<ret.size(); ++i) {
            r.append(ret.get(i));
            r.append('/');
        }
        r.delete(r.length()-1, r.length());
        return r.toString();


    }
}
