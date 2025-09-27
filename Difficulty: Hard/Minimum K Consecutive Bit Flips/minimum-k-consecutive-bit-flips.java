class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int[] isFlipped = new int[n];
        int flipCount = 0, res = 0;

        for (int i = 0; i < n; i++) {
            // remove effect of flip that is out of window
            if (i >= k) {
                flipCount ^= isFlipped[i - k];
            }

            // check if current bit (after flips) is 0
            if ((arr[i] ^ flipCount) == 0) {
                if (i + k > n) return -1; // cannot flip
                res++;
                flipCount ^= 1;       // flip window
                isFlipped[i] = 1;     // mark flip start
            }
        }

        return res;
    }
}
