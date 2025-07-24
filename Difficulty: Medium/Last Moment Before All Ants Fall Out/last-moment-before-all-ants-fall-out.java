public class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxTime = 0;

        for (int pos : left) {
            maxTime = Math.max(maxTime, pos); // Time for left ants = position
        }

        for (int pos : right) {
            maxTime = Math.max(maxTime, n - pos); // Time for right ants = n - position
        }

        return maxTime;
    }
}
