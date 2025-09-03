class Solution {
    int missingNum(int arr[]) {
        int n = arr.length;
        long total = 1L * (n + 1) * (n + 2) / 2; // force long before multiply
        long sum = 0;
        for (int x : arr) sum += x;
        return (int)(total - sum);
    }
}
