public class NumberOf1Between1AndN_Solution {
    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(19));
    }
    static int NumberOf1Between1AndN_Solution(int n) {
        if(n==1) return 1;
        if(n<=0) return 0;
        int numbit = 0;
        int temp = n;
        while(temp>0) {
            numbit+=1;
            temp/=10;
        }
        int base = 1;
        int sum1 = 0;
        int multiply = 1;
        for(int i=0;i<numbit-1;++i) {
            if((n/base) %10==0) {
                sum1+= multiply * (n/base/10);
            }
            else if((n/base) %10==1) {
                int t = n/base/10;
                t = t*base;
                int res = n%base +1;
                sum1+= t+res;
            }
            else {
                int t = n/base/10 +1;
                sum1+= t*base;
            }
            base*=10;
            multiply*=10;
        }

        if(n/base==1) {
            sum1 += n%(base) +1;
        }
        else sum1+=base;
        return sum1;
    }
}
