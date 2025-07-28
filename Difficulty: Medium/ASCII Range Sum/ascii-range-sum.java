import java.util.*;

class Solution {
    public ArrayList<Integer> asciirange(String s) {
        // Store first and last occurrence of each character
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);  // -1 means not yet seen
        
        // First and last position map
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (first[ch] == -1) {
                first[ch] = i;
            }
            last[ch] = i;  // update last always
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1 && first[i] != last[i]) {
                int sum = 0;
                for (int j = first[i] + 1; j < last[i]; j++) {
                    sum += s.charAt(j);
                }
                if (sum > 0) {
                    result.add(sum);
                }
            }
        }
        
        return result;
    }
}
