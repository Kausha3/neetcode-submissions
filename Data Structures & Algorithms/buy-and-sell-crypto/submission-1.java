class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int maxProfit = 0;

        while (r < prices.length) {
            if (prices[r] - prices[l] < 0) {
                l = r;
                r++;
                
            }
            else {
                maxProfit = Math.max(prices[r] - prices[l], maxProfit);
                
                r++;
            }
        }
        return maxProfit; 
    }
}
