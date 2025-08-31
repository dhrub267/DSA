class Solution {
    public int maxWater(int arr[]) {
        int left = 0, right = arr.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Height and width
            int h = Math.min(arr[left], arr[right]);
            int w = right - left;

            // Area
            int area = h * w;
            maxArea = Math.max(maxArea, area);

            // Move pointer
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
