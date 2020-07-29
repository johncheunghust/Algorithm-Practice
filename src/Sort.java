import java.util.Arrays;


public class Sort {
    public static void main(String args[]) {
        int test1[] = {1,2,3,4,5,6,8,9,10,7};
        int test2[] = {};
        int test3[] = {2, -2};
        int test4[] = {0};
//        MergeSort s1 = new MergeSort();
//        QuickSort s2 = new QuickSort();
//        s2.sort(test4,0,test4.length-1);
//        System.out.println(Arrays.toString(test4));
//        BFPRT s3 = new BFPRT();
        heapSort hs = new heapSort();
        int[] h = {4,5,3,0,1,7,2,6};
        hs.heapSort(h);
        System.out.println(Arrays.toString(h));
  }
}

class MergeSort{
    void merge(int arr[], int l, int m, int r) {
        int n1 = m-l+1;
        int n2 = r-m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for(int i=0;i<n1;++i)
            L[i] = arr[l+i];
        for(int j=0;j<n2;++j)
            R[j] = arr[m+1+j];
        int i = 0, j = 0;
        int k=l;
        while(i<n1 &&j<n2) {
            if(L[i]<R[j]) arr[k] = L[i++];
            else arr[k] = R[j++];
            ++k;
        }
        while(i<n1)
            arr[k++] = L[i++];
        while(j<n2)
            arr[k++] = R[j++];
    }
    void sort(int arr[], int l, int r) {
        if(l<r) {
            int middle = (l+r)/2;
            sort(arr, l, middle);
            sort(arr, middle+1, r);
            merge(arr, l, middle, r);
        }
    }
}

class QuickSort{
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    int partition(int arr[],int low,int high) {
        int p = arr[high];//set high as the pivot
        int i = low-1;
        for(int j = low; j<high; j++) {
            if(arr[j]<p) {
                int temp = arr[j];
                arr[j] = arr[++i];
                arr[i] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    void sort(int arr[], int low, int high) {
        if(low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
}

class BFPRT{
    void InsertionSort(int a[], int l, int r){
        for(int i = l + 1; i <= r; i++){
            if(a[i - 1] > a[i]) {
                int t = a[i];
                int j = i;
                while(j > l && a[j - 1] > t){
                    a[j] = a[j - 1];
                    j--;
                }
                a[j] = t;
            }
        }
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    int get_median(int[] a, int l, int r) {
        InsertionSort(a,l,r);
        return a[(l+r)/2];
    }

    int partition(int[] a, int l, int r, int medmed) {
        int i=l;
        for(;i<=r;++i) if(a[i]==medmed) break;
        swap(a,l,i);
        int m=l,n=r;
        int pivot = a[l];
        while (m<n) {
            while(m<n&&a[n]<=pivot) n--;
            a[m] = a[n];
            while(m<n&&a[m]>=pivot) m++;
            a[n] = a[m];
        }
        a[m] = pivot;
        return m;
    }

    int BFPRT(int[] a, int l, int r, int k) {
        if(k>0 && k<= r-l+1) {
            if(l==r) return a[l];
            int n = (r-l+1)/5;
            int left_num = (r-l+1)%5;
            int num_median = left_num==0?n:n+1;
            int[] median = new int [num_median];
            for(int i=l,j=0;j<n;i+=5,++j)
                median[j] = get_median(a, i, i+4);
            if(left_num>0)
                median[num_median-1] = get_median(a, r-left_num+1,r);

            int medmed = num_median==1?median[0]:BFPRT(median, 0,num_median-1, (num_median)/2);
            int m = partition(a, l, r, medmed);

            if(m-l+1 == k) return a[m];
            else if(m-l+1 > k) return BFPRT(a,l, m-1, k);
            else return BFPRT(a, m+1, r, k-(m-l+1));
        }
        else return -1;
    }
}

class heapSort{
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);//将最大元素放入尾部
        while (size > 0) {
            heapify(arr, 0, size);//最小元素堆化
            swap(arr, 0, --size);//最大元素放入尾部，最小元素放入堆头
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 堆化
     */
    public static void heapify(int[] arr, int i, int size) {
        int left =  2*i+1;
        int right = 2*i+2;
        int largest = i;
        if(left<size && arr[left]>arr[largest]) {
            largest = left;
        }
        if(right<size && arr[right]>arr[largest]) {
            largest = right;
        }
        if(largest!=i) {
            swap(arr, i, largest);
            heapify(arr, largest, size);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}