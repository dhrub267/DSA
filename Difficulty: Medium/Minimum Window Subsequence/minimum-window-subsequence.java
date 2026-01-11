// class Solution {
//     public String minWindow(String s1, String s2) {
//         // code here
        
//     }
// }


class Solution {
    public String minWindow(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int minLen = Integer.MAX_VALUE;
        int start = -1;

        int i = 0;
        while (i < n) {
            int j = 0;

            // Step 1: forward scan to match s2
            while (i < n) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;
                    if (j == m) break;
                }
                i++;
            }

            if (j != m) break; // no more possible windows

            // Step 2: backward scan to minimize window
            int end = i;
            j = m - 1;
            while (i >= 0) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j--;
                    if (j < 0) break;
                }
                i--;
            }

            int currLen = end - i + 1;
            if (currLen < minLen) {
                minLen = currLen;
                start = i;
            }

            // Move i forward to search for next window
            i = i + 1;
        }

        return start == -1 ? "" : s1.substring(start, start + minLen);
    }
}
