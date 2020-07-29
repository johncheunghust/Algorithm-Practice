public class canCompleteCircuit {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(a,b));
    }
    static int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        if(gas==null||cost==null||gas.length==0||cost.length==0) return -1;
        int count=0;
        int index = -1;
        int remaining = 0;
        for(int i=0;i<gas.length; ++i) {
            count += gas[i]-cost[i];
            remaining+=gas[i]-cost[i];
            if(remaining<0) {
                remaining=0;
                index=i;
            }
        }
        return count<0?-1:index+1;
    }
}
