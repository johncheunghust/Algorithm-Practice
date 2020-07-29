import java.util.HashMap;

public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i: array) {
            if(m.containsKey(i)) {
                int v = m.get(i);
                m.put(i, ++v);
            }
            else {
                m.put(i,1);
            }
        }
        int len = array.length;
        for(int i: m.keySet()) {
            if(m.get(i)>len/2) return i;
        }
         return 0;
    }
}
