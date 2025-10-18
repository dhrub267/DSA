/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

// class Solution {
//     public int findMedian(Node root) {
//         // Code here
        
//     }
// }


class Solution {
    
    // Helper to count total nodes in BST
    private int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Helper for inorder traversal to find median
    private void inorder(Node root, int[] count, int target1, int target2, int[] result) {
        if (root == null) return;

        inorder(root.left, count, target1, target2, result);

        count[0]++;

        // When we reach target positions, record data
        if (count[0] == target1) result[0] = root.data;
        if (count[0] == target2) result[1] = root.data;

        inorder(root.right, count, target1, target2, result);
    }

    public int findMedian(Node root) {
        int n = countNodes(root); // total number of nodes

        int[] count = new int[1];      // counter during inorder
        int[] result = new int[2];     // store median positions

        // For odd: both targets are same
        if (n % 2 == 1) {
            inorder(root, count, (n + 1) / 2, (n + 1) / 2, result);
            return result[0];
        } 
        // For even: need n/2 and (n/2 + 1)
        else {
            inorder(root, count, n / 2, n / 2 + 1, result);
            return result[0]; // As per problem statement, take V(n/2)
        }
    }
}
