import java.util.ArrayList;
import java.util.List;

public class grayCode {
    public static void main(String[] args) {
        System.out.println(grayCode(2));
    }
    static List<Integer> grayCode(int n) {
        List<Integer> l = new ArrayList<>();
        if(n==0) {
            l.add(0);
            return l;
        }
        List<Integer> pre = grayCode(n-1);
        List<Integer> cur = new ArrayList<>(pre);
        int plus = (int)Math.pow(2, n-1);
        for(int i=plus-1;i>=0;--i) {
            cur.add(cur.get(i)+plus);
        }
        return cur;
    }
}
