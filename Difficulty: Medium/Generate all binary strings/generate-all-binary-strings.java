import java.util.*;

class Solution {
    public ArrayList<String> binstr(int n) {
        ArrayList<String> result = new ArrayList<>();
        int total = 1 << n; // 2^n combinations
        
        for (int i = 0; i < total; i++) {
            // convert i to binary string with leading zeros
            String binary = String.format("%" + n + "s", Integer.toBinaryString(i))
                                .replace(' ', '0');
            result.add(binary);
        }
        return result;
    }
}
