import java.util.*;

public class ladderLengthI {
    public static void main(String[] args) {
        String b = "hot";
        String e = "dog";
        String[] ll = {"hot","dot","dog","lot","log","cog"};
        List<String> l = new ArrayList<>();
        for(String s: ll) l.add(s);
        ladderLength(b, e, l);
    }
    static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> s = new HashSet<>();
        for(String ss: wordList) s.add(ss);
        if(!s.contains(endWord)) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->o1-o2);
        dfs(beginWord, endWord, s, pq, 0);
        if(pq.isEmpty()) return 0;
        return pq.peek()+1;
    }
    static void dfs(String beginWord, String endWord, Set<String> wordList, PriorityQueue<Integer> pq, int level) {
        if(beginWord.equals(endWord)) {
            pq.add(level);
            return;
        }
        if(!pq.isEmpty()&&level>pq.peek()) return;
        int len = beginWord.length();
        for(int i=0; i<len; ++i) {
            for(int j=0; j<26; j++) {
                char[] temp = beginWord.toCharArray();
                temp[i] = (char)('a'+j);
                String s = String.valueOf(temp);
                if(!s.equals(beginWord)&&wordList.contains(s)) {
                    wordList.remove(beginWord);
                    dfs(s, endWord, wordList, pq, level+1);
                    wordList.add(beginWord);
                }
            }
        }
    }
}
