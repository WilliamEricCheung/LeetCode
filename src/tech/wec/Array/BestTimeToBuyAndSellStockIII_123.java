package tech.wec.Array;

public class BestTimeToBuyAndSellStockIII_123 {
    public int maxProfit(int[] prices) {
        int oneBuy = Integer.MAX_VALUE;
        int oneSell = 0;
        int twoBuy = Integer.MIN_VALUE;
        int twoSell = 0;
        for (int price : prices
        ) {
            oneBuy = Math.min(oneBuy, price);
            oneSell = Math.max(oneSell, price - oneBuy);
            twoBuy = Math.max(twoBuy, oneSell - price);
            twoSell = Math.max(twoSell, price + twoBuy);
        }
        return twoSell;
    }
}
