class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        
        int duplicate = -1, missing = -1;
        int n = arr.length;
        
        // Step 1: Find duplicate by marking visited using negative indexing
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) - 1; // convert value into index
            
            if (arr[index] < 0) { // already visited? means duplicate
                duplicate = Math.abs(arr[i]);
            } else {
                arr[index] = -arr[index]; // mark visited
            }
        }

        // Step 2: Find missing => jiska index positive reh gaya
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(duplicate);
        ans.add(missing);
        return ans;
    }
}

