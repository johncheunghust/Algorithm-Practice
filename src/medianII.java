import java.util.*;

public class medianII {
    public static void main(String[] args) {
        int[] nums = {4,5,1,3,2,6,0};
        System.out.println(Arrays.toString(medianII(nums)));
    }
    static int[] medianII(int[] nums) {
        // write your code here
        Queue<Integer> minHeap = new PriorityQueue<Integer>((o1, o2) -> o2-o1);
        Queue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> o1-o2);
        int len = 0;
        int[] ret = new int[nums.length];
        for(Integer n: nums) {
            len++;
            int minSize = len%2==1? len/2 +1 : len/2;
            int maxSize = len/2;
            if(minHeap.size()==0) {
                minHeap.add(n);
                ret[len-1] = n;
                continue;
            }
            if(n<=minHeap.peek()) {
                minHeap.add(n);
                if(minHeap.size()>minSize) {
                    maxHeap.add(minHeap.poll());
                }
                ret[len-1] = minHeap.peek();
            }
            else {
                maxHeap.add(n);
                if(maxHeap.size()>maxSize) {
                    minHeap.add(maxHeap.poll());
                }
                ret[len-1] = minHeap.peek();
            }
        }
        return ret;
    }

    PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1, o2)->(o1-o2));
    PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1, o2)->(o2-o1));
    int sum;
    public void Insert(Integer num) {
        sum++;
        int max_pq1 = (sum+1)/2;
        int max_pq2 = sum - (sum+1)/2;

        if(pq1.size()==0) pq1.offer(num);
        if(pq1.size()>=max_pq1) {
            int top = pq1.peek();
            if(top>num) {
                int out = pq1.poll();
                pq1.offer(num);
                pq2.offer(out);
            }
            else {
                pq2.offer(num);
            }
        }
        else {
            int top = pq1.peek();
            if(top<num) {
                pq2.offer(num);
                int out = pq2.peek();
                pq1.offer(out);
            }
            else pq1.offer(num);
        }
    }

    public Double GetMedian() {
        if(sum%2==1) return (double) pq1.peek();
        else {
            double a = (double) pq1.peek();
            double b = (double) pq2.peek();
            return (a+b)/2;
        }
    }
}
