package dynamicprogramming;

/**
 * @ClassName MaxProfit
 * @Description: 买卖股票的最佳时机
 * @Author gravel
 * @Date 2019/11/22
 * @Version V1.0
 **/
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1) return 0;

        int n = 0;
        int min = prices[0];
        int result  = 0;
        while (n<prices.length){
            result = Math.max(result,prices[n]-min);
            min = Math.min(min,prices[n]);
           n++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
