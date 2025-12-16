// class Solution {
//     public boolean areRotations(String s1, String s2) {
//         // code here
        
//     }
// }


class Solution {
    public boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return kmpSearch(s1 + s1, s2);
    }

    // KMP search
    private boolean kmpSearch(String text, String pattern) {
        int[] lps = buildLPS(pattern);
        int i = 0, j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) return true;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    // Build LPS array
    private int[] buildLPS(String pat) {
        int[] lps = new int[pat.length()];
        int len = 0, i = 1;

        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        return lps;
    }
}
