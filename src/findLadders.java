import java.util.*;

public class findLadders {

    public static void main(String[] args) {
        String a = "hit";
        String b = "cog";
        Set<String> s = new HashSet<>();
        s.add("hot");
        s.add("dot");
        s.add("dog");
        s.add("lot");
        s.add("log");
        System.out.println(findLadders(a,b,s).toString());
    }

    static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        Map<String, List<String>> neighbors = new HashMap<>();
        Map<String, Integer> dstc  = new HashMap<>();
        Set<String> visited = new HashSet<>();
        List<String> solution = new ArrayList<>();
        List<List<String>> ret = new ArrayList<>();
        dstc.put(start, 0);
        bfs(start, end, dict, neighbors, dstc);
        dfs(start, end, dict, neighbors, dstc, solution, ret);
        return ret;
    }
    static void bfs(String start, String end, Set<String> dict,
                    Map neighbors, Map<String, Integer> dstc) {
        Queue<String> temp = new LinkedList<>();
        dict.add(end);
        temp.offer(start);
        int length=1;
        while(!temp.isEmpty()) {
            int sz = temp.size();
            boolean getEnd=false;
            for(int i=0;i<sz;++i) {
                String cur = temp.poll();
                List<String> nbs = new ArrayList<>();
                for(String nextWord : getNextWords(cur, dict)) {
                    nbs.add(nextWord);
                    if(!dstc.containsKey(nextWord)) {
                        dstc.put(nextWord, length);
                        if(end.equals(nextWord)) getEnd = true;
                         temp.offer(nextWord);
                    }
                }
                neighbors.put(cur, new ArrayList<>(nbs));
            }
            if(getEnd) break;
            length++;
        }
    }



    static List<String> getNextWords(String cur, Set<String> dict) {
        List<String> ret = new ArrayList<>();
        for(int i=0;i<cur.length();++i) {
            for(char a = 'a'; a<='z'; ++a ) {
                if(a!=cur.charAt(i)){
                    char[] tmp = cur.toCharArray();
                    tmp[i] = a;
                    String s = new String(tmp);
                    if(dict.contains(s)) {
                    ret.add(s);
                    }
                }
            }
        }
        return ret;
    }

    static void dfs(String cur, String end, Set<String> dict, Map<String, List<String>> neighbors,
                    Map<String, Integer> dstc, List<String> solution, List<List<String>> ret) {
        solution.add(cur);
        if(cur.equals(end)) {
            ret.add(new ArrayList<>(solution));
        }
        else if(neighbors.containsKey(cur)) {
            for(String next: neighbors.get(cur)) {
                int nextdepth = dstc.get(next);
                int curdepth = dstc.get(cur);
                if(nextdepth==curdepth+1) {
                    dfs(next, end, dict, neighbors, dstc, solution, ret);
                }
            }
        }

        solution.remove(solution.size()-1);
    }
}
