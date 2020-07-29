public class removedup {
    public static void main(String[] args) {
        int[] i = new int[]{1,1,2};
        System.out.println(removeDuplicates(i));
    }
    static int removeDuplicates(int[] nums) {
        // write your code here
        if(nums.length==0) return 0;
        int[] n = new int[nums.length];
        int j=0;
        for(int i=0;i<n.length;++i) {
            if(i==0) n[j++] = nums[i];
            else {
                if(n[j-1]<nums[i]) n[j++] = nums[i];
                else continue;
            }
        }
        for(int i=0;i<j;++i) {
            nums[i] = n[i];
        }
        return j;
    }
}
