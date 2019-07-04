package tech.wec.Array;

public class BestTimeToBuyAndSellStockII_122 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length==0)
            return 0;
        int cur = 0;
        int buy = prices[0];
        int sale= prices[0];
        int profit = 0;
        while(cur < prices.length-1){
            while(cur < prices.length-1 && prices[cur]>=prices[cur+1])
                cur++;
            buy = prices[cur];
            while(cur < prices.length-1 && prices[cur]<=prices[cur+1])
                cur++;
            sale= prices[cur];
            profit += sale-buy;
        }
        return profit;
    }
}
