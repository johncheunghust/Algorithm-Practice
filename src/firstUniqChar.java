import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class firstUniqChar {
    public static void main(String[] args) {
       String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(s));
    }
    static int firstUniqChar(String s) {
        int[] idx = new int[26];
        //if repeated, set as -1;
        //if find the first, set as its idx+1;
        //otherwise 0
        char[] str = s.toCharArray();
        for(int i=0;i<str.length;i++) {
            if(idx[str[i]-'a']==0) idx[str[i]-'a']=i+1;
            else if(idx[str[i]-'a']==-1) continue;
            else idx[str[i]-'a']=-1;
        }
        for(int i=0;i<str.length;i++) {
            if(idx[str[i]-'a']!=0&&idx[str[i]-'a']!=-1) return i;
        }

        return -1;
    }
    static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> m = new HashMap<>();
        for(String s: strs) {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            String ss = String.valueOf(a);
            if(m.containsKey(ss)) {
                m.get(ss).add(s);
            }
            else {
                List<String> l = new ArrayList<>();
                l.add(s);
                m.put(ss, l);
            }
        }
        List<List<String>> ret = new ArrayList<>();
        for(List<String> l: m.values()) {
            if(l.size()>1) ret.add(l);
        }
        return ret;
    }
}

