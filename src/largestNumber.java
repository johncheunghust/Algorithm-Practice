import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;

class NumbersComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        return (s2+s1).compareTo(s1+s2);
    }
}

public class largestNumber {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("abcdefg");
        sb.replace(0,0,"false");
        System.out.println(sb);
    }

    static String largestNumber(int[] nums) {
        // write your code here
        String[] strs = new String[nums.length];
        for(int i=0;i<nums.length;++i) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new NumbersComparator());
        String ret = "";
        boolean flag0 = false;
        for(int i=0; i<strs.length; ++i) {
            if(!strs[i].equals("0")) {
                flag0=true;
                break;
            }
        }
        if(!flag0) return "0";
        for(String s: strs) {
            ret +=s;
        }
        return ret;
    }
}
