package tech.wec.DynamicProgramming;

public class BestTimeToBuyAndSellStockWithCooldown_309 {

    /**
     * for k cool down days
     * buy[i]: the max profit up to day i with buy as last action;
     * sell[i]: the max profit up to day i with sell as last action.
     * buy[i] = max(sell[i-k-1]-price, buy[i-1])
     * sell[i] = max(buy[i-1]+price, sell[i-1])
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int buy, buyPre = Integer.MIN_VALUE;
        int sell = 0, sellPre1 = 0, sellPre2 = 0;
        for (int p: prices){
            buy = Math.max(buyPre, sellPre2 - p);
            sell = Math.max(sellPre1, buyPre + p);

            buyPre = buy;
            sellPre2 = sellPre1;
            sellPre1 = sell;
        }
        return sell;
    }
}
