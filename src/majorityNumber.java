import java.util.List;

public class majorityNumber {
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        int count = 0;
        int major = 0;
        for(Integer i:nums) {
            if(count==0) major=i;
            if(major==i) ++count;
            else --count;
        }
        return major;
    }
}
