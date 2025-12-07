class Solution {
    static final int MOD = 1000000007;

    int distinctSubseq(String str) {
        int n = str.length();
        long[] dp = new long[n + 1];
        int[] last = new int[26];

        dp[0] = 1;  // empty subsequence

        for(int i = 1; i <= n; i++) {
            dp[i] = (dp[i-1] * 2) % MOD;

            int ch = str.charAt(i-1) - 'a';

            // if character appeared previously
            if(last[ch] != 0) {
                dp[i] = (dp[i] - dp[last[ch] - 1] + MOD) % MOD;
            }

            last[ch] = i;
        }

        return (int)dp[n];
    }
}
