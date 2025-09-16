import java.util.*;

class Solution {
    public int evaluatePostfix(String[] arr) {
        Stack<Integer> st = new Stack<>();
        
        for (String token : arr) {
            // Agar number hai
            if (isNumber(token)) {
                st.push(Integer.parseInt(token));
            } 
            // Agar operator hai
            else {
                int b = st.pop();
                int a = st.pop();
                int res = 0;

                switch (token) {
                    case "+":
                        res = a + b;
                        break;
                    case "-":
                        res = a - b;
                        break;
                    case "*":
                        res = a * b;
                        break;
                    case "/":
                        // Floor division ka handle
                        res = a / b;
                        if (a % b != 0 && ((a < 0) ^ (b < 0))) {
                            res -= 1;
                        }
                        break;
                    case "^":
                        res = (int)Math.pow(a, b);
                        break;
                }
                st.push(res);
            }
        }
        
        return st.pop();
    }
    
    // Helper function check number hai ya nahi
    private boolean isNumber(String s) {
        if (s.length() > 1 && (s.charAt(0) == '-' || s.charAt(0) == '+')) {
            return Character.isDigit(s.charAt(1));
        }
        return Character.isDigit(s.charAt(0));
    }
}
