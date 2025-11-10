class Solution {
    public int maxProfit(int arr[]) {
        int n = arr.length;
        if (n == 0) return 0;

        // DP variables
        int hold = -arr[0]; // when we buy stock
        int sold = 0;       // when we just sold stock
        int rest = 0;       // when we are resting (cooldown)

        // Iterate over all days
        for (int i = 1; i < n; i++) {
            int prevHold = hold;
            int prevSold = sold;
            int prevRest = rest;

            hold = Math.max(prevHold, prevRest - arr[i]); // hold or buy
            sold = prevHold + arr[i];                     // sell today
            rest = Math.max(prevRest, prevSold);          // rest or after sell
        }

        // Final max profit (can't end with holding)
        return Math.max(sold, rest);
    }
}
