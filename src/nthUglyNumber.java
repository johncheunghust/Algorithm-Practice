import java.util.ArrayList;
import java.util.List;

public class nthUglyNumber {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(41));
    }
    static int nthUglyNumber(int n) {
        // write your code here
        List<Integer> l = new ArrayList<>();
        l.add(1);
        int p2,p3,p5;
        p2=p3=p5=0;
        for(int i=1;i<n;++i) {
            int lastNum = l.get(i-1);
            while(l.get(p2)*2<=lastNum) p2++;
            while(l.get(p3)*3<=lastNum) p3++;
            while(l.get(p5)*5<=lastNum) p5++;
            int a = l.get(p2)*2;
            int b = l.get(p3)*3;
            int c = l.get(p5)*5;
            l.add(Math.min(a,Math.min(b,c)));
        }
        return l.get(n-1);
    }
}
