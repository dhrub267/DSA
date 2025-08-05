class Solution {
    public boolean isPalinSent(String s) {
        // Step 1: Convert to lowercase
        s = s.toLowerCase();

        // Step 2: Remove non-alphanumeric characters using regex
        StringBuilder cleaned = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                cleaned.append(ch);
            }
        }

        // Step 3: Check if cleaned string is a palindrome
        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
