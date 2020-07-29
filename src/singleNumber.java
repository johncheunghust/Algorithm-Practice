import java.util.HashMap;
import java.util.Map;

public class singleNumber {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 2, 3};
        System.out.println(singleNumber(a));
    }

    static int singleNumber(int[] A) {
        // write your code here
//        naive solution use hash map
        int ret = 0;
        for(int i=0; i<32; ++i) {
            int sum=0;
            for(Integer j: A) {
                sum+=(j>>i);
            }
            sum%=3;
            if(sum==1) ret|= (1<<i);
        }
        return ret;
    }
}
