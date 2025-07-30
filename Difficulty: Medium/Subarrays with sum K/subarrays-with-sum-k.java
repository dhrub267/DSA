import java.util.*;

class Solution {
    public int cntSubarrays(int[] arr, int k) {
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        int currSum = 0;
        int count = 0;

        prefixSumFreq.put(0, 1); // Base case: prefix sum 0 occurred once

        for (int num : arr) {
            currSum += num;

            // Check if (currSum - k) exists in map
            if (prefixSumFreq.containsKey(currSum - k)) {
                count += prefixSumFreq.get(currSum - k);
            }

            // Update the prefix sum frequency in map
            prefixSumFreq.put(currSum, prefixSumFreq.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}
