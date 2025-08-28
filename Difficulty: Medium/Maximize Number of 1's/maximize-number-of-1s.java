class Solution {
    public int maxOnes(int arr[], int k) {
        int left = 0, right = 0;
        int zeroCount = 0;
        int maxLen = 0;

        while (right < arr.length) {
            // expand window
            if (arr[right] == 0) {
                zeroCount++;
            }

            // shrink window if zeros exceed k
            while (zeroCount > k) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // update max length
            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen;
    }
}
