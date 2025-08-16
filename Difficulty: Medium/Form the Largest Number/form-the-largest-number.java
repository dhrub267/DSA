import java.util.*;

class Solution {
    public String findLargest(int[] arr) {
        // Convert numbers to string
        String[] strArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strArr[i] = String.valueOf(arr[i]);
        }

        // Custom sort using comparator
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // descending order
            }
        });

        // If largest number is "0", return "0"
        if (strArr[0].equals("0")) return "0";

        // Build result
        StringBuilder sb = new StringBuilder();
        for (String s : strArr) {
            sb.append(s);
        }

        return sb.toString();
    }
}
