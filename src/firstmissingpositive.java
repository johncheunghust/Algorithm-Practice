public class firstmissingpositive {
    public static void main(String[] args) {
        int[] a = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive(a));
    }
    static int firstMissingPositive(int[] A) {
        // write your code here
        for (int i=0; i<A.length; ++i)
            while(A[i]>0&&A[i]<=A.length&&A[i]!=i+1) {
                if(A[i] == A[A[i]-1]) break;
                else swap(A, i, A[i]-1);
            }

        int i;
        for(i=0;i<A.length;++i) {
            if(A[i]!=i+1) return i+1;
        }
        return A.length+1;
    }
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
