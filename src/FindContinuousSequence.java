import java.util.ArrayList;

public class FindContinuousSequence {
    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(9));
    }
    static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int i=1, j=1;
        int s=0;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if(sum==1) return ret;
        while(j<=sum/2+1) {
            while(s<sum) {
                s+=j;
                j++;
            }
            if(s==sum) {
                ArrayList<Integer> t = new ArrayList<>();
                for(int k=i;k<j;++k) t.add(k);
                ret.add(t);
                s+=j;
                j++;
            }
            else {
                while(s>sum) {
                    s-=i;
                    i++;
                }
                if(s==sum) {
                    ArrayList<Integer> t = new ArrayList<>();
                    for(int k=i;k<j;++k) t.add(k);
                    ret.add(t);
                    s-=i;
                    ++i;
                }
                else continue;
            }
        }
        return ret;
    }
}
