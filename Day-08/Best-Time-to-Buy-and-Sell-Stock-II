class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int n = prices.length;
        int profit = 0;

        while (i < n - 1) {
            while (i < n - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            int buy = prices[i];

            while (i < n - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            int sell = prices[i];

            profit += sell - buy;
        }

        return profit;
    }

}
