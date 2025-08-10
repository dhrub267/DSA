class Solution {
    public int countPS(String s) {
        int n = s.length();
        int count = 0;

        // Har index ko center maan ke expand karenge
        for (int center = 0; center < n; center++) {
            // Odd length palindromes
            count += expand(s, center, center);

            // Even length palindromes
            count += expand(s, center, center + 1);
        }
        return count;
    }

    // Expand from the given center
    private int expand(String s, int left, int right) {
        int cnt = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 >= 2) { // length >= 2
                cnt++;
            }
            left--;
            right++;
        }
        return cnt;
    }
}
