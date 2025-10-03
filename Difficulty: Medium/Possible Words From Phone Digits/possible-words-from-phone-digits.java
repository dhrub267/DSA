import java.util.*;

class Solution {
    private static final String[] KEYPAD = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    
    public ArrayList<String> possibleWords(int[] arr) {
        ArrayList<String> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;
        backtrack(arr, 0, new StringBuilder(), result);
        return result;
    }
    
    private void backtrack(int[] arr, int index, StringBuilder current, ArrayList<String> result) {
        if (index == arr.length) {
            if (current.length() > 0) { // only add non-empty strings
                result.add(current.toString());
            }
            return;
        }
        
        String letters = KEYPAD[arr[index]];
        if (letters.isEmpty()) {
            // skip 0 or 1, move to next digit
            backtrack(arr, index + 1, current, result);
        } else {
            for (char ch : letters.toCharArray()) {
                current.append(ch);
                backtrack(arr, index + 1, current, result);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}
