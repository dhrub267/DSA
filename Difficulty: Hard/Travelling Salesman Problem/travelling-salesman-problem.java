class Solution {
    public int tsp(int[][] cost) {
        int n = cost.length;
        int[][] dp = new int[1 << n][n];

        // initialize dp with -1 (meaning "not calculated")
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(1, 0, cost, dp, n); // starting from city 0, visited mask = 1 (city 0)
    }

    private int solve(int mask, int pos, int[][] cost, int[][] dp, int n) {
        // if all cities are visited
        if (mask == (1 << n) - 1) {
            return cost[pos][0]; // return to start
        }

        if (dp[mask][pos] != -1) return dp[mask][pos];

        int ans = Integer.MAX_VALUE;
        for (int next = 0; next < n; next++) {
            // if next city not visited
            if ((mask & (1 << next)) == 0) {
                int newMask = mask | (1 << next);
                ans = Math.min(ans, cost[pos][next] + solve(newMask, next, cost, dp, n));
            }
        }
        dp[mask][pos] = ans;
        return ans;
    }
}
