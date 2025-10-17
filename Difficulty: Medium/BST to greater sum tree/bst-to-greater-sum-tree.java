/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

// class Solution {
//     public static void transformTree(Node root) {
//         // code here
        
//     }
// }


class Solution {
    // Helper variable to keep track of sum of greater nodes
    static int sum = 0;

    public static void transformTree(Node root) {
        // Reset sum for each new call
        sum = 0;
        transform(root);
    }

    // Helper function: reverse inorder traversal
    private static void transform(Node root) {
        if (root == null) return;

        // Step 1: Traverse right subtree (greater elements)
        transform(root.right);

        // Step 2: Process current node
        int oldValue = root.data;   // store original value
        root.data = sum;            // replace with sum of greater nodes
        sum += oldValue;            // update running sum

        // Step 3: Traverse left subtree
        transform(root.left);
    }
}
