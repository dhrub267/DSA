import java.util.*;

class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(prices); // sort ascending
        
        // --- Minimum Cost ---
        int minCost = 0;
        int i = 0, j = prices.length - 1;
        while (i <= j) {
            minCost += prices[i]; // buy cheapest
            i++;  // move to next cheapest
            j -= k; // take k expensive for free
        }
        
        // --- Maximum Cost ---
        int maxCost = 0;
        i = 0;
        j = prices.length - 1;
        while (j >= i) {
            maxCost += prices[j]; // buy most expensive
            j--; // next expensive
            i += k; // take k cheapest for free
        }
        
        ans.add(minCost);
        ans.add(maxCost);
        return ans;
    }
}
