import java.util.*;

public class minSetSize {
    public static void main(String[] args) {
        int[] n ={1000,1000,3,7};
        System.out.println(minSetSize(n));
    }
    static int minSetSize(int[] arr) {
        int len = arr.length;
        HashMap<Integer, Integer> m = new HashMap<>();
        for(Integer i: arr) {
            if(m.containsKey(i)) {
                m.put(i, m.get(i)+1);
            } else m.put(i, 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2-o1));
        List<Integer> l = new ArrayList<>(m.values());
        for(Integer i: l) {
            pq.add(i);
        }
        int sum=0, count=0;
        while(sum<len/2) {
            sum+=pq.poll();
            count++;
        }
        return count;
    }
}
