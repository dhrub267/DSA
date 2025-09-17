class Solution {
    static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0'); // multi-digit number handle
            } 
            else if (ch == '[') {
                countStack.push(num);
                stringStack.push(current);
                num = 0;
                current = new StringBuilder();
            } 
            else if (ch == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder prev = stringStack.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(current);
                }
                current = prev.append(temp);
            } 
            else {
                current.append(ch);
            }
        }
        return current.toString();
    }
}
