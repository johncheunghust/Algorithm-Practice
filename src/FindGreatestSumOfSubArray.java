public class FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        int[] a = {1,-2,3,10,-4,7,2,-5};
//        System.out.println(FindGreatestSumOfSubArray(a));
    }
    static int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0||array==null) return Integer.MIN_VALUE;
        int[] prefix = new int[array.length+1];
        prefix[0] = 0;
        int acc=0;
        for(int i=1;i<prefix.length;++i) {
            acc+=array[i-1];
            prefix[i] = acc;
        }
        int max=Integer.MIN_VALUE, min=0, temp=0;
        for(int i=1;i<prefix.length;++i) {
            temp = prefix[i] - min;
            min = Math.min(prefix[i], min);
            max = Math.max(temp, max);

        }
        return max;

    }
}
