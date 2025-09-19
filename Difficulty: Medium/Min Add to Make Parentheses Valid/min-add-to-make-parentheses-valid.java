class Solution {
    public int minParentheses(String s) {
        int open = 0; // unmatched '('
        int add = 0;  // extra '(' needed for unmatched ')'

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else { // ch == ')'
                if (open > 0) {
                    open--; // match mil gaya
                } else {
                    add++; // ek '(' chahiye
                }
            }
        }

        // total = unmatched '(' (open) + extra '(' needed (add)
        return add + open;
    }
}
