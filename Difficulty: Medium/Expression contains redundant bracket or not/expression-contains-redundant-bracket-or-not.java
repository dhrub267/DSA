// class Solution {
//     public static boolean checkRedundancy(String s) {
//         // code here
//         s
//     }
// }


class Solution {
    public static boolean checkRedundancy(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // push everything except ')'
            if (ch != ')') {
                st.push(ch);
            } 
            else {
                boolean hasOperator = false;

                // pop until '('
                while (!st.isEmpty() && st.peek() != '(') {
                    char top = st.pop();

                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                }

                // pop '('
                st.pop();

                // no operator inside ()
                if (!hasOperator) {
                    return true;
                }
            }
        }

        return false;
    }
}
