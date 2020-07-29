import java.util.ArrayList;
import java.util.List;

public class productexcludeitself {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
//        l.add(2);
//        l.add(3);
        System.out.println(productExcludeItself(l));
    }
    static List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        int len = nums.size();
        Integer[] n = nums.toArray(new Integer[len]);
        long[] n1 = new long[len];
        for(int i=len-1; i>=0; --i) {
            if(i==len-1) n1[i] = 1;
            else {
                n1[i] = n1[i+1]*n[i+1];
            }
        }
        long [] ltor = new long[len];
        for(int i=0;i<len; ++i) {
            if(i==0) ltor[i] = 1;
            else ltor[i] = n[i-1]*ltor[i-1];
        }
        long[] res = new long[len];
        for(int i=0; i<len;++i) {
            res[i] = ltor[i] * n1[i];
        }
        List<Long> l = new ArrayList<>();
        for(long i: res) {
            l.add(i);
        }
        return l;
    }
}
