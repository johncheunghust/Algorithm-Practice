import java.util.*;

public class threesum {
    public static void main(String[] args) {
        int[] n = {0,0,0,0};
        System.out.println(threeSum(n));
    }
    static List<List<Integer>> threeSum(int[] n) {
        // write your code here
        Arrays.sort(n);
        List<List<Integer>> ret = new ArrayList<>();
        if(n.length<3) return ret;
        Set<List<Integer>> s= new HashSet<>();
        for(int i=0;i<n.length-1;++i) {
            if(n[i]>0) break;
            int toSum = -n[i];
            int j = i+1, k=n.length-1;
            while(j<k) {
                if(n[j]+n[k]==toSum) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(n[i]);
                    temp.add(n[j]);
                    temp.add(n[k]);
                    if(s.contains(temp)) {
                        if(n[j+1]!=n[j]) j++;
                        else k--;
                        continue;
                    }
                    else {
                        ret.add(temp);
                        s.add(temp);
                        if(n[j+1]!=n[j]) j++;
                        else k--;
                        continue;
                    }
                }
                else if(n[j]+n[k]<toSum) j++;
                else k--;
            }

        }
        return ret;
    }
}
