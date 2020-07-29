import java.util.*;

public class merge {
    public  static void main(String[] args) {
        int[][]itv = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.toString(merge(itv)));
    }
    static int[][] merge(int[][] intervals) {
        PriorityQueue<pair> ret = new PriorityQueue<pair>(((o1, o2) -> (o1.i-o2.i)));
        int numPair = intervals.length;
        if(intervals.length==0||intervals.length==1) return intervals;
        for(int i=0; i<numPair; ++i) {
            ret.add(new pair(intervals[i][0], intervals[i][1]));
        }
        List<pair> l = new ArrayList<>();
        for(int i=0; i<numPair; ++i) {
            l.add(ret.poll());
        }
        Deque<pair> dq = new ArrayDeque<>();
        dq.add(l.get(0));
        for(int i=1;i<numPair; ++i) {
            pair p1 = dq.peekLast();
            pair p2 = l.get(i);
            if(p1.j>=p2.i) {
                pair n = new pair(p1.i, Math.max(p1.j, p2.j));
                dq.pollLast();
                dq.add(n);
            }
            else dq.add(p2);
        }
        int[][] r = new int[dq.size()][2];
        int i=0;
        while(!dq.isEmpty()) {
            pair t = dq.poll();
            r[i][0] = t.i;
            r[i][1] = t.j;
            i++;
        }
        return r;
    }
}

class pairComparator implements Comparator<pair> {
    public int compare(pair o1, pair o2) {
        return o1.i-o2.i;
    }
}

class pair{
    int i;
    int j;
    public pair(int a, int b) {
        this.i = a;
        this.j = b;
    }
}