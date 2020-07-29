import java.util.ArrayList;

public class GetLeastNumbers_Solution {
    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        int k = 4;
        System.out.println(GetLeastNumbers_Solution(input, k));
    }
    static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> l = new ArrayList<>();
        if(k>input.length||k==0) return l;
        FindKthIdx(input, k, 0, input.length-1);
        for(int i=0;i<k;++i) {
            l.add(input[i]);
        }
        return l;
    }

    static void FindKthIdx(int[] a, int k, int low, int high) {
        int i = partition(a, low, high);
        if(i-low==k-1) return;
        else if(i>k-1) {
            FindKthIdx(a, k, low, i-1);
        }
        else {
            FindKthIdx(a, k-i-1, i+1, high);
        }
    }

    static int partition(int[] a, int low, int high) {
        int p = a[high];
        int i = low - 1;
        for(int j=low;j<high;j++) {
            if(a[j]<p) {
                int temp = a[j];
                a[j] = a[++i];
                a[i] = temp;
            }
        }
        int temp = a[++i];
        a[i] = a[high];
        a[high] = temp;
        return i;
    }
}
