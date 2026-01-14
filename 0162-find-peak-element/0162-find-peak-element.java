class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid])
                return mid;
            else if (nums[mid] < nums[mid+1])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return nums[0] > nums[n-1] ? 0 : n-1;
    }
}
