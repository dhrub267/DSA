import java.util.*;

class Solution {
    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        helper(result, s, target, "", 0, 0, 0);
        Collections.sort(result); // Lexicographically smallest order
        return result;
    }

    private void helper(ArrayList<String> res, String num, int target, String path, int index, long eval, long multed) {
        if (index == num.length()) {
            if (eval == target) {
                res.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            // Prevent numbers with leading zeros
            if (i != index && num.charAt(index) == '0') break;

            String curStr = num.substring(index, i + 1);
            long cur = Long.parseLong(curStr);

            if (index == 0) {
                // First number, pick it without any operator
                helper(res, num, target, curStr, i + 1, cur, cur);
            } else {
                // Try '+'
                helper(res, num, target, path + "+" + curStr, i + 1, eval + cur, cur);
                // Try '-'
                helper(res, num, target, path + "-" + curStr, i + 1, eval - cur, -cur);
                // Try '*'
                helper(res, num, target, path + "*" + curStr, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}
