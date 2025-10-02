
class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        // Base case: sum completed and exactly k numbers used
        if (n == 0 && k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        // If invalid state
        if (n < 0 || k < 0) {
            return;
        }
        
        // Try all numbers from 'start' to 9
        for (int i = start; i <= 9; i++) {
            current.add(i);  // choose
            backtrack(i + 1, n - i, k - 1, current, result); // explore
            current.remove(current.size() - 1); // un-choose (backtrack)
        }
    }
}
