// // User function Template for Java

// class Solution {
//     public int rowWithMax1s(int arr[][]) {
//         // code here
        
//     }
// }



class Solution {
    public int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;

        int maxRowIndex = -1;
        int j = m - 1; // last column se start

        for (int i = 0; i < n; i++) {
            // jab tak 1 mile, left move karo
            while (j >= 0 && arr[i][j] == 1) {
                j--;
                maxRowIndex = i;
            }
        }
        return maxRowIndex;
    }
}
