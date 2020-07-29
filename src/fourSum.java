import java.util.*;

public class fourSum {
        public static void main(String[] args) {

            int[] n = {-3,-1,0,2,4,5};
            System.out.println(fourSum(n,0));
        }


        static List<List<Integer>> fourSum(int[] n, int target) {
            Arrays.sort(n);
            List<List<Integer>> l = new ArrayList<>();
            Set<List<Integer>> s = new HashSet<>();
            for(int i=0; i<n.length-3;i++) {
                for(int j=i+1;j<n.length-2;j++) {
                    int a = j+1,b=n.length-1;
                    int toSum = target-n[i]-n[j];
                    while(a<b) {
                        int cur = n[a]+n[b];
                        if(cur==toSum) {
                            List<Integer> tmp = new ArrayList<>();
                            tmp.add(n[i]);
                            tmp.add(n[j]);
                            tmp.add(n[a]);
                            tmp.add(n[b]);

                            if (!s.contains(tmp)) {
                                l.add(tmp);
                                s.add(tmp);
                            }
                            if(n[a]!=n[a+1]) a++;
                            else b--;
                        }
                        else if(cur>toSum) b--;
                        else a++;
                    }
                }
            }
            return l;
        }

}
