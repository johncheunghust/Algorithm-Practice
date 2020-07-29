import java.util.*;

public class ladderLength {
    public static void main(String[] args) {
        String a = "hit";
        String b = "cog";
        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(ladderLength(a,b,dict));

    }
    static int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        StringBuilder current = new StringBuilder(start);
        Set<String> s = new HashSet<>();
        Queue<String> temp = new LinkedList<>();
        temp.offer(start);
        dict.add(end);
        int length=1;
        while(!temp.isEmpty()) {
            length++;
            int sz = temp.size();
            for(int i=0;i<sz; ++i) {
                String word = temp.poll();
                for(String nextWord: getNextWords(word, dict)) {
                    if (s.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }

                    s.add(nextWord);
                    temp.offer(nextWord);
                }
            }
        }
        return 0;
    }
    static ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<>();
        for(int i=0;i<word.length();++i) {
            for(char c='a';c<='z'; ++c) {
                if(c!=word.charAt(i)) {
                    char[] tmp = word.toCharArray();
                    tmp[i] = c;
                    String nextWord = new String(tmp);
                    if(dict.contains(nextWord)) {
                        nextWords.add(nextWord);
                    }
                }
            }
        }
        return nextWords;
    }

}
