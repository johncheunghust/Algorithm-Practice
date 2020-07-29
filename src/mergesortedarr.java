public class mergesortedarr {
    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,0,0};
        int[] B = new int[] {4,5};
        mergeSortedArray(A,3,B,2);
        System.out.println(A.toString());
    }

    static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int[] tmp = new int[m+n];
        int i=0, j=0;
        int k=0;
        while(i<m&&j<n) {
            if(A[i]>B[j]) {
                tmp[k++] = B[j++];
            }
            else {
                tmp[k++] = A[i++];
            }
        }
        while(i<m) {
            tmp[k++] = A[i++];
        }
        while(j<n) {
            tmp[k++] = B[j++];
        }
        for(int l=0; l<k; ++l) {
            A[l] = tmp[l];
        }
    }
}
