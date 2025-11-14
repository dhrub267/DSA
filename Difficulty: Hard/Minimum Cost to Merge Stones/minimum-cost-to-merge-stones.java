class Solution {
    public static int mergeStones(int[] stones, int k) {
        int n = stones.length;

        // Condition check: Is it possible to get exactly 1 pile?
        if ((n - 1) % (k - 1) != 0) return -1;

        // Prefix sum
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        // DP array
        int[][] dp = new int[n][n];

        // Initialize dp with large values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 0;
            }
        }

        // length from 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE / 2;

                // Try splitting at intervals of (k - 1)
                for (int m = i; m < j; m += (k - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }

                // If we can merge to 1 pile, add total sum
                if ((len - 1) % (k - 1) == 0) {
                    dp[i][j] += prefix[j + 1] - prefix[i];
                }
            }
        }

        return dp[0][n - 1];
    }
}
