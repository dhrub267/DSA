import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numToIndex.containsKey(complement)) {
                return new int[] { numToIndex.get(complement), i };
            }

            numToIndex.put(nums[i], i);
        }

        // Should never reach here based on problem constraints
        return new int[] {};
    }
}
