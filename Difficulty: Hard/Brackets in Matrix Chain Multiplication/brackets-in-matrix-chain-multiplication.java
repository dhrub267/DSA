class Solution {
    
    public String matrixChainOrder(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];       // Minimum cost table
        int split[][] = new int[n][n];    // Where to split

        for (int len = 2; len < n; len++) { // length of chain
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        split[i][j] = k; // store partition point
                    }
                }
            }
        }
        return build(1, n-1, split);
    }

    // construct the final bracket representation
    private String build(int i, int j, int split[][]) {
        if (i == j) 
            return String.valueOf((char)('A' + i - 1)); // A,B,C... mapping

        return "(" 
                + build(i, split[i][j], split) 
                + build(split[i][j] + 1, j, split) 
                + ")";
    }
}
