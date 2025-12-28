// class Solution {
//     public int minTime(int[] ranks, int n) {
//         // code here
        
//     }
// }


class Solution {
    public int minTime(int[] ranks, int n) {
        int m = ranks.length;

        int minRank = Integer.MAX_VALUE;
        for (int r : ranks) {
            minRank = Math.min(minRank, r);
        }

        int low = 0;
        int high = minRank * n * (n + 1) / 2;
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMakeDonuts(ranks, n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canMakeDonuts(int[] ranks, int n, int time) {
        int total = 0;

        for (int r : ranks) {
            int k = (int) ((-1 + Math.sqrt(1 + 8L * time / r)) / 2);
            total += k;

            if (total >= n) return true;
        }
        return false;
    }
}
