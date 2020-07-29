import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combine {
    public static void main(String[] args) {
        System.out.println(combineRecur(4,2).toString());
    }
    //Solution 1:
    static List<List<Integer>> combineBacktracking(int n, int k) {
        // write your code here
        List ret = new ArrayList();
        List solution = new ArrayList();
        helper(ret, solution,n,k,1);
        return ret;
    }
    static void helper(List ret, List solution, int n, int k, int start) {
        if(solution.size()==k) {
            ret.add(new ArrayList(solution));
            return;
        }
        for(int i=start;i<=n-k+solution.size()+1; ++i) {
            solution.add(i);
            helper(ret, solution,n,k, i+1);
            solution.remove(solution.size()-1);
        }
    }
    //Solution 2:
    static List<List<Integer>> combineIter(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //个数为 1 的所有可能
        for (int i = 1; i <= n + 1 - k; i++) res.add(Arrays.asList(i));
        //第一层循环，从 2 到 k
        for (int i = 2; i <= k; i++) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            //第二层循环，遍历之前所有的结果
            for (List<Integer> list : res) {
                //第三次循环，对每个结果进行扩展
                //从最后一个元素加 1 开始，然后不是到 n ，而是和解法一的优化一样
                //(k - (i - 1） 代表当前已经有的个数，最后再加 1 是因为取了 n
                for (int m = list.get(list.size() - 1) + 1; m <= n - (k - (i - 1)) + 1; m++) {
                    List<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(m);
                    tmp.add(newList);
                }
            }
            res = tmp;
        }
        return res;
    }
    //Solution 3:
    static List<List<Integer>> combineRecur(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if (k == n || k == 0) {
            List<Integer> row = new ArrayList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new ArrayList<>(Arrays.asList(row));
        }
        List<List<Integer>> r1 = combineRecur(n-1, k-1);
        r1.forEach(a->a.add(n));//get the set that contains the kth number
        r1.addAll(combineRecur(n-1,k));//get the set without the kth number
        return r1;
    }
    //Solution 4:

}
