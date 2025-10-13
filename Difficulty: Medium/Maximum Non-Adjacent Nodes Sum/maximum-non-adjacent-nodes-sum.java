/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

// class Solution {
//     public int getMaxSum(Node root) {
//         // code here
        
//     }
// }


/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    // Helper function returns an array [include, exclude]
    private int[] solve(Node root) {
        if (root == null) return new int[]{0, 0};

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        // If we include current node
        int include = root.data + left[1] + right[1];

        // If we exclude current node
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{include, exclude};
    }

    public int getMaxSum(Node root) {
        int[] ans = solve(root);
        return Math.max(ans[0], ans[1]);
    }
}
