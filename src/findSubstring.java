import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findSubstring {
    public static void main(String[] args) {
        String s = "aaaaaa";
        String[] words = {"aaa", "aaa"};
        System.out.println(findSubstringBetter(s, words));
    }
    static List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> hm = new HashMap<>();
        for(String word: words) {
            hm.put(word, hm.getOrDefault(word, 0)+1);
        }
        int len = s.length();
        int numWord = words.length;
        int wordLen = words[0].length();
        List<Integer> l = new ArrayList<>();
        Map<String, Integer> slideWindow = new HashMap<>();
        for(int i=0, j=0;i<numWord;i++) {
            String one = s.substring(j,j+wordLen);
            slideWindow.put(one, slideWindow.getOrDefault(one, 0) +1);
            j+=wordLen;
        }
        if(slideWindow.equals(hm)) l.add(0);
        for(int i=0;i<len-numWord*wordLen-wordLen+1;i+=wordLen) {
            String del = s.substring(i,i+wordLen);
            if(hm.containsKey(del)) {
                slideWindow.put(del, slideWindow.get(del)-1);
            }
            int j = i+(numWord)*wordLen;
            String addd = s.substring(j, j+wordLen);
            if(hm.containsKey(addd)) {
                slideWindow.put(addd, slideWindow.getOrDefault(addd, 0)+1);
            }
            if(slideWindow.equals(hm)) l.add(i+wordLen);
        }
        return l;
    }

    static List<Integer> findSubstringBetter(String s, String[] words) {
        Map<String, Integer> hm = new HashMap<>();
        for(String word: words) {
            hm.put(word, hm.getOrDefault(word, 0)+1);
        }
        int len = s.length();
        int numWord = words.length;
        List<Integer> l = new ArrayList<>();
        if(numWord==0) return l;
        int wordLen = words[0].length();
        if(len==0||len<numWord*wordLen) return l;

        for(int a=0;a<wordLen;a++) {
            Map<String, Integer> slideWindow = new HashMap<>();
            for(int i=0, j=a;i<numWord;i++) {
                if(j+wordLen>len) break;
                String one = s.substring(j,j+wordLen);
                if(hm.containsKey(one)) slideWindow.put(one, slideWindow.getOrDefault(one, 0) +1);
                j+=wordLen;
            }
            if(slideWindow.equals(hm)) l.add(a);
            for(int i=a;i<len-numWord*wordLen-wordLen+1;i+=wordLen) {
                if(i+wordLen>len) break;
                String del = s.substring(i,i+wordLen);
                if(hm.containsKey(del)) {
                    slideWindow.put(del, slideWindow.get(del)-1);
                }
                int j = i+(numWord)*wordLen;
                String addd = s.substring(j, j+wordLen);
                if(hm.containsKey(addd)) {
                    slideWindow.put(addd, slideWindow.getOrDefault(addd, 0)+1);
                }
                if(slideWindow.equals(hm)) l.add(i+wordLen);
            }
        }

        return l;
    }

}
