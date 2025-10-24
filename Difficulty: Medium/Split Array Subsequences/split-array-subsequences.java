import java.util.*;

class Solution {
    public boolean isPossible(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (freq.get(num) == 0) continue;

            // If there's a sequence waiting for num
            if (need.getOrDefault(num, 0) > 0) {
                need.put(num, need.get(num) - 1);
                need.put(num + 1, need.getOrDefault(num + 1, 0) + 1);
                freq.put(num, freq.get(num) - 1);
            } 
            else {
                // Try to start a new sequence of length k
                boolean canStart = true;
                for (int i = num; i < num + k; i++) {
                    if (freq.getOrDefault(i, 0) <= 0) {
                        canStart = false;
                        break;
                    }
                }

                if (!canStart) return false;

                for (int i = num; i < num + k; i++) {
                    freq.put(i, freq.get(i) - 1);
                }

                need.put(num + k, need.getOrDefault(num + k, 0) + 1);
            }
        }

        return true;
    }
}
