import java.util.Comparator;
import java.util.PriorityQueue;

public class lgestNumber {
    public static void main(String[] args) {
        int[] nums = {0,0,1};
        System.out.println(largestNumber(nums));
    }
    static String largestNumber(int[] nums) {
        boolean all0 = true;
        for(int i:nums) {
            if(i!=0) {
                all0 = false;
                break;
            }
        }
        if(all0) return new String("0");
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        for(int i:nums) {
            pq.add(Integer.toString(i));
        }
        String ret = "";
        while(!pq.isEmpty()) {
            ret+=pq.poll();
        }
        return ret;
    }
}
