class Solution {
    public int minCost(int keys[], int freq[]) {
        int n = keys.length;
        int dp[][] = new int[n][n];
        int prefix[] = new int[n];

        prefix[0] = freq[0];
        for(int i=1;i<n;i++) 
            prefix[i] = prefix[i-1] + freq[i];

        // length 1 trees cost = freq[i]
        for(int i=0;i<n;i++)
            dp[i][i] = freq[i];

        // L = chain length
        for(int L=2;L<=n;L++){
            for(int i=0;i+L-1<n;i++){
                int j = i+L-1;
                dp[i][j] = Integer.MAX_VALUE;

                int sum = prefix[j] - (i>0 ? prefix[i-1] : 0); // sum of freq i..j
                
                // Try each key as root
                for(int r=i;r<=j;r++){
                    int left = (r > i) ? dp[i][r-1] : 0;
                    int right = (r < j) ? dp[r+1][j] : 0;
                    dp[i][j] = Math.min(dp[i][j], left + right + sum);
                }
            }
        }

        return dp[0][n-1];
    }
}
