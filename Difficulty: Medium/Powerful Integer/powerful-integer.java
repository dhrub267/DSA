import java.util.*;

class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Mark +1 at start and -1 at end+1
        for (int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1] + 1, map.getOrDefault(interval[1] + 1, 0) - 1);
        }

        int active = 0;
        int maxPowerful = -1;

        Integer prev = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int curr = entry.getKey();
            if (prev != null && active >= k) {
                // All numbers in range [prev, curr - 1] are powerful
                maxPowerful = Math.max(maxPowerful, curr - 1);
            }
            active += entry.getValue();
            prev = curr;
        }

        return maxPowerful;
    }
}
