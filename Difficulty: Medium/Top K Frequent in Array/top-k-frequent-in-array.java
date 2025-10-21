import java.util.*;

class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        // Step 1: Count frequencies
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert to list of keys
        List<Integer> elements = new ArrayList<>(freqMap.keySet());

        // Step 3: Sort based on custom comparator
        Collections.sort(elements, (a, b) -> {
            int freqCompare = freqMap.get(b) - freqMap.get(a);
            if (freqCompare == 0)
                return b - a; // larger number first if same frequency
            return freqCompare;
        });

        // Step 4: Pick top k
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(elements.get(i));
        }

        return result;
    }
}
