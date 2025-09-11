class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0; // Already at the end
        if (arr[0] == 0) return -1; // Can't move anywhere

        int jumps = 0;
        int farthest = 0;
        int currentEnd = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + arr[i]);

            // agar currentEnd tak pohonch gaye, jump lena padega
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // agar currentEnd last index se aage hai -> done
                if (currentEnd >= n - 1) {
                    return jumps;
                }
            }

            // agar kahin phase gaye aur aage nahi ja sakte
            if (i >= farthest) {
                return -1;
            }
        }

        return -1;
    }
}
