import java.util.*;

class Solution {
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) return "";

        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        // Count frequency of p
        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }

        int required = p.length(); // total chars needed (including duplicates)
        int formed = 0; // how many chars matched so far
        int left = 0, minLen = Integer.MAX_VALUE, startIndex = -1;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            sFreq[c - 'a']++;

            // If this character helps in fulfilling requirement
            if (pFreq[c - 'a'] > 0 && sFreq[c - 'a'] <= pFreq[c - 'a']) {
                formed++;
            }

            // When we have all chars in current window
            while (formed == required) {
                // Update answer
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                // Shrink from left
                char leftChar = s.charAt(left);
                sFreq[leftChar - 'a']--;

                if (pFreq[leftChar - 'a'] > 0 && sFreq[leftChar - 'a'] < pFreq[leftChar - 'a']) {
                    formed--;
                }
                left++;
            }
        }

        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
