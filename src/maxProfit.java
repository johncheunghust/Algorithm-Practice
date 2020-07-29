public class maxProfit {
    public static void main(String[] args) {
        int[] a = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(a));
    }
    static int maxProfit(int[] prices) {
        int len = prices.length;
        if(len==0||len==1) return 0;
        int min1 = prices[0];
        int min2 = prices[0];
        int profit1 = 0, profit2 = 0;
        for(int i=0; i< len; ++i) {
            min1 = Math.min(min1, prices[i]);
            profit1 = Math.max(profit1, prices[i]-min1);

            min2 = Math.min(min2, prices[i]-profit1);
            profit2 = Math.max(profit2, prices[i]-min2);
        }
        return profit2;
    }
}
