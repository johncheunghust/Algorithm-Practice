import java.util.HashMap;
import java.util.Map;

public class twosum {
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] a = new int[2];//hash map for v-index
        Map<Integer, Integer> m =new HashMap<Integer,Integer>();
        for(int i=0; i<numbers.length; ++i) {
            if(m.containsKey(target-numbers[i])) {
                a[0] = m.get(target-numbers[i]);
                a[1] = i;
                return a;
            }
            else m.put(numbers[i],i);
        }
        return a;
    }
}
