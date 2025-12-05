class Solution {
    int minCost(int[][] costs) {

        int n = costs.length;
        int k = costs[0].length;

        // If only 1 color and multiple walls → impossible
        if(k == 1 && n > 1) return -1; 
        
        int[][] dp = new int[n][k];

        // Initialize 1st row
        for(int j = 0; j < k; j++){
            dp[0][j] = costs[0][j];
        }

        // Fill DP for remaining walls
        for(int i = 1; i < n; i++){
            for(int j = 0; j < k; j++){
                int minPrev = Integer.MAX_VALUE;

                // Find min from previous row except same color
                for(int p = 0; p < k; p++){
                    if(p != j){
                        minPrev = Math.min(minPrev, dp[i-1][p]);
                    }
                }

                dp[i][j] = costs[i][j] + minPrev; 
            }
        }

        // Result is minimum of last row
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < k; j++){
            ans = Math.min(ans, dp[n-1][j]);
        }

        return ans;
    }
}
