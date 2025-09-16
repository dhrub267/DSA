class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];

            if (sum == target) {
                // yaha +1 karna hai kyunki array 1-indexed hai
                return new int[]{start + 1, end + 1};
            } 
            else if (sum > target) {
                end--;
            } 
            else {
                start++;
            }
        }
        return new int[]{}; // problem ke constraints me hamesha ek solution hai
    }
}
