import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        // Step 1: Sort in descending order
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;
        
        // Step 2: Traverse from largest to smallest
        for (int i = 0; i < n; i++) {
            int papers = n - i;  // number of papers with citations >= citations[i]
            if (citations[i] >= papers) {
                h = papers;
                break;
            }
        }
        return h;
    }
}
