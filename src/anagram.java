import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class anagram {
    public static void main(String[] args) {
        String[] ss = new String[]{"ab", "ba", "cd", "dc", "e"};
        System.out.println(anagrams(ss));
    }

    static int BKDRHash(int[] count) {
        int hash = 0;
        for(int i=0;i<26;++i) {
            hash = hash * 131 + count[i];
        }
        return hash;
    }
    static List<String> anagrams(String[] strs) {
        // write your code here
        List<String> l = new ArrayList<>();
        ArrayList<String> result = new ArrayList<String>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            int hash = BKDRHash(count);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<String>());
            }

            map.get(hash).add(str);
        }

        for (ArrayList<String> tmp : map.values()) {
            if (tmp.size() > 1) {
                result.addAll(tmp);
            }
        }

        return result;
    }
//        int[][] c = new int[strs.length][26];
//        for(int i=0; i<strs.length; ++i) {
//            char[] a = strs[i].toCharArray();
//            for(int j =0;j<strs[i].length();++j) {
//                c[i][a[j]-'a']+=1;//construct a map
//            }
//        }
//        boolean[] match = new boolean[strs.length];
//        for(int i=0;i<strs.length-1;++i) {
//            if(match[i]==true) continue;
//            for(int j=i+1;j<strs.length;++j) {
//                if(findMatch(c,i,j)) {
//                    if(match[i]==false) l.add(strs[i]);
//                    if(match[j]==false) l.add(strs[j]);
//                    match[i] = true;
//                    match[j] = true;
//                }
//                else continue;
//            }
//        }
//        return l;


//    static boolean findMatch(int[][]c, int i, int j) {
//        for(int m=0; m<26; ++m) {
//            if(c[i][m]!=c[j][m]) return false;
//        }
//        return true;
//    }

}
