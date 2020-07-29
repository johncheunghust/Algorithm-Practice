import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class subarraysum {
    public static void main(String[] args) {
        int[] n = new int[]{1,2,3,-5,0};
        System.out.println(subarraySum(n));
    }
    static List<Integer> subarraySum(int[] nums) {
        // write your code here
        Map<Integer, Integer> m = new HashMap<>();
        int len = nums.length;
        int[] presum = new int[len+1];
        presum[0] = 0;
        m.put(0,0);
        List<Integer> l = new ArrayList<>() {};
        for (int i=1; i<len+1;++i) {
            presum[i] = presum[i-1] + nums[i-1];
            if(m.containsKey(presum[i])) {
                l.add(m.get(presum[i]));
                l.add(i-1);
                return l;
            }
            else m.put(presum[i],i);
        }
        return l;
    }
}
