import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class testComparator {
    public static void main(String[] args) {
//        Integer[] a = new Integer[2];
//        a[0]=2;
//        a[1]=1;
//        Arrays.sort(a, new numComparator());
//        System.out.println(Arrays.toString(a));
        quickSort a = new quickSort();
        int[] b = {2,1,4,3,7,5};
        a.quickSort(b, 0, b.length-1);
        System.out.println(Arrays.toString(b));
    }
}

class numComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}

class quickSort {
    int partition(int[] n, int l, int r) {
        int p = n[r];
        int i=l-1;
        for(int j=l;j<r;++j) {
            if(n[j]<p) {
                int temp = n[j];
                n[j] = n[++i];
                n[i] = temp;
            }
        }
        int temp = p;
        n[r] = n[++i];
        n[i] = temp;
        return i;
    }
    void quickSort(int[] n, int l, int r) {
        if(l<r) {
            int mid = partition(n, l, r);
            quickSort(n,l,mid-1);
            quickSort(n,mid+1,r);
        }
    }
}

class mergeSort {
    void merge(int[] nums, int l, int middle, int r) {
        if(l<r) {
            int[] ret = new int[r-l+1];
            int i=l, j=middle+1;
            int k=0;
            while(i<=middle&&j<=r) {
                if(nums[i]<nums[j]) ret[k++] = nums[i++];
                else ret[k++] = nums[j++];
            }
            while(i<=middle) ret[k++] = nums[i++];
            while(j<=r) ret[k++] = nums[j++];
            for(int a=0,b=l;a<r-l+1;a++,b++) {
                 nums[b]= ret[a];
            }
        }

    }
    void mergeSort(int[] nums, int l, int r) {
        if(l<r) {
            int middle = (l+r)/2;
            mergeSort(nums, l, middle);
            mergeSort(nums, middle+1, r);
            merge(nums, l, middle, r);
        }
    }
}